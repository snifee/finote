package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.IncomeAdaptor;
import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.entity.Income;

import java.util.List;

public class PemasukanFragment extends Fragment {

    private RecyclerView recyclerView;
    private IncomeViewModel incomeViewModel;

    public PemasukanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final IncomeAdaptor incomeAdaptor = new IncomeAdaptor();

        View view = inflater.inflate(R.layout.fragment_pemasukan, container, false);
        recyclerView = view.findViewById(R.id.recycleViewPemasukan);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(incomeAdaptor);


        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getAllIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(@Nullable List<Income> incomes) {
                incomeAdaptor.setListIncome(incomes);
                System.out.println(incomes.get(0).getMonth());
            }
        });


        return view;
    }

}