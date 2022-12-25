package com.example.aplikasita.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.example.aplikasita.TambahHutangActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.HutangAdaptor;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.viewmodel.HutangViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HutangFragment extends Fragment {

    private HutangAdaptor hutangAdaptor;
    private RecyclerView recyclerView;
    private HutangViewModel hutangViewModel;
    private FloatingActionButton floatingActionButton;


    public HutangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hutang, container, false);

        hutangAdaptor = new HutangAdaptor();
        recyclerView = view.findViewById(R.id.hutangRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(hutangAdaptor);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
        hutangViewModel.getAllBudget().observe(getViewLifecycleOwner(), new Observer<List<Hutang>>() {
            @Override
            public void onChanged(List<Hutang> hutang) {
                hutangAdaptor.setListHutang(hutang);
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
                hutangViewModel.delete(hutangAdaptor.getHutang(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        floatingActionButton = view.findViewById(R.id.addHutangFloatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TambahHutangActivity.class);

                startActivity(intent);
            }
        });

        return view;
    }
}