package com.gzmpc.business.developer.portal.exception;

/**
* @author rwe
* @version 创建时间：2021年4月20日 上午11:51:35
* 未授权错误
*/

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = -5243459729641732952L;

	public ForbiddenException() {
		super();
	}

	public ForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForbiddenException(String message) {
		super(message);
	}

	public ForbiddenException(Throwable cause) {
		super(cause);
	}

}
