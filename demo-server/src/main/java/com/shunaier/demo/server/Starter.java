package com.shunaier.demo.server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author dragon1990
 */
@SpringBootApplication(scanBasePackages = {"com.shunaier.demo"})
@MapperScan("com.shunaier.demo.biz.dao")
@EnableCaching
@EnableScheduling
@SpringBootConfiguration
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}