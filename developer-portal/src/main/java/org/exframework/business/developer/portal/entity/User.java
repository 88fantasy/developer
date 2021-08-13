package org.exframework.business.developer.portal.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.exframework.portal.metadata.dict.Dictionary;
import org.exframework.portal.metadata.dict.DictionaryEnumClass;
import org.exframework.portal.metadata.entity.EntityClass;
import org.exframework.portal.metadata.sys.Account;
import org.exframework.support.common.enums.DictionaryEnum;
import org.exframework.support.doc.annotation.TableDoc;
import org.exframework.support.doc.annotation.TableFieldDoc;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rwe
 * @version 创建时间：2021年4月21日 下午2:31:42
 * 类说明
 */

@TableDoc("用户")
@TableName(value = "user")
@EntityClass
public class User implements Serializable, DictionaryEnumClass {

    private static final long serialVersionUID = -3057721031605971773L;

    @TableFieldDoc("帐号Id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 登陆账号ID
     */
    @TableFieldDoc("登陆账号")
    @TableField
    private String account;

    /**
     * 密码
     */
    @TableFieldDoc("密码")
    @TableField
    private String password;

    /**
     * 帐号名称
     */
    @TableFieldDoc("用户名")
    @TableField
    private String userName;

    /**
     * 最近登录日期
     */
    @TableFieldDoc("最近登录日期")
    @TableField
    @ColumnType(value = MySqlTypeConstant.DATETIME)
    private Date lastLoginDate;

    /**
     * 最近登录 IP
     */
    @TableFieldDoc("最近登录 IP")
    @TableField
    private String lastLoginIp;

    /**
     * 最近登录地区
     */
    @TableFieldDoc("最近登录地区")
    @TableField
    private String lastLoginArea;

    /**
     * 帐号状态
     */
    @TableFieldDoc("帐号状态")
    @TableField
    @EnumValue
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    private Account.AccountStatusTypeEnum accountStatus;

    /**
     * 登陆账号ID
     */
    @TableFieldDoc("帐号来源")
    @TableField
    @EnumValue
    @ColumnType(value = MySqlTypeConstant.VARCHAR)
    private AccountDataSource dataSource;

    @TableFieldDoc("邮箱")
    @TableField
    private String email;

    @TableFieldDoc("岗位")
    @TableField
    private String title;

    @TableFieldDoc("组织架构")
    @TableField
    private String org;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginArea() {
        return lastLoginArea;
    }

    public void setLastLoginArea(String lastLoginArea) {
        this.lastLoginArea = lastLoginArea;
    }

    public Account.AccountStatusTypeEnum getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Account.AccountStatusTypeEnum accountStatus) {
        this.accountStatus = accountStatus;
    }

    public AccountDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(AccountDataSource dataSource) {
        this.dataSource = dataSource;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }


    @Dictionary(value = "accountDataSource", name = "帐号来源")
    public enum AccountDataSource implements DictionaryEnum {

        /**
         * 本地
         */
        LOCAL("本地"),

        /**
         * LDAP
         */
        LDAP("LDAP");

        private String label;

        private AccountDataSource(String label) {
            this.label = label;
        }

        @Override
        public String getLabel() {
            return label;
        }

    }

    @Override
    public Class<? extends DictionaryEnum>[] enums() {
        return new Class[]{AccountDataSource.class};
    }
}
