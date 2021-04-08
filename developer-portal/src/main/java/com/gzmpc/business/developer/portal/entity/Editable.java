package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

/**
* @author rwe
* @version 创建时间：Oct 15, 2020 4:00:05 PM
*  编辑者
*/

public class Editable implements Serializable {

	private static final long serialVersionUID = -8322825586742977459L;

	@TableField
  private String creatorId;

	@TableField
  private Date createDate;

	@TableField
  private String updateId;

	@TableField
  private Date updateDate;

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
}
