package com.example.aplikasita.utils;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class HashingUtils {
    public static String myHashFunc(String data){
        HashFunction hashing = Hashing.sha256();

        return hashing.hashString(data, Charset.defaultCharset()).toString();
    }
}
