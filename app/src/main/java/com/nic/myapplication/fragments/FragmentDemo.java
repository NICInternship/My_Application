package com.nic.myapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.nic.myapplication.R;

public class FragmentDemo extends AppCompatActivity {

    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        toggleButton=findViewById(R.id.changeFragment);
    }

    public void onClick(View view) {
        if(toggleButton.isChecked())
        {

        }
        else
        {
            
        }
    }
}
