package com.example.aplikasita.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.aplikasita.data.dao.BudgetDao;
import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.data.dao.SpendingDao;
import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.utils.EnumCategory;
import com.example.aplikasita.utils.MyPreferences;
import com.example.aplikasita.utils.MyStringUtils;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

import java.util.Date;



@Database(entities = {Spending.class, Income.class, Budget.class}, version =2)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "encrypted.db";

    public abstract SpendingDao spendingDao();

    public abstract IncomeDao incomeDao();

    public abstract BudgetDao budgetDao();

    public abstract MonthlyDao monthlyDao();

    private static volatile AppDatabase appDatabase;



    public static AppDatabase getDB(final Context context, String password){

        if (appDatabase == null){
            synchronized (AppDatabase.class){
                if (appDatabase == null){
                    SupportFactory factory = new SupportFactory(SQLiteDatabase.getBytes(password.toCharArray()));
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME)
                            .addCallback(roomCallback)
                            .fallbackToDestructiveMigration()
                            .openHelperFactory(factory)
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
        private BudgetDao budgetDao;

        private PopulateDbAsyncTask(AppDatabase db){
            incomeDao = db.incomeDao();
            spendingDao = db.spendingDao();
            budgetDao = db.budgetDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try{

                Date date1 = MyStringUtils.stringDateToDateTime("02-12-2022");
                String month1 = MyStringUtils.getMonthYear(date1);

                incomeDao.insert(new Income("123", 230000L,date1, month1,"beli rumah"));
                incomeDao.insert(new Income("123", 10000L,date1,month1,"beli saham"));

                spendingDao.insert(new Spending(23000L,"beli rumah",date1,month1,"Primer"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date1,month1,"Sekunder"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date1,month1,"Sekunder"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date1,month1,"Primer"));

                Date date2 = MyStringUtils.stringDateToDateTime("02-07-2022");
                String month2 = MyStringUtils.getMonthYear(date2);

                incomeDao.insert(new Income("123", 230000L,date2, month2,"beli rumah"));
                incomeDao.insert(new Income("123", 10000L,date2,month2,"beli saham"));

                spendingDao.insert(new Spending(23000L,"beli rumah",date2,month2,"Primer"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date2,month2,"Sekunder"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date2,month2,"Sekunder"));
                spendingDao.insert(new Spending(23000L,"beli rumah",date2,month2,"Primer"));


                budgetDao.insert(new Budget(EnumCategory.Sandang.name(), EnumCategory.Sandang.name(), 50000L));
                budgetDao.insert(new Budget(EnumCategory.Pangan.name(), EnumCategory.Pangan.name(), 50000L));
                budgetDao.insert(new Budget(EnumCategory.Energi.name(), EnumCategory.Energi.name(), 50000L));
                budgetDao.insert(new Budget(EnumCategory.Pendidikan.name(), EnumCategory.Pendidikan.name(), 50000L));
                budgetDao.insert(new Budget(EnumCategory.Hiburan.name(), EnumCategory.Hiburan.name(), 50000L));

            }catch (Exception e){
                System.out.println(e);
            }


            return null;
        }
    }



}
