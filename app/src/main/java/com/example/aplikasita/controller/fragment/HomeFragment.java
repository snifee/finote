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
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.SecondActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.MonthAdaptor;
import com.example.aplikasita.data.MonthlyViewModel;
import com.example.aplikasita.model.MonthlyCashFlow;
import com.example.aplikasita.model.MonthlySpending;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;

public class HomeFragment extends Fragment {

    public static final int SECOND_ACT =1;

    private RecyclerView recyclerView;
    private MonthAdaptor monthAdaptor;
    private MonthlyViewModel monthlyViewModel;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();;

    private TextView tvIncome, tvSpending,tvMonth;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tvIncome = view.findViewById(R.id.idHomeIncome);
        tvSpending = view.findViewById(R.id.idHomeSpending);

        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        monthlyViewModel.getSumofSpendingByMonth("JULY2022").observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long monthSpending) {
                if (monthSpending!=null){
                    numberFormat.setMaximumFractionDigits(0);
                    numberFormat.setCurrency(Currency.getInstance("IDR"));
                    String spending = numberFormat.format(monthSpending);

                    tvSpending.setText(spending);
                }else {
                    tvSpending.setText("null");
                }

            }
        });


        monthAdaptor = new MonthAdaptor();
        recyclerView = view.findViewById(R.id.idHomeRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(monthAdaptor);

//        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        monthlyViewModel.getAllMonthlySpending().observe(this, new Observer<List<MonthlySpending>>() {
            @Override
            public void onChanged(List<MonthlySpending> monthlyCashFlows) {
                monthAdaptor.setListMonthSpending(monthlyCashFlows);
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

        return view;
    }
}