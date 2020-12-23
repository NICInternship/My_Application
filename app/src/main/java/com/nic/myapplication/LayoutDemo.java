package com.nic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LayoutDemo extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);
    }

    public void linearButton(View view)
    {
        intent=new Intent(LayoutDemo.this,LinearDemo.class);
        startActivity(intent);
    }

    public void relativeButton(View view)
    {
        intent=new Intent(LayoutDemo.this,RelativeDemo.class);
        startActivity(intent);
    }

    public void constraintButton(View veiw)
    {
        intent=new Intent(LayoutDemo.this,ConstraintDemo.class);
        startActivity(intent);
    }

    public void tableButton(View view)
    {
        intent=new Intent(LayoutDemo.this,TableDemo.class);
        startActivity(intent);
    }

    public void absoluteButton(View view)
    {
        intent=new Intent(LayoutDemo.this,AbsoluteDemo.class);
        startActivity(intent);
    }

    public void frameButton(View view)
    {
        intent=new Intent(LayoutDemo.this,FrameDemo.class);
        startActivity(intent);
    }

    public void listButton(View view)
    {
        intent=new Intent(LayoutDemo.this,ListDemo.class);
        startActivity(intent);
    }

    public void gridButton(View view)
    {
        intent=new Intent(LayoutDemo.this,GridDemo.class);
        startActivity(intent);
    }
}
