package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//semester long info
@Entity
public class Fact {
    @PrimaryKey (autoGenerate = true)
    int id;
    int versionID;
    int accountGroupID;
    int accountTypeID;
    double p1;  //semesters
    double p2;  //semesters
    double p3;  //semesters
    double p4;  //semesters
    double totalSemester; //semesters

    public Fact(int versionID, int accountGroupID, int accountTypeID, double p1, double p2, double p3, double p4, double totalSemester) {
        this.versionID = versionID;
        this.accountGroupID = accountGroupID;
        this.accountTypeID = accountTypeID;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.totalSemester = totalSemester;
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

    public int getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(int accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getP4() {
        return p4;
    }

    public void setP4(double p4) {
        this.p4 = p4;
    }

    public double getTotalSemester() {
        return totalSemester;
    }

    public void setTotalSemester(double ts) {
        this.totalSemester = ts;
    }
}

