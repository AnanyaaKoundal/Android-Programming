package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.edt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        et.setText(item.getTitle().toString().toUpperCase());
        return true;
    }
}