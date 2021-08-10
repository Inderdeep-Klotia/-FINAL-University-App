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
    String accountGroupName;
    String accountClassName;
    char creditSign; //we'll hard code it
    int creditSignMultiplier;


    public AccountType(String accountTypeName, String accountGroupName, String accountClassName, char creditSign, int creditSignMultiplier) {
        this.accountTypeName = accountTypeName;
        this.accountGroupName = accountGroupName;
        this.accountClassName = accountClassName;
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

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
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

    public String getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(String accountGroupName) {
        this.accountGroupName = accountGroupName;
    }

    public String getAccountClassName() {
        return accountClassName;
    }

    public void setAccountClassName(String accountClassName) {
        this.accountClassName = accountClassName;
    }
}

