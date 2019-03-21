package com.spring.transaction.program.service.impl;

import com.spring.transaction.program.dao.AccountDao;
import com.spring.transaction.program.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:19 2019/3/20
 */
@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;


    @Override
    public void transfer(String out, String in, Double money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                accountDao.out(out, money);
                int i = 1/0;
                accountDao.in(in, money);
                return null;
            }
        });

        /*accountDao.out(out, money);
        int i = 1/0;
        accountDao.in(in, money);*/
    }
}
