package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.example.aplikasita.controller.fragment.PendapatanFragment;
import com.example.aplikasita.controller.fragment.PengeluaranFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    public static String MONTH_YEAR = "SECOND_ACT_MONTH_YEAR";
    public static int ADD_CF_RQ = 1;
    public static final String FRAGMENTVIEW = "FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String monthYear = extras.getString(MONTH_YEAR);


        FloatingActionButton addItemButton = findViewById(R.id.addCfButtonSecondAct);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TambahCashflowActivity.class);
                startActivityForResult(intent,ADD_CF_RQ);
            }
        });

        ViewPager viewPager = findViewById(R.id.SecondViewPager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,1);

        if (getIntent().getIntExtra(FRAGMENTVIEW,1)==1){
            pagerAdapter.addFragment(new PengeluaranFragment(monthYear));
        }else if (getIntent().getIntExtra(FRAGMENTVIEW,1)==2){
            pagerAdapter.addFragment(new PendapatanFragment(monthYear));
        }



        viewPager.setAdapter(pagerAdapter);


    }

}