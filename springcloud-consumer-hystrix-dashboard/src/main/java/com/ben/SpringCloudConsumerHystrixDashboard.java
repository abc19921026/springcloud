package com.ben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
//开启Dashboard
@EnableHystrixDashboard
public class SpringCloudConsumerHystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerHystrixDashboard.class, args);
    }
}
