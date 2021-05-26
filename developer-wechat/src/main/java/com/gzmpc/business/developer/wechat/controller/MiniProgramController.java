package com.gzmpc.business.developer.wechat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.core.constant.WeChatMiniProgramApiConstants;
import com.gzmpc.business.developer.wechat.dto.miniprogram.AppDateRangeRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.AppDateRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionResponse;
import com.gzmpc.business.developer.wechat.dto.miniprogram.GetRetainRequest;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetDailySummaryResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetRetainClientResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetUserPortraitResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetVisitPageResponse;
import com.gzmpc.business.developer.wechat.service.miniprogram.MiniProgramService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.exception.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 10:52:32 AM 预售活动 
 * 接口类
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@Api(tags = "微信小程序 API")
public class MiniProgramController {

	@Autowired
	MiniProgramService miniprogramService;

	@ApiOperation(value = "登录")
	@RequestMapping(value = WeChatMiniProgramApiConstants.WECHAT_MP_API_CODE2SESSION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Code2SessionResponse code2Session(@ApiParam(value = "登录", required = true) @RequestBody Code2SessionRequest request) throws ApiException {
		ApiResponseData<Code2SessionResponse> result = miniprogramService.code2Session(request);
		if(result.isStatus()) {
			return result.getData();
		}
		else {
			throw new ApiException(result.getMessage());
		}
	}
	
	@ApiOperation(value = "获取留存数据")
	@RequestMapping(value = WeChatMiniProgramApiConstants.WECHAT_MP_API_GET_RETAIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<GetRetainClientResponse> getRetainResponse(@ApiParam(required = true) @Valid @RequestBody GetRetainRequest request) throws ApiException {
		return miniprogramService.getRetain(request);
	}
	
	@ApiOperation(value = "获取页面访问数据")
	@RequestMapping(value = WeChatMiniProgramApiConstants.WECHAT_MP_API_BASE+"/getVisitPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<GetVisitPageResponse> getVisitPageResponse(@ApiParam(required = true) @Valid @RequestBody AppDateRequest request) throws ApiException {
		return miniprogramService.getVisitPage(request);
	}
	
	@ApiOperation(value = "获取用户访问数据")
	@RequestMapping(value = WeChatMiniProgramApiConstants.WECHAT_MP_API_BASE+"/getDailySummary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<GetDailySummaryResponse> getDailySummary(@ApiParam(required = true) @Valid @RequestBody AppDateRangeRequest request) throws ApiException {
		return miniprogramService.getDailySummary(request);
	}
	
	@ApiOperation(value = "获取用户画像数据")
	@RequestMapping(value = WeChatMiniProgramApiConstants.WECHAT_MP_API_BASE+"/getUserPortrait", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<GetUserPortraitResponse> getUserPortrait(@ApiParam(required = true) @Valid @RequestBody AppDateRequest request) throws ApiException {
		return miniprogramService.getUserPortrait(request);
	}
}
