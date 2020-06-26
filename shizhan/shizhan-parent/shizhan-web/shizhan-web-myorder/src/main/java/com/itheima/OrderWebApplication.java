package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: shizhan
 * @description
 * @author: Lindiedie
 * @create: 2020-06-23 15:58
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.itheima.order.feign")
public class OrderWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderWebApplication.class,args);
    }
}
