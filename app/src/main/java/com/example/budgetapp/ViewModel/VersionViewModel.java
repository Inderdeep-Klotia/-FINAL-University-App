package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.AccountGroup;
import com.example.budgetapp.DataManager.Model.Version;


import java.util.List;

public class VersionViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Version>> allVersion;


    public VersionViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allVersion = repository.getAllVersion();
    }

    public LiveData<List<Version>> getAllVersion() {
        return allVersion;
    }

    public void insertVersion(Version version) {
        repository.insertVersion(version);
    }

    public void updateVersion(Version version) {
        repository.updateVersion(version);
    }

    public void deleteVersion(Version version) {
        repository.deleteVersion(version);
    }

    public Version getVersion(){
        Version version = (Version) allVersion.getValue();
        return version;
    }


}


