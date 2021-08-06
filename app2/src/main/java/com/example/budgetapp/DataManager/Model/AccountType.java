package com.example.budgetapp.DataManager.Model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

//takes accountgroups
//Add transactions
//version stuff
@Entity
public class AccountType {
    @PrimaryKey (autoGenerate = true)
    int id;
    String accountTypeName;
    int accountGroupID;
    char creditSign; //we'll hard code it
    int creditSignMultiplier;


    public AccountType(String accountTypeName, int accountGroupID, char creditSign, int creditSignMultiplier) {
        this.accountTypeName = accountTypeName;
        this.accountGroupID = accountGroupID;
        this.creditSign = creditSign;
        this.creditSignMultiplier = creditSignMultiplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(int accountGroupID) {
        this.accountTypeName = accountTypeName;
    }

    public int getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(int accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public char getCreditSign() {
        return creditSign;
    }

    public void setCreditSign(char creditSign) {
        this.creditSign = creditSign;
    }

    public int getCreditSignMultiplier() {
        return creditSignMultiplier;
    }

    public void setCreditSignMultiplier(int creditSignMultiplier) {
        this.creditSignMultiplier = creditSignMultiplier;
    }
}

