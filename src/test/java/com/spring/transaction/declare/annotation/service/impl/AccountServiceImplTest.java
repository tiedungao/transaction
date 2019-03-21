package com.spring.transaction.declare.annotation.service.impl;

import com.spring.transaction.declare.annotation.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 22:05 2019/3/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Resource(name="accountServiceDeclareAnnotation")
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("zhao","qian",200D);
    }
}