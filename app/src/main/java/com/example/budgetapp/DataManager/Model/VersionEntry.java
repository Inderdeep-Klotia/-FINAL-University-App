package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Transactions
@Entity
public class VersionEntry {
    @PrimaryKey (autoGenerate = true)
    int id;
    String versionName;
    String entryPeriod;
    String accountTypeName;
    String entryName;
    String entryDesc;
    double entryAmount;

    public VersionEntry(String versionName, String entryPeriod, String accountTypeName, String entryName, String entryDesc, double entryAmount) {
        this.versionName = versionName;
        this.entryPeriod = entryPeriod;
        this.accountTypeName = accountTypeName;
        this.entryName = entryName;
        this.entryDesc = entryDesc;
        this.entryAmount = entryAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntryPeriod() {
        return entryPeriod;
    }

    public void setEntryPeriod(String entryPeriod) {
        this.entryPeriod = entryPeriod;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryDesc() {
        return entryDesc;
    }

    public void setEntryDesc(String entryDesc) {
        this.entryDesc = entryDesc;
    }

    public double getEntryAmount() {
        return entryAmount;
    }

    public void setEntryAmount(double entryAmount) {
        this.entryAmount = entryAmount;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
}

