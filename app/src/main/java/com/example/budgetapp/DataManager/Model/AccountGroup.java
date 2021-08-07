package com.example.budgetapp.DataManager.Model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

//groups of Accounts Types
//spending -
//savings
//bills - tuition

//Create version
//Goals

@Entity
public class AccountGroup {
    @PrimaryKey (autoGenerate = true)
    int id;
    String accountGroupName;

    public AccountGroup(String accountGroupName) {
        this.accountGroupName = accountGroupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(String accountGroupName) {
        this.accountGroupName = accountGroupName;
    }
}

