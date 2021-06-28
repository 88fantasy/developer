package org.exframework.business.developer.portal.exception;

/**
* @author rwe
* @version 创建时间：2021年4月19日 下午11:25:49
* 需要登录错误
*/

public class NeedLoginException extends RuntimeException {

	private static final long serialVersionUID = -8475273812193047343L;

	public NeedLoginException() {
		super();
	}

	public NeedLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public NeedLoginException(String message) {
		super(message);
	}

	public NeedLoginException(Throwable cause) {
		super(cause);
	}

}
