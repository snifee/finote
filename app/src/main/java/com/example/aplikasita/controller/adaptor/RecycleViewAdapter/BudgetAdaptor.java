package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Budget;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class BudgetAdaptor extends RecyclerView.Adapter<BudgetAdaptor.BudgetViewHolder>{

    private List<Budget> listBudget;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    public BudgetAdaptor() {

    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_budget,parent,false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));
        String amount = numberFormat.format(listBudget.get(position).getJumlah());

        holder.tvNeeds.setText(listBudget.get(position).getKebutuhan());
        holder.tvAmount.setText(amount);
        holder.tvNeedsCategory.setText(listBudget.get(position).getCategoryKebutuhan());
    }

    @Override
    public int getItemCount() {
        return (listBudget!=null) ? listBudget.size():0;
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

    public void setListBudget(List<Budget> listBudget) {
        this.listBudget = listBudget;
        notifyDataSetChanged();
    }
}

