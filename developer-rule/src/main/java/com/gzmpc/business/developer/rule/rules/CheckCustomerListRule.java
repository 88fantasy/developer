package com.gzmpc.business.developer.rule.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.rules.entity.PubCustomer;
import com.gzmpc.business.developer.rule.rules.entity.PubGoods;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.entity.ZxBusiControlDefDoc;
import com.gzmpc.business.developer.rule.rules.entity.ZxLicenseToGoods;
import com.gzmpc.business.developer.rule.rules.mapper.MdmMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBusiControlDefDocMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxManageRangeMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxPubGoodsMsgMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月13日 上午10:39:39
* 
* 1 储备集合客户，客户一级属性是其他,保管帐是储备，跳过证照检查。 
* 2 储备客户跳过经营范围检查。 
* 3 检查货品需要的特殊证照 
* 4 判断单位是否属于设置范围内(pf_license_need_chk) 。
* 5 检查单位证照有效期是否过期。
*/

@RuleProperties(input = "companyid", output = "customerListFlag", tags = {"储备客户", "gzmpc"})
@Rule(name = "检查储备客户", description = "检查储备客户集合")
public class CheckCustomerListRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
	MdmMapper mdmMapper;
	
	@Autowired
	ZxBusiControlDefDocMapper zxBusiControlDefDocMapper;
	
	@Condition
    public boolean isUse(@Fact("companyid") long companyid, @Fact("goodsid") long goodsid, Facts facts) {
		boolean status = true;Integer opid = 818947;
		Integer flag = null;Integer controlFlag = null;
		Long storageId = null;Long customId = null; String slicenseid = null;
		//环节控制
		List<ZxBusiControlDefDoc> zxBusiControlDefDoc = zxBusiControlDefDocMapper.SelectCustomerListZxBusiControlDefDocByOpid(1623l);
		if(zxBusiControlDefDoc != null && zxBusiControlDefDoc.size() > 0) {
			System.out.println("--sss:" + zxBusiControlDefDoc.size());
			for(ZxBusiControlDefDoc doc: zxBusiControlDefDoc) {
				//1 储备集合客户，客户一级属性是其他,保管帐是储备，跳过证照检查
				if(opid == 818947) {
					Map<String, Object> map = facts.asMap();
			        if (map.containsKey("storageid")) {
			            storageId = (Long) map.get("storageid");
			        }
			        if (map.containsKey("customid")) {
			            customId = (Long) map.get("customid");
			        }
			        //跳过证照检查
			        Integer count = zxBusiControlDefDocMapper.SelectCountFromPubCustomerSetDtlByCustomId(customId);
			        if(count > 0 && (storageId == 99956 || storageId == 10565 ||storageId == 100006)) {
			        	continue;
			        }
			        
			      //2 客户经大众开票时，按大众商场的经营范围检查证照
			      /*if() {
			    	  
			      }*/   
				}
			}
			//分隔 pf_chk_goodszz 函数
			Long companytype = null;Integer supplyflag = null;Integer customflag = null;String companyno01 = null;String goodsno01 = null;
			if(companytype == 1) {
				supplyflag = 1;
				List<PubSupplyer> supplyers = mdmMapper.listPubSupplyer(Wrappers.<PubSupplyer>lambdaQuery().eq(PubSupplyer::getSupplyid, companyid));
				if(supplyers !=null && supplyers.size() >0) {
					companyno01 = supplyers.get(0).getNo01();
				}
			}else {
				customflag = 1;
				List<PubCustomer> customers = mdmMapper.listPubCustomer(Wrappers.<PubCustomer>lambdaQuery().eq(PubCustomer::getCustomid, companyid));
				if(customers !=null && customers.size() >0) {
					companyno01 = customers.get(0).getNo01();
				}
			}
			List<PubGoods> goods = mdmMapper.listPubGoods(Wrappers.<PubGoods>lambdaQuery().eq(PubGoods::getGoodsid, goodsid));
			if(goods !=null && goods.size() >0) {
				goodsno01 = goods.get(0).getNo01();
			}
			
			
			//储备客户跳过经营范围检查
			if(companytype == 2) {
				Integer cbFlag = zxBusiControlDefDocMapper.SelectCbflagFromPubCustomerSetDtl(customId);
				if(cbFlag > 0) {
					return status;
				}
			}
			
			//检查货品需要的特殊证照
			List<ZxLicenseToGoods> zxLicenseToGoods = new ArrayList<ZxLicenseToGoods>();String licenseflag = null;
			if(customflag == 1) {
				licenseflag = "a.customflag";
				zxLicenseToGoods = zxBusiControlDefDocMapper.SelectZxLicenseToGoodsByNo01(companyno01, goodsno01, licenseflag);
			}else if(supplyflag == 1) {
				licenseflag = "a.supplyflag";
				zxLicenseToGoods = zxBusiControlDefDocMapper.SelectZxLicenseToGoodsByNo01(companyno01, goodsno01, licenseflag);
			}
			
			for(ZxLicenseToGoods licenseGoods : zxLicenseToGoods) {
				//判断单位是否属于设置范围内
				if(licenseGoods !=null) {
					Integer chkFlag = zxBusiControlDefDocMapper.SelectChkFlagFromDual(companyid, licenseGoods.getLicenseid(), licenseGoods.getRowsid(), companytype);
					if(chkFlag > 0) {
						String goodsno = licenseGoods.getGoodsno();
						Long rowsid = licenseGoods.getRowsid();
						Integer zzrang = zxBusiControlDefDocMapper.SelectCountFromPubGoodsById(goodsno, rowsid, goodsid);
						if(zzrang > 0) {
							//货品的销售或进货需要该证照
							if(slicenseid == "") {
								slicenseid = String.valueOf(licenseGoods.getLicenseid());
							}else {
								slicenseid = slicenseid + "," + String.valueOf(licenseGoods.getLicenseid());
							}
						}
					}
				}
				//检查单位证照有效期是否过期
				Integer losezz = zxBusiControlDefDocMapper.selectpubDdlByCompanyId(companyid, slicenseid);
				if(losezz > 0) {
					status = false;
				}
			}
			
		}
		
		return status;
	}

	@Action
	public void doAction(Facts facts) {
		
	}
	
}
