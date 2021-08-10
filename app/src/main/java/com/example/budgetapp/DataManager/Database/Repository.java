package com.example.budgetapp.DataManager.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.budgetapp.*;
import com.example.budgetapp.DataManager.Model.AccountGroup;
import com.example.budgetapp.DataManager.Model.Version;
import com.example.budgetapp.DataManager.Database.Dao.AccountGroupDao;
import com.example.budgetapp.DataManager.Database.Dao.AccountTypeDao;
import com.example.budgetapp.DataManager.Database.Dao.FactDao;
import com.example.budgetapp.DataManager.Database.Dao.GoalDao;
import com.example.budgetapp.DataManager.Database.Dao.GoalDetailDao;
import com.example.budgetapp.DataManager.Database.Dao.VersionDao;
import com.example.budgetapp.DataManager.Database.Dao.VersionEntryDao;
import com.example.budgetapp.DataManager.Model.AccountType;
import com.example.budgetapp.DataManager.Model.Fact;
import com.example.budgetapp.DataManager.Model.Goal;
import com.example.budgetapp.DataManager.Model.GoalDetail;
import com.example.budgetapp.DataManager.Model.VersionEntry;

import java.util.List;


public class Repository {
    private AccountGroupDao accountGroupDao;
    private AccountTypeDao accountTypeDao;
    private FactDao factDao;
    private GoalDao goalDao;
    private GoalDetailDao goalDetailDao;
    private VersionDao versionDao;
    private VersionEntryDao versionEntryDao;

    private LiveData<List<AccountGroup>> allAccountGroup;
    private LiveData<List<AccountType>> allAccountType;
    private LiveData<List<Fact>> allFact;
    private LiveData<List<Goal>> allGoal;
    private LiveData<List<GoalDetail>> allGoalDetail;
    private LiveData<List<Version>> allVersion;
    private LiveData<List<VersionEntry>> allVersionEntry;

    public Repository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        accountGroupDao = db.accountGroupDao();
        allAccountGroup = accountGroupDao.getAllAccountGroup();
        accountTypeDao = db.accountTypeDao();
        allAccountType = accountTypeDao.getAllAccountType();
        factDao = db.factDao();
        allFact = factDao.getAllFact();
        goalDao = db.goalDao();
        allGoal = goalDao.getAllGoal();
        goalDetailDao = db.goalDetailDao();
        allGoalDetail = goalDetailDao.getAllGoalDetail();
        versionDao = db.versionDao();
        allVersion = versionDao.getAllVersion();
        versionEntryDao = db.versionEntryDao();
        allVersionEntry = versionEntryDao.getAllVersionEntry();
    }

    public LiveData<List<AccountGroup>> getAllAccountGroup() {
        return allAccountGroup;
    }

    public void insertAccountGroup(AccountGroup accountGroup) {
        new InsertAGTask(accountGroupDao).execute(accountGroup);
    }

    public class InsertAGTask extends AsyncTask<AccountGroup, Void, Void> {
        private AccountGroupDao accountGroupDao;

        public InsertAGTask(AccountGroupDao accountGroupDao) {
            this.accountGroupDao = accountGroupDao;
        }

        @Override
        protected Void doInBackground(AccountGroup... accountGroups) {
            accountGroupDao.insertAccountGroup(accountGroups[0]);
            return null;
        }
    }

    public void updateAccountGroup(AccountGroup accountGroup) {
        new UpdateAGTask(accountGroupDao).execute(accountGroup);
    }

    public class UpdateAGTask extends AsyncTask<AccountGroup, Void, Void> {
        private AccountGroupDao accountGroupDao;

        public UpdateAGTask(AccountGroupDao accountGroupDao) {
            this.accountGroupDao = accountGroupDao;
        }

        @Override
        protected Void doInBackground(AccountGroup... accountGroups) {
            accountGroupDao.updateAccountGroup(accountGroups[0]);
            return null;
        }
    }

    public void deleteAccountGroup(AccountGroup accountGroup) {
        new DeleteAGTask(accountGroupDao).execute(accountGroup);
    }

    public class DeleteAGTask extends AsyncTask<AccountGroup, Void, Void> {
        private AccountGroupDao accountGroupDao;

        public DeleteAGTask(AccountGroupDao accountGroupDao) {
            this.accountGroupDao = accountGroupDao;
        }

        @Override
        protected Void doInBackground(AccountGroup... accountGroups) {
            accountGroupDao.deleteAccountGroup(accountGroups[0]);
            return null;
        }
    }

    // Account Type
    public LiveData<List<AccountType>> getAllAccountType() {
        return allAccountType;
    }

    public void insertAccountType(AccountType accountType) {
        new InsertATTask(accountTypeDao).execute(accountType);
    }

    public class InsertATTask extends AsyncTask<AccountType, Void, Void> {
        private AccountTypeDao accountTypeDao;

        public InsertATTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.insertAccountType(accountTypes[0]);
            return null;
        }
    }

    public void updateAccountType(AccountType accountType) {
        new UpdateATTask(accountTypeDao).execute(accountType);
    }

    public class UpdateATTask extends AsyncTask<AccountType, Void, Void> {
        private AccountTypeDao accountTypeDao;

        public UpdateATTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.updateAccountType(accountTypes[0]);
            return null;
        }
    }

    public void deleteAccountType(AccountType accountType) {
        new DeleteATTask(accountTypeDao).execute(accountType);
    }

    public class DeleteATTask extends AsyncTask<AccountType, Void, Void> {
        private AccountTypeDao accountTypeDao;

        public DeleteATTask(AccountTypeDao accountTypeDao) {
            this.accountTypeDao = accountTypeDao;
        }

        @Override
        protected Void doInBackground(AccountType... accountTypes) {
            accountTypeDao.deleteAccountType(accountTypes[0]);
            return null;
        }
    }

    // Fact
    public LiveData<List<Fact>> getAllFact() {
        return allFact;
    }

    public void insertFact(Fact fact) {
        new InsertFTask(factDao).execute(fact);
    }

    public class InsertFTask extends AsyncTask<Fact, Void, Void> {
        private FactDao factDao;

        public InsertFTask(FactDao factDao) {
            this.factDao = factDao;
        }

        @Override
        protected Void doInBackground(Fact... facts) {
            factDao.insertFact(facts[0]);
            return null;
        }
    }

    public void updateFact(Fact fact) {
        new UpdateFTask(factDao).execute(fact);
    }

    public class UpdateFTask extends AsyncTask<Fact, Void, Void> {
        private FactDao factDao;

        public UpdateFTask(FactDao factDao) {
            this.factDao = factDao;
        }

        @Override
        protected Void doInBackground(Fact... facts) {
            factDao.updateFact(facts[0]);
            return null;
        }
    }

    public void deleteFact(Fact fact) {
        new DeleteFTask(factDao).execute(fact);
    }

    public class DeleteFTask extends AsyncTask<Fact, Void, Void> {
        private FactDao factDao;

        public DeleteFTask(FactDao factDao) {
            this.factDao = factDao;
        }

        @Override
        protected Void doInBackground(Fact... facts) {
            factDao.deleteFact(facts[0]);
            return null;
        }
    }

    // Goal
    public LiveData<List<Goal>> getAllGoal() {
        return allGoal;
    }

    public void insertGoal(Goal goal) {
        new InsertGTask(goalDao).execute(goal);
    }

    public class InsertGTask extends AsyncTask<Goal, Void, Void> {
        private GoalDao goalDao;

        public InsertGTask(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.insertGoal(goals[0]);
            return null;
        }
    }

    public void updateGoal(Goal goal) {
        new UpdateGTask(goalDao).execute(goal);
    }

    public class UpdateGTask extends AsyncTask<Goal, Void, Void> {
        private GoalDao goalDao;

        public UpdateGTask(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.updateGoal(goals[0]);
            return null;
        }
    }

    public void deleteGoal(Goal goal) {
        new DeleteGTask(goalDao).execute(goal);
    }

    public class DeleteGTask extends AsyncTask<Goal, Void, Void> {
        private GoalDao goalDao;

        public DeleteGTask(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goal... goals) {
            goalDao.deleteGoal(goals[0]);
            return null;
        }
    }

    // Goal Detail
    public LiveData<List<GoalDetail>> getAllGoalDetail() {
        return allGoalDetail;
    }

    public void insertGoalDetail(GoalDetail goalDetail) {
        new InsertGDTask(goalDetailDao).execute(goalDetail);
    }

    public class InsertGDTask extends AsyncTask<GoalDetail, Void, Void> {
        private GoalDetailDao goalDetailDao;

        public InsertGDTask(GoalDetailDao goalDetailDao) {
            this.goalDetailDao = goalDetailDao;
        }

        @Override
        protected Void doInBackground(GoalDetail... goalDetails) {
            goalDetailDao.insertGoalDetail(goalDetails[0]);
            return null;
        }
    }

    public void updateGoalDetail(GoalDetail goalDetail) {
        new UpdateGDTask(goalDetailDao).execute(goalDetail);
    }

    public class UpdateGDTask extends AsyncTask<GoalDetail, Void, Void> {
        private GoalDetailDao goalDetailDao;

        public UpdateGDTask(GoalDetailDao goalDetailDao) {
            this.goalDetailDao = goalDetailDao;
        }

        @Override
        protected Void doInBackground(GoalDetail... goalDetails) {
            goalDetailDao.updateGoalDetail(goalDetails[0]);
            return null;
        }
    }

    public void deleteGoalDetail(GoalDetail goalDetail) {
        new DeleteGDTask(goalDetailDao).execute(goalDetail);
    }

    public class DeleteGDTask extends AsyncTask<GoalDetail, Void, Void> {
        private GoalDetailDao goalDetailDao;

        public DeleteGDTask(GoalDetailDao goalDetailDao) {
            this.goalDetailDao = goalDetailDao;
        }

        @Override
        protected Void doInBackground(GoalDetail... goalDetails) {
            goalDetailDao.deleteGoalDetail(goalDetails[0]);
            return null;
        }
    }

    // Version
    public LiveData<List<Version>> getAllVersion() {
        return allVersion;
    }

    public void insertVersion(Version version) {
        new InsertVTask(versionDao).execute(version);
    }

    public class InsertVTask extends AsyncTask<Version, Void, Void> {
        private VersionDao versionDao;

        public InsertVTask(VersionDao versionDao) {
            this.versionDao = versionDao;
        }

        @Override
        protected Void doInBackground(Version... versions) {
            versionDao.insertVersion(versions[0]);
            return null;
        }
    }

    public void updateVersion(Version version) {
        new UpdateVTask(versionDao).execute(version);
    }

    public class UpdateVTask extends AsyncTask<Version, Void, Void> {
        private VersionDao versionDao;

        public UpdateVTask(VersionDao versionDao) {
            this.versionDao = versionDao;
        }

        @Override
        protected Void doInBackground(Version... versions) {
            versionDao.updateVersion(versions[0]);
            return null;
        }
    }

    public void deleteVersion(Version version) {
        new DeleteVTask(versionDao).execute(version);
    }

    public class DeleteVTask extends AsyncTask<Version, Void, Void> {
        private VersionDao versionDao;

        public DeleteVTask(VersionDao versionDao) {
            this.versionDao = versionDao;
        }

        @Override
        protected Void doInBackground(Version... versions) {
            versionDao.deleteVersion(versions[0]);
            return null;
        }
    }

    // VersionEntry
    public LiveData<List<VersionEntry>> getAllVersionEntry() {
        return allVersionEntry;
    }

    public void insertVersionEntry(VersionEntry versionEntry) {
        new InsertVETask(versionEntryDao).execute(versionEntry);
    }

    public class InsertVETask extends AsyncTask<VersionEntry, Void, Void> {
        private VersionEntryDao versionEntryDao;

        public InsertVETask(VersionEntryDao versionEntryDao) {
            this.versionEntryDao = versionEntryDao;
        }

        @Override
        protected Void doInBackground(VersionEntry... versionEntrys) {
            versionEntryDao.insertVersionEntry(versionEntrys[0]);
            return null;
        }
    }

    public void updateVersionEntry(VersionEntry versionEntry) {
        new UpdateVETask(versionEntryDao).execute(versionEntry);
    }

    public class UpdateVETask extends AsyncTask<VersionEntry, Void, Void> {
        private VersionEntryDao versionEntryDao;

        public UpdateVETask(VersionEntryDao versionEntryDao) {
            this.versionEntryDao = versionEntryDao;
        }

        @Override
        protected Void doInBackground(VersionEntry... versionEntrys) {
            versionEntryDao.updateVersionEntry(versionEntrys[0]);
            return null;
        }
    }

    public void deleteVersionEntry(VersionEntry versionEntry) {
        new DeleteVETask(versionEntryDao).execute(versionEntry);
    }

    public class DeleteVETask extends AsyncTask<VersionEntry, Void, Void> {
        private VersionEntryDao versionEntryDao;

        public DeleteVETask(VersionEntryDao versionEntryDao) {
            this.versionEntryDao = versionEntryDao;
        }

        @Override
        protected Void doInBackground(VersionEntry... versionEntrys) {
            versionEntryDao.deleteVersionEntry(versionEntrys[0]);
            return null;
        }
    }
}
