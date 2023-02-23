package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TambahPendapatanActivity extends AppCompatActivity {

    private PemasukanViewModel pemasukanViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pendapatan);

        EditText editTextRek = findViewById(R.id.etRekening);
        EditText editTextJumlah = findViewById(R.id.etJumlah);
        EditText editTextKet = findViewById(R.id.etKeterangan);
        EditText editTextDate = findViewById(R.id.etDate);
        Button submitButton = findViewById(R.id.submitButton);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getBaseContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                editTextDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rekening = editTextRek.getText()==null ? "":editTextRek.getText().toString();
                String jumlah = editTextJumlah.getText() ==null ? "":editTextJumlah.getText().toString();
                String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
                String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();

                if (jumlah.isEmpty()){
                    Toast.makeText(getBaseContext(),"Please insert amount",Toast.LENGTH_SHORT).show();
                    return;
                }

                saveData(rekening,jumlah,keterangan,date);

                finish();

            }
        });

    }


    private void saveData(String rekening,String jumlah,String keterangan,String date){

        if(date.isEmpty()){
            LocalDate d = LocalDate.now();

            date = d.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
        }

        try {
            Long jml= Long.parseLong(jumlah);

            Date inputDate = MyStringUtils.stringDateToDateTime(date);

            Pendapatan pendapatan = new Pendapatan(rekening,jml,inputDate,keterangan);

            pemasukanViewModel = ViewModelProviders.of(this).get(PemasukanViewModel.class);
            pemasukanViewModel.insert(pendapatan);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}