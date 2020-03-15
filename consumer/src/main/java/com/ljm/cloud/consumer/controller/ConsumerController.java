package com.ljm.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dominick Li
 * @CreateTime 2020/3/15 18:49
 * @description 通关网关去调用服务提供者
 **/
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/users")
    public String users(){
        return this.restTemplate.getForObject("http://gateway/producer/users",String.class);
    }
}
