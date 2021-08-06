package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Goals
@Entity
public class GoalDetail {
    @PrimaryKey (autoGenerate = true)
    int id;
    int goalID;
    int accountGroupID;
    int versionID;
    double amount;

    public GoalDetail(int goalID, int accountGroupID, double amount, int versionID) {
        this.goalID = goalID;
        this.accountGroupID = accountGroupID;
        this.amount = amount;
        this.versionID = versionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public int getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(int accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public double getAmount() {
        return amount;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }
}

