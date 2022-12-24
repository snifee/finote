package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.example.aplikasita.controller.fragment.TambahPendapatanFragment;
import com.example.aplikasita.controller.fragment.TambahPengeluaranFragment;
import com.google.android.material.tabs.TabLayout;

public class AddCashflowActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cashflow);

        tabLayout = findViewById(R.id.tabLayoutAddCf);
        viewPager = findViewById(R.id.viewPagerAddcf);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.add_spending));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.add_income));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());

        pagerAdapter.addFragment(new TambahPengeluaranFragment());
        pagerAdapter.addFragment(new TambahPendapatanFragment());


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