package com.example.aplikasita.utils;

import android.security.keystore.KeyProperties;
import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptManager {
    private static final String ENCRYPT_ALGO = KeyProperties.KEY_ALGORITHM_AES;
    private static final String BLOCK_MODE = KeyProperties.BLOCK_MODE_CBC;
    private static final String PADDING = KeyProperties.ENCRYPTION_PADDING_PKCS7;
    private static final String TRANSFORM = ENCRYPT_ALGO+"/"+BLOCK_MODE;


    public static SecretKeySpec getKey(String password) throws Exception{

        return new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8),ENCRYPT_ALGO);
    }


    public static String encryptData(String data, String password){

        try {
            Key key = getKey(password);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptByteVal = cipher.doFinal(data.getBytes());

            return MyEncoder.encodeToString(encryptByteVal, Base64.DEFAULT);
        }catch (Exception e){
            return e.toString();
        }

    }

    public static String decrypt(String data,String password)
    {
        try{
            Key key = getKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedValue64 = MyEncoder.decode(data, Base64.DEFAULT);
            String result = new String(cipher.doFinal(decryptedValue64),"UTF-8");

            return result;
        }catch (Exception e){
            return e.toString();
        }
    }

}
