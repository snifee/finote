package com.example.aplikasita.controller.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.data.viewmodel.PemasukanViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class TambahPendapatanFragment extends Fragment {

    PemasukanViewModel pemasukanViewModel;



    private EditText editTextRek;
    private EditText editTextJumlah;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;



    public TambahPendapatanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah_pendapatan, container, false);

        editTextRek = view.findViewById(R.id.etRekening);
        editTextJumlah = view.findViewById(R.id.etJumlah);
        editTextKet = view.findViewById(R.id.etKeterangan);
        editTextDate = view.findViewById(R.id.etDate);
        submitButton = view.findViewById(R.id.submitButton);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(),
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
                saveNote();
            }
        });

        return view;
    }

    private void saveNote(){
        String rekening = editTextRek.getText()==null ? "":editTextRek.getText().toString();
        String jumlah = editTextJumlah.getText() ==null ? "":editTextJumlah.getText().toString();
        String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
        String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();

        if (jumlah.isEmpty()){
            Toast.makeText(getActivity(),"Please insert amount",Toast.LENGTH_SHORT).show();
            return;
        }

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
        }finally {
            getActivity().finish();
        }
    }
}