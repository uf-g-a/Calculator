package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class Activity2 extends AppCompatActivity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                     Thread.sleep(1000);
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             TextView tdate = (TextView) findViewById(R.id.date);
                             long date = System.currentTimeMillis();
                             SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nhh-mm-ss");
                             String dateString = sdf.format(date);
                             tdate.setText(dateString);
                         }
                     });
                    }
                }catch (InterruptedException e) {
                }

            }
        };
        t.start();
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity3() {
        Intent intent3 = new Intent( this, Activity3.class);
        startActivity(intent3);
    }

}
