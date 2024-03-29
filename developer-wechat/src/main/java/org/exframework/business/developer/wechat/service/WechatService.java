package org.exframework.business.developer.wechat.service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import org.exframework.business.developer.common.constant.DeveloperConstants;
import org.exframework.business.developer.common.dto.WechatAppDTO;
import org.exframework.business.developer.core.dto.wechat.WechatLoginUserInfo;
import org.exframework.business.developer.wechat.constant.WeChatConstants;
import org.exframework.business.developer.wechat.constant.WeChatMiniProgramConstants;
import org.exframework.business.developer.wechat.entity.GetTokenResponse;
import org.exframework.business.developer.wechat.errorhandle.NotFoundException;
import org.exframework.business.developer.wechat.http.client.WeChatClient;
import org.exframework.business.developer.wechat.http.client.entity.GetLoginCallBackTokenResponse;
import org.exframework.support.common.annotation.BuildComponent;
import org.exframework.support.common.build.Buildable;
import org.exframework.support.common.exception.BuildException;
import org.exframework.support.rest.exception.ApiException;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:12:06 PM
* 类说明
*/

@Service
@BuildComponent
public class WechatService  implements Buildable {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ConcurrentHashMap<String,WechatAppDTO> apps = new ConcurrentHashMap<String,WechatAppDTO>();
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	@Autowired
	WeChatClient weChatClient;

	public void refresh( ) {
		Map<Object, Object> infos = redisTemplate.opsForHash().entries(DeveloperConstants.WECHAT_APP_KEY);
		if( infos != null) {
			ConcurrentHashMap<String,WechatAppDTO> tmp = new ConcurrentHashMap<String,WechatAppDTO>();
			for(Entry<Object, Object> entry : infos.entrySet()) {
				String key = entry.getKey().toString();
				WechatAppDTO info = JSON.parseObject(entry.getValue().toString(),WechatAppDTO.class);
				tmp.put(key, info);
				logger.info("加载微信应用 {} : {}", key, entry.getValue());
			}
			apps = tmp;
		}
	}
	
	public WechatAppDTO getAppInfo(String appId) throws NotFoundException {
		if(apps.containsKey(appId)) {
			return apps.get(appId);
		}
		else {
			throw new NotFoundException("appId 尚未注册");
		}
	}

	@Override
	public void build(ApplicationContext ac) throws BuildException {
		refresh();
	}
	
	public WechatLoginUserInfo getUserInfo(String appid, String code) {
		WechatAppDTO app = getAppInfo(appid);
		String key = MessageFormat.format(WeChatConstants.WECHAT_LOGIN_CODE_KEY, code);
		GetLoginCallBackTokenResponse token = null;
		if(!redisTemplate.hasKey(key)) {
			GetLoginCallBackTokenResponse tokenResponse = weChatClient.getLoginToken(app.getAppId(), app.getAppSecret(), code);
			if(tokenResponse.checkSuccess()) {
				token = tokenResponse;
				long expires = tokenResponse.getExpiresIn();
				redisTemplate.opsForValue().set(key, tokenResponse, expires, TimeUnit.SECONDS);
			}
			else {
				logger.info("微信返回信息 {} : {}",  code, JSON.toJSONString(tokenResponse));
				throw new ApiException(tokenResponse.getErrmsg());
			}
		}
		else {
			token = (GetLoginCallBackTokenResponse) redisTemplate.opsForValue().get(key);
		}
		
		return weChatClient.getUserInfo(token.getAccessToken(), token.getOpenid());
	}
	
	public String getAppToken(String appId) {
		WechatAppDTO appInfo = getAppInfo(appId);
		String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_TOKEN_BASE, appId, appInfo.getAppSecret());
		String token = (String) redisTemplate.opsForValue().get(key);
		if (token == null || "".equals(token)) {
			GetTokenResponse response = weChatClient.getAccessToken(appId, appInfo.getAppSecret());
			Integer errcode = response.getErrcode();
			if (errcode == null || errcode == 0) {
				String accessToken = response.getAccessToken();
				Long expires = response.getExpiresIn();
				redisTemplate.opsForValue().setIfAbsent(key, accessToken, expires - 60, TimeUnit.SECONDS);
				token = accessToken;
			} else {
				logger.error("获取微信应用token失败[{}]:{}", errcode, response.getErrmsg());
			}
		}
		return token;
	}
}
