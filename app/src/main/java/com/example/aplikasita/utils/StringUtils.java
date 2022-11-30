package com.example.aplikasita.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringUtils {

    public static Date stringToDate(String dateString){

        LocalDateTime localDateTime;
        LocalTime localTime = LocalTime.now();
        LocalDate localDate;
        DateTimeFormatter dtf;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        if (dateString.isEmpty()){

            localDate = LocalDate.now();

        }else{

            dtf = DateTimeFormatter.ofPattern("dd-M-yyyy");

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
}
