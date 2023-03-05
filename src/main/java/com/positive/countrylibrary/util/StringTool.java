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
    public static boolean isEqual(String str1,String str2){
        if (str1 == null || str2 == null ){
            return false;
        }
        if (str1.equals(str2)){
            return true;
        }
        return false;
    }
}
