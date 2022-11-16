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

public class MainActivity extends AppCompatActivity {
    public static final int ADD_ITEM_RQ =1;

    IncomeViewModel incomeViewModel;


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent,ADD_ITEM_RQ);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ITEM_RQ && resultCode == RESULT_OK){
            String rekening = data.getStringExtra(AddItemActivity.EXTRA_REK);
            String jumlah = data.getStringExtra(AddItemActivity.EXTRA_JUMLAH);
            String ket = data.getStringExtra(AddItemActivity.EXTRA_KET);
            String date = data.getStringExtra(AddItemActivity.EXTRA_DATE);

            try {
                int rek = Integer.parseInt(rekening);
                int jml= Integer.parseInt(jumlah);

                Income income = new Income(rek,jml,date,ket);

                incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
                incomeViewModel.insert(income);

            }catch (Exception e){
                System.out.println(e);
            }



        }
    }
}