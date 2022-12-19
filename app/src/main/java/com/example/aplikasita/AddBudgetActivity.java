package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.data.viewmodel.BudgetViewModel;
import com.example.aplikasita.utils.MyStringUtils;

public class AddBudgetActivity extends AppCompatActivity {

    private EditText etKebutuhan,etJumlahKebutuhan, etKategoriKebutuhan;
    private BudgetViewModel budgetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        etJumlahKebutuhan = findViewById(R.id.etJumlahBudget);
        etKebutuhan = findViewById(R.id.etKebutuhan);
        etKategoriKebutuhan = findViewById(R.id.etBudgetCategory);

        String kebutuhan = etKebutuhan.getText().toString();
        String kategoriKebutuhan = etKategoriKebutuhan.getText().toString();
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Budget budget = new Budget(kebutuhan,kategoriKebutuhan,jumlah);

            budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel.class);
            budgetViewModel.insert(budget);

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }

    }
}