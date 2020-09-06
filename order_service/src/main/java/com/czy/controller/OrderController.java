package com.czy.controller;

import com.czy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    /**
      注入DiscoveryClient:
        springcloud提供的获取元数据的工具类，调用方法获取服务的元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable Integer id){
        //通过服务名称获取该元信息
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //获取元数据
        ServiceInstance instance = instances.get(0);
        return  restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/user/" + id, User.class);
    }

}
