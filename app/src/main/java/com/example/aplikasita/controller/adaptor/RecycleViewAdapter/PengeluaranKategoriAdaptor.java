package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.EnumKategori;
import com.example.aplikasita.dto.TotalSpendingByKategori;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;


public class PengeluaranKategoriAdaptor extends RecyclerView.Adapter<PengeluaranKategoriAdaptor.KatSpendingViewHolder>{

    private List<TotalSpendingByKategori> listKebutuhan;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    private OnItemClickListener listener;

    public PengeluaranKategoriAdaptor() {

    }

    @NonNull
    @Override
    public KatSpendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_total_spending_by_kat,parent,false);
        return new KatSpendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KatSpendingViewHolder holder, int position) {

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));
        String amount = numberFormat.format(listKebutuhan.get(position).getTotal());

        holder.tvAmount.setText(amount);
        String jenis = EnumKategori.valueOf(listKebutuhan.get(position).getKategori()).get().toString();
        holder.tvNeedsCategory.setText(jenis);
    }

    @Override
    public int getItemCount() {
        return (listKebutuhan !=null) ? listKebutuhan.size():0;
    }

    public class KatSpendingViewHolder extends RecyclerView.ViewHolder{

        private TextView  tvAmount, tvNeedsCategory;

        public KatSpendingViewHolder(View view){
            super(view);

            tvAmount = view.findViewById(R.id.idKategoriSpending);
            tvNeedsCategory = view.findViewById(R.id.idItemKategori);

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
        void onItemClick(TotalSpendingByKategori spending);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setList(List<TotalSpendingByKategori> listKebutuhan) {
        this.listKebutuhan = listKebutuhan;
        notifyDataSetChanged();
    }
}

