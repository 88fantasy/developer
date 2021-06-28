package org.exframework.business.developer.portal.dto;

import java.util.Collection;


/**
* @author rwe
* @version 创建时间：2021年6月18日 下午4:49:14
* 权限集合列表返回
*/

public class DeveloperPermissionListResponse {

	private String code;
	
	private String title;
	
	private Collection<PermissionDTO> permissions;

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

	public Collection<PermissionDTO> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	
	
}
