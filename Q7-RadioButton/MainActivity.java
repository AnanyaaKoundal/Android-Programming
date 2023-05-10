package com.example.practical7;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    private RadioGroup rgCourses;
    private HashMap<String, String> coursesMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Courses();
    }
    private void Courses(){
        rgCourses=(RadioGroup)findViewById(R.id.courses);
        if (coursesMap==null){
            coursesMap=new HashMap<>();
            coursesMap.put("BSc(H) Computer Science"," Dr.V.S.Dixit");
            coursesMap.put("BSc (H) Electronics"," Prof. Jyotika Jogi");
            coursesMap.put("BSc (H) Physics"," Dr.Pinki Dudreja");
            for (String course : coursesMap.keySet()){
                RadioButton rButton=new RadioButton(MainActivity.this);
                rButton.setText(course);
                rgCourses.addView(rButton);
            }
            rgCourses.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int checkedRadioButtonId=rgCourses.getCheckedRadioButtonId();
                    RadioButton rButton=(RadioButton) findViewById(checkedRadioButtonId);

                    Snackbar.make(rgCourses,coursesMap.get(rButton.getText()),Snackbar.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }
}