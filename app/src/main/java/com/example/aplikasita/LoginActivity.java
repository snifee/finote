package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.HashingUtils;
import com.example.aplikasita.utils.MyPreferences;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText inputPassword = findViewById(R.id.etInputPassword);
        Button loginButtton = findViewById(R.id.loginButton);



        loginButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String passwordInput = inputPassword.getText().toString();

                String encodedPassword = HashingUtils.myHashFunc(passwordInput);
                String correctPassword = MyPreferences.getSharedPreferencePassword(getBaseContext());

                System.out.println("passwordInput "+passwordInput);
                System.out.println(encodedPassword);
                System.out.println(correctPassword);

                if (encodedPassword.equals(correctPassword)){

                    startActivity(new Intent(LoginActivity.this,MainActivity.class));

                }else {

                    Toast.makeText(getApplicationContext(),"Password Wrong",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}