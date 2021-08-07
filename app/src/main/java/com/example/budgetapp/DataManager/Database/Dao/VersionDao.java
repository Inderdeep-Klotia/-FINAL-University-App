package com.example.budgetapp.DataManager.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.Version;

import java.util.List;

@Dao
public interface VersionDao {

    @Insert
    void insertVersion(Version version);

    @Update
    void updateVersion(Version version);

    @Delete
    void deleteVersion(Version version);

    @Query("Select * From Version Order By id DESC")
    LiveData<List<Version>> getAllVersion();


}

