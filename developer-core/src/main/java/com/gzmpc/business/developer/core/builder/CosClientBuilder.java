package com.gzmpc.business.developer.core.builder;

import java.util.Arrays;
import java.util.List;

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
	
	
	public CosClient build(String cosRegion, String bucketName, String path) {
		ApiResponseData<List<ParamDTO>> params = configProxy.findParamByKeys(appCode, Arrays.asList(ID_KEY, KEY_KEY));
		if(params == null || !params.isStatus() ) {
			return null;
		}
		List<ParamDTO> list = params.getDataOrElse(Arrays.asList());
		String secretId = list.stream().filter( param -> ID_KEY.equals(param.getParamKey())).findAny().get().getValue();
		String secretKey = list.stream().filter( param -> KEY_KEY.equals(param.getParamKey())).findAny().get().getValue();
		return CosClient.init(secretId, secretKey, cosRegion, bucketName, path);
	}
	
}
