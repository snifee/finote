package com.example.aplikasita.controller.fragment;

import android.content.Intent;
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
import com.example.aplikasita.TambahKebutuhanActivity;
import com.example.aplikasita.controller.adaptor.RecycleViewAdapter.KebutuhanAdaptor;
import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.data.viewmodel.KebutuhanViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class KebutuhanFragment extends Fragment {

    private RecyclerView recyclerView;
    private KebutuhanAdaptor kebutuhanAdaptor;
    private KebutuhanViewModel kebutuhanViewModel;
    private FloatingActionButton tambahKebutuhanButton;

    public KebutuhanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kebutuhan, container, false);

        kebutuhanAdaptor = new KebutuhanAdaptor();
        recyclerView = view.findViewById(R.id.keperluanRecycleView);
        recyclerView.setLayoutManager( new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(kebutuhanAdaptor);

        kebutuhanViewModel = ViewModelProviders.of(this).get(KebutuhanViewModel.class);
        kebutuhanViewModel.getAllBudget().observe(this, new Observer<List<Kebutuhan>>() {
            @Override
            public void onChanged(List<Kebutuhan> kebutuhans) {
                kebutuhanAdaptor.setListBudget(kebutuhans);
            }
        });


        kebutuhanAdaptor.setOnItemClickListener(new KebutuhanAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(Kebutuhan kebutuhan) {
                Intent intent = new Intent(getActivity(), TambahKebutuhanActivity.class);

                intent.putExtra(TambahKebutuhanActivity.JUMLAH, kebutuhan.getJumlah());
                intent.putExtra(TambahKebutuhanActivity.ID, kebutuhan.getIdKebutuhan());
                intent.putExtra(TambahKebutuhanActivity.KEBUTUHAN, kebutuhan.getKebutuhan());
                intent.putExtra(TambahKebutuhanActivity.KATEGORI, kebutuhan.getKategoriKebutuhan());

                startActivityForResult(intent, TambahKebutuhanActivity.EDIT_KEBUTUHAN);
            }
        });


        tambahKebutuhanButton = view.findViewById(R.id.fbTambahKebutuhan);
        tambahKebutuhanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),TambahKebutuhanActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}