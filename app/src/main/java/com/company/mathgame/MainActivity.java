package com.company.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnadd,btnsub,btnmul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd=findViewById(R.id.btnaddition);
        btnsub=findViewById(R.id.btnsubtraction);
        btnmul=findViewById(R.id.btnmultiplication);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Gameactivity.class);
                intent.putExtra("operation",1);
                startActivity(intent);

            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Gameactivity.class);
                intent.putExtra("operation",2);
                startActivity(intent);
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Gameactivity.class);
                intent.putExtra("operation",3);
                startActivity(intent);
            }
        });

    }
}