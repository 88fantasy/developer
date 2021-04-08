package com.gzmpc.business.developer.core.constant;

/**
 * @author rwe
 * @version 创建时间：Dec 9, 2020 10:47:59 AM 类说明
 */

public interface MessageApiConstants {

	String MESSAGE_EMAIL_BASE = "v1/email";

	String MESSAGE_EMAIL_SEND = MESSAGE_EMAIL_BASE + "/send";

	String MESSAGE_EMAIL_ATTACHMENT = MESSAGE_EMAIL_BASE + "/attachment";

	String MESSAGE_SNS_BASE = "v1/sns";

	String MESSAGE_SNS_SEND = MESSAGE_SNS_BASE + "/send";
}