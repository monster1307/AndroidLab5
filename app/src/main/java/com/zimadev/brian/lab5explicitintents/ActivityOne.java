package com.zimadev.brian.lab5explicitintents;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity
{
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onw);

        tv_result = (TextView)findViewById(R.id.act1Result);
    }

    public void act2(View view)
    {
        Intent i = new Intent(this, ActivityTwo.class);

        // request code = 0, only one activity used
        startActivityForResult(i, 0);
    }

    public void act3(View view)
    {
        Intent i = new Intent(this, ActivityThree.class);

        // request code = 0, only one activity used
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
                logIt("result ok");
                if (i != null && i.hasExtra("DATA1"))
                {
                    data = i.getExtras().getString("DATA1");
                    Log.d("DATA", data);
                    if (data == null)
                        tv_result.setText(R.string.empty);
                    else
                        tv_result.setText(data);
                }
                else
                {
                    tv_result.setText("No intent or no extras");
                }
                tv_result.setTextColor(Color.MAGENTA);
                break;
            case RESULT_CANCELED:
            default:
                logIt("result canceled");
                tv_result.setText("Cancel returned from child Activity");
                tv_result.setTextColor(Color.RED);
        }
        tv_result.setVisibility(View.VISIBLE);
    } // onActivityResult()

    /**
     * Simple wrapper method for Log.d()
     *
     * @param msg
     *            string to be logged
     */
    public static void logIt(String msg)
    {
        final String TAG = "INTDATA1";
        Log.d(TAG, msg);
    }

    public void browser(View view)
    {
        String url = "https://www.zimadev.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void geo(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0.0?q=Fermont"));

        startActivity(i);
    }
}
