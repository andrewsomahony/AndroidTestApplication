package com.example.andrew.testapplication.activities;

import android.app.ActionBar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.andrew.testapplication.R;

import fragments.WeatherFragment;

public final class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        _title = "Main";

        super.onCreate(savedInstanceState);

        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome to Andrew's app!");

        WeatherFragment weatherFragment = new WeatherFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.weatherFragmentContainer, weatherFragment);
        transaction.commit();
    }
}
