package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: shizhan
 * @description
 * @author: Lindiedie
 * @create: 2020-06-23 09:50
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.itheima.order.dao")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
