package com.gzmpc.business.developer.portal.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.gzmpc.support.rest.exception.ApiException;


/**
* @author rwe
* @version 创建时间：Nov 11, 2020 2:22:29 PM
* 全局错误处理
*/

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResponseData<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
      BindingResult bindingResult = e.getBindingResult();
      StringBuilder sb = new StringBuilder("校验失败:");
      for (FieldError fieldError : bindingResult.getFieldErrors()) {
          sb.append(fieldError.getField() + "：" + fieldError.getDefaultMessage() + "; ");
      }
      return new ApiResponseData<String>(ResultCode.BAD_REQUEST,sb.toString());
  }
	
	@ExceptionHandler(ApiException.class)
  public ApiResponseData<String> handleApiException(ApiException e){
      return new ApiResponseData<String>(ResultCode.BAD_REQUEST, e.getMessage());
  }
}
