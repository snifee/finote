package com.example.aplikasita;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyAvalancheEffect;

import org.junit.Test;

public class AvalancheEffectTest {
    @Test
    public void test(){

        String[] plaintext1 = {"onepunchmanonepunchmanonepunchma","jujutsukaisenjujutsukaisenjujuts","attackontitanattackontitanattack","chainsawmanchainsawmanchainsawma","sayasukamakansayasukamakansayasu","informatikainformatikainformatik","halloduniahalloduniahalloduniaha","udayanaudayanaudayanaudayanauday","helloworldhelloworldhelloworldhe","fakultasmipafakultasmipafakultas"};
        String[] plaintext2 = {"onepunchmanonepunchmanonepunchmo","jujutsukaisenjujutsukaisenjujuto","attackontitanattackontitanattaco","chainsawmanchainsawmanchainsawmo","sayasukamakansayasukamakansayasc","informatikainformatikainformatic","halloduniahalloduniahalloduniaho","udayanaudayanaudayanaudayanaudac","helloworldhelloworldhelloworldho","fakultasmipafakultasmipafakultaz"};

        double avAvg = 0.0;
        for (int i=0;i<plaintext1.length;i++){
            String str1 = plaintext1[i];
            String str2 = plaintext2[i];

            String key1 = "passwordpassword";
            String key2 = "passwordpassworz";

            String ciphertext1 = CryptManager.aesEncryption(str1,key1);
            String ciphertext2 = CryptManager.aesEncryption(str1,key2);


            System.out.println("========================"+(i+1)+"=========================");
            System.out.println("plaintext1= "+str1);
//            System.out.println("plaintext2= "+str2);
            System.out.println("key1     = "+key1);
            System.out.println("key2     = "+key2);

            double av = MyAvalancheEffect.calculateAE(ciphertext1,ciphertext2);
            avAvg = avAvg+av;

        }

        System.out.println("======================RESULT=====================");
        System.out.println("AVERAGE AV = " + avAvg/plaintext1.length);
        System.out.println("======================RESULT=====================");

    }
}
