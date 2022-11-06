package com.example.aplikasita.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.controller.MonthAdaptor;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;
import java.util.List;


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

        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));
        monthList.add(new Month("Sep","123","123"));

        return monthList;
    }
}