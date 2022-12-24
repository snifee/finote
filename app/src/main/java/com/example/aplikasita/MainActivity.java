package com.example.aplikasita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aplikasita.controller.fragment.KeperluanFragment;
import com.example.aplikasita.controller.fragment.HutangFragment;
import com.example.aplikasita.controller.fragment.MonthlyFragment;
import com.example.aplikasita.controller.fragment.HomeFragment;
import com.example.aplikasita.data.viewmodel.IncomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    IncomeViewModel incomeViewModel;

    private BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    MonthlyFragment monthlyFragment = new MonthlyFragment();
    KeperluanFragment keperluanFragment = new KeperluanFragment();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, monthlyFragment).commit();
                return true;

            case R.id.page_3:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, keperluanFragment).commit();
                return true;

            case R.id.page_4:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, hutangFragment).commit();
                return true;
        }
        return false;
    }
}