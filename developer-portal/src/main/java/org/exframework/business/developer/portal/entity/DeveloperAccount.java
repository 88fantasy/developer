package org.exframework.business.developer.portal.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.exframework.portal.jdbc.entity.AccountDO;
import org.exframework.portal.metadata.dict.Dictionary;
import org.exframework.portal.metadata.dict.DictionaryEnum;
import org.exframework.portal.metadata.entity.EntityClass;
import org.exframework.support.doc.annotation.TableDoc;
import org.exframework.support.doc.annotation.TableFieldDoc;

/**
* @author rwe
* @version 创建时间：2021年4月21日 下午2:31:42
* 类说明
*/

@TableDoc("帐号")
@TableName(value = "account", excludeProperty = {"permissions", "modules"})
@EntityClass
public class DeveloperAccount extends AccountDO {

	private static final long serialVersionUID = -3057721031605971773L;
	
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





	@Dictionary( value = "accountDataSource", name = "帐号来源")
	public enum AccountDataSource implements DictionaryEnum {

		/**
		 *  本地
		 */
		LOCAL("本地"),

		/**
		 *  LDAP
		 */
		LDAP("LDAP")

		;

		private String label;

		private AccountDataSource(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

	}
	
	@Override
	public Class<? extends DictionaryEnum>[] enums() {
		return new Class[] {AccountDataSource.class};
	}
}
