package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.PubGoods;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午6:20:10
* PubSupplyer
*/

public interface ZxPubGoodsMsgMapper extends ExBaseMapper<PubGoods> {

	@Select("SELECT no01,nvl(chkjyfwflag,0) as chkjyfwflag,goodsname FROM pub_goods Where goodsid = #{goodsid}")
	HashMap SelectChkJyfwFlagByGoodsid(@Param("goodsid")Long goodsid);
}
