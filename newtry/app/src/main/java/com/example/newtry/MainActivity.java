package com.example.newtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button time;
    private Button calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = (Button) findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTime();
            }
        });
        calculator = (Button) findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencalculator();
            }
        });
    }
    public void openTime(){
        Intent intent = new Intent(this, Time.class);
        startActivity(intent);
    }

    public void opencalculator(){
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

}
