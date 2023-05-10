package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    Spinner sp;
    ImageView iw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner) findViewById(R.id.sp);
        iw=(ImageView) findViewById(R.id.iv);
        String[] img={"Select One", "P1", "P2","P3", "P4"};
        ArrayAdapter<String> ad= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, img);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 1:
                        iw.setImageResource(R.drawable.p1);
                        break;
                    case 2:
                        iw.setImageResource(R.drawable.p2);
                        break;
                    case 3:
                        iw.setImageResource(R.drawable.p3);
                        break;
                    case 4:
                        iw.setImageResource(R.drawable.p4);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}