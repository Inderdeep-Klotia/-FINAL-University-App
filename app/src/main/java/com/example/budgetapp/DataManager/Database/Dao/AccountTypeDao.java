package com.example.budgetapp.DataManager.Database.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.AccountType;


import java.util.List;

@Dao
public interface AccountTypeDao {

    @Insert
    void insertAccountType(AccountType accountType);

    @Update
    void updateAccountType(AccountType accountType);

    @Delete
    void deleteAccountType(AccountType accountType);

    @Query("Select * From AccountType Order By id DESC")
    LiveData<List<AccountType>> getAllAccountType();

    @Query("Select * From AccountType Where accountTypeName = :accountTypeName")
    List<AccountType> getAccountType(String accountTypeName);
}

