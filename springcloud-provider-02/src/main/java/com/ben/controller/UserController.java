package com.ben.controller;

import com.ben.pojo.model.UserDO;
import com.ben.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //获取一些配置的信息，得到具体的微服务！
    @Autowired
    private DiscoveryClient client;

    //注册进来的微服务~，获取一些消息~
    @GetMapping("/getDiscovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        //得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-01");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }

    @GetMapping("/queryById/{id}")
    public UserDO queryById(@PathVariable("id")Integer id){
        return userService.queryById(id);
    }

    @GetMapping("/queryAll")
    public List<UserDO> queryAll(){
        return userService.queryAll();
    }

    @PostMapping("/add")
    public boolean add(UserDO userDO){
        return userService.insert(userDO);
    }
}
