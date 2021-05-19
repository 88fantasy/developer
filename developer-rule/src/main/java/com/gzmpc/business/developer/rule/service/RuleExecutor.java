package com.gzmpc.business.developer.rule.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.gzmpc.business.developer.rule.PackageWorker;

/**
* @author rwe
* @version 创建时间：2021年5月18日 上午12:30:01
* 类说明
*/

@Service
@DS("master")
public class RuleExecutor {

	public String excute(PackageWorker worker) {
		worker.getEngine().fire(worker.getRules(), worker.getFacts());
		return JSON.toJSONString(worker.getFacts().asMap());
	}
}
