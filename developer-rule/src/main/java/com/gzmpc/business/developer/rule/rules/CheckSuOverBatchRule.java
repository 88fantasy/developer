package com.gzmpc.business.developer.rule.rules;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.BmsSuConDtl;
import com.gzmpc.business.developer.rule.rules.mapper.BmsSuConDtlMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBmsSuOverbatchApplyMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RuleProperties(input = "contracttype,List<BmsSuConDtl>", output = "obapplyid", tags = {"进货合同", "采购", "超批量审批"})
@Rule(name = "进货合同细单，检查超批量审批", description = "1合同细单按确定时，如为超批量采购，则勾对超批量申请单ID。2状态非“已签”的合同细单，不更新超批量申请单的勾对信息。3 非新增或修改数量的合同细单，不更新超批量申请单的勾对信息。")
public class CheckSuOverBatchRule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ZxBmsSuOverbatchApplyMapper zxBmsSuOverbatchApplyMapper;

    @Autowired
    BmsSuConDtlMapper bmsSuConDtlMapper;

    @Autowired
    FactsUtil factsUtil;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map<String, Object> map = facts.asMap();
        Integer contracttype = (Integer) facts.get("contracttype");
        List<BmsSuConDtl> bmsSuConDtls = (List<BmsSuConDtl>) facts.get("bmsSuConDtl");
//        if (!map.containsKey("contracttype")||!map.containsKey("goodsid")||
//                !map.containsKey("usestatus")||!map.containsKey("goodsqty")){
//
//        }

        for (int i = 0; i < bmsSuConDtls.size(); i++) {
            BmsSuConDtl nowDtl = bmsSuConDtls.get(i);
            Integer usestatus = nowDtl.getUsestatus();
            BigDecimal goodsqty = nowDtl.getGoodsqty();
            Long suConDtlId = nowDtl.getSucondtlid();
            //非“已签”的合同细单，不更新超批量申请单的勾对信息
            if (usestatus == null || usestatus != 2) {
                return true;
            }
            //合同类型为：1 商品合同 ， 2 样品合同 时进行控制
            if (!(contracttype == 1 || contracttype == 2)) {
                return true;
            }
            BmsSuConDtl oldBmsSuConDtl = bmsSuConDtlMapper.selectOne(Wrappers.<BmsSuConDtl>lambdaQuery().eq(BmsSuConDtl::getSucondtlid, suConDtlId));

            Long oldGoodsqty = oldBmsSuConDtl.getGoodsqty() != null ? oldBmsSuConDtl.getGoodsqty().longValue() : 0;
            Long oldQty = oldBmsSuConDtl.getObqty();
            Long modiQty = goodsqty.longValue() - oldGoodsqty;
            Long goodsId = nowDtl.getGoodsid();
            if (modiQty == 0) {
                return true;
            }
            Long obapplyId = nowDtl.getObapplyid();
            if ((obapplyId == null || obapplyId <= 0)) {
                obapplyId = zxBmsSuOverbatchApplyMapper.getApplyIdByGoodsId(goodsId);
            }

            Map qtyMap = zxBmsSuOverbatchApplyMapper.getBusiDtlQtyAndUpQty(goodsId);
            //货品分类数量
            BigDecimal busiDtlQty = (BigDecimal) qtyMap.get("BUSIDTLQTY")!=null ?(BigDecimal) qtyMap.get("BUSIDTLQTY"):BigDecimal.ZERO;
            //上限数量
            BigDecimal upQty = (BigDecimal) qtyMap.get("UPQTY")!=null ?(BigDecimal) qtyMap.get("UPQTY"):BigDecimal.ZERO ;
            //查未执行合同数
            Long unAccQty = zxBmsSuOverbatchApplyMapper.getUnAccQty(goodsId, suConDtlId);
            BigDecimal goodsQtyOthers = BigDecimal.ZERO;
            //统计同一合同内申请单ID一致且未保存细单（不包含当前细单）的货品数量和超批量数量的变更
            List<BmsSuConDtl> needList = bmsSuConDtls.stream().filter(p -> !p.getSucondtlid().equals(suConDtlId)).collect(Collectors.toList());
            for (BmsSuConDtl bmsSuConDtl : needList) {
                if (!goodsId.equals(bmsSuConDtl.getGoodsid())) {
                    continue;
                }
                if (!obapplyId.equals(bmsSuConDtl.getObapplyid())) {
                    continue;
                }
                BigDecimal currGoodsQty = bmsSuConDtl.getGoodsqty();

                BmsSuConDtl existDtl = bmsSuConDtlMapper.selectOne(Wrappers.<BmsSuConDtl>lambdaQuery().eq(BmsSuConDtl::getSucondtlid, bmsSuConDtl.getSucondtlid()));
                currGoodsQty = zxBmsSuOverbatchApplyMapper.getNewAddGoodsQty(currGoodsQty, bmsSuConDtl.getSucondtlid());
                goodsQtyOthers = goodsQtyOthers.add(currGoodsQty);
            }
            //最大可采购数量
            BigDecimal upSuConQty = upQty.multiply(new BigDecimal(1.1)).subtract(busiDtlQty).subtract( new BigDecimal(unAccQty.doubleValue()));
            String msgOther = null;
            if (upSuConQty.doubleValue() > 0) {
                msgOther = "，合同整单新增数量为" + modiQty.doubleValue() + upSuConQty.doubleValue();

            } else {
                msgOther = "";
            }

            if (upSuConQty.doubleValue() - (modiQty.doubleValue() + goodsQtyOthers.doubleValue()) < 0) {
                if (obapplyId > 0) {
                    Long notFinishQty = zxBmsSuOverbatchApplyMapper.getNotFinishQtyByApplyId(obapplyId);
                    if (notFinishQty.doubleValue() < modiQty.doubleValue() + goodsQtyOthers.doubleValue()) {
                        String msg = MessageFormat.format("提示：货品超批量采购, 细单{0}:新增数量为{1}{2}，原超批量申请单ID:{3} 剩余数量({4})不足，不能保存.", suConDtlId.toString(), modiQty.toString(), msgOther, obapplyId.toString(), notFinishQty.toString());
                        logger.info(msg);
                        factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, msg);
                        return false;
                    }
                    nowDtl.setObapplyid(obapplyId);

                }else {
                    String msg = MessageFormat.format("提示：细单超批量采购', '细单{0}：细单新增数量为{1}{2} '，无超批量申请单可勾对该数量，不能保存。", suConDtlId.toString(), modiQty.toString(), msgOther);
                    logger.info(msg);
                    factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, msg);
                    nowDtl.setObapplyid(null);
                    return false;
                }
            }else {
                nowDtl.setObapplyid(null);
            }

        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {

    }
}
