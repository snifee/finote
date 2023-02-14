package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.SecondActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.PengeluaranAdaptor;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.data.viewmodel.PengeluaranViewModel;

import java.util.List;


public class PengeluaranFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;
    private String monthYear;
    private PengeluaranViewModel pengeluaranViewModel;


    public PengeluaranFragment(String monthYear) {
        // Required empty public constructor
        this.monthYear = monthYear;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengeluaran, container, false);
        PengeluaranAdaptor pengeluaranAdaptor = new PengeluaranAdaptor();
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewPengeluaran);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pengeluaranAdaptor);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));


        if (SecondActivity.MONTH_YEAR != null){
            pengeluaranViewModel = ViewModelProviders.of(this).get(PengeluaranViewModel.class);
            pengeluaranViewModel.getAllSpendingByMonth(this.monthYear).observe(this, new Observer<List<Pengeluaran>>() {
                @Override
                public void onChanged(@Nullable List<Pengeluaran> pengeluarans) {
                    pengeluaranAdaptor.setListSpending(pengeluarans);
//                System.out.println(incomes.get(0).getMonth());
                }
            });
        }else {
            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
        }



        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                pengeluaranViewModel.delete(pengeluaranAdaptor.getSpending(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
        return view;

    }




}