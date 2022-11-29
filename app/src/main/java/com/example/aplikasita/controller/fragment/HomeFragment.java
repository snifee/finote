package com.example.aplikasita.controller.fragment;

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

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.MonthAdaptor;
import com.example.aplikasita.data.MonthlyViewMode;
import com.example.aplikasita.data.SpendingViewModel;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

public class HomeFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;

    private RecyclerView recyclerView;
    private MonthAdaptor monthAdaptor;
    private MonthlyViewMode monthlyViewMode;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        monthAdaptor = new MonthAdaptor();
        recyclerView = view.findViewById(R.id.idHomeRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(monthAdaptor);

        monthlyViewMode = ViewModelProviders.of(this).get(MonthlyViewMode.class);
        monthlyViewMode.getAllMonthly().observe(this, new Observer<List<MonthlyCashFlow>>() {
            @Override
            public void onChanged(List<MonthlyCashFlow> monthlyCashFlows) {
                monthAdaptor.setListMonth(monthlyCashFlows);
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
            public void onItemClick(MonthlyCashFlow sgbm) {
                Toast.makeText(getActivity(), String.valueOf(sgbm.getSpendingTotal()), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}