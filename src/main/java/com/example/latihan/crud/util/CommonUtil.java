package com.example.latihan.crud.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {

    public static String generateTransactionCode(long count) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();

    String newOne = "IV"+validateMonthandYear(month, year)+checkSequence(count);
        return newOne;
    }

    private static String validateMonthandYear(int month, int year) {
        String newMonth = "";
        String newYear = Integer.toString(year);
        if(month<10){
            newMonth = "0"+month;
        } else {
            newMonth = ""+month;
        }
        newMonth = newMonth+newYear.substring(newYear.length() - 2);

        return newMonth;

    }

    private static String checkSequence(long count) {
        String newSeq = "";
        if ( count < 9) {
            newSeq = "000000"+(count+1);
        } else if ( count < 99) {
            newSeq = "00000"+(count+1);
        } else if ( count < 999) {
            newSeq = "0000"+(count+1);
        } else if ( count < 9999) {
            newSeq = "000"+(count+1);
        } else if ( count < 99999) {
            newSeq = "00"+(count+1);
        } else if ( count < 999999) {
            newSeq = "0"+(count+1);
        } else {
            newSeq = ""+count+1;
        }

        return newSeq;
    }

}
