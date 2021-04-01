package com.gzmpc.business.developer.wechat.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.WechatAppDTO;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:12:06 PM
* 类说明
*/

@Service
public class WeChatService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ConcurrentHashMap<String,WechatAppDTO> apps = new ConcurrentHashMap<String,WechatAppDTO>();
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	

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
	
}
