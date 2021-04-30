package com.gzmpc.business.developer.message.sender;




import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.dto.SendSnsRequest;
import com.gzmpc.business.developer.common.enums.MessageFrom;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.message.config.MontnetsBean;
import com.gzmpc.business.developer.message.entity.MessageUnion;
import com.gzmpc.business.developer.message.entity.MontnetsAccount;
import com.gzmpc.business.developer.message.entity.MessageUnion.MessageType;
import com.gzmpc.business.developer.message.entity.MessageUnion.SendState;
import com.gzmpc.business.developer.message.exception.MessageException;
import com.gzmpc.business.developer.message.http.client.MessageClient;
import com.gzmpc.business.developer.message.http.client.entity.SendMessageHttpRequest;
import com.gzmpc.business.developer.message.http.client.entity.SendMessageHttpResponse;
import com.gzmpc.business.developer.message.mapper.MessageUnionMapper;
import com.gzmpc.business.developer.message.service.Sender;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.gzmpc.support.rest.exception.ApiException;
import com.gzmpc.support.rest.exception.ServerException;

/**
 * @author rwe
 * @version 创建时间：2021年3月24日 下午1:21:12 
 * 短信发送
 */

@Service
public class SnsSender implements Sender {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageUnionMapper messageUnionMapper;

	@Autowired
	MessageClient messageClient;

	@Autowired
	MontnetsBean montnetsBean;
	
	Pattern regex = Pattern.compile("^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$"); 

	@Override
	public void send(String json) throws MessageException {
		SendSnsRequest request = JSON.parseObject(json, SendSnsRequest.class);
		sendMessage(request);
	}
	
	public ApiResponseData<MessageResponse> sendMessage(SendSnsRequest request) {
		ApiResponseData<MessageResponse> res = new ApiResponseData<>(null);
		String body = request.getContent();
		String mobile = request.getTarget();
		MessageFrom from = request.getFrom();
		String svrtype = request.getSvrtype();
		String exno = request.getExno();
		String[] targets = mobile.split(",");
		
		String target = request.getTarget();
		String content = request.getContent();
		String typeCode = request.getTypeCode();
		String sourceData = request.getSourceData();
		String ip = request.getIp();
		MessageUnion union = new MessageUnion(typeCode, sourceData, null, content, target, MessageType.SNS, ip, from.getKey(), svrtype, exno, null, null);
		
		try {
			for (String t : targets) {
	      if (!regex.matcher(t).find()) {
	      	throw new ApiException("目标手机号非法[" + t + "] 在[" + targets.toString() + "]");
	      }
			}
			
			MontnetsAccount montnets = montnetsBean.getAccounts().stream().filter(account -> from.getKey().equals(account.getFrom())).findFirst().orElse(null);
			if(montnets != null) {
				SendMessageHttpRequest httpRequest = new SendMessageHttpRequest(montnets.getUserid(), montnets.getPwd(), mobile, body, svrtype, exno, null);
				SendMessageHttpResponse response = !mobile.contains(",") ? messageClient.sendSingle(montnets.getUrl(), httpRequest) : messageClient.sendBatch(montnets.getUrl(), httpRequest);
				if(response == null || response.getResult() != 0) {
					throw new ServerException(response == null? "无返回" : "错误码"+response.getResult());
				}
				else {
					union.setSendTargetId(response.getMsgid().toString());
					union.setSendState(SendState.SUCCESS);
					union.setSendTime(new Date());
					union.setFeedback(JSON.toJSONString(response));
				}
			}
			else {
				throw new ServerException("未配置帐号"+from);
			}
		} catch ( Exception e) {
			logger.error("发送短信失败[{}], 内容: {}", e.getMessage(), JSON.toJSONString(request));
			union.setSendState(SendState.FAIL);;
			union.setFeedback(e.getMessage());
			union.setFailCount(1);
			res = ApiException.class.isAssignableFrom(e.getClass())? new ApiResponseData<>(ResultCode.BAD_REQUEST, e.getMessage(), null) : new ApiResponseData<>();
		} finally {
			messageUnionMapper.insert(union);
		}
		res.setData(new MessageResponse(union.getId()));
		return res;
	}
	
}
