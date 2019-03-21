package com.spring.transaction.declare.proxyFactoryBean.service;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:17 2019/3/20
 */
public interface AccountService {

    /**
     *
     * @param out   ：转出账户
     * @param in    ：转入账户
     * @param money ：转账金额
     */
    public void transfer(String out, String in, Double money);

}
