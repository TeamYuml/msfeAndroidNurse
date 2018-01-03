package com.example.konrad.dla_pielegniarekmobile;

import android.content.Intent;
import android.os.ConditionVariable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.konrad.dla_pielegniarekmobile.v2.Nurse_List;

public class Wejscie extends AppCompatActivity {

    LinearLayout glowny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wejscie);
       glowny = (LinearLayout)findViewById(R.id.glowny_lay);
       glowny.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Wejscie.this,Menager_Nurse_List.class);
               startActivity(intent);
               finish();
           }
       });
    }
}
