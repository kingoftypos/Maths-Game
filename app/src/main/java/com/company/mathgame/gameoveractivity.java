package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameoveractivity extends AppCompatActivity {
TextView scoreview;
Button exitbtn,newbtn;
int score,operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameoveractivity);

        scoreview=findViewById(R.id.score);
        exitbtn=findViewById(R.id.exitbtn);
        newbtn=findViewById(R.id.newgamebtn);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0);
        operation=intent.getIntExtra("operation",1);
        scoreview.setText(""+score);

        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(gameoveractivity.this,Gameactivity.class);
            intent.putExtra("operation",operation);
            startActivity(intent);
            finish();
            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gameoveractivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}