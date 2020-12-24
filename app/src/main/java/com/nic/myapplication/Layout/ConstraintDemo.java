package com.nic.myapplication.Layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nic.myapplication.R;

public class ConstraintDemo extends AppCompatActivity {


    RadioGroup radioGroup;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_constraint_demo);
        //radioGroup=findViewById(R.id.radioGroup);
    }

    /*public void clickMe(View view) {
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.editRadio:
            {
                displayMethod(R.id.textEdit);
                break;
            }
            case R.id.passwordRadio:
            {
                displayMethod(R.id.passwordText);
                break;
            }
            case R.id.numPassRadio:
            {
                displayMethod(R.id.numPassText);
                break;
            }
            case R.id.emailRadio:
            {
                displayMethod(R.id.emailText);
                break;
            }
            case R.id.phoneRadio:
            {
                displayMethod(R.id.phoneText);
                break;
            }
            default:
            {
                Toast.makeText(getApplicationContext(),"No Radio Button Clicked",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }*/

    private void displayMethod(int id) {
        input=findViewById(id);
        String text=input.getText().toString();
        if(text.length()!=0)
        {
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No text entered or wrong radio button checked",Toast.LENGTH_SHORT).show();
        }
        input.getText().clear();
    }
}
