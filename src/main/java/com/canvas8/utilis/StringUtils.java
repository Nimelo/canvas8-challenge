package com.canvas8.utilis;

/**
 * Created by mrnimelo on 03/05/17.
 */
public class StringUtils {
    public static String addDBLikeParamAttributes(String string){
        return String.format("%%%s%%", string == null ? "" : string);
    }
}
