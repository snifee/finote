package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

    private AutoCompleteTextView autoCompleteCategory;
    private TextView tvTitle;
    private KebutuhanViewModel kebutuhanViewModel;
    private Button submitButton;

    private Integer jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kebutuhan);

        Intent intent = getIntent();



        etJumlahKebutuhan = findViewById(R.id.etJumlahBudget);
        etKebutuhan = findViewById(R.id.etKebutuhan);
        submitButton = findViewById(R.id.submitButtonKebutuhan);
        tvTitle = findViewById(R.id.tvTambahKebutuhanTitle);
        autoCompleteCategory = findViewById(R.id.idDropdownCategory2);

        String[] category = getResources().getStringArray(R.array.kategori_keperluan);
        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<>(this,R.layout.dropdown_kategori,category);
        autoCompleteCategory.setAdapter(arrayAdapter);
        autoCompleteCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jenis = Integer.valueOf(arrayAdapter.getPosition(autoCompleteCategory.getText().toString()))+1;
                System.out.println(jenis);
                System.out.println(jenis);
                System.out.println(jenis);
            }
        });

        if (intent.hasExtra(ID)){
            tvTitle.setText("Edit Kebutuhan");
            etJumlahKebutuhan.setText(String.valueOf(intent.getLongExtra(JUMLAH,0)));
            etKebutuhan.setText(intent.getStringExtra(KEBUTUHAN));

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editKebutuhan(intent.getIntExtra(ID,0));
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
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Kebutuhan keperluan = new Kebutuhan(kebutuhan,jenis,jumlah);

            kebutuhanViewModel = ViewModelProviders.of(this).get(KebutuhanViewModel.class);
            kebutuhanViewModel.insert(keperluan);

            finish();

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }
    }

    private void editKebutuhan(Integer id){
        String kebutuhan = etKebutuhan.getText().toString();
        String jumlahString = etJumlahKebutuhan.getText().toString();

        try {
            Long jumlah = Long.parseLong(jumlahString);

            Kebutuhan keperluan = new Kebutuhan(kebutuhan,jenis,jumlah);
            keperluan.setIdKebutuhan(id);

            kebutuhanViewModel = ViewModelProviders.of(this).get(KebutuhanViewModel.class);
            kebutuhanViewModel.update(keperluan);

            finish();

        }catch (Exception e){
            Toast.makeText(this,"Gagal Menyimpan",Toast.LENGTH_SHORT).show();
        }
    }
}