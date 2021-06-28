package org.exframework.business.developer.wechat.service;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.exframework.business.developer.core.dto.wechat.GetTokenResponse;
import org.exframework.business.developer.core.dto.wechat.TokenRequest;
import org.exframework.business.developer.wechat.constant.WeChatConstants;
import org.exframework.business.developer.wechat.http.client.jsapi.WeChatJsClient;

/**
 * @author rwe
 * @version 创建时间：Feb 10, 2020 8:53:13 PM 微信相关服务
 */
@Service
public class AuthService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WeChatJsClient weChatJsClient;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

//	private final String ACCESS_TOKEN_KEY = KEY_PREFIX.concat("access-token");
//	private final String JSAPI_TICKET_KEY = KEY_PREFIX.concat("jsapi-ticket");

//	private final String APP_ID = "wx0739399759ec14dc";
//	private final String APP_SECRET = "4ded36cfd4cc465ed66ce9d1ad59b87f";

//	public OperateResult getJsSignature(String url) {
//		OperateResult or = new OperateResult(false);
//		try {
//			WechatSign sign = getSign(url);
//			or.setData(sign);
//			or.setSuccess(true);
//		} catch (Exception e) {
//			or.setMessage(e.getMessage());
//		}
//		return or;
//	}

	/**
	 * 根据 openid 获取统一帐号
	 * 
	 * @param openid
	 * @return uaccount or null if not exists
	 */
	public String getUaccountByOpenid(String openid) {
		if (!StringUtils.isEmpty(openid)) {
			String key = MessageFormat.format(WeChatConstants.WECHAT_OPENID_BASE, openid);
			return (String) redisValue().get(key);
		} else {
			return null;
		}
	}

	public boolean bindOpenid(String openid, String uaccount) {
		String key = MessageFormat.format(WeChatConstants.WECHAT_OPENID_BASE, openid);
		if (StringUtils.isEmpty(uaccount)) {
			redisTemplate.delete(key);
			return true;
		} else {
			return redisTemplate.opsForValue().setIfAbsent(key, uaccount);
		}
	}

	public GetTokenResponse getToken(TokenRequest request) {
		String token = null;
		long expire = WeChatConstants.EXPIRE_DATE;
		String tenantId = request.getTenantId();
		String secret = request.getSecret();
		String key = MessageFormat.format(WeChatConstants.WECHAT_TENANT_TOKEN_BASE, tenantId);
		if (redisTemplate.hasKey(key)) {
			token = (String) redisValue().get(key);
			expire = redisTemplate.getExpire(key);
		} else {
			try {
				// 过期时间
				Date date = new Date(System.currentTimeMillis() + (WeChatConstants.EXPIRE_DATE * 1000));
				// 秘钥及加密算法
				Algorithm algorithm = Algorithm.HMAC256(WeChatConstants.TOKEN_SECRET);
				// 设置头部信息
				Map<String, Object> header = new HashMap<>();
				header.put("typ", "JWT");
				header.put("alg", "HS256");
				// 携带username，password信息，生成签名
				token = JWT.create().withHeader(header).withClaim("username", tenantId).withClaim("password", secret)
						.withExpiresAt(date).sign(algorithm);
				redisValue().setIfAbsent(key, token, expire, TimeUnit.SECONDS);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
				GetTokenResponse response = new GetTokenResponse();
				response.setErrcode(500);
				response.setErrmsg("生成 token 失败:" + e.getMessage());
				return response;
			}
		}
		return new GetTokenResponse(token, expire);
	}

//	private WechatSign getSign(String url) throws Exception {
//		WechatSign result = new WechatSign();
//		String ticket = getTicket();
//
//		String noncestr = RandomStringUtils.randomAlphanumeric(16);
//		long timestamp = new Date().getTime() / 1000;
//
//		String toSignStr = "jsapi_ticket=".concat(ticket).concat("&noncestr=").concat(noncestr).concat("&timestamp=")
//				.concat(String.valueOf(timestamp).concat("&url=").concat(url));
//		String sign = getSHA1(toSignStr);
//		result.setAppId(APP_ID);
//		result.setTimestamp(timestamp);
//		result.setSignature(sign);
//		result.setNonceStr(noncestr);
//		return result;
//	}

//	private String getToken(String appid, String secret) throws Exception {
//		String token = (String) redisUtil.get(ACCESS_TOKEN_KEY);
//		if (token == null || "".equals(token)) {
//			weChatJsClient.getToken(appid, secret);
//			if (tokenString != null) {
//				JSONObject tokenJson = JSON.parseObject(tokenString);
//				String accessToken = tokenJson.getString("access_token");
//				int expiresIn = tokenJson.getIntValue("expires_in");
//				if( accessToken != null && !"".equals(accessToken)) {
//					redisUtil.set(ACCESS_TOKEN_KEY, accessToken, expiresIn - 60);
//					token = accessToken;
//				}
//				else {
//					throw new Exception("获取token失败:".concat(tokenJson.getString("errmsg").concat("["+tokenJson.getString("errcode"))+"]"));
//				}
//			}
//		}
//		return token;
//	}

//	private String getTicket() throws Exception {
//		String ticket = (String) redisUtil.get(JSAPI_TICKET_KEY);
//		if (ticket == null || "".equals(ticket)) {
//			String token = getToken();
//			String ticketurl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + token
//					+ "&type=jsapi";
//			String ticketString = HttpClientUtils.httpGet(ticketurl);
//			if (ticketString != null) {
//				JSONObject ticketJson = JSON.parseObject(ticketString);
//				String jsapiTicket = ticketJson.getString("ticket");
//				int expiresIn = ticketJson.getIntValue("expires_in");
//				if( jsapiTicket != null && !"".equals(jsapiTicket)) {
//					redisUtil.set(JSAPI_TICKET_KEY, jsapiTicket, expiresIn - 60);
//					ticket = jsapiTicket;
//				}
//				else {
//					throw new Exception("获取ticket失败:".concat(ticketJson.getString("errmsg").concat("["+ticketJson.getString("errcode"))+"]"));
//				}
//			}
//		}
//		return ticket;
//	}

	private String getSHA1(String signstr) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(signstr.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		String str = "jsapi_ticket=30_SH8TV36Mpcqnw1HF1VGU8f0_7R31_5oFISZDhB_y6uybd2vtdSFbVolXmqqkRJQdyyIYR_DMAqSLeMzsK0o6Zj8ctt04Iw4Lnr2ofCDPpvlvtepL_uXzWvCai2p6Xd1cLi4PvyGrJRSZmKDbEILlCBAIMP&noncestr=gJxFju8hpMgiGyuf&timestamp=1581563422&url=http://cloud.wechat.gzmpc.com/sale";
		AuthService s = new AuthService();
		System.out.print(s.getSHA1(str));
	}

	private ValueOperations<String, Object> redisValue() {
		return redisTemplate.opsForValue();
	}
}
