package com.canvas8.utilis;

public class StringUtils {
    public static String addDBLikeParamAttributes(String string) {
        return String.format("%%%s%%", string == null ? "" : string);
    }
}
