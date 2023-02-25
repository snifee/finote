package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.PengeluaranKategoriAdaptor;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.data.viewmodel.PengeluaranViewModel;
import com.example.aplikasita.dto.TotalSpendingByKategori;
import com.example.aplikasita.utils.MyStringUtils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    private PengeluaranViewModel pengeluaranViewModel;
    private PemasukanViewModel pemasukanViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        LocalDate localDate = LocalDate.now();
        String currentMonth = localDate.getMonth().toString();
        currentMonth = MyStringUtils.myCapitalizefunc(currentMonth);

        String day = localDate.getDayOfWeek().toString();
        String date1 = String.valueOf(localDate.getDayOfMonth());
        String year = String.valueOf(localDate.getYear());

        String currentDate = MyStringUtils.myCapitalizefunc(day)+", "+date1+" "+currentMonth+" "+year;

        TextView tvIncome = view.findViewById(R.id.idHomeIncome);
        TextView tvSpending = view.findViewById(R.id.idHomeSpending);
        TextView tvMonth = view.findViewById(R.id.tvHomeBulan);
        tvMonth.setText(currentDate);

        Date currentDateMonth = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-YYYY");
        String monthDateNow = sdf.format(currentDateMonth);

        System.out.println(monthDateNow);

        pengeluaranViewModel = ViewModelProviders.of(this).get(PengeluaranViewModel.class);
        pengeluaranViewModel.getSumofSpendingByMonth(monthDateNow).observe(this, new Observer<Long>() {
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

        PengeluaranKategoriAdaptor pengeluaranKategoriAdaptor = new PengeluaranKategoriAdaptor();
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewTotalPengeluaran);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pengeluaranKategoriAdaptor);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        pengeluaranViewModel.getTotalSpendingGroupByKategori(monthDateNow).observe(this, new Observer<List<TotalSpendingByKategori>>() {
            @Override
            public void onChanged(List<TotalSpendingByKategori> list) {
                pengeluaranKategoriAdaptor.setList(list);
            }
        });

        pemasukanViewModel = ViewModelProviders.of(this).get(PemasukanViewModel.class);
        pemasukanViewModel.getSumofIncomeByMonth(monthDateNow).observe(this, new Observer<Long>() {
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