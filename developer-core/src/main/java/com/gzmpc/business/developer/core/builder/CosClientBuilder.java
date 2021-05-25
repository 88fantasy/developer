package com.gzmpc.business.developer.core.builder;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.common.dto.ParamDTO;
import com.gzmpc.business.developer.core.proxy.ConfigProxy;
import com.gzmpc.spring.boot.autoconfigure.cos.CosClient;
import com.gzmpc.support.rest.entity.ApiResponseData;

/**
* @author rwe
* @version 创建时间：2021年5月25日 上午8:47:36
* 类说明
*/

@Service
public class CosClientBuilder {

	@Value("${spring.application.name}")
	String appCode;
	
	@Autowired
	ConfigProxy configProxy;
	
	private final String ID_KEY = "tencentcloud.secret.id";
	
	private final String KEY_KEY = "tencentcloud.secret.key";
	
	private final ParamDTO DEFAULT = new ParamDTO();
	
	
	public CosClient build(String cosRegion, String bucketName, String path) {
		ApiResponseData<Map<String,ParamDTO>> params = configProxy.findParamByKeys(appCode, Arrays.asList(ID_KEY, KEY_KEY));
		if(params == null || !params.isStatus() ) {
			return null;
		}
		Map<String,ParamDTO> map = params.getDataOrElse(new ConcurrentHashMap<>());
		String secretId = map.getOrDefault(ID_KEY, DEFAULT).getValue();
		String secretKey = map.getOrDefault(KEY_KEY, DEFAULT).getValue();
		return CosClient.init(secretId, secretKey, cosRegion, bucketName, path);
	}
	
}
