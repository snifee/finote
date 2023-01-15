package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasita.R;
import com.example.aplikasita.dto.MonthlyIncome;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;


public class PendapatanPerbulanAdaptor extends RecyclerView.Adapter<PendapatanPerbulanAdaptor.MonthViewHolder>{

    private List<MonthlyIncome> listMonthIncome;

    private OnItemClickListener listener;
    NumberFormat format = NumberFormat.getCurrencyInstance();

    public PendapatanPerbulanAdaptor() {
    }

    @NonNull
    @Override
    public PendapatanPerbulanAdaptor.MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_pendapatan_perbulan,parent,false);
        return new MonthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendapatanPerbulanAdaptor.MonthViewHolder holder, int position) {

        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

//        String income = format.format(listMonthIncome.get(position).getIncomeTotal());
        String income = format.format(listMonthIncome.get(position).getIncomeTotal());

        holder.tvMonth.setText(listMonthIncome.get(position).getMonthYear());
//        holder.tvIncome.setText(income);
        holder.tvOutcome.setText(income);
    }

    @Override
    public int getItemCount() {

        return (listMonthIncome!=null) ? listMonthIncome.size():0;
    }

    public class MonthViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMonth, tvOutcome;

        public MonthViewHolder(View view){
            super(view);

            tvMonth = view.findViewById(R.id.idMonth);
//            tvIncome = view.findViewById(R.id.idIncome);
            tvOutcome = view.findViewById(R.id.idIncome);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null && pos!= RecyclerView.NO_POSITION){
                        listener.onItemClick(listMonthIncome.get(pos));
                    }

                }
            });
        }
    }

    public void setListMonthSpending(List<MonthlyIncome> listMonthIncome) {
        this.listMonthIncome = listMonthIncome;
        notifyDataSetChanged();
    }

//    public void setListMonthIncome(List<MonthlyIncome> listMonthIncome) {
//        this.listMonthIncome = listMonthIncome;
//        notifyDataSetChanged();
//    }

    public interface OnItemClickListener{
        void onItemClick(MonthlyIncome monthlyIncome);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }
}

