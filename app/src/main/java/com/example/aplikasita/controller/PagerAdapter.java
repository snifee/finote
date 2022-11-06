package com.example.aplikasita.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    int totalTab;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
//    final private List<String> titles;

    public PagerAdapter(@NonNull FragmentManager fm, int behafiour, int totalTab) {
        super(fm,behafiour);
        this.totalTab = totalTab;
    }


//    @NonNull
//    @Override
//    public Fragment getItem(int position){
//        switch (position){
//            case 0:
//                PengeluaranFragment pengeluaranFragment = new PengeluaranFragment();
//                return pengeluaranFragment;
//            case 1:
//                PemasukanFragment pemasukanFragment= new PemasukanFragment();
//                return pemasukanFragment;
//            default:
//                return null;
//        }
//    }

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
