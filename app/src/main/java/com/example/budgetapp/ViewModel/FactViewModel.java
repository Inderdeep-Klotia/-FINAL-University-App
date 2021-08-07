package com.example.budgetapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.budgetapp.DataManager.Database.Repository;
import com.example.budgetapp.DataManager.Model.Fact;

import java.util.List;

public class FactViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Fact>> allFact;


    public FactViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.allFact = repository.getAllFact();
    }

    public LiveData<List<Fact>> getAllFact() {
        return allFact;
    }

    public void insertFact(Fact fact) {
        repository.insertFact(fact);
    }

    public void updateFact(Fact fact) {
        repository.updateFact(fact);
    }

    public void deleteFact(Fact fact) {
        repository.deleteFact(fact);
    }


}

