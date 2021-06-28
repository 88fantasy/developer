package org.exframework.business.developer.wechat.http.client.entity;

import org.exframework.business.developer.wechat.entity.GetTokenResponse;

/**
 * @author rwe
 * @version 创建时间：2021年4月16日 下午2:30:37 类说明
 */

public class GetLoginCallBackTokenResponse extends GetTokenResponse {

	private static final long serialVersionUID = 2870660638835519954L;

	/**
	 * 用户刷新access_token
	 */
	private String refreshToken;

	/**
	 * 授权用户唯一标识
	 */
	private String openid;
	
	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	private String scope;
	
	/**
	 * 开放平台统一ID
	 * 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
	 */
	private String unionid;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
}
