package com.nic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nic.myapplication.layout.LayoutDemo;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView label,value;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.input);
    }



    public void layoutNav(View view)
    {
        Intent intent=new Intent(MainActivity.this,LayoutDemo.class);
        startActivity(intent);
    }

    public void fragmentNav(View view) {
    }

    public void bottomNav(View view) {
    }

    public void dbNav(View view) {
    }
}
