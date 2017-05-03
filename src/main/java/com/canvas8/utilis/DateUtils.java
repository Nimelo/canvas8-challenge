package com.canvas8.utilis;

import java.util.Date;

public class DateUtils {
    public static boolean isAfterCurrentTime(Date date) {
        if (date == null) {
            return true;
        }
        Date currentDate = new Date();
        return date.after(currentDate);
    }
}
