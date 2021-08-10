package com.example.budgetapp.DataManager.Database.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.AccountGroup;
import com.example.budgetapp.DataManager.Model.AccountGroup;

import java.util.List;

@Dao
public interface AccountGroupDao {

    @Insert
    void insertAccountGroup(AccountGroup accountGroup);

    @Insert
    void insertPreloadAccountGroup(AccountGroup[] accountGroups);

    @Update
    void updateAccountGroup(AccountGroup accountGroup);

    @Delete
    void deleteAccountGroup(AccountGroup accountGroup);

    @Query("Select * From AccountGroup Order By id DESC")
    LiveData<List<AccountGroup>> getAllAccountGroup();


}
