package com.canvas8.utilis;

import java.util.Date;

/**
 * Created by mrnimelo on 02/05/17.
 */
public class DateUtils {
    public static boolean isAfterCurrentTime(Date date){
        if(date == null){
            return true;
        }
        Date currentDate = new Date();
        return date.after(currentDate);
    }
}
