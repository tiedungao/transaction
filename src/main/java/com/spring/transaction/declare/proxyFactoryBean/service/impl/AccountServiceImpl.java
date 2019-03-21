package com.spring.transaction.declare.proxyFactoryBean.service.impl;

import com.spring.transaction.declare.proxyFactoryBean.service.AccountService;
import com.spring.transaction.program.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:19 2019/3/20
 */
@Component("accountServiceDeclare")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.out(out, money);
        //int i = 1/0;
        accountDao.in(in, money);
    }
}
