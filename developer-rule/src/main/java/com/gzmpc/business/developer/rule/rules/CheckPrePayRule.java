package com.gzmpc.business.developer.rule.rules;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompany;
import com.gzmpc.business.developer.rule.rules.entity.PubCustomer;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubCustomerMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerMapper;
import com.gzmpc.business.developer.rule.rules.mapper.SuCheckMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yjf
 * @version 创建时间：2021年5月7日 下午5:27:37
 * 提示供应商是否有预付款
 */

@RuleProperties(input = " supplyid 或 conpanyid", tags = {"主数据"})
@Rule(name = "提示供应商是否有预付款", description = "提示预付款")
public class CheckPrePayRule {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PubSupplyerMapper pubSupplyerMapper;

    @Autowired
    SuCheckMapper suCheckMapper;

    @Autowired
    FactsUtil factsUtil;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map<String, Object> map = facts.asMap();
        if (map.containsKey("supplyid")) {
            Long supplyid = (Long) map.get("supplyid");
            if (suCheckMapper.countPrePayNumBySupplyId(supplyid) > 0) {
                PubSupplyer supply = pubSupplyerMapper.selectOne(Wrappers.<PubSupplyer>lambdaQuery().eq(PubSupplyer::getSupplyid, supplyid));
                factsUtil.setMessage(facts,RuleConstants.RULE_TIPS_MESSAGE_KEY,"供应商" + supply.getSupplyopcode() + "(" + supply.getSupplyname() + ")");

            }
        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {
        logger.debug("成立");
    }
}
