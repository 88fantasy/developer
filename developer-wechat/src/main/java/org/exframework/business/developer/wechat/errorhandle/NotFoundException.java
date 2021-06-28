package org.exframework.business.developer.wechat.errorhandle;

/**
* @author rwe
* @version 创建时间：2021年4月24日 上午11:29:35
* 找不到 错误类
*/

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2750555753496124463L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}

}
