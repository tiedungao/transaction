package com.spring.transaction.declare.proxyFactoryBean.service.impl;

import com.spring.transaction.declare.proxyFactoryBean.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 20:07 2019/3/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    //这里Idea会提示报错，但是可以正常运行，纠结了好久...
    @Autowired
    @Qualifier("accountServiceProxy")
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("zhao","qian",200D);
    }
}