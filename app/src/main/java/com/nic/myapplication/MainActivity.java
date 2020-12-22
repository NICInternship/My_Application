package com.nic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView label,value;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.input);
        label=findViewById(R.id.label);
        value=findViewById(R.id.value);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText=input.getText().toString();
                value.setText(inputText);
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("input",inputText);
                startActivity(intent);
            }
        });
    }
}