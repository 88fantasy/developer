package com.gzmpc.business.developer.wechat.service.miniprogram;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionResponse;
import com.gzmpc.business.developer.wechat.entity.AppInfo;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.WeChatMiniprogramClient;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.service.WeChatService;
import com.gzmpc.support.redis.util.RedisUtil;
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
	WeChatService weChatService;
	
	@Autowired
	RedisUtil redisUtil;
	
	public ApiResponseData<Code2SessionResponse> code2Session(Code2SessionRequest request) {
		String appid = request.getAppid();
		String jscode = request.getJsCode();
		
		if(!StringUtils.isEmpty(appid) && !StringUtils.isEmpty(jscode)) {
			AppInfo appInfo = weChatService.getAppInfo(appid);
			
			if(appInfo != null) {
			
				String secret = appInfo.getAppSecret();
				String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_SESSION_BASE, appid, secret, jscode);
				Code2SessionResponse session = (Code2SessionResponse) redisUtil.get(key);
				if (session == null) {
					GetSessionResponse response = weChatMiniprogramClient.jscode2session(appid, secret, jscode);
					if(response != null && response.checkSuccess()) {
						Code2SessionResponse res = new Code2SessionResponse();
						BeanUtils.copyProperties(response, res);
						res.setSessionKey(response.getSession_key());
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
				return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, "appId尚未注册", null);
			}
		}
		else {
			return ApiResponseData.notEnough();
		}
	}
}
