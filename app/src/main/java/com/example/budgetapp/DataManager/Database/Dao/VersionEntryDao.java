package com.example.budgetapp.DataManager.Database.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.VersionEntry;

import java.util.List;

@Dao
public interface VersionEntryDao {

    @Insert
    void insertVersionEntry(VersionEntry versionEntry);

    @Update
    void updateVersionEntry(VersionEntry versionEntry);

    @Delete
    void deleteVersionEntry(VersionEntry versionEntry);

    @Query("Select * From VersionEntry Order By id DESC")
    LiveData<List<VersionEntry>> getAllVersionEntry();


}
