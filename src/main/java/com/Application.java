package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.mapper")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Application {


    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}
