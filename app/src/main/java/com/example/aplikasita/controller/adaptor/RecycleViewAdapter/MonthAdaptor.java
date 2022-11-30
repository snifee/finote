package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;

import com.example.aplikasita.R;
import com.example.aplikasita.model.MonthlySpending;


public class MonthAdaptor extends RecyclerView.Adapter<MonthAdaptor.MonthViewHolder>{

    private List<MonthlySpending> listMonthSpending;

    private OnItemClickListener listener;
    NumberFormat format = NumberFormat.getCurrencyInstance();

    public MonthAdaptor() {
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

        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("IDR"));

//        String income = format.format(listMonthIncome.get(position).getIncomeTotal());
        String spending = format.format(listMonthSpending.get(position).getSpendingTotal());

        holder.tvMonth.setText(listMonthSpending.get(position).getMonthYear());
//        holder.tvIncome.setText(income);
        holder.tvOutcome.setText(spending);
    }

    @Override
    public int getItemCount() {

        return (listMonthSpending!=null) ? listMonthSpending.size():0;
    }

    public class MonthViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMonth, tvOutcome;

        public MonthViewHolder(View view){
            super(view);

            tvMonth = view.findViewById(R.id.idMonth);
//            tvIncome = view.findViewById(R.id.idIncome);
            tvOutcome = view.findViewById(R.id.idSpending);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null && pos!= RecyclerView.NO_POSITION){
                        listener.onItemClick(listMonthSpending.get(pos));
                    }

                }
            });
        }
    }

    public void setListMonthSpending(List<MonthlySpending> listMonthSpending) {
        this.listMonthSpending = listMonthSpending;
        notifyDataSetChanged();
    }

//    public void setListMonthIncome(List<MonthlyIncome> listMonthIncome) {
//        this.listMonthIncome = listMonthIncome;
//        notifyDataSetChanged();
//    }

    public interface OnItemClickListener{
        void onItemClick(MonthlySpending monthlySpending);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }
}

