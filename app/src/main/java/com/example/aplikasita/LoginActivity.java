package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.MyPreferences;

public class LoginActivity extends AppCompatActivity {

    private EditText inputPassword;
    private Button loginButtton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        inputPassword = findViewById(R.id.etInputPassword);
        loginButtton = findViewById(R.id.loginButton);

        String passwordInput = inputPassword.getText().toString();

        loginButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correctPassword = MyPreferences.getSharedPreferencePassword(getBaseContext());

                if (passwordInput.equals(correctPassword)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Password Wrong",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}