package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.data.viewmodel.PengeluaranViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TambahPengeluaranActivity extends AppCompatActivity {

    private PengeluaranViewModel pengeluaranViewModel;
    private Integer jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengeluaran);

        EditText editTextJumlahPeng = findViewById(R.id.etAddSpendingJumlah);
        EditText editTextKet = findViewById(R.id.etAddSpendingKeterangan);
        EditText editTextDate = findViewById(R.id.etAddSpendingDate);
        Button submitButton = findViewById(R.id.submitAddSpendingButton);
        AutoCompleteTextView autoCompleteCategory = findViewById(R.id.idDropdownCategory);

        String[] category = getResources().getStringArray(R.array.kategori_keperluan);
        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<>(this,R.layout.dropdown_kategori,category);
        autoCompleteCategory.setAdapter(arrayAdapter);
        autoCompleteCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jenis = Integer.valueOf(arrayAdapter.getPosition(autoCompleteCategory.getText().toString()))+1;
            }
        });

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

                String jumlah = editTextJumlahPeng.getText() ==null ? "":editTextJumlahPeng.getText().toString();
                String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
                String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();
                saveSpending(jumlah, keterangan, date,jenis);

                if (jumlah.isEmpty()){
                    Toast.makeText(getBaseContext(),"Please insert amount",Toast.LENGTH_SHORT).show();
                    return;
                }

                finish();
            }
        });

    }

    private void saveSpending(String jumlah,String keterangan, String date,Integer jenis){

        if(date.isEmpty()){
            LocalDate d = LocalDate.now();

            date = d.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
        }

        try {
            long jml= Long.parseLong(jumlah);

            Date inputDate = MyStringUtils.stringDateToDateTime(date);

            Pengeluaran pengeluaran = new Pengeluaran(jml,keterangan,inputDate,jenis);

            pengeluaranViewModel = ViewModelProviders.of(this).get(PengeluaranViewModel.class);
            pengeluaranViewModel.insert(pengeluaran);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}