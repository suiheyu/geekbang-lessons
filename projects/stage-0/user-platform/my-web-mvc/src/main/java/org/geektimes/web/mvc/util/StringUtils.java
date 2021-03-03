package org.geektimes.web.mvc.util;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/03/03
 * @link
 * @see
 */
public class StringUtils {

    public static boolean isNumnic(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
