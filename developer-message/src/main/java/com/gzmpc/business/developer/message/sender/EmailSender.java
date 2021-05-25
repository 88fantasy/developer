package com.gzmpc.business.developer.message.sender;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.dto.SendEmailRequest;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.message.constant.MessageConstants;
import com.gzmpc.business.developer.message.entity.MessageUnion;
import com.gzmpc.business.developer.message.entity.MessageUnion.MessageType;
import com.gzmpc.business.developer.message.entity.MessageUnion.SendState;
import com.gzmpc.business.developer.message.exception.MessageException;
import com.gzmpc.business.developer.message.mapper.MessageUnionMapper;
import com.gzmpc.business.developer.message.service.Sender;
import com.gzmpc.spring.boot.autoconfigure.cos.CosClient;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.gzmpc.support.rest.exception.ApiException;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.transfer.Download;

/**
 * @author rwe
 * @version 创建时间：2021年3月24日 下午1:21:12 邮件发送
 */

@Service
public class EmailSender implements Sender {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MessageUnionMapper messageUnionMapper;
	
	@Autowired
	JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	String user;
	
	@Autowired
	CosClient cosClient;
	
	private Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@Override
	public void send(String json) throws MessageException {
		SendEmailRequest request = JSON.parseObject(json, SendEmailRequest.class);
		sendEmail(request);
	}
	
	public ApiResponseData<MessageResponse> sendEmail(SendEmailRequest request) {
		ApiResponseData<MessageResponse> res = new ApiResponseData<>(null);
		String to = request.getTarget().trim();
		String subject = request.getSubject();
		String content = request.getContent();
		String[] attachment = request.getAttachments();
		String typeCode = request.getTypeCode();
		String sourceData = request.getSourceData();
		String ip = request.getIp();
		MessageUnion union = new MessageUnion(typeCode, sourceData, subject, content, to, MessageType.EMAIL, ip);

		MimeMessage newMessage = javaMailSender.createMimeMessage();
		
		try {
			newMessage.setFrom(new InternetAddress(user));
	
			newMessage.setRecipients(javax.mail.Message.RecipientType.TO, translateAddress(to));
	
			newMessage.setHeader("X-Mailer", "gzmpc");
			newMessage.setSubject(subject);
			newMessage.setSentDate(new Date());
			if (attachment != null && attachment.length > 0) {
				Multipart mp = new MimeMultipart();
				MimeBodyPart text = new MimeBodyPart();
				text.setText(content, "utf-8");
				mp.addBodyPart(text);
				for (int i = 0, j = attachment.length; i < j; i++) {
					String cosUrl = attachment[i];
					if (StringUtils.hasText(cosUrl)) {
						File target = File.createTempFile("attachment", null);
						Download download = cosClient.download(cosUrl, target);
						String filename = download.getObjectMetadata().getUserMetaDataOf(MessageConstants.ATTACHMENT_FILENAME_KEY);
						if (target.exists() && target.isFile()) {
							MimeBodyPart attach = new MimeBodyPart();
							FileDataSource fds = new FileDataSource(target); // 得到数据源
							attach.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
							attach.setFileName(MimeUtility.encodeText(filename, "utf-8", null)); // 得到文件名同样至入BodyPart
							mp.addBodyPart(attach);
						} else {
							throw new ApiException("文件[" + attachment[i] + "]不存在");
						}
					}
					
				}
	
				newMessage.setContent(mp); // Multipart加入到信件
				newMessage.saveChanges();
				union.setExt1(String.join(",", attachment));
			} else {
				newMessage.setText(content, "utf-8");
			}
	
			javaMailSender.send(newMessage);
			union.setSendState(SendState.SUCCESS);
			union.setSendTime(new Date());

		} catch (MessagingException | ApiException | CosClientException | InterruptedException | IOException e) {
			String message = "发送邮件失败" + e.getMessage();
			logger.error(message, e);
			
			union.setSendState(SendState.FAIL);
			union.setFeedback(e.getMessage());
			union.setFailCount(1);
			res = ApiException.class.isAssignableFrom(e.getClass())? new ApiResponseData<>(ResultCode.BAD_REQUEST, e.getMessage(), null) : new ApiResponseData<>();
		} finally {
			messageUnionMapper.insert(union);
		}
		res.setData(new MessageResponse(union.getId()));
		return res;
		
	}


	private Address[] translateAddress(String toAddress) throws ApiException {
		List<Address> result = new ArrayList<Address>();
		if (toAddress != null) {
			String[] ads = toAddress.split(",");
			for (int i = 0, j = ads.length; i < j; i++) {
				String add = ads[i];
				if(!regex.matcher(add).find()) {
					throw new ApiException("无效地址:"+add);
				}
				try {
					result.add(new InternetAddress(add));
				} catch (AddressException e) {
					throw new ApiException(e.getMessage());
				}
			}
		}
		return result.toArray(new Address[result.size()]);
	}
}
