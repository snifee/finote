package com.example.aplikasita.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplikasita.AddCashflowActivity;
import com.example.aplikasita.R;
import com.example.aplikasita.SecondActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.MonthAdaptor;
import com.example.aplikasita.data.MonthlyViewModel;
import com.example.aplikasita.model.MonthlySpending;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MonthlyFragment extends Fragment {

    public static int SECOND_ACT =1;
    public static int ADD_CF_RQ =2;

    private RecyclerView recyclerView;
    private MonthlyViewModel monthlyViewModel;
    private MonthAdaptor monthAdaptor;


    public MonthlyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        monthAdaptor = new MonthAdaptor();
        View view = inflater.inflate(R.layout.fragment_monthly, container, false);
        recyclerView = view.findViewById(R.id.recycleViewMonthly);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(monthAdaptor);

        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        monthlyViewModel.getAllMonthlySpending().observe(this, new Observer<List<MonthlySpending>>() {
            @Override
            public void onChanged(List<MonthlySpending> monthlySpendings) {
                monthAdaptor.setListMonthSpending(monthlySpendings);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.ACTION_STATE_IDLE) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        monthAdaptor.setOnItemClickListener(new MonthAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(MonthlySpending monthlySpending) {
//                Toast.makeText(getActivity(), String.valueOf(sgbm.getSpendingTotal()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                String monthYear = monthlySpending.getMonthYear();
                intent.putExtra(SecondActivity.MONTH_YEAR,monthYear);
                startActivityForResult(intent,SECOND_ACT);
//                startActivity(intent);
            }
        });

        FloatingActionButton addItemButton = view.findViewById(R.id.addCfButtonMonthly);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddCashflowActivity.class);
                startActivityForResult(intent,ADD_CF_RQ);
            }
        });



        return view;
    }
}