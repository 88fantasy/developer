package com.gzmpc.business.developer.rule.util;

import com.gzmpc.business.developer.rule.constant.RuleConstants;
import org.jeasy.rules.api.Facts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FactsUtil {

   public void setMessage (Facts facts,String type,String msg){
       List<String> errors = (List<String>) facts.getFact(type);
       errors.add(msg);
       facts.put(type, msg);
   }


}
