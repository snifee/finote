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
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.PendapatanAdaptor;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.data.entity.Pendapatan;

import java.util.List;

public class PendapatanFragment extends Fragment {

    public static final int ADD_ITEM_RQ =1;
    private String monthYear;
    private PemasukanViewModel pemasukanViewModel;

    public PendapatanFragment(String monthYear) {
        this.monthYear = monthYear;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        final PendapatanAdaptor pendapatanAdaptor = new PendapatanAdaptor();

        View view = inflater.inflate(R.layout.fragment_pemasukan, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewPemasukan);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(pendapatanAdaptor);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));


        pemasukanViewModel = ViewModelProviders.of(this).get(PemasukanViewModel.class);
        pemasukanViewModel.getIncomeByMonthYear(monthYear).observe(this, new Observer<List<Pendapatan>>() {
            @Override
            public void onChanged(@Nullable List<Pendapatan> pendapatans) {
                pendapatanAdaptor.setListIncome(pendapatans);
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
                pemasukanViewModel.delete(pendapatanAdaptor.getIncome(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
        return view;
    }

}