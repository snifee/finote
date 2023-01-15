package com.example.aplikasita.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class HashingUtils {
    public static String hashingSHA256(String data){
        HashFunction hashing = Hashing.sha256();

        return hashing.hashString(data, Charset.defaultCharset()).toString();
    }

    public static String myMd5Func(String data){
        HashFunction hashing = Hashing.md5();

        HashCode result = hashing.hashString(data, Charset.defaultCharset());

        return result.toString();
    }
}
