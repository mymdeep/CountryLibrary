package com.positive.countrylibrary.service.impl;

import com.positive.countrylibrary.bean.User;
import com.positive.countrylibrary.repository.UserRepository;
import com.positive.countrylibrary.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.service.impl
 * @filename UserServiceImpl
 * @data 2023/3/4
 * @description 服务的实现
 */
@Service//spring boot会自动扫描到@Component注解的类，并把这些类纳入Spring中管理，可以用@Component
public class UserServiceImpl implements UserService {
    @Resource(name = "userRepository")//名称通过name属性指定，如果没有写name就用字段名查找
//    @Autowired(required = false)//默认按照类型装配，如果允许为空，可以设置required=false
    private UserRepository userRepository;
    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByUserName(String useranme) {
        return userRepository.findByUsername(useranme).get(0);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @Override
//    Page<User> findAll(Pageable pageable){
//
//    }
}
