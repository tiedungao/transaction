package com.spring.transaction.program.dao;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 10:19 2019/3/20
 */
public interface AccountDao {

    public void out(String out,Double money);

    public void in(String in,Double money);

}
