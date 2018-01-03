package com.example.konrad.dla_pielegniarekmobile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Konrad on 2017-12-28.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    List<menager> valueList;
    public ListAdapter(List<menager> listValue,Context context)
    {
        this.context = context;
        this.valueList = listValue;
    }
    @Override
    public int getCount() {
        return this.valueList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.valueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
     ViewItem viewItem = null;
     if(convertView == null)
     {
         viewItem = new ViewItem();
         LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
         convertView = layoutInflater.inflate(R.layout.layout_items,null);
         viewItem.TextViewMenagerName = (TextView)convertView.findViewById(R.id.textview1);
         convertView.setTag(viewItem);
     }
     else
     {
         viewItem = (ViewItem) convertView.getTag();

     }
     viewItem.TextViewMenagerName.setText(valueList.get(position).id_Harmonogramu);
     return convertView;
     }
}

    class ViewItem{
        TextView TextViewMenagerName;
    }

