package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.viewmodel.IncomeViewModel;
import com.example.aplikasita.data.viewmodel.SpendingViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;

public class HomeFragment extends Fragment {

    private SpendingViewModel spendingViewModel;

    private IncomeViewModel incomeViewModel;
    private TextView tvIncome, tvSpending,tvMonth,tvDate;

    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();;
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


        localDate = LocalDate.now();
        currentMonth = localDate.getMonth().toString();
        currentMonth = MyStringUtils.myCapitalizefunc(currentMonth);

        String day = localDate.getDayOfWeek().toString();
        String date1 = String.valueOf(localDate.getDayOfMonth());
        String year = String.valueOf(localDate.getYear());

        String currentDate = MyStringUtils.myCapitalizefunc(day)+", "+date1+" "+currentMonth+" "+year;

        tvIncome = view.findViewById(R.id.idHomeIncome);
        tvSpending = view.findViewById(R.id.idHomeSpending);
        tvMonth = view.findViewById(R.id.tvHomeBulan);
        tvMonth.setText(currentDate);

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