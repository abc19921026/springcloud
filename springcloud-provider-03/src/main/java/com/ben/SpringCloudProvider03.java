package com.ben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//EnableEurekaClient 客户端的启动类，在服务启动后自动向注册中心注册服务
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudProvider03 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider03.class,args);
    }
}
