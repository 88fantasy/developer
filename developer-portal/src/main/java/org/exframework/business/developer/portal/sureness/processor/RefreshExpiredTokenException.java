package org.exframework.business.developer.portal.sureness.processor;

import com.usthe.sureness.processor.exception.SurenessAuthenticationException;

/**
 * refresh token message
 * 
 * @author tomsun28
 * @date 2020-12-03 23:29
 */
public class RefreshExpiredTokenException extends SurenessAuthenticationException {

	private static final long serialVersionUID = -5083374777343869580L;

	public RefreshExpiredTokenException(String message) {
		super(message);
	}
}
