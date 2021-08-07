package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Transactions
@Entity
public class VersionEntry {
    @PrimaryKey (autoGenerate = true)
    int id;
    int versionID;
    String entryPeriod;
    int accountTypeID;
    String entryName;
    String entryDesc;
    double entryAmount;

    public VersionEntry(int versionID, String entryPeriod, int accountTypeID, String entryName, String entryDesc, double entryAmount) {
        this.versionID = versionID;
        this.entryPeriod = entryPeriod;
        this.accountTypeID = accountTypeID;
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

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String getEntryPeriod() {
        return entryPeriod;
    }

    public void setEntryPeriod(String entryPeriod) {
        this.entryPeriod = entryPeriod;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
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
}

