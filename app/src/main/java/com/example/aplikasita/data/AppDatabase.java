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
import com.example.aplikasita.data.dao.KeperluanDao;
import com.example.aplikasita.data.dao.PendapatanDao;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.data.dao.PengeluaranDao;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.entity.Keperluan;
import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.utils.EnumCategory;
import com.example.aplikasita.utils.MyStringUtils;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

import java.util.Date;



@Database(entities = {Pengeluaran.class, Pendapatan.class, Keperluan.class, Hutang.class}, version =1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "databse.db";

    public abstract PengeluaranDao pengeluaranDao();

    public abstract PendapatanDao pemasukanDao();

    public abstract KeperluanDao keperluanDao();

    public abstract MonthlyDao monthlyDao();

    public abstract HutangDao hutangDao();

    private static volatile AppDatabase appDatabase;



    public static AppDatabase getDB(final Context context){

        if (appDatabase == null){
            synchronized (AppDatabase.class){
                if (appDatabase == null){
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME)
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

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
        private KeperluanDao keperluanDao;
        private HutangDao hutangDao;

        private PopulateDbAsyncTask(AppDatabase db){
            pendapatanDao = db.pemasukanDao();
            pengeluaranDao = db.pengeluaranDao();
            keperluanDao = db.keperluanDao();
            hutangDao = db.hutangDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try{

                Date date1 = MyStringUtils.stringDateToDateTime("02-12-2022");
                String month1 = MyStringUtils.getMonthYear(date1);

                pendapatanDao.insert(new Pendapatan("123", 230000L,date1, month1,"beli rumah"));
                pendapatanDao.insert(new Pendapatan("123", 10000L,date1,month1,"beli saham"));

                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date1,month1,"Primer"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date1,month1,"Sekunder"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date1,month1,"Sekunder"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date1,month1,"Primer"));

                Date date2 = MyStringUtils.stringDateToDateTime("02-07-2022");
                String month2 = MyStringUtils.getMonthYear(date2);

                pendapatanDao.insert(new Pendapatan("123", 230000L,date2, month2,"beli rumah"));
                pendapatanDao.insert(new Pendapatan("123", 10000L,date2,month2,"beli saham"));

                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date2,month2,"Primer"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date2,month2,"Sekunder"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date2,month2,"Sekunder"));
                pengeluaranDao.insert(new Pengeluaran(23000L,"beli rumah",date2,month2,"Primer"));


                keperluanDao.insert(new Keperluan(EnumCategory.Sandang.name(), EnumCategory.Sandang.name(), 50000L));
                keperluanDao.insert(new Keperluan(EnumCategory.Pangan.name(), EnumCategory.Pangan.name(), 50000L));
                keperluanDao.insert(new Keperluan(EnumCategory.Energi.name(), EnumCategory.Energi.name(), 50000L));
                keperluanDao.insert(new Keperluan(EnumCategory.Pendidikan.name(), EnumCategory.Pendidikan.name(), 50000L));
                keperluanDao.insert(new Keperluan(EnumCategory.Hiburan.name(), EnumCategory.Hiburan.name(), 50000L));

                hutangDao.insert(new Hutang(200000L,date2,"apalah",false));
                hutangDao.insert(new Hutang(200000L,date2,"apalah",true));

            }catch (Exception e){
                System.out.println(e);
            }


            return null;
        }
    }



}
