package com.positive.countrylibrary.security;

import com.positive.countrylibrary.encoder.CustomEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.security
 * @filename WebSecurityConfig
 * @data 2023/3/5
 * @description TODO
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new CustomEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin() //自定义自己编写的登录页面
//                .loginPage("/login.html") //登录页面设置

//                .loginProcessingUrl("/user/login") //登录访问路径
//                .defaultSuccessUrl("/homeconfig.html");//登录成功之后的跳转路径
//                .and().authorizeRequests().antMatchers("/","/test/hello","/user/login")
//                .permitAll() //设置不需要认证访问路径
//                .anyRequest().authenticated()
//                .and().csrf().disable(); //关闭csrf防护

//    }
}
