package com.spring.transaction.declare.aspectj.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 20:40 2019/3/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Resource(name="accountServiceDeclareAspectj")
    private AccountServiceImpl accountService;


    @Test
    public void transfer() {
        accountService.transfer("zhao","qian",200D);
    }


}