package com.spring.transaction.program.dao.impl;

import com.spring.transaction.program.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:22 2019/3/20
 */
@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void out(String out, Double money) {
        String updateSql = " UPDATE ACCOUNT SET ACCOUNT = ACCOUNT - ? WHERE NAME = ?";
        jdbcTemplate.update(updateSql,money,out);
    }

    @Override
    public void in(String in, Double money) {
        String updateSql = " UPDATE ACCOUNT SET ACCOUNT = ACCOUNT+? WHERE NAME = ?";
        jdbcTemplate.update(updateSql,money,in);
    }
}
