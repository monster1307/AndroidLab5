package com.zimadev.brian.lab5explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityTwo extends AppCompatActivity
{
    boolean returnHit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void sendMessage1(View view)
    {
        Intent intent = new Intent();

        intent.putExtra("DATA1", "Activity 2: One, 1, uno, un/une");

        setResult(RESULT_OK, intent);

        returnHit = true;

        finish();
    }

    public void sendMessage2(View view)
    {
        Intent intent = new Intent();

        intent.putExtra("DATA1", "Activity 2: Two, 2 , due, deux");

        setResult(RESULT_OK, intent);

        returnHit = true;

        finish();
    }

    @Override
    public void finish()
    {
        if (!returnHit) {
            Intent i = new Intent();
            i.putExtra("DATA1", "Data dropped, back button was hit!");
            setResult(RESULT_CANCELED, i);
        }
        super.finish();
    }
}
