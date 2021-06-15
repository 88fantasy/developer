package com.gzmpc.business.developer.core.dto.wechat;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月16日 下午2:55:31
* 微信登录信息返回
*/

@ApiModel(value="微信登录信息返回")
public class WechatLoginUserInfo extends GlobalResponse {

	/**
	 * 普通用户的标识，对当前开发者帐号唯一
	 */
	@ApiModelProperty(value = "普通用户的标识，对当前开发者帐号唯一")
	private String openid;
	
	/**
	 * 普通用户昵称
	 */
	@ApiModelProperty(value = "普通用户昵称")
	private String nickname;

	/**
	 * 普通用户性别，1为男性，2为女性
	 */
	@ApiModelProperty(value = "普通用户性别")
	private Integer sex;
	
	/**
	 * 省份
	 */
	@ApiModelProperty(value = "省份")
	private String province;
	
	/**
	 * 城市
	 */
	@ApiModelProperty(value = "城市")
	private String city;
	
	/**
	 * 国家
	 */
	@ApiModelProperty(value = "国家")
	private String country;
	
	/**
	 * 用户头像Url
	 * 有0、46、64、96、132数值可选，0代表640*640正方形头像
	 */
	@ApiModelProperty(value = "用户头像Url")
	private String headimgurl;
	
	/**
	 * 特权信息
	 */
	@ApiModelProperty(value = "特权信息")
	private List<String> privilege;
	
	/**
	 * 用户统一标识
	 * 同一用户的unionid是唯一
	 */
	@ApiModelProperty(value = "用户统一标识")
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public List<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
}
