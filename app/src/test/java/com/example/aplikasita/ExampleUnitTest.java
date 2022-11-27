package com.example.aplikasita;

import org.junit.Test;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        LocalDate d = LocalDate.now();

        String date = d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();


        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try{
            System.out.println("hello"+date);
            System.out.println(df.parse(date));
        }catch (ParseException e){

        }


    }
}