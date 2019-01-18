package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ItemModel> data;

    public GridAdapter(Context context, ArrayList<ItemModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ItemModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
            viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.iconImg), (TextView)convertView.findViewById(R.id.textView));
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setModel(getItem(position));
        return convertView;
    }

    class ViewHolder {
        private ImageView iconImg;
        private TextView textView;
        private ItemModel model;

        public void setModel(ItemModel model) {
            this.model = model;
            iconImg.setImageResource(model.getImgSrc());
            textView.setText(model.getText());
        }

        public ImageView getIconImg() {
            return iconImg;
        }

        public TextView getTextView() {
            return textView;
        }

        public ViewHolder(ImageView iconImg, TextView textView) {
            this.iconImg = iconImg;
            this.textView = textView;
        }
    }
}
