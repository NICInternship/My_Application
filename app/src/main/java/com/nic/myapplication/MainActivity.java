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

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent=getIntent();
        if(intent.hasExtra("input1"))
        {
            Bundle bundle=getIntent().getExtras();
            String receivedStr=bundle.getString("input1");
            value.setText(receivedStr);
        }
        else {
            value.setText("receivedStr");
        }
    }

    public void layoutNav(View view)
    {
        Intent intent=new Intent(MainActivity.this,LayoutDemo.class);
        startActivity(intent);
    }
}
