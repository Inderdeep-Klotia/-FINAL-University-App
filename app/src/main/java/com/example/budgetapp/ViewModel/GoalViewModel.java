package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.Activities.CreateVersion;
import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.Goal;

import java.util.List;

public class GoalViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Goal>> allGoal;


    public GoalViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allGoal = repository.getAllGoal();
    }

    public LiveData<List<Goal>> getAllGoal() {
        return allGoal;
    }

    public void insertGoal(Goal goal) {
        repository.insertGoal(goal);
    }

    public void updateGoal(Goal goal) {
        repository.updateGoal(goal);
    }

    public void deleteGoal(Goal goal) {
        repository.deleteGoal(goal);
    }


}

