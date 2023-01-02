package com.example.aplikasita;

import org.junit.Test;

import static org.junit.Assert.*;


import android.util.Base64;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyEncoder;
import com.example.aplikasita.utils.MyStringUtils;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
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

        LocalDate d = LocalDate.now();

        String date = d.format(DateTimeFormatter.ofPattern("dd-M-yyyy"));

        Date date1 = MyStringUtils.stringDateToDateTime(date);

        System.out.println(date1);

    }

    @Test
    public void test4()  throws Exception{


        String en = CryptManager.encryptData("helloworldhelloworldhelloworldhelloworldhelloworld","passwordpassword");

        System.out.println("Hasil enkripsi:"+en);

        String de = CryptManager.decrypt(en,"passwordpassword");

        System.out.println("Hasil dekripsi:"+de);
    }

    @Test
    public void test5() {

        HashFunction hashing = Hashing.sha256();

        String password = hashing.hashString("password", Charset.defaultCharset()).toString();
        String password2 = hashing.hashString("password", Charset.defaultCharset()).toString();

        System.out.println(password);
        System.out.println(password2);
    }

    @Test
    public void test6(){
        byte[] result = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(result);
        System.out.println(result.length);
        System.out.println(MyEncoder.encodeToString(result, Base64.DEFAULT));
    }


    @Test
    public void test7(){
        String str1 = "helloworld";
        String str2 = MyEncoder.encodeToString(str1.getBytes(),Base64.DEFAULT);

        String ciphertext1 = CryptManager.encryptData(str1,"sayasangatsukamakansatekambinggg");
        String ciphertext2 = CryptManager.encryptData(str2,"sayasangatsukamakansatekambinggg");

        String cipherTextInBinary = MyStringUtils.convertStringToBinary(ciphertext1);
        String plainTextInBinary = MyStringUtils.convertStringToBinary(str1);
        System.out.println(cipherTextInBinary.length());
        System.out.println(plainTextInBinary.length());
    }
}