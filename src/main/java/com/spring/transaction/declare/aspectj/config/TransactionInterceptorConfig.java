package com.spring.transaction.declare.aspectj.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 20:52 2019/3/20
 */
@Component
@Configuration
public class TransactionInterceptorConfig {

    @Resource(name="dataSourceTransactionManagerConfig")
    private DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionInterceptor getTransactionInterceptor(){
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(dataSourceTransactionManager);
        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("transfer","PROPAGATION_REQUIRED,ISOLATION_DEFAULT");
        transactionInterceptor.setTransactionAttributes(transactionAttributes);

        return transactionInterceptor;
    }

    @Bean
    public Advisor getTxAdvisor(){
        String AOP_POINTCUT_EXPRESSION = " execution(* com.spring.transaction.declare.aspectj.service.impl.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(AOP_POINTCUT_EXPRESSION);

        return new DefaultPointcutAdvisor(aspectJExpressionPointcut,getTransactionInterceptor());
    }

}
