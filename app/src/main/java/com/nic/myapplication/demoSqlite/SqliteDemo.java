package com.nic.myapplication.demoSqlite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nic.myapplication.R;

public class SqliteDemo extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    LayoutInflater inflater;
    View dialogLayout;
    EditText date,in_time,out_time,task,remarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

        floatingActionButton=findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inflater = getLayoutInflater();
                dialogLayout = inflater.inflate(R.layout.activity_input_dialog, null);
                builder = new AlertDialog.Builder(SqliteDemo.this);
                builder.setTitle(R.string.add_data);
                builder.setView(dialogLayout);
                alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }

    public void add(View view) {
        date=dialogLayout.findViewById(R.id.date);
        in_time=dialogLayout.findViewById(R.id.in_time);
        out_time=dialogLayout.findViewById(R.id.out_time);
        task=dialogLayout.findViewById(R.id.task);
        remarks=dialogLayout.findViewById(R.id.remarks);
        //Toast.makeText(SqliteDemo.this,date.getText().toString()+in_time.getText().toString()+out_time.getText().toString()+task.getText().toString()+remarks.getText().toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(SqliteDemo.this,"Inserted Successfully",Toast.LENGTH_SHORT).show();
        alertDialog.dismiss();
    }

    public void cancel(View view) {
        Toast.makeText(SqliteDemo.this,"No Data Added",Toast.LENGTH_SHORT).show();
        alertDialog.cancel();
    }
}
