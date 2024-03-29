package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.HashingUtils;
import com.example.aplikasita.utils.MyPreferences;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText inputPassword = findViewById(R.id.etInputPassword);
        Button loginButtton = findViewById(R.id.loginButton);

//        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//        startActivity(intent);
//        finish();

        loginButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passwordInput = inputPassword.getText().toString();

                Boolean passwordCorrect = login(passwordInput);


                if (passwordCorrect){

                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();

                }else {

                    Toast.makeText(getApplicationContext(),"Password Wrong",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean login(String password){
        String encodedPassword = HashingUtils.hashingSHA256(password);
        String correctPassword = MyPreferences.getSharedPreferencePassword(getBaseContext());

        if (encodedPassword.equals(correctPassword)){

            String encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(getApplicationContext());
            String dbPassword = CryptManager.aesDecryption(encryptedDBPassword,password);

            Log.i("DB_PASSWORD",dbPassword);
            AppDatabase.getDB(getApplicationContext(),dbPassword);

            return true;

        }else {
            Toast.makeText(getBaseContext(),"Passsowrd wrong",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}

