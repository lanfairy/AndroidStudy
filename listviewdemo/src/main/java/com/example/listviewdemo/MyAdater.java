package com.example.listviewdemo;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class MyAdater extends BaseAdapter {

    private Context mContext;
    private List<String> mData;
    public MyAdater(Context context, List<String> dataSource) {
        this.mContext = context;
        this.mData = dataSource;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            holder = new Holder();
            holder.textView = convertView.findViewById(R.id.title);
            holder.textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            convertView.setTag(holder);
            Log.i("TAG", "创建对象: "+convertView);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(getItem(position));

        return convertView;
    }

    class Holder {
        public TextView textView;
    }
}
