package com.nic.myapplication.demoSqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.nic.myapplication.R;

import java.util.HashMap;
import java.util.List;

class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private HashMap<String,List<String >>childList;
    private List<String >heading;

    CustomAdapter(SqliteDemo sqliteDemo, List<String> heading, HashMap<String, List<String>> childList) {
        this.context=sqliteDemo;
        this.childList=childList;
        this.heading=heading;

    }

    @Override
    public int getGroupCount() {
        return this.heading.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.childList.get(this.heading.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.heading.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.childList.get(this.heading.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headingStr=(String)getGroup(i);
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.activity_header, null);
        }
        TextView headingText=view.findViewById(R.id.heading);
        headingText.setText(headingStr);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String childStr= (String) getChild(i,i1);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.activity_child,null);
        }
        TextView childText= view.findViewById(R.id.child);
        childText.setText(childStr);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void setNewItems(List<String> listDataHeader,HashMap<String, List<String>> listChildData) {
        this.heading = listDataHeader;
        this.childList = listChildData;
        notifyDataSetChanged();
    }
}
