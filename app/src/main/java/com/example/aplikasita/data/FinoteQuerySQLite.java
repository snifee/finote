package com.example.aplikasita.data;

public interface FinoteQuerySQLite {
    public static String BANK_TABLE = "CREATE TABLE IF NOT EXISTS bank (no_rekening INTEGER PRIMARY KEY, nama_bank TEXT, saldo INTEGER);";

    public static String SUMBER_PENGELUARAN_TABLE = "CREATE TABLE IF NOT EXISTS sumber_pengeluaran (sumber TEXT PRIMARY KEY, no_rekening INTEGER);";

    public static String BUDGET_TABLE = "CREATE TABLE IF NOT EXISTS budget (id INTEGER PRIMARY KEY AUTOINCREMENT, sumber_anggaran TEXT, kategori_pengeluaran TEXT);";

    public static String PEMASUKAN_TABLE ="CREATE TABLE IF NOT EXISTS pemasukan (id INTEGER PRIMARY KEY AUTOINCREMENT, no_rekening INTEGER, jumlah INTEGER, bulan TEXT,created_at TEXT DEFAULT CURRENT_TIMESTAMP);";

    public static String PENGELUARAN_TABLE ="CREATE TABLE IF NOT EXISTS pengeluaran (id INTEGER PRIMARY KEY AUTOINCREMENT, sumber_pengeluaran INTEGER, jumlah INTEGER, keterangan TEXT, waktu DATETIME,jenis_pengeluaran TEXT,created_at TEXT DEFAULT CURRENT_TIMESTAMP);";

    public static String PINJAMAN_TABLE ="CREATE TABLE IF NOT EXISTS pinjaman (id INTEGER PRIMARY KEY AUTOINCREMENT, nama_pinjaman TEXT, jumlah INTEGER, sisa_pinjaman INT, created_at TEXT DEFAULT CURRENT_TIMESTAMP);";
}
