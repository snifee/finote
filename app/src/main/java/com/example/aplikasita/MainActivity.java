package com.example.aplikasita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private ArrayList<Month> monthArrayList;

    private RecyclerView recyclerView;
    private MonthAdaptor monthAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recycleViewId);

        monthAdaptor = new MonthAdaptor(monthArrayList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(monthAdaptor);



    }

    public void getData(){
        monthArrayList = new ArrayList<>();
        monthArrayList.add(new Month("Jan","12.4","12.9"));
        monthArrayList.add(new Month("Feb","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
        monthArrayList.add(new Month("March","12.4","12.9"));
    }
}