package com.nic.myapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.nic.myapplication.R;

public class FragmentDemo extends AppCompatActivity {

    ToggleButton toggleButton;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        toggleButton=findViewById(R.id.changeFragment);
    }

    public void onClick(View view) {
        if(!toggleButton.isChecked())
        {
            fragment=new FragmentOne();
            loadFragment(fragment);
        }
        else
        {
            fragment=new FragmentTwo();
            loadFragment(fragment);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }
}
