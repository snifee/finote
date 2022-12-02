package com.example.aplikasita.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.data.viewmodel.IncomeViewModel;
import com.example.aplikasita.data.entity.Income;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class AddIncomeFragment extends Fragment {

    IncomeViewModel incomeViewModel;



    private EditText editTextRek;
    private EditText editTextJumlah;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;



    public AddIncomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_income, container, false);

        editTextRek = view.findViewById(R.id.etRekening);
        editTextJumlah = view.findViewById(R.id.etJumlah);
        editTextKet = view.findViewById(R.id.etKeterangan);
        editTextDate = view.findViewById(R.id.etDate);
        submitButton = view.findViewById(R.id.submitButton);


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
            LocalDateTime d = LocalDateTime.now();

            date = d.format(DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss")).toString();
        }

        try {
            Long jml= Long.parseLong(jumlah);

            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

            Date formattedDate = df.parse(date);

            System.out.println("haiiii"+df.parse(date));

            String monthYear = Month.of(formattedDate.getMonth()).toString() + String.valueOf(1900+formattedDate.getYear());


            Income income = new Income(rekening,jml,formattedDate, monthYear,keterangan);

            incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
            incomeViewModel.insert(income);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            getActivity().finish();
        }
    }
}