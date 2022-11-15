package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.BankRecycleViewAdaptor;
import com.example.aplikasita.data.DummyData;

public class BankFragment extends Fragment {

    private RecyclerView recyclerView;


    public BankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank, container, false);
        recyclerView = view.findViewById(R.id.recycleViewBank);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new BankRecycleViewAdaptor(DummyData.getDataBank()));

        return view;
    }
}