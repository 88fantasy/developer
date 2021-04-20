package com.gzmpc.business.developer.portal.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;


/**
* @author rwe
* @version 创建时间：Nov 11, 2020 2:22:29 PM
* 全局错误处理
*/

@RestControllerAdvice
public class PortalExceptionHandler {

	@ExceptionHandler(NeedLoginException.class)
  public ApiResponseData<String> handleNeedLoginException(NeedLoginException e){
      return new ApiResponseData<String>(ResultCode.UNAUTHORIZED, null);
  }
	
	@ExceptionHandler(ForbiddenException.class)
  public ApiResponseData<String> handleUnAuthorizedException(ForbiddenException e){
      return new ApiResponseData<String>(ResultCode.FORBIDDEN, null);
  }
}
