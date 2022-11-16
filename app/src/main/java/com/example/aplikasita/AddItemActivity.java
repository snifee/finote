package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    public static final String EXTRA_JUMLAH = "com.example.aplikasita.JUMLAH";
    public static final String EXTRA_REK = "com.example.aplikasita.REK";
    public static final String EXTRA_KET = "com.example.aplikasita.KET";
    public static final String EXTRA_DATE = "com.example.aplikasita.DATE";



    private EditText editTextRek;
    private EditText editTextJumlah;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        editTextRek = findViewById(R.id.etRekening);
        editTextJumlah = findViewById(R.id.etJumlah);
        editTextKet = findViewById(R.id.etKeterangan);
        editTextDate = findViewById(R.id.etDate);
        submitButton = findViewById(R.id.submitButton);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_exit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });


    }

    private void saveNote(){
        String rekening = editTextRek.getText()==null ? "":editTextRek.getText().toString();
        String jumlah = editTextJumlah.getText() ==null ? "":editTextJumlah.getText().toString();
        String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
        String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();

        if (jumlah.isEmpty()){
            Toast.makeText(this,"Please insert amount",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_REK,rekening);
        data.putExtra(EXTRA_JUMLAH,jumlah);
        data.putExtra(EXTRA_KET,keterangan);
        data.putExtra(EXTRA_DATE,date);

        setResult(RESULT_OK,data);
        finish();
    }
}