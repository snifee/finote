package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.HashingUtils;
import com.example.aplikasita.utils.MyPreferences;

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

                if ((password.equals(password2))){

                    String encodedPassword = HashingUtils.myHashFunc(password);

                    MyPreferences.setSharedPreferencePassword(getBaseContext(),encodedPassword);
                    MyPreferences.setSharedPreferenceDBKey(getBaseContext(),"user");

                    System.out.println(password);

                    System.out.println(MyPreferences.getSharedPreferencePassword(getBaseContext()));

                    databaseKeyEncryption(encodedPassword,"password",getBaseContext());

                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }


            }
        });
    }


    public void databaseKeyEncryption(String password, String key, Context context){

        try {
            String encryptedKey = CryptManager.encryptData(key,password);

            MyPreferences.setSharedPreferenceDBKey(context,encryptedKey);
        }catch (Exception e){

        }

    }


}