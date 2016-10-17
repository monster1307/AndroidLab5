package com.zimadev.brian.lab5explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
    }

    @Override
    public void finish()
    {
        Intent intent = new Intent();

        intent.putExtra("DATA1", "Dave. I'm afraid I can't do that!");

        setResult(RESULT_OK, intent);

        super.finish();
    }
}
