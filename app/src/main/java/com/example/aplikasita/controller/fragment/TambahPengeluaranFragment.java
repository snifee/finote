package com.example.aplikasita.controller.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasita.R;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.data.viewmodel.SpendingViewModel;
import com.example.aplikasita.utils.MyStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TambahPengeluaranFragment extends Fragment {

    private SpendingViewModel spendingViewModel;

    private EditText editTextJumlahPeng;
    private EditText editTextKet;
    private EditText editTextDate;
    private Button submitButton;
    private AutoCompleteTextView autoCompleteCategory;

    private String rekening, jumlah, keterangan,date,jenis;

    public TambahPengeluaranFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_spending, container, false);

        editTextJumlahPeng = view.findViewById(R.id.etAddSpendingJumlah);
        editTextKet = view.findViewById(R.id.etAddSpendingKeterangan);
        editTextDate = view.findViewById(R.id.etAddSpendingDate);
        submitButton = view.findViewById(R.id.submitAddSpendingButton);
        autoCompleteCategory = view.findViewById(R.id.idDropdownCategory);

        String[] category = getResources().getStringArray(R.array.category);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),R.layout.dropdown_category,category);
        autoCompleteCategory.setAdapter(arrayAdapter);
        autoCompleteCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jenis = autoCompleteCategory.getText().toString();
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
                saveSpending();
            }
        });

        return view;
    }
    private void saveSpending(){
        jumlah = editTextJumlahPeng.getText() ==null ? "":editTextJumlahPeng.getText().toString();
        keterangan = editTextKet.getText() ==null ? "":editTextKet.getText().toString();
        date = editTextDate.getText() ==null ? "":editTextDate.getText().toString();

        if (jumlah.isEmpty()){
            Toast.makeText(getActivity(),"Please insert amount",Toast.LENGTH_SHORT).show();
            return;
        }

        if(date.isEmpty()){
            LocalDate d = LocalDate.now();

            date = d.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
        }

        try {
            long jml= Long.parseLong(jumlah);

            Date inputDate = MyStringUtils.stringDateToDateTime(date);

            String monthYear = MyStringUtils.getMonthYear(inputDate);

            Pengeluaran pengeluaran = new Pengeluaran(jml,keterangan,inputDate, monthYear,jenis);

            spendingViewModel = ViewModelProviders.of(this).get(SpendingViewModel.class);
            spendingViewModel.insert(pengeluaran);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            getActivity().finish();
        }
    }
}