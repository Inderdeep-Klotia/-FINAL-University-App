package com.example.budgetapp.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.budgetapp.DataManager.Model.GoalDetail;
import com.example.budgetapp.DataManager.Model.Version;
//import com.example.budgetapp.ViewModel.AccountGroupViewModel;
//import com.example.budgetapp.ViewModel.GoalDetailViewModel;
//import com.example.budgetapp.ViewModel.GoalViewModel;
//import com.example.budgetapp.ViewModel.VersionViewModel;

import java.util.List;

import static com.example.budgetapp.Activities.MainActivity.accountGroupViewModel;
import static com.example.budgetapp.Activities.MainActivity.goalDetailViewModel;
import static com.example.budgetapp.Activities.MainActivity.goalViewModel;
import static com.example.budgetapp.Activities.MainActivity.versionViewModel;


public class CreateVersionDialog extends AppCompatDialogFragment {

//
//    GoalViewModel goalViewModel = new ViewModelProvider(this).get(GoalViewModel.class);
//    GoalDetailViewModel goalDetailViewModel = new ViewModelProvider(this).get(GoalDetailViewModel.class);
//    VersionViewModel versionViewModel = new ViewModelProvider(this).get(VersionViewModel.class);
//    AccountGroupViewModel accountGroupViewModel = new ViewModelProvider(this).get(AccountGroupViewModel.class);
    List<Version> versionList;
    private String TAG;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Saved")
                .setMessage("Your Contents are Saved")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        GoalDetail essentials = new GoalDetail(goalViewModel.getGoal().getId(),
                            accountGroupViewModel.getAccountGroup().getId(),
                            1000,
                            versionViewModel.getVersion().getId());

                    goalDetailViewModel.insertGoalDetail(essentials);

                    //                //GoalViewModel display
                    goalDetailViewModel.getAllGoalDetail().observe(CreateVersionDialog.this, goals -> {
                        Log.d(TAG, "GoalViewModel Observed is WOKRING ");

                        int goals1 = goals.indexOf(0);
                        Log.d(TAG, "goals1: " + goals1);
                        try {

                            for (GoalDetail v : goals) {

                                Log.d(TAG, "goal id= " + v.getId());
                                Log.d(TAG, "goal name= " + v.getGoalID());
                                Log.d(TAG, "goal amount= " + v.getAmount());
                            }
                        } catch (NullPointerException e) {
                            e.getMessage();
                        }



                        Log.d(TAG, "GoalViewModel Observed AFTER PRINTING ");
                    });

                    }

                });
        return builder.create();
    }
}
