package org.exframework.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.exframework.business.developer.rule.rules.entity.PubCompany;
import org.exframework.business.developer.rule.rules.entity.PubCustomer;
import org.exframework.business.developer.rule.rules.entity.PubGoods;
import org.exframework.business.developer.rule.rules.entity.PubSupplyer;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午5:47:02
* 主数据获取
*/

public interface MdmMapper {

	@Select(" select * from pub_customer o  ${ew.customSqlSegment}")
	List<PubCustomer> listPubCustomer(@Param(Constants.WRAPPER) Wrapper<PubCustomer> wrapper);
	
	@Select(" select * from pub_supplyer o  ${ew.customSqlSegment}")
	List<PubSupplyer> listPubSupplyer(@Param(Constants.WRAPPER) Wrapper<PubSupplyer> wrapper);
	
	@Select(" select * from pub_company o  ${ew.customSqlSegment}")
	List<PubCompany> listPubCompany(@Param(Constants.WRAPPER) Wrapper<PubCompany> wrapper);
	
	@Select(" select * from pub_goods o  ${ew.customSqlSegment}")
	List<PubGoods> listPubGoods(@Param(Constants.WRAPPER) Wrapper<PubGoods> wrapper);
}
