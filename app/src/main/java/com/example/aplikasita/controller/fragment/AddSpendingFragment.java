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
import com.example.aplikasita.data.SpendingViewModel;
import com.example.aplikasita.data.entity.Spending;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AddSpendingFragment extends Fragment {
    private SpendingViewModel spendingViewModel;



    private EditText editTextSumberPeng;
    private EditText editTextJumlahPeng;
    private EditText editTextJenisPeng;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;

    public AddSpendingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_spending, container, false);

        editTextSumberPeng = view.findViewById(R.id.etAddSpendingRekening);
        editTextJenisPeng = view.findViewById(R.id.etAddSpendingJenisPengeluaran);
        editTextJumlahPeng = view.findViewById(R.id.etAddSpendingJumlah);
        editTextKet = view.findViewById(R.id.etAddSpendingKeterangan);
        editTextDate = view.findViewById(R.id.etAddSpendingDate);
        submitButton = view.findViewById(R.id.submitAddSpendingButton);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSpending();
            }
        });
        return view;
    }
    private void saveSpending(){
        String rekening = editTextSumberPeng.getText()==null ? "":editTextSumberPeng.getText().toString();
        String jumlah = editTextJumlahPeng.getText() ==null ? "":editTextJumlahPeng.getText().toString();
        String keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
        String date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();
        String jenis = editTextJenisPeng.getText() ==null ? "":editTextJenisPeng.getText().toString();

        if (jumlah.isEmpty()){
            Toast.makeText(getActivity(),"Please insert amount",Toast.LENGTH_SHORT).show();
            return;
        }

        if(date.isEmpty()){
            LocalDateTime d = LocalDateTime.now();

            date = d.format(DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss")).toString();
        }

        try {
            long jml= Long.parseLong(jumlah);

            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

            System.out.println("haiiii"+df.parse(date));

            Date formattedDate = df.parse(date);

            String monthYear = Month.of(formattedDate.getMonth()).toString() + String.valueOf(1900+formattedDate.getYear());


            Spending spending = new Spending(rekening,jml,keterangan,formattedDate, monthYear,jenis);

            spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
            spendingViewModel.insert(spending);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            getActivity().finish();
        }
    }
}