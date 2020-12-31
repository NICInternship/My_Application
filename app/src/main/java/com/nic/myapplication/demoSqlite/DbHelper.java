package com.nic.myapplication.demoSqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;

class DbHelper extends SQLiteOpenHelper {

    private final static String dbName="Internship.db";
    private final static String tabName="log";
    private final static String col1="ID";
    private final static String col2="DATE";
    private final static String col3="IN_TIME";
    private final static String col4="OUT_TIME";
    private final static String col5="TASK";
    private final static String col6="REMARKS";

    DbHelper(Context context) {

        super(context,dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + tabName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,  DATE TEXT, IN_TIME TEXT, OUT_TIME TEXT, TASK TEXT, REMARKS TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    boolean insertData(String dateStr, String inTimeStr, String outTimeStr, String taskStr, String remarksStr) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(col2,dateStr);
        cv.put(col3,inTimeStr);
        cv.put(col4,outTimeStr);
        cv.put(col5,taskStr);
        cv.put(col6,remarksStr);
        long res=db.insert(tabName,null,cv);
        return res != -1;
    }


    public Cursor getData(String id) {
        SQLiteDatabase db= this.getWritableDatabase();
        String query="SELECT * FROM "+tabName+" WHERE ID='"+id+"'";
        return db.rawQuery(query,null);
    }

}
