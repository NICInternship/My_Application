package com.nic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nic.myapplication.demoSqlite.SqliteDemo;
import com.nic.myapplication.fragments.FragmentDemo;
import com.nic.myapplication.layout.LayoutDemo;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Intent intent;
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
        intent=new Intent(MainActivity.this,LayoutDemo.class);
        startActivity(intent);
    }

    public void fragmentNav(View view) {
        intent=new Intent(MainActivity.this, FragmentDemo.class);
        startActivity(intent);
    }

    public void bottomNav(View view) {
    }

    public void dbNav(View view) {
        intent=new Intent(MainActivity.this, SqliteDemo.class);
        startActivity(intent);
    }
}
