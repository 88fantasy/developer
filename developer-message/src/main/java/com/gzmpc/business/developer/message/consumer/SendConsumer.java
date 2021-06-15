//package com.gzmpc.business.developer.message.consumer;
//
//import java.text.MessageFormat;
//
//import org.apache.pulsar.client.api.Consumer;
//import org.apache.pulsar.client.api.MessageListener;
//import org.apache.pulsar.client.api.PulsarClientException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.gzmpc.business.developer.message.service.MessageService;
//import com.gzmpc.support.tdmq.annotation.TDMQConsumer;
//
///**
// * @author rwe
// * @version 创建时间：2021年3月24日 上午9:49:39 
// * 消息消费队列
// */
//
//@TDMQConsumer(value = "tdmq.topic.send")
//public class SendConsumer implements MessageListener<String> {
//
//	private static final long serialVersionUID = -8453219483294207298L;
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	MessageService messageService;
//
//	@Value("${spring.mail.username}")
//	String user;
//
//
//	@Override
//	public void received(Consumer<String> consumer, org.apache.pulsar.client.api.Message<String> msg) {
//		String json = msg.getValue();
//		try {
//			messageService.send(json);
//			consumer.acknowledge(msg);
//		} catch (PulsarClientException e) {
//			String message =  MessageFormat.format("发送消息失败 {0} : {1}" , e.getMessage(), json);
//			logger.error(message, e);
//		} finally {
//
//		}
//		
//	}
//}
