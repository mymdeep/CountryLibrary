package com.positive.countrylibrary.security;

import com.positive.countrylibrary.encoder.CustomEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * @param http
     * @throws Exception
     * https://blog.csdn.net/m0_59562547/article/details/120864233
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.formLogin() //自定义自己编写的登录页面
        http.authorizeRequests()
                //对可访问URL资源进行角色控制
//                .antMatchers("/**")
//                .hasRole("ADMIN")

                //用户访问其他URL资源都必须认证后访问，即登陆后访问
                .anyRequest()
                .authenticated()
                //开启表单登录，即登录界面，登录URL为/login，登录参数用户名username密码password
                //Ajax或移动端通过POST请求登录，接口为/login，permitAll表示登录不需要认证即可访问
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                //成功登录后跳转到hello页面
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
                        response.setContentType("application/json;charset=utf-8");
                        //创建一个Cookie用于演示
                        Cookie cookie=new Cookie("Authentication",
                                UUID.randomUUID().toString().replace("-",""));
                        cookie.setMaxAge(24 * 60 * 60);
                        response.addCookie(cookie);
                        response.sendRedirect("/config/home");
                    }
                })
                //配置注销登录，logoutUrl为注销接口，clearAuthentication清除身份认证信息
                //invalidateHttpSession表示是线程失效，deleteCookies清除Cookie
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("Authentication")
                //配置注销逻辑，可以执行数据清理
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                    }
                })
                //配置注销后的逻辑，返回JSON代码或者跳转到登录页面
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
                        response.sendRedirect("/login");
                    }
                })
                .and()
                .csrf().disable(); //关闭csrf防护

    }
}
