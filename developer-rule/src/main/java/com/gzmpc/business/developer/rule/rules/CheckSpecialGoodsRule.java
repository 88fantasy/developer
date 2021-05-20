package com.gzmpc.business.developer.rule.rules;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.BmsSuConDtl;
import com.gzmpc.business.developer.rule.rules.entity.ZxBmsSuConYearDoc;
import com.gzmpc.business.developer.rule.rules.mapper.SuCheckMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBmsSuConYearDocMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBmsSuConYearMapper;
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

/**
 * @author yjf
 * @version 创建时间：2021年5月18日 下午10:39:39
 */

@RuleProperties(input = "contracttype,List<BmsSuConDtl>", tags = {"进货合同", "采购", "特殊药品"})
@Rule(name = "赠品合同不能含特殊药品.", description = "合同类型为\"赠品合同\"且细单为特殊药品（麻醉药品、精神药品、蛋白同化制剂、肽类激素及含特殊药品复方制剂）时不能保存")
public class CheckSpecialGoodsRule {

    @Autowired
    SuCheckMapper suCheckMapper;


    @Autowired
    FactsUtil factsUtil;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map map = facts.asMap();

        if (!factsUtil.checkInput(facts, Arrays.asList("contracttype", "bmsSuConDtl"))) {
            return false;
        }
        List<BmsSuConDtl> bmsSuConDtls = (List<BmsSuConDtl>) map.get("bmsSuConDtls");
        Integer contracttype = (Integer) facts.get("contracttype");
        if (contracttype == 7) {
            for (int row = 0; row < bmsSuConDtls.size(); row++) {

                BmsSuConDtl bmsSuConDtl = bmsSuConDtls.get(row);
                Integer count = suCheckMapper.countSpecialGoodsById(bmsSuConDtl.getGoodsid());
                if (count > 0) {
                    factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, MessageFormat.format("第{0}行品种：{1} 特殊药品不能做赠品合同。", row + 1, bmsSuConDtl.getGoodsid().toString()));
                    return false;
                }
            }

        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {

    }
}
