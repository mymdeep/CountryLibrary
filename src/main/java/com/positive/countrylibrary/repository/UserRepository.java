package com.positive.countrylibrary.repository;

import com.positive.countrylibrary.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.repository
 * @filename UserRepository
 * @data 2023/3/4
 * @description SpringDataJPA
 * 用来实现增删改查
 * 需要引入spring-boot-starter-data-jpa
 */
public interface UserRepository extends JpaRepository<User,String> {
    /**
     * @param username
     * @return
     * 相当月select u from sys_user u where u.username = ?1
     */
    List<User> findByUsername(String username);
}
