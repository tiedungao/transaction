package com.spring.transaction.program.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 16:55 2019/3/20
 */
@Component
@Configuration
public class TransactionManagerConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("dataSourceTransactionManagerConfig")
    public DataSourceTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
