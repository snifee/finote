package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.entity.Kebutuhan;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class HutangAdaptor extends RecyclerView.Adapter<HutangAdaptor.HutangViewHolder>{

    private List<Hutang> listHutang = new ArrayList<>();
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    private OnItemClickListener listener;

    public HutangAdaptor() {
    }

    @NonNull
    @Override
    public HutangAdaptor.HutangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_hutang,parent,false);
        return new HutangViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HutangAdaptor.HutangViewHolder holder, int position) {
        Hutang hutang = listHutang.get(position);

        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setCurrency(Currency.getInstance("IDR"));
        String jumlah = numberFormat.format(hutang.getJumlah());

        SimpleDateFormat sdf = new SimpleDateFormat();

        holder.tvJumlahHutang.setText(jumlah);
        holder.tvKeterangan.setText(hutang.getKeterangan());
        holder.tvJatuhTempo.setText(sdf.format(hutang.getJatuhTempo()));
        if (hutang.getLunas()) holder.tvLunas.setText(R.string.lunas);
    }

    @Override
    public int getItemCount() {
        return (listHutang !=null) ? listHutang.size():0;
    }

    public class HutangViewHolder extends RecyclerView.ViewHolder{

        private TextView tvJatuhTempo, tvJumlahHutang, tvKeterangan,tvLunas;

        public HutangViewHolder(View view){
            super(view);
            tvJumlahHutang = view.findViewById(R.id.tvJumlahHutang);
            tvKeterangan = view.findViewById(R.id.tvKeteranganHutang);
            tvJatuhTempo = view.findViewById(R.id.tvJatuhTempo);
            tvLunas = view.findViewById(R.id.tvLunas);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener != null && pos != RecyclerView.NO_POSITION){
                        listener.onItemClick(listHutang.get(pos));
                    }

                }
            });
        }
    }

    public Hutang getHutang(int pos){
        return listHutang.get(pos);
    }

    public interface OnItemClickListener{
        void onItemClick(Hutang hutang);
    }

    public void setOnItemClickListener(HutangAdaptor.OnItemClickListener listener){
        this.listener = listener;
    }


    public void setListHutang(List<Hutang> listHutang) {
        this.listHutang = listHutang;
        notifyDataSetChanged();
    }
}

