package com.example.aplikasita.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyStringUtils {

    public static Date stringDateToDateTime(String dateString){

        LocalDateTime localDateTime;
        LocalTime localTime = LocalTime.now();
        LocalDate localDate;
        DateTimeFormatter dtf;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        if (dateString.isEmpty()){

            localDate = LocalDate.now();

        }else{
            dtf = DateTimeFormatter.ofPattern("d-M-yyyy");

            localDate = LocalDate.parse(dateString,dtf);
        }

        try{

            localDateTime = LocalDateTime.of(localDate,localTime);

            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        }catch (Exception e){
            return null;
        }
    }

    public static String getMonthYear(Date date){
        int m = date.getMonth()+1;
        int y = date.getYear()+1900;

        String month = Month.of(m).toString();
        String year = String.valueOf(y);

        return month+year;
    }

    public static String myCapitalizefunc(String str){
        str = str.toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
