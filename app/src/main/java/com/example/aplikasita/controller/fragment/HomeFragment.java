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
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.MonthAdaptor;
import com.example.aplikasita.data.SpendingViewModel;
import com.example.aplikasita.model.SpendingGroupByModel;

import java.util.List;

public class HomeFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;

    private RecyclerView recyclerView;
    private MonthAdaptor monthAdaptor;
    private SpendingViewModel spendingViewModel;


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

        spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
        spendingViewModel.getCountSpendingByMonth().observe(this, new Observer<List<SpendingGroupByModel>>() {
            @Override
            public void onChanged(List<SpendingGroupByModel> spendingGroupByModels) {
                monthAdaptor.setListMonth(spendingGroupByModels);
            }
        });


        return view;
    }
}