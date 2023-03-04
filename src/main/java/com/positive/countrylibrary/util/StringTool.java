package com.positive.countrylibrary.util;

/**
 * @author WangFei
 * @package com.positive.countrylibrary.util
 * @filename StringTool
 * @data 2023/3/4
 * @description TODO
 */
public class StringTool {
    public static boolean isEmpty(String str){
        if (str == null){
            return true;
        }
        if (str.trim().equals("")){
            return true;
        }
        return false;
    }
}
