package com.gzmpc.business.developer.portal.sureness.provider;

import com.gzmpc.business.developer.portal.service.AccountService;
import com.usthe.sureness.provider.SurenessAccount;
import com.usthe.sureness.provider.SurenessAccountProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * the provider provides account info
 * load account info from database
 * @author tomsun28
 * @date 22:44 2020-03-02
 */
@Component
public class DatabaseAccountProvider implements SurenessAccountProvider {

    @Autowired
    AccountService accountService;

    @Override
    public SurenessAccount loadAccount(String account) {
        return accountService.loadSurenessAccount(account);
    }
}
