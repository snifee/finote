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
    private HutangViewModel hutangViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hutang);

        EditText etJumlah = findViewById(R.id.etJumlah);
        EditText etKeterangan = findViewById(R.id.etKeterangan);
        EditText etJatuhTempo = findViewById(R.id.etJatuhTempo);
        Button submitButton = findViewById(R.id.submitButtonHutang);
        CheckBox checkBoxLunas = findViewById(R.id.checkboxIsLunas);
        TextView tvTitle = findViewById(R.id.tvTambahHutangTitle);

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

                    if (etKeterangan.getText().toString().isEmpty() || etJatuhTempo.getText().toString().isEmpty() || etKeterangan.getText().toString().isEmpty()){
                        Toast.makeText(getBaseContext(),"semua field harus diisi",Toast.LENGTH_SHORT).show();
                    }else {

                        String jumlah = etJumlah.getText().toString();
                        String keterangan = etKeterangan.getText().toString();
                        Date jatuhTempo = MyStringUtils.stringDateToDateTime(etJatuhTempo.getText().toString());
                        Boolean isLunas = checkBoxLunas.isChecked();

                        editHutang(intent.getLongExtra(ID, 0), jumlah, jatuhTempo,keterangan, isLunas);

                        finish();
                    }
                }
            });
        }else {
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (etKeterangan.getText().toString().isEmpty() || etJatuhTempo.getText().toString().isEmpty() || etKeterangan.getText().toString().isEmpty()){
                        Toast.makeText(getBaseContext(),"semua field harus diisi",Toast.LENGTH_SHORT).show();
                    }else {

                        String jumlah = etJumlah.getText().toString();
                        String keterangan = etKeterangan.getText().toString();
                        Date jatuhTempo = MyStringUtils.stringDateToDateTime(etJatuhTempo.getText().toString());
                        Boolean isLunas = checkBoxLunas.isChecked();

                        saveHutang(jumlah, jatuhTempo,keterangan, isLunas);

                        finish();
                    }

                }
            });
        }
    }

    private void saveHutang(String jumlah, Date jatuhTempo,String keterangan, Boolean isLunas){

        try{
            Long jml = Long.parseLong(jumlah);
            Hutang hutang = new Hutang(jml, jatuhTempo,keterangan, isLunas);

            hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
            hutangViewModel.insert(hutang);
        }catch (Exception e){

        }
    }

    private void editHutang(Long id, String jumlah, Date jatuhTempo,String keterangan, Boolean isLunas){
        try{
            Long jml = Long.parseLong(jumlah);
            Hutang hutang = new Hutang(jml, jatuhTempo,keterangan, isLunas);
            hutang.setId(id);

            hutangViewModel = ViewModelProviders.of(this).get(HutangViewModel.class);
            hutangViewModel.update(hutang);
        }catch (Exception e){

        }
    }
}