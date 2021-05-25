package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午12:04:33
* 类说明
*/

public class GetUserPortrait {

	private List<GetUserPortraitItem> province;
	
	private List<GetUserPortraitItem> city;
	
	private List<GetUserPortraitItem> genders;
	
	private List<GetUserPortraitItem> platforms;
	
	private List<GetUserPortraitItem> devices;
	
	private List<GetUserPortraitItem> ages;
	
	public List<GetUserPortraitItem> getProvince() {
		return province;
	}
	public void setProvince(List<GetUserPortraitItem> province) {
		this.province = province;
	}
	public List<GetUserPortraitItem> getCity() {
		return city;
	}
	public void setCity(List<GetUserPortraitItem> city) {
		this.city = city;
	}
	public List<GetUserPortraitItem> getGenders() {
		return genders;
	}
	public void setGenders(List<GetUserPortraitItem> genders) {
		this.genders = genders;
	}
	public List<GetUserPortraitItem> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<GetUserPortraitItem> platforms) {
		this.platforms = platforms;
	}
	public List<GetUserPortraitItem> getDevices() {
		return devices;
	}
	public void setDevices(List<GetUserPortraitItem> devices) {
		this.devices = devices;
	}
	public List<GetUserPortraitItem> getAges() {
		return ages;
	}
	public void setAges(List<GetUserPortraitItem> ages) {
		this.ages = ages;
	}
	
	
}
