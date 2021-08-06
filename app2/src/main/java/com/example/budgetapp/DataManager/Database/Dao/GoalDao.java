package com.example.budgetapp.DataManager.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.Goal;


import java.util.List;

@Dao
public interface GoalDao {

    @Insert
    void insertGoal(Goal goal);

    @Update
    void updateGoal(Goal goal);

    @Delete
    void deleteGoal(Goal goal);

    @Query("Select * From Goal Order By id DESC")
    LiveData<List<Goal>> getAllGoal();


}

