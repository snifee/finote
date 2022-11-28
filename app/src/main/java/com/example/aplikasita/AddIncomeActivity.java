package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.IncomeViewModel;
import com.example.aplikasita.data.entity.Income;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AddIncomeActivity extends AppCompatActivity {

    public static final String EXTRA_JUMLAH = "com.example.aplikasita.JUMLAH";
    public static final String EXTRA_REK = "com.example.aplikasita.REK";
    public static final String EXTRA_KET = "com.example.aplikasita.KET";
    public static final String EXTRA_DATE = "com.example.aplikasita.DATE";


    IncomeViewModel incomeViewModel;



    private EditText editTextRek;
    private EditText editTextJumlah;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

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

        if(date.isEmpty()){
            LocalDateTime d = LocalDateTime.now();

            date = d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
        }

        try {
            Long jml= Long.parseLong(jumlah);

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            Date formattedDate = df.parse(date);

            System.out.println("haiiii"+df.parse(date));

            String monthYear = Month.of(formattedDate.getMonth()).toString() + String.valueOf(1900+formattedDate.getYear());


            Income income = new Income(rekening,jml,formattedDate, monthYear,keterangan);

            incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
            incomeViewModel.insert(income);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            finish();
        }
    }
}