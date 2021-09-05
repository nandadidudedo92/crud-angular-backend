package com.example.latihan.crud.util;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {

    public static String generateTransactionCode() {
        Date date  = new Date();
        Calendar requestCal = Calendar.getInstance();
        requestCal.setTime(date);
        String newOne = requestCal.getWeekYear() + "" + String.format("%15s", requestCal.getTimeInMillis()+"").replace(' ', '0');


        return newOne;
    }

}
