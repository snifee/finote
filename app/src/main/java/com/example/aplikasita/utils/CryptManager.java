package com.example.aplikasita.utils;

import android.security.keystore.KeyProperties;
import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptManager {
    private static final String ENCRYPT_ALGO = "AES";
    private static final String BLOCK_MODE = "CBC";
    private static final String PADDING = "PKCS5PADDING";
    private static final String TRANSFORM = ENCRYPT_ALGO+"/"+BLOCK_MODE+"/"+PADDING;

    private static final IvParameterSpec IV = new IvParameterSpec("axhvchybmsllnayb".getBytes());
    public static SecretKeySpec getKey(String password) throws Exception{

        return new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8),ENCRYPT_ALGO);
    }


    public static String aesEncryption(String data, String password){

        try {
            Key key = getKey(password);

            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.ENCRYPT_MODE, key,IV);
            byte[] encryptByteVal = cipher.doFinal(data.getBytes());

            return MyEncoder.encodeToString(encryptByteVal, Base64.DEFAULT);
        }catch (Exception e){
            return e.toString();
        }

    }

    public static String aesDecryption(String data, String password)
    {
        try{
            Key key = getKey(password);
            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.DECRYPT_MODE, key,IV);
            byte[] decryptedValue64 = MyEncoder.decode(data, Base64.DEFAULT);
            String result = new String(cipher.doFinal(decryptedValue64),"UTF-8");

            return result;
        }catch (Exception e){
            return e.toString();
        }
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

}
