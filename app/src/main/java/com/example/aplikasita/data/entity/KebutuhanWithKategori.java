package com.example.aplikasita.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class KebutuhanWithKategori {
    @Embedded
    public KategoriPengeluaran kategoriPengeluaran;
    @Relation(
            parentColumn = "idKebutuhan",
            entityColumn = "idKategoriPengeluaran"
    )
    public List<Kebutuhan> kebutuhans;
}
