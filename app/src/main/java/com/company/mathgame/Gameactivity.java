package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;

public class Gameactivity extends AppCompatActivity {
TextView live,score,time,question;
EditText answer;
Button check,next;
Random random=new Random();
int num1,num2,realans,userans,userscore=0,userlives=3,second;
CountDownTimer timer;
private static final long START_TIMER_IN_MILLIS= 20000;
Boolean timer_running;
long time_left_in_millis=START_TIMER_IN_MILLIS;
Intent intop;
int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);

        score=findViewById(R.id.textview2);

       live=findViewById(R.id.textview4);

        time=findViewById(R.id.textview6);
       question =findViewById(R.id.textviewquestion);
       answer =findViewById(R.id.editextanswer);
       check =findViewById(R.id.checkbtn);
        next=findViewById(R.id.nextbtn);
         intop=getIntent();
        operation=intop.getIntExtra("operation",1);
        gamecontinue();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    userans=Integer.valueOf(answer.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    question.setText("invalid input");
                    return;
                }
                pauseTimer();

                if(realans==userans&& second!=0)
                {
                  userscore=userscore+10;
                  score.setText(""+userscore);
                  question.setText("Congrats! you have entered the right answer");

                }
                else if(realans!=userans)
                {
                    userlives=userlives-1;
                    live.setText(""+userlives);
                    question.setText("Sorry! you have entered the wrong answer");
                }
                else
                {

                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                answer.setText("");
                resetTimer();

                if(userlives==0)
                {
                    Intent intent=new Intent(Gameactivity.this,gameoveractivity.class);
                    intent.putExtra("score",userscore);
                    intent.putExtra("operation",operation);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    gamecontinue();
                }


            }
        });
    }

    public void gamecontinue()
    {
        num1=random.nextInt(100);
        num2=random.nextInt(100);
        if(operation==1)
        {
            question.setText(num1 +" + " +num2);
            realans=num1+num2;
        }
        else if (operation==2)
        {
            question.setText(num1 +" - " +num2);
            realans=num1-num2;
        }
        else if(operation==3)
        {
            question.setText(num1 +" * " +num2);
            realans=num1*num2;
        }

        starttimer();

    }
    public void starttimer()
    {

        timer =new CountDownTimer(time_left_in_millis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_in_millis=millisUntilFinished;
                updateText();

            }

            @Override
            public void onFinish() {
             timer_running=false;
             pauseTimer();
             updateText();
             userlives=userlives-1;
             question.setText("Sorry! Time is up");
             live.setText(""+userlives);
            }
        }.start();

        timer_running=true;
    }
    public void updateText()
    {
         second =(int)(time_left_in_millis/1000) % 60;
        String time_left= String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);

    }
    public void pauseTimer()
    {
        timer.cancel();
        timer_running=false;
    }
    public void resetTimer()
    {
        time_left_in_millis=START_TIMER_IN_MILLIS;
        updateText();
    }


}