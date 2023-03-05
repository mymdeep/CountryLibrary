package com.positive.countrylibrary.service;

import com.positive.countrylibrary.bean.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.service
 * @filename CustomUserService
 * @data 2023/3/5
 * @description TODO
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Resource
    private UserService userService;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     * Spring提供的User鉴权方法，需要返回一个Spring的Security的User
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null){
            return null;
        }
//        当前无用户配置，用户都是管理员，所以角色不需要处理
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ADMIN"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),list);
    }
}
