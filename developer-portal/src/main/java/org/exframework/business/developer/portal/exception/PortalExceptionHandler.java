package org.exframework.business.developer.portal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.exframework.portal.exception.NotFoundException;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.enums.ResultCode;

/**
 * @author rwe
 * @version 创建时间：Nov 11, 2020 2:22:29 PM 全局错误处理
 */

@RestControllerAdvice
public class PortalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(NeedLoginException.class)
	public ApiResponseData<String> handleNeedLoginException(NeedLoginException e) {
		logger.error(e.getMessage(), e);
		return new ApiResponseData<String>(ResultCode.UNAUTHORIZED, e.getMessage(), null);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ApiResponseData<String> handleUnAuthorizedException(ForbiddenException e) {
		logger.error(e.getMessage(), e);
		return new ApiResponseData<String>(ResultCode.FORBIDDEN, e.getMessage(), null);
	}

	@ExceptionHandler(NotFoundException.class)
	public ApiResponseData<?> handleNotFoundException(NotFoundException e) {
		logger.error(e.getMessage(), e);
		return new ApiResponseData<>(ResultCode.BAD_REQUEST, e.getMessage(), null);
	}

	@ExceptionHandler(Exception.class)
	public ApiResponseData<?> handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage(), null);
	}
}
