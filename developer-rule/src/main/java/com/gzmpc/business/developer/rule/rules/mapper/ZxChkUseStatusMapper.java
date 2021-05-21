package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.ZxChkUseStatus;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午6:20:10
* PubSupplyer
*/

public interface ZxChkUseStatusMapper extends ExBaseMapper<ZxChkUseStatus> {
	
	@Select("select actmsg,retcode from zx_chkusestatus where opid = #{opId} and usestatus = #{userStatus} and field = 'GOODSID'")
	HashMap SelectRetcode(@Param("opId")Long opId, @Param("userStatus")Integer userStatus);

}
