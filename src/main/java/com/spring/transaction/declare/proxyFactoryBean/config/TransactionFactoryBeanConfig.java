package com.spring.transaction.declare.proxyFactoryBean.config;

import com.spring.transaction.declare.proxyFactoryBean.service.AccountService;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import java.util.Properties;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 17:49 2019/3/20
 */
@Component
@Configuration
public class TransactionFactoryBeanConfig {

    @Autowired
    @Qualifier("dataSourceTransactionManagerConfig")
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    @Qualifier("accountServiceDeclare")
    private AccountService accountService;

    @Bean("accountServiceProxy")
    public TransactionProxyFactoryBean getTransactionProxyFactoryBean(){
        TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
        transactionProxyFactoryBean.setTransactionManager(dataSourceTransactionManager);
        transactionProxyFactoryBean.setTarget(accountService);

        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("transfer","PROPAGATION_REQUIRED,ISOLATION_DEFAULT");
        transactionProxyFactoryBean.setTransactionAttributes(transactionAttributes);

        return transactionProxyFactoryBean;
    }

}
