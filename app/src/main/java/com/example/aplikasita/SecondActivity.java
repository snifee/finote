package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.example.aplikasita.controller.fragment.BankFragment;
import com.example.aplikasita.controller.fragment.HomeFragment;
import com.example.aplikasita.controller.fragment.PemasukanFragment;
import com.example.aplikasita.controller.fragment.PengeluaranFragment;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    public static String MONTH_YEAR = "SECOND_ACT_MONTH_YEAR";

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String monthYear = extras.getString(MONTH_YEAR);



        tabLayout = findViewById(R.id.SecondTabLayout);
        viewPager = findViewById(R.id.SecondViewPager);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.spending_tab));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.income_tab));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());

        pagerAdapter.addFragment(new PengeluaranFragment(monthYear));
        pagerAdapter.addFragment(new PemasukanFragment(monthYear));

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