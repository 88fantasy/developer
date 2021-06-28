package org.exframework.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.exframework.business.developer.common.dto.RequestLogger;

/**
 * @author rwe
 * @version 创建时间：2021年6月10日 下午4:07:22 
 * 请求日志
 */

@TableName("request_log")
public class RequestLog extends RequestLogger implements Serializable {

	private static final long serialVersionUID = 6986247409021478702L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long requestId;

	@TableField
	private String method;

	@TableField
	private String uri;

	@TableField
	private String params;

	@TableField
	private Integer statusCode;

	@TableField
	private Long executeTime;

	@TableField
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date createTime;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

}
