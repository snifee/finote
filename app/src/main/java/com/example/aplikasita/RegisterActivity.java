package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.MyPreferences;

public class RegisterActivity extends AppCompatActivity {


    private EditText etPassword,etPassword2;
    private Button registerButton;

    private String password,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        if (MyPreferences.getSharedPreferencePassword(getBaseContext())!=null){
//            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
//            startActivity(intent);
//        }

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

                if ((password.equals(password2))){

                    MyPreferences.setSharedPreferencePassword(getBaseContext(),password);
                    MyPreferences.setSharedPreferenceDBKey(getBaseContext(),"user");

                    System.out.println(password);

                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);

                }


            }
        });
    }


}