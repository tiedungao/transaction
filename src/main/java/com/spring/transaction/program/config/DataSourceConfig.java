package com.spring.transaction.program.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author: gtd
 * @Description:
 * @Date: Create in 11:36 2019/3/20
 */
@Component
@ConfigurationProperties(prefix = "jdbc")
public class DataSourceConfig {
    private String driver;
    private String url;
    private String username;
    private String password;


    private ComboPooledDataSource comboPooledDataSource;

    @Bean
    public DataSource getDataSource (){
        comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(username);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setAutoCommitOnClose(false);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        //保证getDataSource先执行
        if (null == comboPooledDataSource){
            getDataSource();
        }
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(comboPooledDataSource);
        return jdbcTemplate;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
