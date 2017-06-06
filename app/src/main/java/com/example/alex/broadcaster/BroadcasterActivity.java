/**
 * BroadcasterActivity.java
 * Homework #4
 * Alex Chochia
 * Purpose: to send and receive brodcasts while managing the view
 */

package com.example.alex.broadcaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

// **************BroadcasterActivity******************
public class BroadcasterActivity extends AppCompatActivity
{
    public static BroadcasterActivity ba;
    public static String BROADCAST_STRING = "android.intent.action.TEST";

// ***************ReceiveBroadcast*****************
    public static class ReceiveBroadcast extends BroadcastReceiver
    {
        @Override
        // *************onReceive()*********************
        public void onReceive(Context con, Intent in)
        {
            String actionName = in.getAction();
            if(actionName != null && actionName.equals(BROADCAST_STRING))
            {
                String message = in.getStringExtra("start_text");
                ba.setText(message);
            }
        }
    }

    @Override
    // ************onCreate()***************************
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcaster);
        ba = this;
    }

    // *****************pushButton()***********************
    public void pushButton(View v)
    {
        Intent in = new Intent();
        in.putExtra("start_text", ((EditText) findViewById(R.id.start_text)).getText().toString());

        in.setAction(BROADCAST_STRING);
        sendBroadcast(in);
    }

    // *******************setText()********************
    public void setText(String s)
    {
        ((EditText) findViewById(R.id.receive_text)).setText((s != null) ? s : "it is null");
    }
}
