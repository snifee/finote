package com.example.aplikasita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.aplikasita.controller.fragment.KebutuhanFragment;
import com.example.aplikasita.controller.fragment.HutangFragment;
import com.example.aplikasita.controller.fragment.PerbulanFragment;
import com.example.aplikasita.controller.fragment.HomeFragment;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.utils.MyPreferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    PemasukanViewModel pemasukanViewModel;

    private BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    PerbulanFragment perbulanFragment = new PerbulanFragment();
    KebutuhanFragment kebutuhanFragment = new KebutuhanFragment();
    HutangFragment hutangFragment = new HutangFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setSelectedItemId(R.id.page_1);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.page_1:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, homeFragment).commit();
                return true;

            case R.id.page_2:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, perbulanFragment).commit();
                return true;

            case R.id.page_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, kebutuhanFragment).commit();
                return true;

            case R.id.page_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, hutangFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        MyPreferences.deleteSharedPreferenceTemporaryPassword(getApplicationContext());
        System.out.println("app dimatikan");
    }
}