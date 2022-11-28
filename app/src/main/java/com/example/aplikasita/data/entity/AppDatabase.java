package com.example.aplikasita.data.entity;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.aplikasita.data.DateConverter;
import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.dao.SpendingDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Database(entities = {Spending.class, Income.class}, version = 2)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract SpendingDao spendingDao();

    public abstract IncomeDao incomeDao();

    private static volatile AppDatabase appDatabase;

    public static AppDatabase getDB(final Context context){
        if (appDatabase == null){
            synchronized (AppDatabase.class){
                if (appDatabase == null){
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "finote1_db")
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return appDatabase;
    };



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
        private IncomeDao incomeDao;
        private SpendingDao spendingDao;

        private PopulateDbAsyncTask(AppDatabase db){
            incomeDao = db.incomeDao();
            spendingDao = db.spendingDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try{
                LocalDate d = LocalDate.now();

                String date = d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date formattedDate = df.parse(date);


                incomeDao.insert(new Income("123", 230000L,formattedDate, Month.of(formattedDate.getMonth()).toString(),"beli rumah"));
                incomeDao.insert(new Income("123", 10000L,formattedDate,Month.of(formattedDate.getMonth()).toString(),"beli saham"));


                incomeDao.insert(new Income("123", 230000L,formattedDate, Month.of(2).toString(),"beli rumah"));
                incomeDao.insert(new Income("123", 10000L,formattedDate,Month.of(2).toString(),"beli saham"));

                incomeDao.insert(new Income("123", 230000L,formattedDate, Month.of(3).toString(),"beli rumah"));
                incomeDao.insert(new Income("123", 10000L,formattedDate,Month.of(3).toString(),"beli saham"));
//            public Spending( String sumberPengeluaran, Integer jumlah, String keterangan, Date waktu, String jenisPengeluaran) {

                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(formattedDate.getMonth()).toString(),"Primer"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(formattedDate.getMonth()).toString(),"Sekunder"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(formattedDate.getMonth()).toString(),"Sekunder"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(formattedDate.getMonth()).toString(),"Primer"));

                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(2).toString(),"Primer"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(2).toString(),"Sekunder"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(2).toString(),"Primer"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(2).toString(),"Primer"));

                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(3).toString(),"Primer"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(3).toString(),"Sekunder"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(3).toString(),"Primer"));
                spendingDao.insert(new Spending("03628293", 23000L,"beli rumah",formattedDate,Month.of(3).toString(),"Primer"));
            }catch (Exception e){
                System.out.println(e);
            }


            return null;
        }
    }



}
