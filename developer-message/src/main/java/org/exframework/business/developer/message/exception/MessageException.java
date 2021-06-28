package org.exframework.business.developer.message.exception;

public class MessageException extends Exception {

	private static final long serialVersionUID = 5334473742204040004L;

	public MessageException(String message) {
		super(message);
	}

	/**
	 * Create an AccessException with a specific message and cause.
	 * @param message the message
	 * @param cause the cause
	 */
	public MessageException(String message, Exception cause) {
		super(message, cause);
	}
	
}
