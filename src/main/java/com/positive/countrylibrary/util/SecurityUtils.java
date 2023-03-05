package com.positive.countrylibrary.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.util
 * @filename SecurityUtils
 * @data 2023/3/5
 * @description 工具类，密码需要转化
 */
public class SecurityUtils {
    public static String encryptPassword(String rawPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }

    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
