package com.gzmpc.business.developer.wechat.service;

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
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.WechatAppDTO;
import com.gzmpc.business.developer.core.dto.wechat.WechatLoginUserInfo;
import com.gzmpc.business.developer.wechat.constant.WeChatConstants;
import com.gzmpc.business.developer.wechat.http.client.WeChatClient;
import com.gzmpc.business.developer.wechat.http.client.entity.GetLoginCallBackTokenResponse;
import com.gzmpc.support.common.annotation.BuildComponent;
import com.gzmpc.support.common.build.Buildable;
import com.gzmpc.support.common.exception.BuildException;
import com.gzmpc.support.rest.exception.ApiException;

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
	
	public WechatAppDTO getAppInfo(String appId) {
		return apps.get(appId);
	}

	@Override
	public void build(ApplicationContext ac) throws BuildException {
		refresh();
	}
	
	public WechatLoginUserInfo getUserInfo(String appid, String code) {
		WechatAppDTO app = getAppInfo(appid);
		if(app != null) {
			String key = MessageFormat.format(WeChatConstants.WECHAT_LOGIN_CODE_KEY, code);
			GetLoginCallBackTokenResponse token = null;
			if(!redisTemplate.hasKey(key)) {
				GetLoginCallBackTokenResponse tokenResponse = weChatClient.getLoginToken(app.getAppId(), app.getAppSecret(), code);
				if(tokenResponse.checkSuccess()) {
					token = tokenResponse;
					long expires = tokenResponse.getExpiresIn();
					redisTemplate.opsForValue().set(key, tokenResponse, expires, TimeUnit.SECONDS);
				}
			}
			else {
				token = (GetLoginCallBackTokenResponse) redisTemplate.opsForValue().get(key);
			}
			
			return weChatClient.getUserInfo(token.getAccessToken(), token.getOpenid());
		}
		else {
			throw new ApiException("appid未维护");
		}
	}
	
}