package com.spring.transaction.program.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 17:32 2019/3/20
 */
@Component
@Configuration
public class TransactionTemplateCConfig {

    @Autowired
    @Qualifier("dataSourceTransactionManagerConfig")
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Bean
    public TransactionTemplate getTransactionTemplate(){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
        return transactionTemplate;
    }

}
