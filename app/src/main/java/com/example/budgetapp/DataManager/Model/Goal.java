package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//goals
//create/modify version
@Entity
public class Goal {
    @PrimaryKey (autoGenerate = true)
    int id;
    String goalName;
    boolean currentGoal;

    public Goal(String goalName, boolean currentGoal) {
        this.goalName = goalName;
        this.currentGoal = currentGoal;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public boolean getCurrentGoal() {
        return currentGoal;
    }

    public void setCurrentGoal(boolean currentGoal) {
        this.currentGoal = currentGoal;
    }
}

