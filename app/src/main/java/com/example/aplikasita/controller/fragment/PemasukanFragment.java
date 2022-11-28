package com.example.aplikasita.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.example.aplikasita.AddIncomeActivity;
import com.example.aplikasita.MainActivity;
import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.IncomeAdaptor;
import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.entity.Income;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PemasukanFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;

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

        FloatingActionButton addItemButton = view.findViewById(R.id.addIncomeButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddIncomeActivity.class);
                startActivityForResult(intent,ADD_ITEM_RQ);
            }
        });


        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getAllIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(@Nullable List<Income> incomes) {
                incomeAdaptor.setListIncome(incomes);
//                System.out.println(incomes.get(0).getMonth());
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                incomeViewModel.delete(incomeAdaptor.getIncome(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
        return view;
    }

}