package com.example.aplikasita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MonthAdaptor extends RecyclerView.Adapter<MonthAdaptor.ViewHolder>{

    private final Context context;
    private final ArrayList<Month> monthArrayList;


    public MonthAdaptor(Context context,ArrayList<Month> monthArrayList){
        this.context = context;
        this.monthArrayList = monthArrayList;
    }

    @NonNull
    @Override
    public MonthAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return monthArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView monthText;
        private final TextView incomeText;
        private final TextView outcomeText;

        public ViewHolder(View view) {
            super(view);

            monthText = view.findViewById(R.id.idMonth);
            incomeText = view.findViewById(R.id.idIncome);
            outcomeText = view.findViewById(R.id.idOutcome);
        }
    }
}

