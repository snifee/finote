package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.data.viewmodel.KebutuhanViewModel;

public class TambahKebutuhanActivity extends AppCompatActivity {

    public static final int TAMBAH_KEBUTUHAN = 1;
    public static final int EDIT_KEBUTUHAN = 2;

    public static final String KEBUTUHAN = "com.example.aplikasita.KEBUTUHAN";
    public static final String JUMLAH = "com.example.aplikasita.JUMLAH";
    public static final String ID = "com.example.aplikasita.ID";
    public static final String KATEGORI = "com.example.aplikasita.KATEGORI";


    private EditText etKebutuhan,etJumlahKebutuhan, etKategoriKebutuhan;
    private TextView tvTitle;
    private KebutuhanViewModel kebutuhanViewModel;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kebutuhan);

        Intent intent = getIntent();



        etJumlahKebutuhan = findViewById(R.id.etJumlahBudget);
        etKebutuhan = findViewById(R.id.etKebutuhan);
        etKategoriKebutuhan = findViewById(R.id.etKatagoriKebutuhan);
        submitButton = findViewById(R.id.submitButtonKebutuhan);
        tvTitle = findViewById(R.id.tvTambahKebutuhanTitle);

        if (intent.hasExtra(ID)){
            tvTitle.setText("Edit Kebutuhan");
            etJumlahKebutuhan.setText(String.valueOf(intent.getLongExtra(JUMLAH,0)));
            etKebutuhan.setText(intent.getStringExtra(KEBUTUHAN));
            etKategoriKebutuhan.setText(intent.getStringExtra(KATEGORI));

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editKebutuhan(intent.getLongExtra(ID,0));
                }
            });
        }else {
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveKebutuhan();
                }
            });
        }
    }

    private void saveKebutuhan(){
        String kebutuhan = etKebutuhan.getText().toString();
        String kategoriKebutuhan = etKategoriKebutuhan.getText().toString();
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Kebutuhan keperluan = new Kebutuhan(kebutuhan,kategoriKebutuhan,jumlah);

            kebutuhanViewModel = ViewModelProviders.of(this).get(KebutuhanViewModel.class);
            kebutuhanViewModel.insert(keperluan);

            finish();

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }
    }

    private void editKebutuhan(Long id){
        String kebutuhan = etKebutuhan.getText().toString();
        String kategoriKebutuhan = etKategoriKebutuhan.getText().toString();
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Kebutuhan keperluan = new Kebutuhan(kebutuhan,kategoriKebutuhan,jumlah);
            keperluan.setIdKebutuhan(id);

            kebutuhanViewModel = ViewModelProviders.of(this).get(KebutuhanViewModel.class);
            kebutuhanViewModel.update(keperluan);

            finish();

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }
    }
}