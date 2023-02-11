package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class answerlist extends AppCompatActivity {
    TextView textView5,textView6,textView7,textView8,textView9,textView10,
            textView11,textView12,textView13,textView14,textView15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerlist);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        textView9=findViewById(R.id.textView9);
        textView10=findViewById(R.id.textView10);
        textView11=findViewById(R.id.textView11);
        textView12=findViewById(R.id.textView12);
        textView13=findViewById(R.id.textView13);
        textView14=findViewById(R.id.textView14);
        textView15=findViewById(R.id.textView15);
    }
}