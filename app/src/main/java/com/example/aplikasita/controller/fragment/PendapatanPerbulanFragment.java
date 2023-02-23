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

import com.example.aplikasita.R;
import com.example.aplikasita.SecondActivity;
import com.example.aplikasita.TambahPengeluaranActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.PendapatanPerbulanAdaptor;
import com.example.aplikasita.data.viewmodel.MonthlyViewModel;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.dto.MonthlyIncome;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PendapatanPerbulanFragment extends Fragment {

    public static int SECOND_ACT =1;
    public static int PENDAPATAN = 2;

    private PemasukanViewModel pemasukanViewModel;
    private MonthlyViewModel monthlyViewModel;

    public PendapatanPerbulanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PendapatanPerbulanAdaptor pendapatanPerbulanAdaptor = new PendapatanPerbulanAdaptor();
        View view = inflater.inflate(R.layout.fragment_pendapatan_perbulan, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewPendapatanPerbulan);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pendapatanPerbulanAdaptor);

        FloatingActionButton addItemButton = view.findViewById(R.id.addCfButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TambahPengeluaranActivity.class);
                startActivity(intent);
            }
        });

        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);
        monthlyViewModel.getAllMonthlyIncome().observe(this, new Observer<List<MonthlyIncome>>() {
            @Override
            public void onChanged(List<MonthlyIncome> monthlySpendings) {
                pendapatanPerbulanAdaptor.setListMonthSpending(monthlySpendings);
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

        pendapatanPerbulanAdaptor.setOnItemClickListener(new PendapatanPerbulanAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(MonthlyIncome monthlyIncome) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                String monthYear = monthlyIncome.getMonthYear();
                intent.putExtra(SecondActivity.MONTH_YEAR,monthYear);
                intent.putExtra(SecondActivity.FRAGMENTVIEW,PENDAPATAN);
                startActivityForResult(intent,SECOND_ACT);
            }
        });



        return view;
    }
}