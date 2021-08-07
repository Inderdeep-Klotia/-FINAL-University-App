package com.example.budgetapp.DataManager.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.Fact;


import java.util.List;

@Dao
public interface FactDao {

    @Insert
    void insertFact(Fact fact);

    @Update
    void updateFact(Fact fact);

    @Delete
    void deleteFact(Fact fact);

    @Query("Select * From Fact Order By id DESC")
    LiveData<List<Fact>> getAllFact();


}
