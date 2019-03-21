package com.spring.transaction.declare.annotation.service.impl;

import com.spring.transaction.declare.annotation.service.AccountService;
import com.spring.transaction.program.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:19 2019/3/20
 */
@Component("accountServiceDeclareAnnotation")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.out(out, money);
//        int i = 1/0;
        accountDao.in(in, money);
    }
}
