//package me.loda.spring.configurationbean;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    SimpleBean simpleBeanConfigure(){
//        // Khởi tạo một instance của SimpleBean và trả ra ngoài
//        return new SimpleBean("loda");
//    }
//
//    @Bean("mysqlConnector")
//    public DataSource dataSource() {
//        DriverManagerDataSource  dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("0002");
//        dataSource.setUrl(
//                "jdbc:mysql://localhost:3306/loda");
//
//        return dataSource;
//    }
//}