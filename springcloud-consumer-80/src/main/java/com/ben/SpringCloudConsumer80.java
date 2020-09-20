package com.ben;

import com.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能加载自定义的Ribbon类(自定义的规则会覆盖原有默认的规则)
//开启负载均衡,并指定自定义的规则
@RibbonClient(name = "SPRINGCLOUD-PROVIDER",configuration = MyRule.class)
public class SpringCloudConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer80.class, args);
    }
}
