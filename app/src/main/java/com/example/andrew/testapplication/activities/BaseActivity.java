package com.example.andrew.testapplication.activities;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.andrew.testapplication.R;

import utils.AOMMetadata;

/**
 * Created by andrew on 5/21/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Bundle _metadata;
    protected String _title = "";

    private static String mainLayoutKey = "main_layout";

    private Object getMetadataValue(String key) {
        return _metadata.get(key);
    }

    private int getMainLayoutID() {
        Object layoutID = getMetadataValue(BaseActivity.mainLayoutKey);

        assert(null != layoutID);

        return (int)layoutID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _metadata = AOMMetadata.getActivityMetadata(this);

        assert(null != _metadata);

        setContentView(getMainLayoutID());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(_title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_main, menu);
        return true;
    }
}
