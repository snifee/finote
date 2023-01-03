package com.example.aplikasita.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.data.entity.Pengeluaran;

import java.util.List;

public class PengeluaranWithKebutuhan {

    @Embedded
    public Kebutuhan user;
    @Relation(
            parentColumn = "idKebutuhan",
            entityColumn = "idPengeluaran"
    )
    public List<Pengeluaran> pengeluarans;

}