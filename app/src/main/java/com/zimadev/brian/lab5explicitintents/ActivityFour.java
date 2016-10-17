package com.zimadev.brian.lab5explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityFour extends AppCompatActivity
{
    boolean returnHit = false;

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        et = (EditText)findViewById(R.id.et);
    }

    public void onReturn(View view)
    {
        String result = et.getText().toString();

        if (!result.isEmpty())
        {
            Intent intent = new Intent();

            intent.putExtra("DATA1", result);

            setResult(RESULT_OK, intent);

            returnHit = true;

            finish();
        }
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
