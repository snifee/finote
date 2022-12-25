package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.viewmodel.HutangViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TambahHutangActivity extends AppCompatActivity {

    private EditText etJumlah;
    private EditText etKeterangan;
    private EditText etJatuhTempo;
    private Button submitButton;
    private CheckBox checkBoxLunas;
    private HutangViewModel hutangViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hutang);

        etJumlah = findViewById(R.id.etJumlah);
        etKeterangan = findViewById(R.id.etKeterangan);
        etJatuhTempo = findViewById(R.id.etJatuhTempo);
        submitButton = findViewById(R.id.submitButtonHutang);
        checkBoxLunas = findViewById(R.id.checkboxIsLunas);

        etJatuhTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TambahHutangActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etJatuhTempo.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                saveHutang();

            }
        });
    }

    private void saveHutang(){
        try {

            if (etKeterangan.getText().toString().isEmpty() || etJatuhTempo.getText().toString().isEmpty() || etKeterangan.getText().toString().isEmpty()){
                Toast.makeText(this, "semua field harus diisi",Toast.LENGTH_SHORT).show();
            }else {
                String keterangan;
                Date jatuhTempo;
                Long jumlah;
                Boolean isLunas;

                jumlah = Long.parseLong(etJumlah.getText().toString());
                keterangan = etKeterangan.getText().toString();
                jatuhTempo = MyStringUtils.stringDateToDateTime(etJatuhTempo.getText().toString());
                isLunas = checkBoxLunas.isChecked();

                Hutang hutang = new Hutang(jumlah, jatuhTempo,keterangan, isLunas);

                hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
                hutangViewModel.insert(hutang);

                finish();


            }


        }catch (Exception e){

        }
    }
}