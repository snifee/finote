package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.KeperluanAdaptor;
import com.example.aplikasita.data.entity.Keperluan;
import com.example.aplikasita.data.viewmodel.BudgetViewModel;

import java.util.List;

public class KeperluanFragment extends Fragment {

    private RecyclerView recyclerView;
    private KeperluanAdaptor keperluanAdaptor;
    private BudgetViewModel budgetViewModel;

    public KeperluanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keperluan, container, false);

        keperluanAdaptor = new KeperluanAdaptor();
        recyclerView = view.findViewById(R.id.idBudgetRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(keperluanAdaptor);

        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel.class);
        budgetViewModel.getAllBudget().observe(this, new Observer<List<Keperluan>>() {
            @Override
            public void onChanged(List<Keperluan> keperluans) {
                keperluanAdaptor.setListBudget(keperluans);
            }
        });

        return view;
    }
}