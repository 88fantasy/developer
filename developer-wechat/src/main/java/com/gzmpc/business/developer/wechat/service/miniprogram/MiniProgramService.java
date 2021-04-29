package com.gzmpc.business.developer.wechat.service.miniprogram;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.common.dto.WechatAppDTO;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.WeChatMiniprogramClient;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.service.WechatService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 10:01:58 PM
* 小程序 业务类
*/

@Service
public class MiniProgramService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WeChatMiniprogramClient weChatMiniprogramClient;
	
	@Autowired
	WechatService weChatService;
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	public ApiResponseData<Code2SessionResponse> code2Session(Code2SessionRequest request) {
		String appid = request.getAppid();
		String jscode = request.getJsCode();
		
		if(!StringUtils.isEmpty(appid) && !StringUtils.isEmpty(jscode)) {
			WechatAppDTO appInfo = weChatService.getAppInfo(appid);
			
			if(appInfo != null) {
			
				String secret = appInfo.getAppSecret();
				String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_SESSION_BASE, appid, secret, jscode);
				Code2SessionResponse session = (Code2SessionResponse) redisTemplate.opsForValue().get(key);
				if (session == null) {
					GetSessionResponse response = weChatMiniprogramClient.jscode2session(appid, secret, jscode);
					if(response != null && response.checkSuccess()) {
						Code2SessionResponse res = new Code2SessionResponse();
						BeanUtils.copyProperties(response, res);
						res.setSessionKey(response.getSession_key());
						redisTemplate.opsForValue().set(key, res, 300, TimeUnit.SECONDS);
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
				return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, "appId尚未注册", null);
			}
		}
		else {
			return ApiResponseData.notEnough();
		}
	}
	
	
}
