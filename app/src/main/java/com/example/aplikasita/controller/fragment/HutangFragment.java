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

import com.example.aplikasita.R;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.HutangAdaptor;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.viewmodel.HutangViewModel;

import java.util.List;

public class HutangFragment extends Fragment {

    private HutangAdaptor hutangAdaptor;
    private RecyclerView recyclerView;
    private HutangViewModel hutangViewModel;


    public HutangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hutang, container, false);

        hutangAdaptor = new HutangAdaptor();
        recyclerView = view.findViewById(R.id.hutangRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(hutangAdaptor);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
        hutangViewModel.getAllBudget().observe(getViewLifecycleOwner(), new Observer<List<Hutang>>() {
            @Override
            public void onChanged(List<Hutang> hutang) {
                hutangAdaptor.setListHutang(hutang);
            }
        });

        return view;
    }
}