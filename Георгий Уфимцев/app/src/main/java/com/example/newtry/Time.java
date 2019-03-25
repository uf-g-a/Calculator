package com.example.newtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Time extends AppCompatActivity {
    private Button calculator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Thread t = new Thread()
        {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.date);
                                long date =System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy\nhh-mm-ss");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e){ }
            }

        };
        t.start();
        calculator2 = (Button) findViewById(R.id.calculator2);
        calculator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencalculator2();
            }
        });
    }
    public void opencalculator2(){
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
}
