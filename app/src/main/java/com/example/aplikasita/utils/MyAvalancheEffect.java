package com.example.aplikasita.utils;

import android.util.Base64;

import java.math.BigInteger;

public class MyAvalancheEffect {
    public static float calculateAE(String ciphertext1, String ciphertext2){
        int countBiyChanged = 0;

        byte[] decode1 = MyEncoder.decode(ciphertext1, Base64.DEFAULT);
        byte[] decode2 = MyEncoder.decode(ciphertext2, Base64.DEFAULT);

        String c1binary = new BigInteger(1, decode1).toString(2);
        String c2binary = new BigInteger(1, decode2).toString(2);

//        System.out.println(c1binary);
//        System.out.println(c2binary);

        if (c1binary.length()<c2binary.length()){
            int zeroNeeded = c2binary.length() - c1binary.length();

            String padded = "";
            for (int i = 0;i<zeroNeeded;i++){
                padded = padded.concat("0");
            }
            System.out.println("padded : "+padded);

            c1binary = padded + c1binary;
        }

        if (c1binary.length()>c2binary.length()){
            int zeroNeeded = c1binary.length() - c2binary.length();

            String padded = "";
            for (int i = 0;i<zeroNeeded;i++){
                padded = padded.concat("0");
            }
            System.out.println("padded : "+padded);

            c2binary = padded + c2binary;
        }

        for (int i = 0;i<c1binary.length();i++){
            if (c1binary.charAt(i) != c2binary.charAt(i)){
                countBiyChanged++;
            }
        }

        System.out.println();
        System.out.println("bit changed :" + countBiyChanged);
        System.out.println("total bit   :" + c1binary.length());

        float totalBit = (float) c1binary.length();
        float bitChanged = (float) countBiyChanged;
        float result = bitChanged/totalBit;
        return result;
    }
}
