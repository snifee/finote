package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.viewmodel.HutangViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TambahHutangActivity extends AppCompatActivity {

    public static final String JUMLAH = "package com.example.aplikasita.JUMLAH";
    public static final String KETERANGAN = "package com.example.aplikasita.KETERANGAN";
    public static final String JATUH_TEMPO = "package com.example.aplikasita.JATUH_TEMPO";
    public static final String IS_LUNAS = "package com.example.aplikasita.IS_LUNAS";
    public static final String ID = "package com.example.aplikasita.ID";

    private EditText etJumlah;
    private EditText etKeterangan;
    private EditText etJatuhTempo;
    private Button submitButton;
    private CheckBox checkBoxLunas;
    private HutangViewModel hutangViewModel;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hutang);

        etJumlah = findViewById(R.id.etJumlah);
        etKeterangan = findViewById(R.id.etKeterangan);
        etJatuhTempo = findViewById(R.id.etJatuhTempo);
        submitButton = findViewById(R.id.submitButtonHutang);
        checkBoxLunas = findViewById(R.id.checkboxIsLunas);
        tvTitle = findViewById(R.id.tvTambahHutangTitle);

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

        Intent intent = getIntent();

        if (intent.hasExtra(ID)){
            tvTitle.setText("Edit Hutang");
            etJumlah.setText(String.valueOf(intent.getLongExtra(JUMLAH,0)));
            etKeterangan.setText(intent.getStringExtra(KETERANGAN));
            etJatuhTempo.setText(intent.getStringExtra(JATUH_TEMPO));

            Boolean isChecked = intent.getBooleanExtra(IS_LUNAS,false);
            if (isChecked){
                checkBoxLunas.setChecked(true);
            }
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    editHutang(intent.getLongExtra(ID,0));

                }
            });
        }else {
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    saveHutang();

                }
            });
        }


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

    private void editHutang(Long id){
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
                hutang.setId(id);

                hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
                hutangViewModel.update(hutang);

                finish();


            }


        }catch (Exception e){

        }
    }
}