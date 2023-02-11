package com.example.myquizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quizactivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv1,tv2,textView4;
    Button b1,b2,b3,b4,b5;
    int score=0;
    int p=1;
    int totalquestion =questionandanswer.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        textView4=findViewById(R.id.textView4);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);



        loadnewquestion();
    }
    public void onClick(View view) {
        b1.setBackgroundColor(Color.WHITE);
        b2.setBackgroundColor(Color.WHITE);
        b3.setBackgroundColor(Color.WHITE);
        b4.setBackgroundColor(Color.WHITE);

        Button click=(Button)view;

        if(click.getId()==R.id.b5)

        {
            if(selectedAnswer.equals(questionandanswer.correctAnswers[currentQuestionIndex]))
            {
                score++;
                textView4.setText("SCORE : "+score+"/10");






            }

            currentQuestionIndex++;
            p++;
            loadnewquestion();

        }
        else
        {

            selectedAnswer=click.getText().toString();

                click.setBackgroundColor(Color.YELLOW);

        }


    }





    void loadnewquestion()
    {

        if(currentQuestionIndex==totalquestion)
        {
            finishquiz();
            return;
        }
        tv1.setText("Total Question : "+p +"/10");
        tv2.setText(questionandanswer.question[currentQuestionIndex]);
        b1.setText(questionandanswer.choice[currentQuestionIndex][0]);
        b2.setText(questionandanswer.choice[currentQuestionIndex][1]);
        b3.setText(questionandanswer.choice[currentQuestionIndex][2]);
        b4.setText(questionandanswer.choice[currentQuestionIndex][3]);

    }
    void finishquiz()
    {
        String pass="";
        if(score>totalquestion*0.6)
        {
            pass="Pass";
        }
        else
        {
            pass="Fail";
        }
        AlertDialog.Builder a=new AlertDialog.Builder(quizactivity.this);

        a.setTitle(pass);
        a.setMessage("Your Score out of "+ totalquestion+ " is "+ score)

                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        restartquiz();
                    }
                })

                .setNegativeButton("SHOW CORRECT ANSWERS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(quizactivity.this,answerlist.class));
                    }
                });
        AlertDialog c=a.create();
        c.show();





    }
    void restartquiz()
    {
        score=0;
        p=1;
        currentQuestionIndex=0;
        loadnewquestion();
    }

}