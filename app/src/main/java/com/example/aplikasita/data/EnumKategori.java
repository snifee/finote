package com.example.aplikasita.data;

import java.util.Arrays;
import java.util.Optional;

public enum EnumKategori {
    Sandang(1),Pangan(2), Pendidikan(3), Energi(4), Hiburan(5);

    private int value;

    EnumKategori(int value){
        this.value = value;
    }

    public static Optional<EnumKategori> valueOf(int value) {
        return Arrays.stream(values())
                .filter(legNo -> legNo.value == value)
                .findFirst();
    }
}
