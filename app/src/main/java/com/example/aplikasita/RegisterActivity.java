package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.HashingUtils;
import com.example.aplikasita.utils.MyEncoder;
import com.example.aplikasita.utils.MyPreferences;

import java.security.SecureRandom;

public class RegisterActivity extends AppCompatActivity {


    private EditText etPassword,etPassword2;
    private Button registerButton;

    private String password,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (MyPreferences.getSharedPreferencePassword(getBaseContext())!=null){
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        etPassword = findViewById(R.id.etPasswordInput);
        etPassword2 = findViewById(R.id.etPasswordInput2);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                password = etPassword.getText().toString();
                password2 = etPassword2.getText().toString();

                if (!(password.equals(password2))){
                    Toast.makeText(getApplicationContext(),"Password Tidak Sama",Toast.LENGTH_SHORT).show();
                }

                if (password.length()!=16){
                    Toast.makeText(getApplicationContext(),"Panjang Password harus 16 char",Toast.LENGTH_SHORT).show();
                }

                if ((password.equals(password2)) && password.length()==16){

                    try {

                        registrasi(password);

                        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){

                    }
                }
            }
        });
    }


    public void registrasi(String password){

        String encodedPassword = HashingUtils.hashingSHA256(password);

        MyPreferences.setSharedPreferencePassword(getBaseContext(),encodedPassword);

        String databaseKey = generateKey();

        String encryptedKey = CryptManager.aesEncryption(databaseKey,password);

        MyPreferences.setSharedPreferenceDBKey(getBaseContext(),encryptedKey);

        MyPreferences.setSharedPreferenceTemporaryPassword(getBaseContext(),password);

    }

    public String generateKey(){
            byte[] result = new byte[32];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(result);
            return MyEncoder.encodeToString(result, Base64.DEFAULT);
    }


}