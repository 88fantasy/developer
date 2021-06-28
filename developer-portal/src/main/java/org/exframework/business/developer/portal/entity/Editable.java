package org.exframework.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccount;
import org.exframework.support.jdbc.annotation.AutoCreateTime;
import org.exframework.support.jdbc.annotation.AutoUpdateTime;

/**
* @author rwe
* @version 创建时间：Oct 15, 2020 4:00:05 PM
*  编辑者
*/

public class Editable implements Serializable {

	private static final long serialVersionUID = -8322825586742977459L;

	@AutoCurrentAccount
	@TableField(fill = FieldFill.INSERT)
  private String creator;

	@AutoCreateTime
	@TableField(fill = FieldFill.INSERT)
  private Date createTime;

	@AutoCurrentAccount
	@TableField(fill = FieldFill.UPDATE)
  private String updator;

	@AutoUpdateTime
	@TableField(fill = FieldFill.UPDATE)
  private Date updateTime;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
