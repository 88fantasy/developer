package com.gzmpc.business.developer.portal.entity;

import java.util.Date;

/**
* @author rwe
* @version 创建时间：2021年5月14日 上午9:50:09
* 版本控制
*/

public interface Version {

	Integer getVersion();

	void setVersion(Integer version);

	Date getVersionTime();

	void setVersionTime(Date versionTime);

	default void nextVersion() {
		Integer version = getVersion();
		if(version == null) {
			version = 1;
		}
		else {
			version++;
		}
		setVersion(version);
		setVersionTime(new Date());
	}
	
}
