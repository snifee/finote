package com.example.aplikasita;

import android.security.keystore.KeyProperties;
import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptManager {
    private static final String ENCRYPT_ALGO = KeyProperties.KEY_ALGORITHM_AES;
    private static final String BLOCK_MODE = KeyProperties.BLOCK_MODE_CBC;
    private static final String PADDING = KeyProperties.ENCRYPTION_PADDING_PKCS7;
    private static final String TRANSFORM = ENCRYPT_ALGO+"/"+BLOCK_MODE+"/"+PADDING;


    public static Key getKey(String password) throws Exception{
        Key key = new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8),ENCRYPT_ALGO);

        return key;
    }


    public static String encryptData(String data, String password) throws Exception{
        Key key =  getKey(password);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptByteVal = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        String result = Base64.encodeToString(encryptByteVal, Base64.DEFAULT);

        return result;

    }

    public static String decrypt(String data,String password) throws Exception
    {
        Key key = getKey(password);
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue64 = Base64.decode(data, Base64.DEFAULT);
        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedValue = new String(decryptedByteValue,"utf-8");
        return decryptedValue;

    }

}
