package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.GoalDetail;

import java.util.List;

public class GoalDetailViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<GoalDetail>> allGoalDetail;


    public GoalDetailViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allGoalDetail = repository.getAllGoalDetail();
    }

    public LiveData<List<GoalDetail>> getAllGoalDetail() {
        return allGoalDetail;
    }

    public void insertGoalDetail(GoalDetail goalDetail) {
        repository.insertGoalDetail(goalDetail);
    }

    public void updateGoalDetail(GoalDetail goalDetail) {
        repository.updateGoalDetail(goalDetail);
    }

    public void deleteGoalDetail(GoalDetail goalDetail) {
        repository.deleteGoalDetail(goalDetail);
    }


}


