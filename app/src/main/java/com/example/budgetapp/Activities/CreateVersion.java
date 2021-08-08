package com.example.budgetapp.Activities;

import android.accounts.Account;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.budgetapp.DataManager.Model.AccountGroup;
import com.example.budgetapp.DataManager.Model.AccountType;
import com.example.budgetapp.DataManager.Model.Goal;
import com.example.budgetapp.DataManager.Model.GoalDetail;
import com.example.budgetapp.DataManager.Model.Version;
import com.example.budgetapp.DataManager.Model.VersionEntry;
import com.example.budgetapp.R;
import com.example.budgetapp.ViewModel.AccountGroupViewModel;
import com.example.budgetapp.ViewModel.GoalDetailViewModel;
import com.example.budgetapp.ViewModel.GoalViewModel;
import com.example.budgetapp.ViewModel.VersionViewModel;
import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;

public class CreateVersion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //TEST TO GIT

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private EditText versionNameEntry;
    private EditText estimateIncomeEntry;
    private EditText estimateExpensesEntry;
    
    private TextView remainingBalance;
    private TextView essentialsEntry;
    private TextView nonessentialsEntry;
    private TextView savingsEntry;

    private SeekBar essentialsBar;
    private SeekBar nonessentialsBar;
    private SeekBar savingsBar;

    private Button saveButton;

    private String versionName;
    private Double estimateIncome= 0.0;
    private Double estimateExpenses;
    private Double essentialsVal = 0.0;
    private Double nonessentialsVal = 0.0;
    private Double savingsVal = 0.0;
    private Double essentialsValStart;
    private Double nonessentialsValStart;
    private Double savingsValStart;
    private Double balance = 0.0;
    private String TAG;


    GoalViewModel goalViewModel;
    GoalDetailViewModel goalDetailViewModel;
    VersionViewModel versionViewModel;
    AccountGroupViewModel accountGroupViewModel;
    List<Version> versionList;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_version);

        //DATABASE: VIEW MODELS
        goalViewModel = new ViewModelProvider(this).get(GoalViewModel.class);
        goalDetailViewModel = new ViewModelProvider(this).get(GoalDetailViewModel.class);
        versionViewModel = new ViewModelProvider(this).get(VersionViewModel.class);
        accountGroupViewModel = new ViewModelProvider(this).get(AccountGroupViewModel.class);

        versionList = new ArrayList<>();

        //SIDEBAR MENU
        toolbar = findViewById(R.id.create_version_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.create_version_drawer_layout);
        navigationView = findViewById(R.id.create_version_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setActionBar("Create Version");

        //Buttons and choices
        versionNameEntry = (EditText) findViewById(R.id.create_version_response1);
        estimateIncomeEntry = (EditText) findViewById(R.id.create_version_response2);
        estimateExpensesEntry = (EditText) findViewById(R.id.create_version_response3);

        remainingBalance = (TextView) findViewById(R.id.create_version_remaining_entry);
        essentialsEntry = (TextView) findViewById(R.id.create_version_essentials_amt);
        nonessentialsEntry = (TextView) findViewById(R.id.create_version_nonessentials_amt);
        savingsEntry = (TextView) findViewById(R.id.create_version_savings_amt);

        essentialsBar = (SeekBar) findViewById(R.id.create_version_seekBar_essentials);
        nonessentialsBar = (SeekBar) findViewById(R.id.create_version_seekBar_nonessentials);
        savingsBar = (SeekBar) findViewById(R.id.create_version_seekBar_savings);

        saveButton = (Button) findViewById(R.id.create_version_save_changes);


        //SETTING UP LISTENERS
        //entryTextWatcher controls the listening of all the three entries.

        TextWatcher entryTextWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String enteredIncome = estimateIncomeEntry.getText().toString();
                String enteredExpense = estimateExpensesEntry.getText().toString();
                String enteredVName = versionNameEntry.getText().toString();

                saveButton.setEnabled(!enteredVName.isEmpty() && !enteredIncome.isEmpty()
                        && !enteredExpense.isEmpty());

                try {
                    versionName = enteredVName;
                    //debugging
                    //Toast.makeText(CreateVersion.this, versionName, Toast.LENGTH_SHORT).show();
                } catch (IllegalFormatException ex) {
                    versionNameEntry.setText("");
                    versionName = "";
                }

                try {
                    Double val = Double.parseDouble(enteredIncome);
                    estimateIncome = val;
                    balance = val;
                    Double fifty = val * 0.50;
                    Double thirty = val * 0.30;
                    Double twenty = val * 0.20;


                    String a = String.format("%.2f", fifty);
                    essentialsEntry.setText("$");
                    essentialsEntry.append(a);
                    essentialsValStart = fifty;
                    essentialsVal = essentialsValStart;


                    String b = String.format("%.2f", thirty);
                    nonessentialsEntry.setText("$");
                    nonessentialsEntry.append(b);
                    nonessentialsValStart = thirty;
                    nonessentialsVal = nonessentialsValStart;


                    String c = String.format("%.2f", twenty);
                    savingsEntry.setText("$");
                    savingsEntry.append(c);
                    savingsValStart = twenty;
                    savingsVal = savingsValStart;


                    essentialsBar.setProgress(50, true);
                    nonessentialsBar.setProgress(30, true);
                    savingsBar.setProgress(20, true);


                } catch (NumberFormatException e) {
                    essentialsEntry.setText("$0");
                    nonessentialsEntry.setText("$0");
                    savingsEntry.setText("$0");
                }

                try {
                    Double val = Double.parseDouble(enteredExpense);

                    estimateExpenses = val;
                } catch (NumberFormatException e) {
                    nonessentialsEntry.setText("$0");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        estimateIncomeEntry.addTextChangedListener(entryTextWatcher);
        estimateExpensesEntry.addTextChangedListener(entryTextWatcher);
        versionNameEntry.addTextChangedListener(entryTextWatcher);

        //Scrollbar changing values
        //essentials bar
        essentialsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Double half = (i*(estimateIncome/100.0));
                Double val = (i * (estimateIncome / 100.0));

                //Toast.makeText(CreateVersion.this, val.toString(), Toast.LENGTH_SHORT).show();
                essentialsEntry.setText("$");
                essentialsEntry.append(val.toString());
                essentialsVal = val;
                Log.d(TAG, "essentialsVal: " + essentialsVal);
                //Toast.makeText(CreateVersion.this, essentialsVal.toString(), Toast.LENGTH_SHORT).show();

                //balance = essentialsVal;
                balance = estimateIncome - essentialsVal - nonessentialsVal - savingsVal;
                Log.d(TAG, "balance: " + balance);


                // Log.d(TAG, "Balance at last try: " + balance);
                remainingBalance.setText("$");
                remainingBalance.append(balance.toString());
                if (balance < 0) {
                    remainingBalance.setTextColor(Color.RED);
                } else {
                    remainingBalance.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

        //nonessentials bar
        nonessentialsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Double val = (i * (estimateIncome / 100.0));
                //Toast.makeText(CreateVersion.this, val.toString(), Toast.LENGTH_SHORT).show();
                nonessentialsEntry.setText("$");
                nonessentialsEntry.append(val.toString());
                nonessentialsVal = val;
                Log.d(TAG, "nonessentialsVal: " + nonessentialsVal);
                //Toast.makeText(CreateVersion.this, nonessentialsVal.toString(), Toast.LENGTH_SHORT).show();

                balance = estimateIncome - essentialsVal - nonessentialsVal - savingsVal;

                Log.d(TAG, "balance: " + balance);


                remainingBalance.setText("$");
                remainingBalance.append(balance.toString());
                if (balance < 0) {
                    remainingBalance.setTextColor(Color.RED);
                } else {
                    remainingBalance.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //savings bar
        savingsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Double val = (i * (estimateIncome / 100.0));
                //Toast.makeText(CreateVersion.this, val.toString(), Toast.LENGTH_SHORT).show();
                savingsEntry.setText("$");
                savingsEntry.append(val.toString());
                savingsVal = val;
                Log.d(TAG, "nonessentialsVal: " + nonessentialsVal);

                balance = estimateIncome - essentialsVal - nonessentialsVal - savingsVal;
                Log.d(TAG, "balance: " + balance);


                // Log.d(TAG, "Balance at last try: " + balance);
                remainingBalance.setText("$");
                remainingBalance.append(balance.toString());
                if (balance < 0) {
                    remainingBalance.setTextColor(Color.RED);
                } else {
                    remainingBalance.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Goal goal = new Goal(versionName);

                AccountGroup accGroup = new AccountGroup(versionName);

                Version version = new Version(versionName);

                //AccountType accType = new AccountType(accGroup.getAccountGroupName(), accGroup.getId(), "")

                //VersionViewModel
                versionViewModel.insertVersion(version);

                //GoalViewModel
                goalViewModel.insertGoal(goal);

                //AccountGroupViewModel
                accountGroupViewModel.insertAccountGroup(accGroup);

                Log.d(TAG, "goal.getId(): " + goal.getId());
                Log.d(TAG, "accGroup.getId() " + accGroup.getId());
                Log.d(TAG, "version.getId() " + version.getId());

                //GoalDetail
                GoalDetail essentials = new GoalDetail(goal.getId(), accGroup.getId(), essentialsVal, version.getId());
                GoalDetail nonessentials = new GoalDetail(goal.getId(), accGroup.getId(), nonessentialsVal, version.getId());
                GoalDetail savings = new GoalDetail(goal.getId(), accGroup.getId(), savingsVal, version.getId());

                if(essentials==null){
                    Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
                }

                Log.d(TAG, "onClick: AFTER CREATING GOAL DETAIL");
                goalDetailViewModel.insertGoalDetail(essentials);
                goalDetailViewModel.insertGoalDetail(nonessentials);
                goalDetailViewModel.insertGoalDetail(savings);

                Log.d(TAG, "onClick: AFTER INSERTING GOAL DETAIL");


                //VersionViewModel display
                versionViewModel.getAllVersion().observe(CreateVersion.this, versions -> {
                    Log.d(TAG, "VeersionViewModel Observed is WOKRING ");

                   // int version1 = versions.indexOf(0);
                   // Log.d(TAG, "version1: " + version1);
                    try {

                        for (Version v : versions) {
                            Log.d(TAG, "version id= " + v.getId());
                            Log.d(TAG, "version name= " + v.getVersionName());
                        }
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }

                    Log.d(TAG, "versionViewModel Observed AFTER PRINTING ");
                });

                //GoalViewModel display
                goalViewModel.getAllGoal().observe(CreateVersion.this, goals -> {
                    Log.d(TAG, "GoalViewModel Observed is WOKRING ");

                    //int goals1 = goals.indexOf(0);
                   // Log.d(TAG, "goals1: " + goals1);
                    try {

                        for (Goal v : goals) {
                            Log.d(TAG, "goal id= " + v.getId());
                            Log.d(TAG, "goal name= " + v.getGoalName());
                        }
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }

                    Log.d(TAG, "GoalViewModel Observed AFTER PRINTING ");
                });

                //AccountGroupViewModel display
                accountGroupViewModel.getAllAccountGroup().observe(CreateVersion.this, accgroup -> {
                    Log.d(TAG, "AccountGroupViewModel Observed is WOKRING ");

                    //int accgroup1 = accgroup.indexOf(0);
                    //Log.d(TAG, "accgroup1: " + accgroup1);
                    try {

                        for (AccountGroup v : accgroup) {
                            Log.d(TAG, "acc group id= " + v.getId());
                            Log.d(TAG, "acc group name= " + v.getAccountGroupName());
                        }
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }

                    Log.d(TAG, "accountGroupViewModel Observed AFTER PRINTING ");
                });


            }
        });

    }
    public void setActionBar(String heading){
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.outline_menu_white_48);
        //actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        actionBar.setTitle(heading);
        actionBar.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
