package com.ben.controller;

import com.ben.pojo.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/user")
public class UserConsumerController {

    // 理解：消费者，不应该有service层~
    // RestTemplate .... 供我们直接调用就可以了！ 注册到Spring中
    // (url, 实体：Map ,Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简单的Restful服务模板~

//    public static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER";
    @GetMapping("/queryById/{id}")
    public UserDO queryById(@PathVariable("id") Integer id){
        System.out.println("AAA");
        return  restTemplate.getForObject(REST_URL_PREFIX+"/user/queryById/"+id,UserDO.class);
    }

    @PostMapping("/add")
    public boolean add(UserDO userDO){
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/add",userDO,Boolean.class);
    }


}
