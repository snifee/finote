package com.example.aplikasita.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.model.Bank;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;


public class BankRecycleViewAdaptor extends RecyclerView.Adapter<BankRecycleViewAdaptor.BankViewHolder>{

    private ArrayList<Bank> listBank;

    public BankRecycleViewAdaptor(ArrayList<Bank> listBank) {
        this.listBank = listBank;
    }

    @NonNull
    @Override
    public BankRecycleViewAdaptor.BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_bank,parent,false);
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankRecycleViewAdaptor.BankViewHolder holder, int position) {
        holder.tvBankName.setText(listBank.get(position).getBankName());
        holder.tvRekening.setText(listBank.get(position).getRekeneing());
        holder.tvSaldo.setText(listBank.get(position).getSaldo());
    }

    @Override
    public int getItemCount() {
        return (listBank!=null) ? listBank.size():0;
    }

    public class BankViewHolder extends RecyclerView.ViewHolder{

        private TextView tvBankName, tvSaldo, tvRekening;

        public BankViewHolder(View view){
            super(view);

            tvBankName = view.findViewById(R.id.idTvBank);
            tvRekening = view.findViewById(R.id.idTvRekening);
            tvSaldo = view.findViewById(R.id.idTvSaldo);
        }
    }
}

