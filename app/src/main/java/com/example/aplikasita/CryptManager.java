//package com.example.aplikasita;
//
//import android.security.keystore.KeyProperties;
//
//import java.security.KeyStore;
//
//import javax.crypto.Cipher;
//
//public class CryptManager {
//    private final String ENCRYPT_ALGO = KeyProperties.KEY_ALGORITHM_AES;
//    private final String BLOCK_MODE = KeyProperties.BLOCK_MODE_CBC;
//    private final String PADDING = KeyProperties.ENCRYPTION_PADDING_PKCS7;
//    private final String TRANSFORM = ENCRYPT_ALGO+"/"+BLOCK_MODE+"/"+PADDING;
//
//    Cipher cipher = Cipher.getInstance(TRANSFORM).doFinal()
//
//    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
//    keyStore.load(null)
//
//
//}
