package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.example.aplikasita.controller.fragment.TambahPendapatanFragment;
import com.example.aplikasita.controller.fragment.TambahPengeluaranFragment;
import com.google.android.material.tabs.TabLayout;

public class TambahCashflowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_cashflow);

        TabLayout tabLayout = findViewById(R.id.tabLayoutAddCf);
        ViewPager viewPager = findViewById(R.id.viewPagerAddcf);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tambah_pengeluaran));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tambah_pendapatan));


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