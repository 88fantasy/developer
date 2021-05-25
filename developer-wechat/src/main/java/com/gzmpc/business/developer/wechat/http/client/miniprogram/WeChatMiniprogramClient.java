package com.gzmpc.business.developer.wechat.http.client.miniprogram;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.http.client.com.ComAccessTokenInterceptor;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetDailySummaryResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetOcrBankCardResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetPaidUnionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetPerformanceDataRequest;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetPerformanceDataResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetRetainClientRequest;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetRetainClientResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetUserPortraitResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetVisitDistributionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetVisitPageResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetVisitTrendResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:49:38 PM
* 微信小程序 api
*/

public interface WeChatMiniprogramClient {

	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_CODE2SESSION, dataType = "json")
	GetSessionResponse jscode2session(@DataVariable("appid") String appid, @DataVariable("secret") String secret, @DataVariable("jscode") String jscode);
	
	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_GET_PAID_UNIONID + "&transaction_id=${transaction_id}", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class)
	GetPaidUnionResponse getPaidUnionId(@DataVariable("appid") String appid, @DataVariable("openid") String openid, @DataVariable("transaction_id") String transactionId);
	
	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_GET_PAID_UNIONID + "&mch_id=${mch_id}&out_trade_no=${out_trade_no}", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetPaidUnionResponse getPaidUnionId(@DataVariable("appid") String appid, @DataVariable("openid") String openid, @DataVariable("mch_id") String mchId, @DataVariable("mch_id") String outTradeNo);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_OCR_BANKCARD, dataType = "json", interceptor = ComAccessTokenInterceptor.class )
	GetOcrBankCardResponse ocrBankCard(@DataVariable("appid") String appid, @DataVariable("url") String imgUrl);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_DAILY_RETAIN, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetRetainClientResponse getDailyRetain(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_WEEKLY_RETAIN, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetRetainClientResponse getWeeklyRetain(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_MONTHLY_RETAIN, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetRetainClientResponse getMonthlyRetain(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);

	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_DAILY_SUMMARY, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetDailySummaryResponse getDailySummary(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);

	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_VISIT_PAGE, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetVisitPageResponse getVisitPage(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);

	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_VISIT_DISTRIBUTION, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetVisitDistributionResponse getVisitDistribution(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_USER_PORTRAIT, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetUserPortraitResponse getUserPortrait(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_DAILY_VISIT_TREND, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetVisitTrendResponse getDailyVisitTrend(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_WEEKLY_VISIT_TREND, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetVisitTrendResponse getWeeklyVisitTrend(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_MONTHLY_VISIT_TREND, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetVisitTrendResponse getMonthlyVisitTrend(@DataVariable("appid") String appid, @Body GetRetainClientRequest request);

	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_ANALYSIS_PERFORMANCE_DATA, contentType = "application/json", dataType = "json", interceptor = MiniprogramAccessTokenInterceptor.class )
	GetPerformanceDataResponse getPerformanceData(@DataVariable("appid") String appid, @Body GetPerformanceDataRequest request);

}
