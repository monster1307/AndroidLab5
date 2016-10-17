package com.zimadev.brian.lab5explicitintents;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityThree extends AppCompatActivity
{
    String tv_result = "nothing";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }

    public void onAct4(View view)
    {
        Intent i = new Intent(this, ActivityFour.class);

        startActivityForResult(i, 0);
    }

    public void onAct5(View view)
    {
        Intent i = new Intent(this, ActivityFive.class);

        startActivityForResult(i, 0);
    }

    /**
     * Lifecycle method called when an activity you launched exits
     *
     * @param request
     *            int originally supplied to startActivityForResult()
     * @param result
     *            int returned by the child activity through its setResult().
     * @param i
     *            Intent can be used to return (extras) result data to caller
     */
    protected void onActivityResult(int request, int result, Intent i)
    {
        String data;
        switch (result)
        {
            case RESULT_OK:
                if (i != null && i.hasExtra("DATA1"))
                {
                    data = i.getExtras().getString("DATA1");
                    Log.d("DATA", data);
                    if (data == null)
                        tv_result = getString(R.string.empty);
                    else
                        tv_result = data;
                }
                else
                {
                    tv_result = "No intent or no extras";
                }
                break;
            case RESULT_CANCELED:
            default:
                tv_result = "Cancel returned from child Activity";
        }
    }

    @Override
    public void finish()
    {
        Intent i = new Intent();
        i.putExtra("DATA1", tv_result);

        setResult(RESULT_OK, i);

        super.finish();
    }
}
