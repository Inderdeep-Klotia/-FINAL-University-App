package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.VersionEntry;

import java.util.List;

public class VersionEntryViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<VersionEntry>> allVersionEntry;


    public VersionEntryViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allVersionEntry = repository.getAllVersionEntry();
    }

    public LiveData<List<VersionEntry>> getAllVersionEntry() {
        return allVersionEntry;
    }

    public void insertVersionEntry(VersionEntry versionEntry) {
        repository.insertVersionEntry(versionEntry);
    }

    public void updateVersionEntry(VersionEntry versionEntry) {
        repository.updateVersionEntry(versionEntry);
    }

    public void deleteVersionEntry(VersionEntry versionEntry) {
        repository.deleteVersionEntry(versionEntry);
    }


}

