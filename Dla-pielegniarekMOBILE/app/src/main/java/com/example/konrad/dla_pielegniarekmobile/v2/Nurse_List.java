package com.example.konrad.dla_pielegniarekmobile.v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.example.konrad.dla_pielegniarekmobile.R;



public class Nurse_List extends AppCompatActivity {
    Button btn1;
    public static TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse__list);
        btn1 = (Button)findViewById(R.id.button1);
        text1 = (TextView) findViewById(R.id.textview1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData process = new fetchData();
                process.execute();

            }
        });
    }
}
