package com.ben;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//EnableEurekaClient 客户端的启动类，在服务启动后自动向注册中心注册服务
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudProvider01 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider01.class,args);
    }

}
