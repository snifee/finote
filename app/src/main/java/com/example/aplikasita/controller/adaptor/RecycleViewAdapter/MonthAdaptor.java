package com.example.aplikasita.controller.adaptor.RecycleViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.aplikasita.R;
import com.example.aplikasita.model.MonthlyCashFlow;


public class MonthAdaptor extends RecyclerView.Adapter<MonthAdaptor.MonthViewHolder>{

    private List<MonthlyCashFlow> listMonth;
    private OnItemClickListener listener;

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
        holder.tvMonth.setText(listMonth.get(position).getDateYear());
        holder.tvIncome.setText("XX");
        holder.tvOutcome.setText(String.valueOf(listMonth.get(position).getSpendingTotal()));
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
            tvOutcome = view.findViewById(R.id.idSpending);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (listener!=null && pos!= RecyclerView.NO_POSITION){
                        listener.onItemClick(listMonth.get(pos));
                    }

                }
            });
        }
    }

    public void setListMonth(List<MonthlyCashFlow> listSpending) {
        this.listMonth = listSpending;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClick(MonthlyCashFlow sgbm);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }
}

