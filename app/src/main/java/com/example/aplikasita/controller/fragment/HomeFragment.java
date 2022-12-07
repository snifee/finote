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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aplikasita.MainActivity;
import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.BudgetAdaptor;
import com.example.aplikasita.data.viewmodel.BudgetViewModel;
import com.example.aplikasita.data.viewmodel.IncomeViewModel;
import com.example.aplikasita.data.viewmodel.MonthlyViewModel;
import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.data.viewmodel.SpendingViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Currency;
import java.util.List;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private SpendingViewModel spendingViewModel;
    private IncomeViewModel incomeViewModel;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();;

    private TextView tvIncome, tvSpending,tvMonth,tvDate;
    private String currentMonth;

    private LocalDate localDate;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = view.findViewById(R.id.idProggressBarSpending);
        progressBar.setProgress(0);


        localDate = LocalDate.now();
        currentMonth = localDate.getMonth().toString();
        currentMonth = MyStringUtils.myCapitalizefunc(currentMonth);

        String day = localDate.getDayOfWeek().toString();
        String date1 = String.valueOf(localDate.getDayOfMonth());
        String year = String.valueOf(localDate.getYear());

        String currentDate = MyStringUtils.myCapitalizefunc(day)+", "+date1+" "+currentMonth+" "+year;

        tvMonth = view.findViewById(R.id.idHomeMonth);
        tvMonth.setText(currentDate);

        tvIncome = view.findViewById(R.id.idHomeIncome);
        tvSpending = view.findViewById(R.id.idHomeSpending);

        LocalDate currentDateMonth = LocalDate.now();
        String monthDateNow = currentDateMonth.getMonth().toString()+String.valueOf(currentDateMonth.getYear());

        spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
        spendingViewModel.getSumofSpendingByMonth(monthDateNow).observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long monthSpending) {
                if (monthSpending!=null){
                    numberFormat.setMaximumFractionDigits(0);
                    numberFormat.setCurrency(Currency.getInstance("IDR"));
                    String spending = numberFormat.format(monthSpending);

                    tvSpending.setText(spending);

                    Long progressValue = (monthSpending/1000000)*100;

                    progressBar.setProgress(progressValue.intValue());
                }else {
                    tvSpending.setText("No Spending This Month");
                }

            }
        });

        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getSumofIncomeByMonth(monthDateNow).observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long monthIncome) {
                if (monthIncome!=null){
                    numberFormat.setMaximumFractionDigits(0);
                    numberFormat.setCurrency(Currency.getInstance("IDR"));
                    String income = numberFormat.format(monthIncome);

                    tvIncome.setText(income);
                }else {
                    tvIncome.setText("No Income This Month");
                }

            }
        });

        return view;
    }
}