package com.example.aplikasita.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.aplikasita.data.dao.HutangDao;
import com.example.aplikasita.data.dao.KategoriPengeluaranDao;
import com.example.aplikasita.data.dao.KebutuhanDao;
import com.example.aplikasita.data.dao.PendapatanDao;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.data.dao.PengeluaranDao;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.entity.KategoriPengeluaran;
import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.utils.MyStringUtils;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

import java.util.Date;



@Database(entities = {Pengeluaran.class, Pendapatan.class, Kebutuhan.class, Hutang.class, KategoriPengeluaran.class}, version =3)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "finot.db";

    public abstract PengeluaranDao pengeluaranDao();

    public abstract PendapatanDao pemasukanDao();

    public abstract KebutuhanDao keperluanDao();

    public abstract MonthlyDao monthlyDao();

    public abstract HutangDao hutangDao();

    public abstract KategoriPengeluaranDao kategoriPengeluaranDao();

    private static volatile AppDatabase appDatabase;



    public static AppDatabase getDB(final Context context, String password){
        SupportFactory factory = new SupportFactory(SQLiteDatabase.getBytes(password.toCharArray()));
        appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .addCallback(roomCallback)
                .fallbackToDestructiveMigration()
                .openHelperFactory(factory)
                .build();
        return appDatabase;
    }




    private  static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(appDatabase).execute();

        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db){
            super.onDestructiveMigration(db);
            new PopulateDbAsyncTask(appDatabase).execute();
        }

    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private PendapatanDao pendapatanDao;
        private PengeluaranDao pengeluaranDao;
        private KebutuhanDao kebutuhanDao;
        private HutangDao hutangDao;

        private KategoriPengeluaranDao kategoriPengeluaranDao;

        private PopulateDbAsyncTask(AppDatabase db){
            pendapatanDao = db.pemasukanDao();
            pengeluaranDao = db.pengeluaranDao();
            kebutuhanDao = db.keperluanDao();
            hutangDao = db.hutangDao();
            kategoriPengeluaranDao = db.kategoriPengeluaranDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try{

                kategoriPengeluaranDao.insert(new KategoriPengeluaran(1,EnumKategori.Sandang.name()));
                kategoriPengeluaranDao.insert(new KategoriPengeluaran(2,EnumKategori.Pangan.name()));
                kategoriPengeluaranDao.insert(new KategoriPengeluaran(3,EnumKategori.Pendidikan.name()));
                kategoriPengeluaranDao.insert(new KategoriPengeluaran(4,EnumKategori.Energi.name()));
                kategoriPengeluaranDao.insert(new KategoriPengeluaran(5,EnumKategori.Hiburan.name()));

                Date date1 = MyStringUtils.stringDateToDateTime("02-12-2022");


                kebutuhanDao.insert(new Kebutuhan(EnumKategori.Sandang.name(), 1, 500000L));
                kebutuhanDao.insert(new Kebutuhan(EnumKategori.Pangan.name(), 2, 1000000L));
                kebutuhanDao.insert(new Kebutuhan(EnumKategori.Energi.name(), 3, 500000L));
                kebutuhanDao.insert(new Kebutuhan(EnumKategori.Pendidikan.name(), 4, 5000000L));
                kebutuhanDao.insert(new Kebutuhan(EnumKategori.Hiburan.name(), 5, 800000L));

                pendapatanDao.insert(new Pendapatan("08678929816", 2300000L,date1,"Gaji januari"));
                pendapatanDao.insert(new Pendapatan("09276678299", 10000000L,date1,"Penjualan saham"));

                pengeluaranDao.insert(new Pengeluaran(100000L,"Paket internet",date1,1));
                pengeluaranDao.insert(new Pengeluaran(230000L,"Bahan makanan pokok",date1,2));
                pengeluaranDao.insert(new Pengeluaran(2300000L,"Bayar UKT",date1,3));
                pengeluaranDao.insert(new Pengeluaran(230000L,"Beli rokok",date1,4));

                Date date2 = MyStringUtils.stringDateToDateTime("02-07-2022");

                pendapatanDao.insert(new Pendapatan("08678929816", 2300000L,date2,"Gaji januari"));
                pendapatanDao.insert(new Pendapatan("09276678299", 10000000L,date2,"Penjualan saham"));

                pengeluaranDao.insert(new Pengeluaran(100000L,"Paket internet",date2,1));
                pengeluaranDao.insert(new Pengeluaran(230000L,"Bahan makanan pokok",date2,2));
                pengeluaranDao.insert(new Pengeluaran(230000L,"Beli rokok",date2,4));


                hutangDao.insert(new Hutang(200000L,date2,"Tunggakan air",false));
                hutangDao.insert(new Hutang(20000L,date2,"Bon toko",true));

            }catch (Exception e){
                System.out.println("ERROR POPULATE DB caused by = "+e);
                System.out.println("ERROR POPULATE DB caused by = "+e);
                System.out.println("ERROR POPULATE DB caused by = "+e);
                System.out.println("ERROR POPULATE DB caused by = "+e);
                System.out.println("ERROR POPULATE DB caused by = "+e);
            }


            return null;
        }
    }



}
