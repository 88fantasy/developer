package com.gzmpc.business.developer.rule.util;

import com.gzmpc.business.developer.rule.constant.RuleConstants;
import org.jeasy.rules.api.Facts;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FactsUtil {

    public void setMessage(Facts facts, String type, String msg) {
        if (facts != null) {
            List<String> errors = facts.getFact(type) != null ? (List<String>) facts.getFact(type) : new ArrayList<>();
            errors.add(msg);
            facts.put(type, msg);
        }
    }


}
