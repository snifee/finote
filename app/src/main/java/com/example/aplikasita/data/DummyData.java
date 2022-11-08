package com.example.aplikasita.data;

import com.example.aplikasita.model.Bank;
import com.example.aplikasita.model.Month;

import java.util.ArrayList;

public class DummyData {

    public static ArrayList getData(){
        ArrayList<Month> monthList = new ArrayList<>();

        monthList.add(new Month("January","123","123"));
        monthList.add(new Month("February","123","123"));
        monthList.add(new Month("March","123","123"));
        monthList.add(new Month("April","123","123"));
        monthList.add(new Month("May","123","123"));
        monthList.add(new Month("June","123","123"));
        monthList.add(new Month("July","123","123"));
        monthList.add(new Month("August","123","123"));
        monthList.add(new Month("September","123","123"));
        monthList.add(new Month("Oktober","123","123"));
        monthList.add(new Month("November","123","123"));

        return monthList;
    }

    public static ArrayList getDataBank(){
        ArrayList<Bank> monthList = new ArrayList<>();

        monthList.add(new Bank("BCA","123","123222"));
        monthList.add(new Bank("BRI","123","1234343"));


        return monthList;
    }
}
