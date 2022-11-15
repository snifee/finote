package com.example.aplikasita.controller.adaptor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    int totalTab;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fm, int behafiour, int totalTab) {
        super(fm,behafiour);
        this.totalTab = totalTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position){
        return this.fragmentList.get(position);
    }

    public void addFragment(Fragment f){
       this.fragmentList.add(f);
    }

    @Override
    public int getCount(){
        return totalTab;
    }
}
