package com.example.aplikasita.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.TambahCashflowActivity;
import com.example.aplikasita.controller.adaptor.PagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class PerbulanFragment extends Fragment {

    public static int ADD_CF_RQ =2;

    public PerbulanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perbulan, container, false);

        TabLayout tabLayout = view.findViewById(R.id.MonthlyTabLayout);
        ViewPager viewPager = view.findViewById(R.id.MonthlyViewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Pendapatan Perbulan"));
        tabLayout.addTab(tabLayout.newTab().setText("Pengeluaran Perbulan"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());

        pagerAdapter.addFragment(new PendapatanPerbulanFragment());
        pagerAdapter.addFragment(new PengeluaranPerbulanFragment());


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

        FloatingActionButton addItemButton = view.findViewById(R.id.addCfButtonSecondAct);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TambahCashflowActivity.class);
                startActivityForResult(intent,ADD_CF_RQ);
            }
        });



        return view;
    }
}