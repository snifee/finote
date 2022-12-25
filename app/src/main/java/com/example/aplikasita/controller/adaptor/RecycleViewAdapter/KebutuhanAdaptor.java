package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Keperluan;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;


public class KebutuhanAdaptor extends RecyclerView.Adapter<KebutuhanAdaptor.BudgetViewHolder>{

    private List<Keperluan> listKeperluan;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    public KebutuhanAdaptor() {

    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_keperluan,parent,false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));
        String amount = numberFormat.format(listKeperluan.get(position).getJumlah());

        holder.tvNeeds.setText(listKeperluan.get(position).getKebutuhan());
        holder.tvAmount.setText(amount);
        holder.tvNeedsCategory.setText(listKeperluan.get(position).getKategoriKebutuhan());
    }

    @Override
    public int getItemCount() {
        return (listKeperluan !=null) ? listKeperluan.size():0;
    }

    public class BudgetViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNeeds, tvAmount, tvNeedsCategory;

        public BudgetViewHolder(View view){
            super(view);

            tvNeeds = view.findViewById(R.id.idBudgetName);
            tvAmount = view.findViewById(R.id.idBudgetAmount);
            tvNeedsCategory = view.findViewById(R.id.idBudgetCategory);
        }
    }

    public void setListBudget(List<Keperluan> listKeperluan) {
        this.listKeperluan = listKeperluan;
        notifyDataSetChanged();
    }
}

