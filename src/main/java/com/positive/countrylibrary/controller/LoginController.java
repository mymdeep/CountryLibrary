package com.positive.countrylibrary.controller;

/**
 * @author WangFei
 * @package com.positive.booklibrary.controller
 * @filename LoginController
 * @data 2023/3/3
 * @description 登录使用
 */

import com.alibaba.fastjson.JSONObject;
import com.positive.countrylibrary.bean.User;
import com.positive.countrylibrary.service.UserService;

import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class LoginController {
//    private final UserService service;
//    private JdbcTemplate jdbcTemplate;
@Resource
private UserService userService;

    @GetMapping("/login")
    public JSONObject getLogin(String name,String pwd){
        JSONObject object = new JSONObject();

        User user = userService.findByUserName(name);
        if (user != null && pwd != null){
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
            if (user.getPassword() != null &&pwd.equals(user.getPassword())){
                object.put("status","success");
            }else {
                object.put("status","fail");
            }

        }else {
            object.put("status","fail");
        }
        return object;

    }
}
