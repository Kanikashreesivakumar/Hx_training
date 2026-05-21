package com.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com")
public class AppConfig {

    @Bean
    public DataSource getDBConnection(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // url, username, password, driver class
        dataSource.setUrl("jdbc:mysql://localhost:3306/crime_db");
        dataSource.setUsername("root");
        dataSource.setPassword("kani@2004");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
}
}