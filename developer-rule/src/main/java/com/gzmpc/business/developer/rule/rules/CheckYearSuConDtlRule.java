package com.gzmpc.business.developer.rule.rules;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.*;
import com.gzmpc.business.developer.rule.rules.mapper.*;
import com.gzmpc.business.developer.rule.util.FactsUtil;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static sun.security.krb5.Confounder.longValue;

/**
 * @author rwe
 * @version 创建时间：2021年4月24日 下午10:39:39 进货合同，进货退出时检查证照
 */

@RuleProperties(input = "supplyid,contracttype,signdate,List<BmsSuConDtl>", tags = {"进货合同", "采购", "年度合同"})
@Rule(name = "进货合同细单检查年度合同.", description = "在进货合同细单validdtl时，检查年度合同. 1商品合同以外，不需勾对年度合同。 2 检查年度合同数量是否满足 ，如曾同一时间段内，曾有年度合同完成或中止，则要求录入新的年度合同，才能录入进货合同；\n" +
        "  无则不作年度合同要求；\n" +
        "  年度合同中止可能是因为要调价；\n" +
        "  年度合同完成后可能会追加数量，但合同的结束日期未到，\n" +
        "  但这样会不允许合同中止或完成后，在期限内将品种当作非年度合同品种来操作。 3 对比新旧年度合同检查是否要重新勾兑 。4 合同版本类型为年度购销合同时检查年度协议剩余数量。")
public class CheckYearSuConDtlRule {

    @Autowired
    ZxBmsSuConYearMapper zxBmsSuConYearMapper;

    @Autowired
    ZxBmsSuConYearDocMapper zxBmsSuConYearDocMapper;

    @Autowired
    FactsUtil factsUtil;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map map = facts.asMap();

        if (!factsUtil.checkInput(facts, Arrays.asList("supplyid", "contracttype", "signdate", "bmsSuConDtl"))) {
            return false;
        }
        Long supplyId = (Long) map.get("supplyid");
        Integer contractType = (Integer) map.get("contracttype");
        List<BmsSuConDtl> bmsSuConDtls = (List) map.get("bmsSuConDtl");
        Date signDate = (Date) map.get("signdate");
        //商品合同以外，不需勾对年度合同
        if (contractType != 1) {
            return true;
        }
        for (int row = 0; row < bmsSuConDtls.size(); row++) {
            Long ySuConId = zxBmsSuConYearMapper.getYearSuConId(supplyId,  signDate);
            BmsSuConDtl bmsSuConDtl = bmsSuConDtls.get(row);
            Long ySuConDtlId = null;
            Long ySuConIdOld = bmsSuConDtl.getYsucondtlid();
            if (ySuConId == 0) {
                ySuConDtlId = zxBmsSuConYearMapper.getYearSuConDtlId(supplyId, bmsSuConDtl.getGoodsid(), signDate, Arrays.asList(2, 3));

                if (ySuConDtlId == 0) {
                    ySuConDtlId = zxBmsSuConYearMapper.getYearSuConDtlId(supplyId, bmsSuConDtl.getGoodsid(), signDate, Arrays.asList(4, 5));
                    //如曾同一时间段内，曾有年度合同完成或中止，则要求录入新的年度合同，才能录入进货合同
                    //无则不作年度合同要求
                    //年度合同中止可能是因为要调价
                    //年度合同完成后可能会追加数量，但合同的结束日期未到
                    //但这样会不允许合同中止或完成后，在期限内将品种当作非年度合同品种来操作
                    if (ySuConDtlId > 0) {
                        factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, MessageFormat.format("第{0}行品种：{1}要求勾对年度合同，但年度合同数量已用完，请重新签订年度合同。", row + 1, bmsSuConDtl.getGoodsid().toString()));
                        return false;
                    }
                    continue;
                }
                if (!ySuConDtlId.equals(ySuConIdOld) || ySuConIdOld == null) {
                    factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, MessageFormat.format("第{0}行品种：{1}请勾兑年度合同。", row + 1, bmsSuConDtl.getGoodsid().toString()));
                    return false;
                }
            }
            //细单内检查年度合同剩余数量。在afterupdate时会再检查一次总数
            Map remqtyMap = zxBmsSuConYearMapper.getRemqtyAndPriceByDtlId(ySuConDtlId);
            BigDecimal remQty = (BigDecimal) remqtyMap.get("REMQTY");
            BigDecimal yUnitPrice = (BigDecimal) remqtyMap.get("YUNITPRICE");
            ySuConId =  remqtyMap.get("YSUCONID")!=null?((BigDecimal)remqtyMap.get("YSUCONID")).longValue() :0 ;
            ZxBmsSuConYearDoc zxBmsSuConYearDoc = zxBmsSuConYearDocMapper.selectOne(Wrappers.<ZxBmsSuConYearDoc>lambdaQuery().eq(ZxBmsSuConYearDoc::getYsuconid,ySuConId));
            if(zxBmsSuConYearDoc!=null){
                if (zxBmsSuConYearDoc.getConvertype()==2){
                    if(remQty.doubleValue()<bmsSuConDtl.getGoodsqty().doubleValue()){
                        factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, MessageFormat.format("第{0}行品种：{1} 年度协议剩余数量不足，不能继续录入进货合同。", row + 1, bmsSuConDtl.getGoodsid().toString()));
                        return false;
                    }
                };
            }

        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {

    }
}
