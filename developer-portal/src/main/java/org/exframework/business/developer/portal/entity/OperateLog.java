package org.exframework.business.developer.portal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccount;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccountName;
import org.exframework.support.jdbc.annotation.AutoCurrentTime;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志
 *
 * @author rwe
 * @date 2021/7/1 17:36
 **/

@TableName("operate_log")
public class OperateLog implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField
    private String moduleCode;

    @TableField
    private String content;

    @TableField
    private String sourceId;

    @TableField
    private String param;

    @AutoCurrentAccount
    @TableField
    private String account;

    @AutoCurrentAccountName
    @TableField
    private String accountName;

    @AutoCurrentTime
    @TableField
    @ColumnType(value = MySqlTypeConstant.DATETIME)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
