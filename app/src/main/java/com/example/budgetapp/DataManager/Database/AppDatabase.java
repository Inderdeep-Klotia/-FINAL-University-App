package com.example.budgetapp.DataManager.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.budgetapp.DataManager.Database.Dao.AccountGroupDao;
import com.example.budgetapp.DataManager.Database.Dao.AccountTypeDao;
import com.example.budgetapp.DataManager.Database.Dao.FactDao;
import com.example.budgetapp.DataManager.Database.Dao.GoalDao;
import com.example.budgetapp.DataManager.Database.Dao.VersionDao;
import com.example.budgetapp.DataManager.Database.Dao.VersionEntryDao;
import com.example.budgetapp.DataManager.Database.Dao.GoalDetailDao;
import com.example.budgetapp.DataManager.Model.AccountGroup;
import com.example.budgetapp.DataManager.Model.AccountType;
import com.example.budgetapp.DataManager.Model.Fact;
import com.example.budgetapp.DataManager.Model.Goal;
import com.example.budgetapp.DataManager.Model.GoalDetail;
import com.example.budgetapp.DataManager.Model.Version;
import com.example.budgetapp.DataManager.Model.VersionEntry;

import java.util.concurrent.Executors;

@Database(entities={AccountGroup.class, AccountType.class, Fact.class, Goal.class, GoalDetail.class, Version.class, VersionEntry.class}, version=4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract AccountGroupDao accountGroupDao();
    public abstract AccountTypeDao accountTypeDao();
    public abstract FactDao factDao();
    public abstract GoalDao goalDao();
    public abstract GoalDetailDao goalDetailDao();
    public abstract VersionDao versionDao();
    public abstract VersionEntryDao versionEntryDao();
    private static volatile AppDatabase appDatabase;

    static AppDatabase getDatabase(final Context context){
        if (appDatabase==null)
        {
            synchronized (AppDatabase.class){
                appDatabase= Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,
                        "App_Database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomDatabaseCallback)
                        .build();
            }

        }

        return appDatabase;
    }

    private static RoomDatabase.Callback roomDatabaseCallback= new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopularDBAsync(appDatabase).execute();
        }
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopularDBAsync(appDatabase).execute();
            new PopulateDBAsync(appDatabase).execute();
        }
    };

    private static class PopulateDBAsync extends AsyncTask<Void,Void,Void>{
        private final AccountGroupDao agDao;
        public PopulateDBAsync(AppDatabase adb){

            this.agDao = adb.accountGroupDao();
            AccountGroup[] accountGroups = new AccountGroup[]{
                    new AccountGroup("Essential"),
                    new AccountGroup("NonEssential"),
                    new AccountGroup("Savings"),
                    new AccountGroup("Balance"),
                    new AccountGroup("Income"),
                    new AccountGroup("Expenses")
            };
            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    for(AccountGroup ag : accountGroups) {
                        adb.accountGroupDao().insertAccountGroup(ag);
                    }
                }
            });

        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


    private static class PopularDBAsync extends AsyncTask<Void,Void,Void>{
        private final AccountGroupDao agDao;
        private final AccountTypeDao atDao;
        private final FactDao fDao;
        private final GoalDao gDao;
        private final GoalDetailDao gdDao;
        private final VersionDao vDao;
        private final VersionEntryDao veDao;

        public PopularDBAsync(AppDatabase adb) {
            this.agDao = adb.accountGroupDao();
            this.atDao = adb.accountTypeDao();
            this.fDao = adb.factDao();
            this.gDao = adb.goalDao();
            this.gdDao = adb.goalDetailDao();
            this.vDao = adb.versionDao();
            this.veDao = adb.versionEntryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}
