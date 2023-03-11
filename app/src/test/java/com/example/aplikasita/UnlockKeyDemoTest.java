package com.example.aplikasita;

import com.example.aplikasita.utils.CryptManager;

import org.junit.Test;

public class UnlockKeyDemoTest {

    @Test
    public void unlockTest(){
        String ciphertext = "3/Jli8wLyw1pmUm83c2j9/ILhV8XRn2K00ikvgYZNs0T+sNTP7y4YiR0G/2H03ll";
        String userPassword = "passwordpassword";
        String plaintext = CryptManager.aesDecryption(ciphertext, userPassword);

        System.out.println(plaintext);
    }
}
