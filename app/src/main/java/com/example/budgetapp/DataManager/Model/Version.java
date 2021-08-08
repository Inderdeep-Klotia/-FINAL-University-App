package com.example.budgetapp.DataManager.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Transaction
@Entity
public class Version {
    @PrimaryKey (autoGenerate = true)
    int id;
    String versionName;

    public Version()
    { this.versionName = "test"; }

    public Version(String versionName) {
        this.versionName = versionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
