package com.spring.transaction.program.service.impl;

import com.spring.transaction.program.config.DataSourceConfig;
import com.spring.transaction.program.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 11:24 2019/3/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Resource
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("zhao","qian",200D);
    }
}