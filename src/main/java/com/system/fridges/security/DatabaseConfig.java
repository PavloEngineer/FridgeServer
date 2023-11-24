//package com.system.fridges.security;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PreDestroy;
//import javax.sql.DataSource;
//
//@Component
//public class DatabaseConfig {
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        return new HikariDataSource();
//    }
//}
