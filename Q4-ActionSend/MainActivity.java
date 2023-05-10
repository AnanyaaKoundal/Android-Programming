package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    EditText edt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=(EditText) findViewById(R.id.edit_txt);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                String st=edt.getText().toString();
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,st);
                startActivity(i.createChooser(i,"Share"));
            }
        });
    }
}