package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Keperluan;
import com.example.aplikasita.data.viewmodel.BudgetViewModel;

public class TambahKeperluanActivity extends AppCompatActivity {

    private EditText etKebutuhan,etJumlahKebutuhan, etKategoriKebutuhan;
    private BudgetViewModel budgetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keperluan);

        etJumlahKebutuhan = findViewById(R.id.etJumlahBudget);
        etKebutuhan = findViewById(R.id.etKebutuhan);
        etKategoriKebutuhan = findViewById(R.id.etBudgetCategory);

        String kebutuhan = etKebutuhan.getText().toString();
        String kategoriKebutuhan = etKategoriKebutuhan.getText().toString();
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Keperluan keperluan = new Keperluan(kebutuhan,kategoriKebutuhan,jumlah);

            budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel.class);
            budgetViewModel.insert(keperluan);

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }

    }
}