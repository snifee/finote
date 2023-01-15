package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Pendapatan;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class PendapatanAdaptor extends RecyclerView.Adapter<PendapatanAdaptor.IncomeViewHolder>{

    private List<Pendapatan> listPendapatan = new ArrayList<>();
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();;

    public PendapatanAdaptor() {
    }

    @NonNull
    @Override
    public PendapatanAdaptor.IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_pendapatan,parent,false);
        return new IncomeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PendapatanAdaptor.IncomeViewHolder holder, int position) {
        Pendapatan currentPendapatan = listPendapatan.get(position);

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));
        String income = numberFormat.format(currentPendapatan.getJumlah());

        SimpleDateFormat sdf = new SimpleDateFormat();

        holder.tvRekening.setText(String.valueOf(currentPendapatan.getNoRekening()));
        holder.tvIncome.setText(income);
        holder.tvKeterangan.setText(currentPendapatan.getKeterangan());
        holder.tvDate.setText(sdf.format(currentPendapatan.getWaktu()));
    }

    @Override
    public int getItemCount() {
        return (listPendapatan !=null) ? listPendapatan.size():0;
    }

    public class IncomeViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate, tvRekening, tvIncome, tvKeterangan;

        public IncomeViewHolder(View view){
            super(view);

            tvRekening = view.findViewById(R.id.idTvIncomeRekening);
            tvIncome = view.findViewById(R.id.tvIncomeAmount);
            tvKeterangan = view.findViewById(R.id.idTvIncomeKet);
            tvDate = view.findViewById(R.id.idTvIncomeDate);
        }
    }

    public Pendapatan getIncome(int pos){
        return listPendapatan.get(pos);
    }


    public void setListIncome(List<Pendapatan> listPendapatan) {
        this.listPendapatan = listPendapatan;
        notifyDataSetChanged();
    }
}

