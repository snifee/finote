package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.EnumKategori;
import com.example.aplikasita.data.dao.KebutuhanDao;
import com.example.aplikasita.data.entity.Pengeluaran;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class PengeluaranAdaptor extends RecyclerView.Adapter<PengeluaranAdaptor.SpendingViewHolder>{

    private List<Pengeluaran> listPengeluaran = new ArrayList<>();
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    private KebutuhanDao kebutuhanDao;

    public PengeluaranAdaptor() {
    }

    @NonNull
    @Override
    public PengeluaranAdaptor.SpendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_pengeluaran,parent,false);
        return new SpendingViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PengeluaranAdaptor.SpendingViewHolder holder, int position) {
        Pengeluaran currentPengeluaran = listPengeluaran.get(position);

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));

        String spending = numberFormat.format(currentPengeluaran.getJumlah());

        SimpleDateFormat sdf = new SimpleDateFormat();

        holder.tvSpending.setText(spending);
        holder.tvKeterangan.setText(currentPengeluaran.getKeterangan());
        holder.tvDate.setText(sdf.format(currentPengeluaran.getWaktu()));
        String jenis = EnumKategori.valueOf(currentPengeluaran.getIdKategoriPengeluaran()).get().toString();
        holder.tvJenis.setText(jenis);
    }

    @Override
    public int getItemCount() {
        return (listPengeluaran !=null) ? listPengeluaran.size():0;
    }

    public class SpendingViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDate, tvRekening, tvSpending, tvKeterangan,tvJenis;

        public SpendingViewHolder(View view){
            super(view);

            tvSpending = view.findViewById(R.id.tvSpendingAmount);
            tvKeterangan = view.findViewById(R.id.idTvSpendingKet);
            tvDate = view.findViewById(R.id.idTvSpendingDate);
            tvJenis = view.findViewById(R.id.idTvSpendingJenisPengeluaran);
        }
    }

    public Pengeluaran getSpending(int pos){
        return listPengeluaran.get(pos);
    }


    public void setListSpending(List<Pengeluaran> listPengeluaran) {
        this.listPengeluaran = listPengeluaran;
        notifyDataSetChanged();
    }
}