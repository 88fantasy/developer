package org.exframework.business.developer.wechat.controller;

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

import org.exframework.business.developer.common.dto.WechatAppDTO;
import org.exframework.business.developer.core.constant.WeChatApiConstants;
import org.exframework.business.developer.core.dto.wechat.BindOpenIdRequest;
import org.exframework.business.developer.core.dto.wechat.WechatLoginUserInfo;
import org.exframework.business.developer.wechat.service.AuthService;
import org.exframework.business.developer.wechat.service.WechatService;
import org.exframework.support.rest.entity.ApiResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 10:52:32 AM 预售活动 接口类
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@Api(tags = "微信 API")
public class WeChatController {

	@Autowired
	AuthService authService;

	@Autowired
	WechatService weChatService;

	@ApiOperation(value = "绑定openid")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_BIND_OPENID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> bindOpenid(
			@Valid @ApiParam(value = "登录", required = true) @RequestBody BindOpenIdRequest request) {
		Boolean success = authService.bindOpenid(request.getOpenid(), request.getUaccount());
		return new ApiResponseData<>(success);
	}

	@ApiOperation(value = "根据openid获取统一账号")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_GET_UACCOUNT_BY_OPENID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> getUaccountByOpenid(
			@Valid @ApiParam(value = "openid", required = true) @PathVariable("openid") String openid) {
		if (!StringUtils.isEmpty(openid)) {
			String uaccount = authService.getUaccountByOpenid(openid);
			if (!StringUtils.isEmpty(uaccount)) {
				return new ApiResponseData<>(uaccount);
			} else {
				return ApiResponseData.notFound("找不到此帐号");
			}
		} else {
			return ApiResponseData.notEnough();
		}
	}

	@ApiOperation(value = "获取微信app信息")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_APPINFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<WechatAppDTO> getAppInfo(
			@Valid @ApiParam(value = "appid", required = true) @PathVariable(value = "appId", required = true) String appId) {
		WechatAppDTO appInfo = weChatService.getAppInfo(appId);
		if (appInfo != null) {
			return new ApiResponseData<>(appInfo);
		} else {
			return ApiResponseData.notFound("找不到此id");
		}
	}

//	@ApiOperation(value = "获取token")
//	@RequestMapping(value = WeChatApiConstants.WECHAT_API_GET_TOKEN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public GetTokenResponse getToken(@ApiParam(value = "tenantId", required = true) @Valid TokenRequest request) {
//		return authService.getToken(request);
//	}

	@ApiOperation(value = "微信登录获取信息")
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_LOGIN_USERINFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<WechatLoginUserInfo> getUserinfo(
			@Valid @ApiParam(value = "appid", required = true) @PathVariable String appid,
			@ApiParam(value = "code", required = true) @PathVariable String code) {
		return new ApiResponseData<>(weChatService.getUserInfo(appid, code));
	}
}
