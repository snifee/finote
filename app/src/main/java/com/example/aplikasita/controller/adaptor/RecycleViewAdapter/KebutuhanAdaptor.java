package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Kebutuhan;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;


public class KebutuhanAdaptor extends RecyclerView.Adapter<KebutuhanAdaptor.BudgetViewHolder>{

    private List<Kebutuhan> listKebutuhan;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    private OnItemClickListener listener;

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
        String amount = numberFormat.format(listKebutuhan.get(position).getJumlah());

        holder.tvNeeds.setText(listKebutuhan.get(position).getKebutuhan());
        holder.tvAmount.setText(amount);
        holder.tvNeedsCategory.setText(listKebutuhan.get(position).getKategoriKebutuhan());
    }

    @Override
    public int getItemCount() {
        return (listKebutuhan !=null) ? listKebutuhan.size():0;
    }

    public class BudgetViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNeeds, tvAmount, tvNeedsCategory;

        public BudgetViewHolder(View view){
            super(view);

            tvNeeds = view.findViewById(R.id.idBudgetName);
            tvAmount = view.findViewById(R.id.idBudgetAmount);
            tvNeedsCategory = view.findViewById(R.id.idBudgetCategory);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener != null && pos != RecyclerView.NO_POSITION){
                        listener.onItemClick(listKebutuhan.get(pos));
                    }

                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Kebutuhan kebutuhan);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setListBudget(List<Kebutuhan> listKebutuhan) {
        this.listKebutuhan = listKebutuhan;
        notifyDataSetChanged();
    }
}

