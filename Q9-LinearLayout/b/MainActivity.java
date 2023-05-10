package com.example.practical9b;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRed;
    private Button btnBlue;
    private Button btnYellow;
    private Button btnReset;
    private ConstraintLayout layoutSuperParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutSuperParent=(ConstraintLayout)findViewById(R.id.layoutSuperParent);
        btnRed=(Button)findViewById(R.id.btnRed);
        btnBlue=(Button)findViewById(R.id.btnBlue);
        btnYellow=(Button)findViewById(R.id.btnYellow);
        btnReset=(Button)findViewById(R.id.btnReset);
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRed:
                layoutSuperParent.setBackgroundColor(Color.RED);
                break;
            case R.id.btnBlue:
                layoutSuperParent.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnYellow:
                layoutSuperParent.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.btnReset:
                layoutSuperParent.setBackgroundColor(Color.TRANSPARENT);
                break;
            default:
                break;
        }
    }
}