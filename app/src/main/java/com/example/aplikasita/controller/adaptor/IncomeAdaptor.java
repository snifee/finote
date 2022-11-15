package com.example.aplikasita.controller.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Income;

import java.util.ArrayList;
import java.util.List;


public class IncomeAdaptor extends RecyclerView.Adapter<IncomeAdaptor.IncomeViewHolder>{

    private List<Income> listIncome = new ArrayList<>();

//    public IncomeAdaptor(List<Month> listIncome) {
//        this.listIncome = listIncome;
//    }

    public IncomeAdaptor() {
    }

    @NonNull
    @Override
    public IncomeAdaptor.IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.income_item,parent,false);
        return new IncomeViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull IncomeAdaptor.IncomeViewHolder holder, int position) {
//        holder.tvRekening.setText(listIncome.get(position).getIncome());
//        holder.tvIncome.setText(listIncome.get(position).getMonth());
//        holder.tvKeterangan.setText(listIncome.get(position).getOutcome());
//    }

    @Override
    public void onBindViewHolder(@NonNull IncomeAdaptor.IncomeViewHolder holder, int position) {
        Income currentIncome = listIncome.get(position);
        holder.tvRekening.setText(String.valueOf(currentIncome.getNoRekening()));
        holder.tvIncome.setText(String.valueOf(currentIncome.getJumlah()));
        holder.tvKeterangan.setText(currentIncome.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return (listIncome!=null) ? listIncome.size():0;
    }

    public class IncomeViewHolder extends RecyclerView.ViewHolder{

        private TextView tvRekening, tvIncome, tvKeterangan;

        public IncomeViewHolder(View view){
            super(view);

            tvRekening = view.findViewById(R.id.idTvIncomeRekening);
            tvIncome = view.findViewById(R.id.idTvIncomeIncome);
            tvKeterangan = view.findViewById(R.id.idTvKet);
        }
    }


    public void setListIncome(List<Income> listIncome) {
        this.listIncome = listIncome;
        notifyDataSetChanged();
    }
}

