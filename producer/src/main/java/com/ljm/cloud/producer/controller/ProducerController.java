package com.ljm.cloud.producer.controller;

import com.ljm.cloud.producer.model.User;
import com.ljm.cloud.producer.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dominick Li
 * @CreateTime 2020/3/15 18:14
 * @description
 **/
@RestController
public class ProducerController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String findAll(){
        List<User> userList=userRepository.findAll();
        return JSONObject.valueToString(userList);
    }

}
