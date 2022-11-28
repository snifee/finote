package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.SpendingViewModel;
import com.example.aplikasita.data.entity.Spending;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AddSpendingActivity extends AppCompatActivity {
    public static final String EXTRA_JUMLAH = "com.example.aplikasita.JUMLAH";
    public static final String EXTRA_REK = "com.example.aplikasita.REK";
    public static final String EXTRA_KET = "com.example.aplikasita.KET";
    public static final String EXTRA_DATE = "com.example.aplikasita.DATE";


    private SpendingViewModel spendingViewModel;



    private EditText editTextSumberPeng;
    private EditText editTextJumlahPeng;
    private EditText editTextJenisPeng;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spending);

        editTextSumberPeng = findViewById(R.id.etAddSpendingRekening);
        editTextJenisPeng = findViewById(R.id.etAddSpendingJenisPengeluaran);
        editTextJumlahPeng = findViewById(R.id.etAddSpendingJumlah);
        editTextKet = findViewById(R.id.etAddSpendingKeterangan);
        editTextDate = findViewById(R.id.etAddSpendingDate);
        submitButton = findViewById(R.id.submitAddSpendingButton);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSpending();
            }
        });


    }

    private void saveSpending(){
        String rekening = editTextSumberPeng.getText()==null ? "":editTextSumberPeng.getText().toString();
        String jumlah = editTextJumlahPeng.getText() ==null ? "":editTextJumlahPeng.getText().toString();
        String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
        String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();
        String jenis = editTextJenisPeng.getText() ==null ? "":editTextJenisPeng.getText().toString();

        if (jumlah.isEmpty()){
            Toast.makeText(this,"Please insert amount",Toast.LENGTH_SHORT).show();
            return;
        }

        if(date.isEmpty()){
            LocalDateTime d = LocalDateTime.now();

            date = d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
        }

        try {
            long jml= Long.parseLong(jumlah);

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            System.out.println("haiiii"+df.parse(date));

            Date formattedDate = df.parse(date);

            String monthYear = Month.of(formattedDate.getMonth()).toString() + String.valueOf(1900+formattedDate.getYear());


            Spending spending = new Spending(rekening,jml,keterangan,formattedDate, monthYear,jenis);

            spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
            spendingViewModel.insert(spending);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            finish();
        }
    }
}