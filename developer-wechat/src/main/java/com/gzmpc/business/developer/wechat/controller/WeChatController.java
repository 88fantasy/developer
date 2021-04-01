package com.gzmpc.business.developer.wechat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.common.dto.WechatAppDTO;
import com.gzmpc.business.developer.core.dto.wechat.BindOpenIdRequest;
import com.gzmpc.business.developer.core.dto.wechat.GetTokenResponse;
import com.gzmpc.business.developer.core.dto.wechat.GetUaccountByOpenidResponse;
import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;
import com.gzmpc.business.developer.core.dto.wechat.TokenRequest;
import com.gzmpc.business.developer.wechat.constant.WeChatApiConstants;
import com.gzmpc.business.developer.wechat.dto.GetAppInfoResponse;
import com.gzmpc.business.developer.wechat.service.AuthService;
import com.gzmpc.business.developer.wechat.service.WeChatService;
import com.gzmpc.support.rest.exception.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 10:52:32 AM 预售活动 接口类
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@Api(tags = "微信小程序 API")
public class WeChatController {

	@Autowired
	AuthService authService;

	@Autowired
	WeChatService weChatService;

	@ApiOperation(value = "绑定openid")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_BIND_OPENID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GlobalResponse bindOpenid(@ApiParam(value = "登录", required = true) @RequestBody BindOpenIdRequest request)
			throws ApiException {
		Boolean success = authService.bindOpenid(request.getOpenid(), request.getUaccount());
		if (success) {
			GlobalResponse reponse = new GlobalResponse();
			reponse.setErrcode(0);
			return reponse;
		} else {
			throw new ApiException("绑定失败,请稍后重试");
		}
	}

	@ApiOperation(value = "根据openid获取统一账号")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_GET_UACCOUNT_BY_OPENID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GetUaccountByOpenidResponse getUaccountByOpenid(
			@ApiParam(value = "openid", required = true) @PathVariable String openid) throws ApiException {
		GetUaccountByOpenidResponse response = new GetUaccountByOpenidResponse();
		if (!StringUtils.isEmpty(openid)) {
			String uaccount = authService.getUaccountByOpenid(openid);
			if (!StringUtils.isEmpty(uaccount)) {
				response.setErrcode(0);
				response.setUaccount(uaccount);
			} else {
				response.setErrcode(404);
				response.setErrmsg("获取失败,请稍后重试");
			}
		} else {
			response.setErrcode(404);
			response.setErrmsg("缺少必要参数");
		}
		return response;
	}

	@ApiOperation(value = "获取微信app信息")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_APPINFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GetAppInfoResponse getAppInfo(@ApiParam(value = "appid", required = true) @PathVariable String appId)
			throws ApiException {
		GetAppInfoResponse response = new GetAppInfoResponse();
		if (!StringUtils.isEmpty(appId)) {
			WechatAppDTO appInfo = weChatService.getAppInfo(appId);
			if (appInfo != null) {
				response.setErrcode(0);
				response.setAppInfo(appInfo);
			} else {
				response.setErrcode(404);
				response.setErrmsg("找不到此id");
			}
		} else {
			response.setErrcode(400);
			response.setErrmsg("缺少必要参数");
		}
		return response;
	}

	@ApiOperation(value = "获取token")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_GET_TOKEN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GetTokenResponse getToken(@ApiParam(value = "tenantId", required = true) @Valid TokenRequest request) {
		return authService.getToken(request);
	}
}
