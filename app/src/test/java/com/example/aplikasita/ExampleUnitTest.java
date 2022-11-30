package com.example.aplikasita;

import org.junit.Test;

import static org.junit.Assert.*;


import com.example.aplikasita.utils.EnumCategory;
import com.example.aplikasita.utils.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test(){

        try{
            LocalDateTime d = LocalDateTime.now();

            String date = d.format(DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss"));


            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

            Date formattedDate = df.parse(date);
            System.out.println(df.parse(date));

//            Sun Nov 27 00:00:00 GMT 2022

        }catch (ParseException e){

        }


    }


    @Test
    public void test2(){
        System.out.println(new Date(2005, 5,6));
        System.out.println(Month.of(1).toString());

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));


        System.out.println(format.format(1000000));

    }

    @Test
    public void test3(){

//        try{
//            String date = "02-04-2022";
//
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
//
//            LocalTime localTime = LocalTime.now();
//
//            LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-M-yyyy"));
//
//
//            LocalDateTime ldt = LocalDateTime.of(localDate,localTime);
//
//            System.out.println(ldt.format(DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss")));
//        }catch (Exception e){
//
//        }

        int m = StringUtils.stringToDate("02-05-2022").getMonth();
        int y = StringUtils.stringToDate("02-05-2022").getYear();

        String month = Month.of(m+1).toString();

        Date date = StringUtils.stringToDate("02-05-2022");

        System.out.println(StringUtils.getMonthYear(date));


    }
}