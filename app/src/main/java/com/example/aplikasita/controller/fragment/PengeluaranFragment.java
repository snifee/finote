package com.example.aplikasita.controller.fragment;

import android.content.Intent;
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

import com.example.aplikasita.AddIncomeActivity;
import com.example.aplikasita.AddSpendingActivity;
import com.example.aplikasita.MainActivity;
import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.MonthAdaptor;
import com.example.aplikasita.controller.adaptor.SpendingAdaptor;
import com.example.aplikasita.data.DummyData;
import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.SpendingViewModel;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class PengeluaranFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;

    private RecyclerView recyclerView;
    private SpendingAdaptor spendingAdaptor;
    private SpendingViewModel spendingViewModel;


    public PengeluaranFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        spendingAdaptor = new SpendingAdaptor();
        recyclerView = view.findViewById(R.id.recycleViewPengeluaran);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(spendingAdaptor);

        FloatingActionButton addItemButton = view.findViewById(R.id.addSpendingButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddSpendingActivity.class);
                startActivityForResult(intent,ADD_ITEM_RQ);
            }
        });

        spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
        spendingViewModel.getAllSpending().observe(this, new Observer<List<Spending>>() {
            @Override
            public void onChanged(@Nullable List<Spending> spendings) {
                spendingAdaptor.setListSpending(spendings);
//                System.out.println(incomes.get(0).getMonth());
            }
        });
        return view;
    }

}