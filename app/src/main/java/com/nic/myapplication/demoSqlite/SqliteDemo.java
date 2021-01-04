package com.nic.myapplication.demoSqlite;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nic.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SqliteDemo extends AppCompatActivity {

    ExpandableListView expandableListView;
    HashMap<String, List<String>> childList;
    List<String> heading;
    CustomAdapter customAdapter;
    DbHelper db;
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

        db=new DbHelper(this);
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

        expandableListView=findViewById(R.id.exp_list_view);
        childList=ExpandableListData.getData(db);
        heading= new ArrayList<>(childList.keySet());
        customAdapter=new CustomAdapter(this,heading,childList);
        expandableListView.setAdapter(customAdapter);
    }

    public void add(View view) {
        date=dialogLayout.findViewById(R.id.date);
        in_time=dialogLayout.findViewById(R.id.in_time);
        out_time=dialogLayout.findViewById(R.id.out_time);
        task=dialogLayout.findViewById(R.id.task);
        remarks=dialogLayout.findViewById(R.id.remarks);
        String dateStr=date.getText().toString();
        String inTimeStr=in_time.getText().toString();
        String outTimeStr=out_time.getText().toString();
        String taskStr=task.getText().toString();
        String remarksStr=remarks.getText().toString();
        boolean res=db.insertData(dateStr,inTimeStr,outTimeStr,taskStr,remarksStr);
        if(res){
            Toast.makeText(SqliteDemo.this,"Inserted Successfully",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(SqliteDemo.this,"Can't Insert",Toast.LENGTH_SHORT).show();
        }
        childList=ExpandableListData.getData(db);
        heading= new ArrayList<>(childList.keySet());
        customAdapter=new CustomAdapter(this,heading,childList);
        expandableListView.setAdapter(customAdapter);
        alertDialog.dismiss();
    }

    public void cancel(View view) {
        Toast.makeText(SqliteDemo.this,"No Data Added",Toast.LENGTH_SHORT).show();
        alertDialog.cancel();
    }
}
