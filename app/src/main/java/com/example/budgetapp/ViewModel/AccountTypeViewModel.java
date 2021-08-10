package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.AccountType;

import java.util.List;

public class AccountTypeViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<AccountType>> allAccountType;


    public AccountTypeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allAccountType = repository.getAllAccountType();
    }

    public LiveData<List<AccountType>> getAllAccountType() {
        return allAccountType;
    }

    public void insertAccountType(AccountType accountType) {
        repository.insertAccountType(accountType);
    }

    public void updateAccountType(AccountType accountType) {
        repository.updateAccountType(accountType);
    }

    public void deleteAccountType(AccountType accountType) {
        repository.deleteAccountType(accountType);
    }

    public List<AccountType> getAccountType(String accountTypeName){
        return repository.getAccountType(accountTypeName);
    }

}

