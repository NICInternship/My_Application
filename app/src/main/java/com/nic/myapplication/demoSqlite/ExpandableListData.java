package com.nic.myapplication.demoSqlite;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ExpandableListData {

    static HashMap<String, List<String>> getData(DbHelper db) {
        HashMap<String ,List<String >> expListDetail= new HashMap<>();
        Cursor cursor=db.getAllData();
        int count=cursor.getCount();
        if(count==0){
            List<String>list= new ArrayList<>();
            list.add("No data to display");
            expListDetail.put("Empty List",list);
        }
        else{
            cursor.moveToFirst();
            List<String>outerList= new ArrayList<>();
            outerList.add("In: "+cursor.getString(2));
            outerList.add("Out: "+cursor.getString(3));
            outerList.add("Task: "+cursor.getString(4));
            outerList.add("Remarks: "+cursor.getString(5));
            expListDetail.put(cursor.getString(1),outerList);
            while (cursor.moveToNext()){
                List<String>list= new ArrayList<>();
                list.add("In: "+cursor.getString(2));
                list.add("Out: "+cursor.getString(3));
                list.add("Task: "+cursor.getString(4));
                list.add("Remarks: "+cursor.getString(5));
                expListDetail.put(cursor.getString(1),list);
            }
        }
        return expListDetail;
    }
}
