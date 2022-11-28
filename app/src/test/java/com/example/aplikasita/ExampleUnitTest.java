package com.example.aplikasita;

import org.junit.Test;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
            LocalDate d = LocalDate.now();

            String date = d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));


            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            Date formattedDate = df.parse(date);
            System.out.println("hello "+String.valueOf(1900+formattedDate.getYear()));

//            Sun Nov 27 00:00:00 GMT 2022

        }catch (ParseException e){

        }


    }


    @Test
    public void test2(){
        System.out.println(new Date(2005, 5,6));
        System.out.println(Month.of(1).toString());
    }
}