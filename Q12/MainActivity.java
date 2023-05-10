package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    EditText name, age, ph;
    Button i, d, u, s;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.name);
        age=(EditText) findViewById(R.id.age);
        ph=(EditText) findViewById(R.id.ph);
        i=(Button) findViewById(R.id.insertbtn);
        d=(Button) findViewById(R.id.deletebtn);
        u=(Button) findViewById(R.id.updatebtn);
        s=(Button) findViewById(R.id.showbtn);
        db= new DBhelper(this);
        i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String a=age.getText().toString();
                String p=ph.getText().toString();
                Boolean chk=db.insertdata(n,a,p);

                if(chk){
                    Toast.makeText(MainActivity.this, "New Record Inserted", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "New Record not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                boolean chk=db.deletedata(n);
                if(chk){
                    Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        u.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String a=age.getText().toString();
                String p=ph.getText().toString();
                boolean chk=db.updatedata(n,a,p);
                if(chk){
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        s.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db.showdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this,"No record inserted", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer bf= new StringBuffer();
                while (res.moveToNext()){
                    bf.append("Name: "+res.getString(0)+"\n");
                    bf.append("Age: "+res.getString(1)+"\n");
                    bf.append(("Mobile: "+res.getString(2)+"\n\n"));
                }
                AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                build.setCancelable(true);
                build.setTitle("Entries");
                build.setMessage(bf.toString());
                build.show();
            }
        });
    }
}