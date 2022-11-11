package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(tableName = "month_table")
public class Month {

    @PrimaryKey
    private Long id;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "year")
    private String year;
}
