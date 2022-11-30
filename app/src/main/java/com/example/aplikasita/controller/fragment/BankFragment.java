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
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.BudgetAdaptor;
import com.example.aplikasita.data.BudgetViewModel;
import com.example.aplikasita.data.DummyData;
import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.model.MonthlySpending;

import java.util.List;

public class BankFragment extends Fragment {

    private RecyclerView recyclerView;
    private BudgetViewModel budgetViewModel;


    public BankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        BudgetAdaptor budgetAdaptor = new BudgetAdaptor();
        View view = inflater.inflate(R.layout.fragment_bank, container, false);
        recyclerView = view.findViewById(R.id.recycleViewBank);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(budgetAdaptor);

        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel.class);
        budgetViewModel.getAllBudget().observe(this, new Observer<List<Budget>>() {
            @Override
            public void onChanged(List<Budget> budgets) {
                budgetAdaptor.setListBudget(budgets);
            }
        });

        return view;
    }
}