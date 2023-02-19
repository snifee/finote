package com.example.aplikasita;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyAvalancheEffect;

import org.junit.Assert;
import org.junit.Test;

public class EncyptionDecryptionTest {

    String[] plaintext1 = {
            "onepunchmanonepunchmanonepunchma",
            "jujutsukaisenjujutsukaisenjujuts",
            "attackontitanattackontitanattack",
            "chainsawmanchainsawmanchainsawma",
            "sayasukamakansayasukamakansayasu",
            "informatikainformatikainformatik",
            "halloduniahalloduniahalloduniaha",
            "udayanaudayanaudayanaudayanauday",
            "helloworldhelloworldhelloworldhe",
            "fakultasmipafakultasmipafakultas"
    };
    String key = "passwordpasswdku";

    @Test
    public void test0(){

        String plaintext = plaintext1[0];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test1(){

        String plaintext = plaintext1[1];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test2(){

        String plaintext = plaintext1[2];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test3(){

        String plaintext = plaintext1[3];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test4(){

        String plaintext = plaintext1[4];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test5(){

        String plaintext = plaintext1[5];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test6(){

        String plaintext = plaintext1[6];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }

    @Test
    public void test7(){

        String plaintext = plaintext1[7];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }
    @Test
    public void test8(){

        String plaintext = plaintext1[8];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }
    @Test
    public void test9(){

        String plaintext = plaintext1[9];

        String ciphertext = CryptManager.aesEncryption(plaintext,key);

        String plaintextAfterEncryption = CryptManager.aesDecryption(ciphertext,key);

        System.out.println("Origin plaintext :" + plaintext);
        System.out.println("Plaintext        :" + plaintextAfterEncryption);

        Assert.assertEquals(plaintext,plaintextAfterEncryption);

    }
}
