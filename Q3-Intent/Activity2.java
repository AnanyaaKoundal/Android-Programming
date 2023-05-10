package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tv=findViewById(R.id.txtv);
        String st= getIntent().getExtras().getString("Value");
        tv.setText(st);
    }
}
