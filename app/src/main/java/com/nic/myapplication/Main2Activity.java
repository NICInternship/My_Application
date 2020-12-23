package com.nic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView receivedText;
    EditText input;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        receivedText=findViewById(R.id.receivedtext);
        input=findViewById(R.id.input);
        back=findViewById(R.id.back);
        Bundle bundle=getIntent().getExtras();
        String receivedStr=bundle.getString("input");
        receivedText.setText(receivedStr);
    }
    public void backFunction(View view)
    {
        String inputStr=input.getText().toString();
        receivedText.setText(inputStr);
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        intent.putExtra("input1",inputStr);
        startActivity(intent);
    }
}
