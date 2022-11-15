package com.example.aplikasita.controller.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.example.aplikasita.R;
import com.example.aplikasita.model.Month;


public class MonthAdaptor extends RecyclerView.Adapter<MonthAdaptor.MonthViewHolder>{

    private ArrayList<Month> listMonth;

    public MonthAdaptor(ArrayList<Month> listMonth) {
        this.listMonth = listMonth;
    }

    @NonNull
    @Override
    public MonthAdaptor.MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_month,parent,false);
        return new MonthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdaptor.MonthViewHolder holder, int position) {
        holder.tvMonth.setText(listMonth.get(position).getMonth());
        holder.tvIncome.setText(listMonth.get(position).getIncome());
        holder.tvOutcome.setText(listMonth.get(position).getOutcome());
    }

    @Override
    public int getItemCount() {
        return (listMonth!=null) ? listMonth.size():0;
    }

    public class MonthViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMonth, tvIncome, tvOutcome;

        public MonthViewHolder(View view){
            super(view);

            tvMonth = view.findViewById(R.id.idMonth);
            tvIncome = view.findViewById(R.id.idIncome);
            tvOutcome = view.findViewById(R.id.idOutcome);
        }
    }
}

