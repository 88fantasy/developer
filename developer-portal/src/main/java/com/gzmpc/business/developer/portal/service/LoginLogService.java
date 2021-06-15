package com.gzmpc.business.developer.portal.service;

import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.portal.entity.LoginLog;
import com.gzmpc.business.developer.portal.mapper.LoginLogMapper;
import com.gzmpc.support.jdbc.service.ExBaseService;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:48:31
* 登录日志
*/

@Service
public class LoginLogService extends ExBaseService<LoginLogMapper, LoginLog> {

}
