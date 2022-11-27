package com.example.aplikasita.controller.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SpendingAdaptor extends RecyclerView.Adapter<SpendingAdaptor.SpendingViewHolder>{

    private List<Spending> listSpending = new ArrayList<>();

    public SpendingAdaptor() {
    }

    @NonNull
    @Override
    public SpendingAdaptor.SpendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.spending_item,parent,false);
        return new SpendingViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SpendingAdaptor.SpendingViewHolder holder, int position) {
        Spending currentSpending = listSpending.get(position);

        SimpleDateFormat sdf = new SimpleDateFormat();

        holder.tvRekening.setText(String.valueOf(currentSpending.getSumberPengeluaran()));
        holder.tvSpending.setText("Rp."+ String.valueOf(currentSpending.getJumlah())+",00");
        holder.tvKeterangan.setText(currentSpending.getKeterangan());
        holder.tvDate.setText(sdf.format(currentSpending.getWaktu()));
        holder.tvJenis.setText(currentSpending.getJenisPengeluaran());
    }

    @Override
    public int getItemCount() {
        return (listSpending!=null) ? listSpending.size():0;
    }

    public class SpendingViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate, tvRekening, tvSpending, tvKeterangan,tvJenis;

        public SpendingViewHolder(View view){
            super(view);

            tvRekening = view.findViewById(R.id.idTvSpendingRekening);
            tvSpending = view.findViewById(R.id.tvSpendingAmount);
            tvKeterangan = view.findViewById(R.id.idTvSpendingKet);
            tvDate = view.findViewById(R.id.idTvSpendingDate);
            tvJenis = view.findViewById(R.id.idTvSpendingJenisPengeluaran);
        }
    }


    public void setListSpending(List<Spending> listSpending) {
        this.listSpending = listSpending;
        notifyDataSetChanged();
    }
}