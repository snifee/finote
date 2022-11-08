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
import com.example.aplikasita.data.DummyData;


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
        recyclerView = view.findViewById(R.id.recycleViewPengeluaran);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MonthAdaptor(DummyData.getData()));
        return view;
    }

}