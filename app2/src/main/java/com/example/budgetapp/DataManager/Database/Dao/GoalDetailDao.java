package com.example.budgetapp.DataManager.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.budgetapp.DataManager.Model.GoalDetail;

import java.util.List;

@Dao
public interface GoalDetailDao {

    @Insert
    void insertGoalDetail(GoalDetail goalDetail);

    @Update
    void updateGoalDetail(GoalDetail goalDetail);

    @Delete
    void deleteGoalDetail(GoalDetail goalDetail);

    @Query("Select * From GoalDetail Order By id DESC")
    LiveData<List<GoalDetail>>getAllGoalDetail();


}
