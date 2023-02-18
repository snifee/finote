package com.example.aplikasita.utils;

import android.util.Base64;

import java.security.SecureRandom;

public class KeyManager {
    public static String generateKey(){
        byte[] result = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(result);
        return MyEncoder.encodeToString(result, Base64.DEFAULT);
    }
}
