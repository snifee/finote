package com.example.aplikasita.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PengeluaranWithKategori {

    @Embedded
    public KategoriPengeluaran kategoriPengeluaran;
    @Relation(
            parentColumn = "idPengeluaran",
            entityColumn = "idKategoriPengeluaran"
    )
    public List<Pengeluaran> pengeluarans;

}