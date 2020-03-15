package com.ljm.cloud.producer.repository;

import com.ljm.cloud.producer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Dominick Li
 * @CreateTime 2020/3/15 18:12
 * @description 用户接口
 **/
public interface UserRepository extends JpaRepository<User,Integer> {


}
