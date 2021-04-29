package com.gzmpc.business.developer.rule.springboot.test;

import java.net.URL;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.gzmpc.business.developer.rule.rules.CheckUseStatusRule;
import com.gzmpc.business.developer.rule.springboot.application.DeveloperRuleApplication;


/**
 * @author rwe
 * @version 创建时间：Jan 20, 2020 12:07:32 AM 
 * 类说明
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeveloperRuleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProviderApplicationTest {
	private static final Logger logger = LoggerFactory.getLogger(ProviderApplicationTest.class);
	
	@LocalServerPort
	private int port;

	private URL base;
	
	@Autowired
	CheckUseStatusRule checkUsestateRule;

	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}

	/**
	 * 向"/test"地址发送请求，并打印返回结果
	 * 
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		Facts facts = new Facts();
    facts.put("supplyid", 2009l);
    
    Rules rules = new Rules();
    rules.register(checkUsestateRule);
    
    RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
		RulesEngine rulesEngine = new DefaultRulesEngine();
    rulesEngine.fire(rules, facts);

	}
}
