package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.Goal;
import com.example.budgetapp.ViewModel.*;
import com.example.budgetapp.DataManager.Model.AccountGroup;

import java.util.List;

public class AccountGroupViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<AccountGroup>> allAccountGroup;


    public AccountGroupViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allAccountGroup = repository.getAllAccountGroup();
    }

    public LiveData<List<AccountGroup>> getAllAccountGroup() {
        return allAccountGroup;
    }

    public void insertAccountGroup(AccountGroup accountGroup) {
        repository.insertAccountGroup(accountGroup);
    }

    public void updateAccountGroup(AccountGroup accountGroup) {
        repository.updateAccountGroup(accountGroup);
    }

    public void deleteAccountGroup(AccountGroup accountGroup) {
        repository.deleteAccountGroup(accountGroup);
    }

/*    public AccountGroup getAccountGroup(){
        AccountGroup accGroup = (AccountGroup) allAccountGroup.getValue();
        return accGroup;
    }*/
    public AccountGroup getAccountGroup(String accountGroupName) {
        return repository.getAccountGroup(accountGroupName);
    }

}

