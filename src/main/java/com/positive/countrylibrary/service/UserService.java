package com.positive.countrylibrary.service;

import com.positive.countrylibrary.bean.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.service
 * @filename UserService
 * @data 2023/3/4
 * @description 服务层，用来组装各种查询
 */
public interface UserService {
    User findById(String id);
    User findByUserName(String useranme);
    List<User> findAll();
//    Page<User>findAll(Pageable pageable);
}
