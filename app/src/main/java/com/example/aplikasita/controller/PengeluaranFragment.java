package com.example.aplikasita.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.adaptor.MonthAdaptor;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;


public class PengeluaranFragment extends Fragment {

    private RecyclerView recyclerView;


    public PengeluaranFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        recyclerView = view.findViewById(R.id.recycleViewId);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MonthAdaptor(getData()));
        return view;
    }



    private ArrayList getData(){
        ArrayList<Month> monthList = new ArrayList<>();

        monthList.add(new Month("January","123","123"));
        monthList.add(new Month("February","123","123"));
        monthList.add(new Month("March","123","123"));
        monthList.add(new Month("April","123","123"));
        monthList.add(new Month("May","123","123"));
        monthList.add(new Month("June","123","123"));
        monthList.add(new Month("July","123","123"));
        monthList.add(new Month("August","123","123"));
        monthList.add(new Month("September","123","123"));
        monthList.add(new Month("Oktober","123","123"));
        monthList.add(new Month("November","123","123"));

        return monthList;
    }
}