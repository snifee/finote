package com.example.aplikasita;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.example.aplikasita.controller.fragment.BankFragment;
import com.example.aplikasita.controller.fragment.PemasukanFragment;
import com.example.aplikasita.controller.fragment.PengeluaranFragment;
import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.entity.Income;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {


    IncomeViewModel incomeViewModel;


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.spending_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.income_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.bank_tab));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());

        pagerAdapter.addFragment(new PengeluaranFragment());
        pagerAdapter.addFragment(new PemasukanFragment());
        pagerAdapter.addFragment(new BankFragment());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

    }

}