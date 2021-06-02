package com.gzmpc.business.developer.wechat.service.miniprogram;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gzmpc.business.developer.common.dto.WechatAppDTO;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.dto.miniprogram.AppDateRangeRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.AppDateRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.Code2SessionResponse;
import com.gzmpc.business.developer.wechat.dto.miniprogram.GetRetainRequest;
import com.gzmpc.business.developer.wechat.dto.miniprogram.GetUserPortraitRequest;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.WeChatMiniprogramClient;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.DateRange;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetDailySummary;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetDailySummaryResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetRetainClientResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetUserPortraitResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetVisitPageResponse;
import com.gzmpc.business.developer.wechat.service.WechatService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;

/**
 * @author rwe
 * @version 创建时间：Oct 3, 2020 10:01:58 PM 小程序 业务类
 */

@Service
public class MiniProgramService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private  final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Autowired
	WeChatMiniprogramClient weChatMiniprogramClient;

	@Autowired
	WechatService weChatService;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public ApiResponseData<Code2SessionResponse> code2Session(Code2SessionRequest request) {
		String appid = request.getAppid();
		String jscode = request.getJsCode();

		if (StringUtils.hasText(appid) && StringUtils.hasText(jscode)) {
			WechatAppDTO appInfo = weChatService.getAppInfo(appid);

			if (appInfo != null) {
				String secret = appInfo.getAppSecret();
				String key = MessageFormat.format(WeChatMiniProgramConstants.WECHAT_MP_SESSION_BASE, appid, secret, jscode);
				Code2SessionResponse session = (Code2SessionResponse) redisTemplate.opsForValue().get(key);
				if (session == null) {
					GetSessionResponse response = weChatMiniprogramClient.jscode2session(appid, secret, jscode);
					if (response != null && response.checkSuccess()) {
						Code2SessionResponse res = new Code2SessionResponse();
						BeanUtils.copyProperties(response, res);
						res.setSessionKey(response.getSession_key());
						redisTemplate.opsForValue().set(key, res, 300, TimeUnit.SECONDS);
						return new ApiResponseData<>(res);
					} else {
						String detailMessage = response == null ? "空值" : response.getErrcode() + ":" + response.getErrmsg();
						LOG.error(detailMessage);
						return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, detailMessage, null);
					}
				} else {
					return new ApiResponseData<>(session);
				}
			} else {
				return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, "appId尚未注册", null);
			}
		} else {
			return ApiResponseData.notEnough();
		}
	}

	public ApiResponseData<GetRetainClientResponse> getRetain(GetRetainRequest request) {
		if (StringUtils.hasText(request.getAppId())) {
			WechatAppDTO appInfo = weChatService.getAppInfo(request.getAppId());
			switch (request.getType()) {
			case DAILY:
				return new ApiResponseData<>(weChatMiniprogramClient.getDailyRetain(appInfo.getAppId(), request.getRequest()));
			case WEEKLY:
				return new ApiResponseData<>(weChatMiniprogramClient.getWeeklyRetain(appInfo.getAppId(), request.getRequest()));
			case MONTHLY:
				return new ApiResponseData<>(
						weChatMiniprogramClient.getMonthlyRetain(appInfo.getAppId(), request.getRequest()));
			}
		}
		return ApiResponseData.paramError();
	}

	public ApiResponseData<GetVisitPageResponse> getVisitPage(AppDateRequest request) {
		if (StringUtils.hasText(request.getAppId())) {
			WechatAppDTO appInfo = weChatService.getAppInfo(request.getAppId());
			DateRange range = new DateRange();
			range.setBegin_date(request.getDate());
			range.setEnd_date(request.getDate());
			return new ApiResponseData<>(weChatMiniprogramClient.getVisitPage(appInfo.getAppId(), range));
		}
		return ApiResponseData.paramError();
	}

	public ApiResponseData<GetDailySummaryResponse> getDailySummary(AppDateRangeRequest request) {
		if (StringUtils.hasText(request.getAppId())) {
			WechatAppDTO appInfo = weChatService.getAppInfo(request.getAppId());

			DateRange range = request.getRequest();
			try {
				List<DateRange> ranges = splitRange(range);
				List<GetDailySummary> summaries = new ArrayList<>();
				for (DateRange r : ranges) {
					GetDailySummaryResponse daily = weChatMiniprogramClient.getDailySummary(appInfo.getAppId(), r);
					if (daily.checkSuccess()) {
						summaries.addAll(daily.getList());
					}
				}
				GetDailySummaryResponse reponse = new GetDailySummaryResponse();
				reponse.setList(summaries);
				return new ApiResponseData<>(reponse);
			} catch (ParseException e) {
				LOG.error("日期格式错误:" + e.getMessage(), e);
				return new ApiResponseData<>(ResultCode.BAD_REQUEST, "日期格式错误", null);
			}
		}
		return ApiResponseData.paramError();

	}
	
	public ApiResponseData<GetUserPortraitResponse> getUserPortrait(GetUserPortraitRequest request) {
		if (StringUtils.hasText(request.getAppId())) {
			WechatAppDTO appInfo = weChatService.getAppInfo(request.getAppId());
			String date = request.getDate();
			int range = request.getRange();
			DateRange dateRange = new DateRange();
			try {
				Date begin = DateUtils.addDays(DateUtils.parseDate(date, "yyyyMMdd"), -(range-1));
				dateRange.setBegin_date(sdf.format(begin));
				dateRange.setEnd_date(date);
				return new ApiResponseData<>(weChatMiniprogramClient.getUserPortrait(appInfo.getAppId(), dateRange));
			} catch (ParseException e) {
				return ApiResponseData.paramError();
			}
		}
		return ApiResponseData.paramError();
	}

	private List<DateRange> splitRange(DateRange source) throws ParseException {
		Date begin = DateUtils.parseDate(source.getBegin_date(), "yyyyMMdd");
		Date end = DateUtils.parseDate(source.getEnd_date(), "yyyyMMdd");
		if (begin.after(end)) {
			throw new ParseException("开始日期大于结束日期", 0);
		} else {
			List<DateRange> ranges = new ArrayList<>();
			Date today = DateUtils.truncate(new Date(), Calendar.DATE);
			for (end = DateUtils.addDays(end, 1); !DateUtils.isSameDay(begin, end) && begin.before(today)
					&& !DateUtils.isSameDay(begin, today); begin = DateUtils.addDays(begin, 1)) {
				DateRange newRange = new DateRange();
				String day = sdf.format(begin);
				newRange.setBegin_date(day);
				newRange.setEnd_date(day);
				ranges.add(newRange);
			}
			return ranges;
		}
	}
}
