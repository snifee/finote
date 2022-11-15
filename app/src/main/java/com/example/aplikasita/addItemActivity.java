package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class addItemActivity extends AppCompatActivity {

    private EditText editTextRek;
    private EditText editTextJumlah;
    private EditText editTextKet;
    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editTextRek = findViewById(R.id.etRekening);
        editTextJumlah = findViewById(R.id.etJumlah);
        editTextKet = findViewById(R.id.etKeterangan);
        editTextDate = findViewById(R.id.etDate);


    }

    private void saveNote(){
        String rekening = editTextRek.getText().toString();
        String jumlah = editTextJumlah.getText().toString();
        String keterangan = editTextKet.getText().toString();
        String date = editTextDate.getText().toString();
    }
}