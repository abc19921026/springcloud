package com.ben;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//EnableEurekaClient 客户端的启动类，在服务启动后自动向注册中心注册服务
@EnableEurekaClient
@EnableDiscoveryClient
//添加对熔断的支持注解
@EnableCircuitBreaker
public class SpringCloudProviderHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrix8001.class,args);
    }
    //增加一个 Servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        //访问该页面就是监控页面
        registrationBean.addUrlMappings("/actuator/hystrix.stream");

        return registrationBean;
    }
}
