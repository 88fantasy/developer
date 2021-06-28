package org.exframework.business.developer.wechat.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatMiniProgramConstants {
	
	String WECHAT_MP_SESSION_BASE = "/wechat-auth/mp/session/{0}/{1}/{2}";
	
	String WECHAT_MP_TOKEN_BASE = "/wechat-auth/mp/token/{0}/{1}";
	
	String WECHAT_MP_BASE = "https://api.weixin.qq.com";
	
	String WECHAT_MP_API_TOKEN = WeChatConstants.WECHAT_API_TOKEN;

	String WECHAT_MP_API_CODE2SESSION = WECHAT_MP_BASE+"/sns/jscode2session?appid=${appid}&secret=${secret}&js_code=${jscode}&grant_type=authorization_code";
	
	String WECHAT_MP_API_GET_PAID_UNIONID = WECHAT_MP_BASE+"/wxa/getpaidunionid?openid=${openid}";
	
	String WECHAT_MP_API_OCR_BANKCARD = WECHAT_MP_BASE+"/cv/ocr/bankcard?img_url=${url}";

	String WECHAT_MP_API_ANALYSIS_DAILY_RETAIN = WECHAT_MP_BASE+"/datacube/getweanalysisappiddailyretaininfo?appid=${appid}";
	
	String WECHAT_MP_API_ANALYSIS_WEEKLY_RETAIN = WECHAT_MP_BASE+"/datacube/getweanalysisappidweeklyretaininfo?appid=${appid}";
	
	String WECHAT_MP_API_ANALYSIS_MONTHLY_RETAIN = WECHAT_MP_BASE+"/datacube/getweanalysisappidmonthlyretaininfo?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_DAILY_SUMMARY = WECHAT_MP_BASE+"/datacube/getweanalysisappiddailysummarytrend?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_VISIT_PAGE = WECHAT_MP_BASE+"/datacube/getweanalysisappidvisitpage?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_VISIT_DISTRIBUTION = WECHAT_MP_BASE+"/datacube/getweanalysisappidvisitdistribution?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_USER_PORTRAIT = WECHAT_MP_BASE+"/datacube/getweanalysisappiduserportrait?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_PERFORMANCE_DATA = WECHAT_MP_BASE+"/datacube/getweanalysisappidvisitdistribution?appid=${appid}";

	String WECHAT_MP_API_ANALYSIS_DAILY_VISIT_TREND = WECHAT_MP_BASE+"/datacube/getweanalysisappiddailyvisittrend?appid=${appid}";
	
	String WECHAT_MP_API_ANALYSIS_WEEKLY_VISIT_TREND = WECHAT_MP_BASE+"/datacube/getweanalysisappidweeklyvisittrend?appid=${appid}";
	
	String WECHAT_MP_API_ANALYSIS_MONTHLY_VISIT_TREND = WECHAT_MP_BASE+"/datacube/getweanalysisappidmonthlyvisittrend?appid=${appid}";

	String WECHAT_MP_API_GET_PERFORMANCE_DATA = WECHAT_MP_BASE+"/wxa/business/performance/boot?appid=${appid}";
	
	
}
