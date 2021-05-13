package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.ZxBusiControlDefDoc;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年4月24日 下午10:45:26
* 映射类
*/

public interface ZxBusiControlDefDocMapper extends ExBaseMapper<ZxBusiControlDefDoc>{
	
	@Select("select t.docid,t.columnname,t.controlflag,t.jyfwmsg,c.compsubtype as optype,t.companytype,t.approvemanid "
			+ "FROM SYS_OP o, ZX_BUSICONTROL_DEF_DOC t, SYS_COMP c WHERE o.opid = t.opid AND o.COMPID = c.COMPID "
			+ "and t.opid =  #{opid} AND t.flag = 0 order by t.companytype;")
	List<ZxBusiControlDefDoc> SelectZxBusiControlDefDocByOpid(@Param("opid")Long opid);

}
