package com.gzmpc.business.developer.wechat.service.com;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.core.dto.wechat.com.Code2SessionRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.Code2SessionResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import com.gzmpc.business.developer.core.enums.WeChatSendMessageEnum;
import com.gzmpc.business.developer.wechat.constant.WeChatConstants;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.http.client.com.auth.AuthClient;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.http.client.com.message.MessageClient;
import com.gzmpc.business.developer.wechat.service.AuthService;
import com.gzmpc.microservice.config.annotation.EnableConfig;
import com.gzmpc.microservice.config.annotation.ParamValue;
import com.gzmpc.microservice.config.enums.ConfigParamValueTypeEnum;
import com.gzmpc.support.redis.util.RedisUtil;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.gzmpc.support.rest.exception.ServerException;

/**
* @author rwe
* @version 创建时间：Sep 23, 2020 10:55:03 AM
* 企业微信 业务逻辑类
*/

@EnableConfig
@Service
public class ComService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ParamValue(value = "app.secret", defaultValue = "{}", type = ConfigParamValueTypeEnum.MAP)
	private Map<String, String> secrets;
	
	@Autowired
	MessageClient messageClient;
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	RedisUtil redisUtil;
	
	public ApiResponseData<Code2SessionResponse> code2Session(Code2SessionRequest request) {
		Integer agentId = request.getAgentId();
		String jscode = request.getJsCode();
		
		if(agentId != null && !StringUtils.isEmpty(jscode)) {
			String agentIdString = String.valueOf(agentId);
			String secret = secrets.get(agentIdString);
			
			if(secrets != null && secret != null) {
				String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_SESSION_BASE, agentIdString, secret, jscode);
				Code2SessionResponse session = (Code2SessionResponse) redisUtil.get(key);
				if (session == null) {
					String token = authService.getComToken(agentId);
					GetSessionResponse response = authClient.jscode2session(token, jscode);
					if(response != null && response.checkSuccess()) {
						Code2SessionResponse res = new Code2SessionResponse();
						BeanUtils.copyProperties(response, res);
						redisUtil.set(key, res, 300);
						return new ApiResponseData<>(res);
					}
					else {
						String detailMessage = response == null? "空值" : response.getErrcode()+":"+response.getErrmsg();
						LOG.error(detailMessage);
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
				LOG.error(message, e);
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				return new ApiResponseData<SendMessageResponse>(ResultCode.INTERNAL_SERVER_ERROR, message+" - "+errors.toString(), null);
			}
		}
	}
}
