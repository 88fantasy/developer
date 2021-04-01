package com.gzmpc.business.developer.wechat.service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.WechatComAppDTO;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.http.client.com.WeChatComClient;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:12:06 PM
* 类说明
*/

@Service
public class WeChatComService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ConcurrentHashMap<String,String> coms = new ConcurrentHashMap<String,String>();

	@Value("${wechat.com.corpid}")
	private String corpid;
	
	@Autowired
	WeChatComClient weChatComClient;
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	public void refreshComs( ) {
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
	
	public String getComSecret(String agentId) {
		return coms.get(agentId);
	}
}
