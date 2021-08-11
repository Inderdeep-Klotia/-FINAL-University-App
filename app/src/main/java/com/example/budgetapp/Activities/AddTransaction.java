package com.example.budgetapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.budgetapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.IllegalFormatException;

public class AddTransaction extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String TAG;

    private EditText transactionType;
    private EditText transactionDate;
    private EditText transactionName;
    private EditText transactionDescription;
    private EditText transactionAmount;

    private String type;
    private String date;
    private String name;
    private String description;
    private Double amount;
    
    private Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        //INITIALIZING BUTTONS AND EDIT TEXTS
        transactionType = (EditText) findViewById(R.id.add_transaction_type_entry);
        transactionDate = (EditText) findViewById(R.id.add_transaction_date_entry);
        transactionName = (EditText) findViewById(R.id.add_transaction_name_entry);
        transactionDescription = (EditText) findViewById(R.id.add_transaction_description_entry);
        transactionAmount = (EditText) findViewById(R.id.add_transaction_amount_entry);

        saveButton = (Button) findViewById(R.id.add_transaction_save_button);

        //SIDEBAR MENU
        toolbar = findViewById(R.id.add_transaction_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.add_transaction_drawer_layout);
        navigationView = findViewById(R.id.add_transaction_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        setActionBar("Add Transaction");

        //REMOVING TEXT WHEN CLICKED
        transactionType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionType.setText("");
            }
        });
        transactionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionDate.setText("");
            }
        });
        transactionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionName.setText("");
            }
        });
        transactionDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionDescription.setText("");
            }
        });
        transactionAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transactionAmount.setText("");
            }
        });

        //SETING UP TEXT WATCHER LISTENER FOR ENTRIES
        TextWatcher entryTextWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                type = transactionType.getText().toString();
                date = transactionDate.getText().toString();
                name = transactionName.getText().toString();
                description = transactionDescription.getText().toString();
                String amtEntry = transactionAmount.getText().toString();

                amount = Double.parseDouble(amtEntry);

                saveButton.setEnabled(!type.isEmpty() && !date.isEmpty()
                        && !name.isEmpty() && description.isEmpty() && amtEntry.isEmpty());

                Log.d(TAG, "type = " + type);
                Log.d(TAG, "date = " + date);
                Log.d(TAG, "name = " + name);
                Log.d(TAG, "description = " + description);
                Log.d(TAG, "amount = " + amount);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    //DIALOG BOX CODE
    public void openDialog(){
        CreateVersionDialog createVersionDialog = new CreateVersionDialog();
        createVersionDialog.show(getSupportFragmentManager(), "saved dialog box");
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

        switch(item.getItemId()){
            case R.id.create_new_version_nav: {
                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, CreateVersion.class);
                startActivity(intent);
                break;
            }
            case R.id.modify_version_nav: {
                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ModifyVersion.class);
                startActivity(intent);
                break;
            }
            case R.id.add_transaction_nav: {
                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AddTransaction.class);
                startActivity(intent);
                break;
            }
//            case R.id.modify_transaction_nav: {
//                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, ModifyTransaction.class);
//                startActivity(intent);
//                break;
//            }
            case R.id.dashboard_nav: {
                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.view_version_nav: {
                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ViewVersion.class);
                startActivity(intent);
                break;
            }
//            case R.id.view_transaction_nav: {
//                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, ViewTransaction.class);
//                startActivity(intent);
//                break;
//            }case R.id.view_goals_nav: {
//                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, ViewGoals.class);
//                startActivity(intent);
//                break;
//            }case R.id.strategies_nav: {
//                //Toast.makeText(this, "create_version is pressed", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, Introduction.class);
//                startActivity(intent);
//                break;
//            }

        }
        return true;


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
