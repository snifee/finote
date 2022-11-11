package com.example.aplikasita.data;

import com.example.aplikasita.model.Bank;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;

public class DummyData {

    public static ArrayList getData(){
        ArrayList<Month> data = new ArrayList<>();

        data.add(new Month("January","123","123"));
        data.add(new Month("February","123","123"));
        data.add(new Month("March","123","123"));
        data.add(new Month("April","123","123"));
        data.add(new Month("May","123","123"));
        data.add(new Month("June","123","123"));
        data.add(new Month("July","123","123"));
        data.add(new Month("August","123","123"));
        data.add(new Month("September","123","123"));
        data.add(new Month("Oktober","123","123"));
        data.add(new Month("November","123","123"));

        return data;
    }

    public static ArrayList getDataBank(){
        ArrayList<Bank> data = new ArrayList<>();

        data.add(new Bank("BCA","123","123222"));
        data.add(new Bank("BRI","123","1234343"));


        return data;
    }
}
