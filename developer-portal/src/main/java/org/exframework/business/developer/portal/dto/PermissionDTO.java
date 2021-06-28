package org.exframework.business.developer.portal.dto;

/**
* @author rwe
* @version 创建时间：2021年6月18日 下午4:50:50
* 类说明
*/

public class PermissionDTO {

	private String code;

	private String title;
	
	private Boolean disabled;
	
	private Boolean checked;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
}
