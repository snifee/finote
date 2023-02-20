package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.HashingUtils;
import com.example.aplikasita.utils.KeyManager;
import com.example.aplikasita.utils.MyPreferences;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (MyPreferences.getSharedPreferencePassword(getBaseContext())!=null){
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        EditText etEmail = findViewById(R.id.etEmailInput);
        EditText etPassword = findViewById(R.id.etPasswordInput);
        EditText etPassword2 = findViewById(R.id.etPasswordInput2);
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String password2 = etPassword2.getText().toString();

                if (!(password.equals(password2))){
                    Toast.makeText(getApplicationContext(),"Password Tidak Sama",Toast.LENGTH_SHORT).show();
                }

                if (password.length()!=16){
                    Toast.makeText(getApplicationContext(),"Panjang Password harus 16 char",Toast.LENGTH_SHORT).show();
                }

                if ((password.equals(password2)) && password.length()==16 && !email.isEmpty()){

                    try {

                        registrasi(email,password);

                        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){

                    }
                }else {
                    Toast.makeText(RegisterActivity.this, "Email cannot empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void registrasi(String email,String password){

        String encodedPassword = HashingUtils.hashingSHA256(password);

        MyPreferences.setSharedPreferencePassword(getBaseContext(),encodedPassword);

        MyPreferences.setSharedPreferenceEmail(getBaseContext(),email);

        String databaseKey = KeyManager.generateKey();

        String encryptedKey = CryptManager.aesEncryption(databaseKey,password);

        MyPreferences.setSharedPreferenceDBKey(getBaseContext(),encryptedKey);

        getApplicationContext()

        MyPreferences.setSharedPreferenceTemporaryPassword(getBaseContext(),password);

    }

}