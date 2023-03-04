package com.positive.countrylibrary.repository;

import com.positive.countrylibrary.bean.HomeCofig;
import com.positive.countrylibrary.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.repository
 * @filename HomeConfigRepository
 * @data 2023/3/4
 * @description TODO
 */
public interface HomeConfigRepository extends JpaRepository<HomeCofig,String> {
    /**
     * @param id
     * @return
     * 相当月select u from sys_user u where u.username = ?1
     */


}
