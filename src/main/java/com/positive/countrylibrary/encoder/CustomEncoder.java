package com.positive.countrylibrary.encoder;

import com.positive.countrylibrary.util.StringTool;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.encoder
 * @filename CustomEncoder
 * @data 2023/3/5
 * @description 注入这个东西主要是前期不加密密码，无法进行判断
 */

public class CustomEncoder extends BCryptPasswordEncoder {
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return StringTool.isEqual(rawPassword.toString(),encodedPassword);
//        return super.matches(rawPassword, encodedPassword);
    }
}
