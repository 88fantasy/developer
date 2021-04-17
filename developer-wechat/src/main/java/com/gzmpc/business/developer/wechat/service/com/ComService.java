package com.gzmpc.business.developer.wechat.service.com;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.WechatComAppDTO;
import com.gzmpc.business.developer.core.dto.wechat.com.Code2SessionRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.Code2SessionResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import com.gzmpc.business.developer.core.enums.WeChatSendMessageEnum;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.constant.WeChatConstants;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.http.client.com.WeChatComClient;
import com.gzmpc.business.developer.wechat.http.client.com.auth.AuthClient;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.http.client.com.message.MessageClient;
import com.gzmpc.support.common.annotation.BuildComponent;
import com.gzmpc.support.common.build.Buildable;
import com.gzmpc.support.common.exception.BuildException;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.gzmpc.support.rest.exception.ServerException;

/**
* @author rwe
* @version 创建时间：Sep 23, 2020 10:55:03 AM
* 企业微信 业务逻辑类
*/

@Service
@BuildComponent
public class ComService implements Buildable {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ConcurrentHashMap<String,String> coms = new ConcurrentHashMap<String,String>();
	
	@Autowired
	MessageClient messageClient;
	
	@Autowired
	AuthClient authClient;
	
	@Value("${wechat.com.corpid}")
	private String corpid;
	
	@Autowired
	WeChatComClient weChatComClient;
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	public void refresh( ) {
		Map<Object, Object> infos = redisTemplate.opsForHash().entries(DeveloperConstants.WECHAT_COM_APP_KEY);
		if( infos != null) {
			ConcurrentHashMap<String,String> tmp = new ConcurrentHashMap<String,String>();
			for(Entry<Object, Object> entry : infos.entrySet()) {
				String key = entry.getKey().toString();
				WechatComAppDTO info = JSON.parseObject(entry.getValue().toString(),WechatComAppDTO.class);
				tmp.put(key, info.getSecret());
				logger.info("加载企业微信应用 {} : {}", key, entry.getValue());
			}
			coms = tmp;
		}
	}
	
	public String getComToken(int agentId) {
		String key = MessageFormat.format(WeChatComConstants.WECHAT_COM_TOKEN_BASE, corpid, agentId);
		String token = (String) redisTemplate.opsForValue().get(key);
		if (token == null || "".equals(token)) {
			String agentIdString = String.valueOf(agentId);
			if (coms != null && coms.containsKey(agentIdString)) {
				String secret = coms.get(agentIdString);
				com.gzmpc.business.developer.wechat.http.client.com.entity.GetTokenResponse response = weChatComClient
						.getToken(corpid, secret);
				Integer errcode = response.getErrcode();
				if (errcode == 0) {
					String accessToken = response.getAccessToken();
					Long expires = response.getExpiresIn();
					redisTemplate.opsForValue().setIfAbsent(key, accessToken, expires - 60, TimeUnit.SECONDS);
					token = accessToken;
				} else {
					logger.error(MessageFormat.format("获取企业微信token失败[{0}]:{1}", errcode, response.getErrmsg()));
				}
			} else {
				logger.error(MessageFormat.format("获取企业微信token失败[{0}]:{1}", 404, "尚未配置应用密钥,请检查配置中心配置项"));
			}
		}
		return token;
	}
	
	public ApiResponseData<Code2SessionResponse> code2Session(Code2SessionRequest request) {
		Integer agentId = request.getAgentId();
		String jscode = request.getJsCode();
		
		if(agentId != null && !StringUtils.isEmpty(jscode)) {
			String agentIdString = String.valueOf(agentId);
			String secret = coms.get(agentIdString);
			
			if(coms != null && secret != null) {
				String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_SESSION_BASE, agentIdString, secret, jscode);
				Code2SessionResponse session = (Code2SessionResponse) redisTemplate.opsForValue().get(key);
				if (session == null) {
					String token = getComToken(agentId);
					GetSessionResponse response = authClient.jscode2session(token, jscode);
					if(response != null && response.checkSuccess()) {
						Code2SessionResponse res = new Code2SessionResponse();
						BeanUtils.copyProperties(response, res);
						redisTemplate.opsForValue().set(key, res, 300);
						return new ApiResponseData<>(res);
					}
					else {
						String detailMessage = response == null? "空值" : response.getErrcode()+":"+response.getErrmsg();
						logger.error(detailMessage);
						return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, detailMessage, null);
					}
				}
				else {
					return new ApiResponseData<>(session);
				}
			}
			else {
				return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, "agentId尚未注册", null);
			}
		}
		else {
			return ApiResponseData.notEnough();
		}
		
	}
	
	public ApiResponseData<SendMessageResponse> sendText(SendTextMessageRequest request) {
		final String operateName = "发送文本消息";
		SendMessage sender = new SendMessage(operateName, request);
		return sender.send(new SendFunction() {
			@Override
			public SendMessageResponse doWork(Object... args) {
				return messageClient.sendText(request, WeChatSendMessageEnum.TEXT.value(), request.getEnableIdTrans(), request.getDuplicateCheckInterval());
			}
		});
	}
	
	public ApiResponseData<SendMessageResponse> sendTextcard(SendTextcardMessageRequest request) {
		final String operateName = "发送文本卡片消息";
		SendMessage sender = new SendMessage(operateName, request);
		return sender.send(new SendFunction() {
			@Override
			public SendMessageResponse doWork(Object... args) {
				return messageClient.sendTextcard(request, WeChatSendMessageEnum.TEXTCARD.value(), request.getEnableIdTrans(), request.getDuplicateCheckInterval());
			}
		});
	}
	
	public ApiResponseData<SendMessageResponse> sendNews(SendNewsMessageRequest request) {
		final String operateName = "发送图文消息";
		SendMessage sender = new SendMessage(operateName, request);
		return sender.send(new SendFunction() {
			@Override
			public SendMessageResponse doWork(Object... args) {
				return messageClient.sendNews(request, WeChatSendMessageEnum.NEWS.value(), request.getEnableIdTrans(), request.getDuplicateCheckInterval());
			}
		});
	}
	
	public ApiResponseData<SendMessageResponse> sendImage(SendImageMessageRequest request) {
		final String operateName = "发送图片消息";
		SendMessage sender = new SendMessage(operateName, request);
		return sender.send(new SendFunction() {
			@Override
			public SendMessageResponse doWork(Object... args) {
				return messageClient.sendImage(request, WeChatSendMessageEnum.IMAGE.value(), request.getEnableIdTrans(), request.getDuplicateCheckInterval());
			}
		});
	}
	
	public ApiResponseData<SendMessageResponse> sendMiniProgram(SendMiniProgramMessageRequest request) {
		final String operateName = "发送小程序消息";
		SendMessage sender = new SendMessage(operateName, request);
		return sender.send(new SendFunction() {
			@Override
			public SendMessageResponse doWork(Object... args) {
				return messageClient.sendMiniProgram(request, WeChatSendMessageEnum.MINIPROGRAM.value(), request.getEnableIdTrans(), request.getDuplicateCheckInterval());
			}
		});
	}
	
	interface SendFunction {

		/**
		 * 操作逻辑
		 *
		 * @param entity
		 * @param args
		 * @return
		 * @throws OperateException
		 */
		SendMessageResponse doWork(Object... args) throws ServerException;
	}

	class SendMessage {
		String operateName;
		Object[] args;

		SendMessage(String operateName, Object... args) {
			this.operateName = operateName;
			this.args = args;
		}

		ApiResponseData<SendMessageResponse> send(SendFunction func) {
			try {
				SendMessageResponse response = func.doWork(args);
				Integer errcode = response.getErrcode();
				String errmsg = response.getErrmsg();
				return new ApiResponseData<>(errcode == 0 ? ResultCode.OK: ResultCode.INTERNAL_SERVER_ERROR, errmsg, response);
			}catch (Exception e) {
				String message = MessageFormat.format(WeChatConstants.API_OPERATE_ERROR, operateName, e.getMessage(), args);
				logger.error(message, e);
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				return new ApiResponseData<SendMessageResponse>(ResultCode.INTERNAL_SERVER_ERROR, message+" - "+errors.toString(), null);
			}
		}
	}

	@Override
	public void build(ApplicationContext ac) throws BuildException {
		refresh();
	}
}
