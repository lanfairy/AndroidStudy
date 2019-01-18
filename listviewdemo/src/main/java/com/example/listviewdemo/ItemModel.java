package com.example.listviewdemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class ItemModel {
    private int imgSrc;
    private String text;

    public int getImgSrc() {
        return imgSrc;
    }

    public String getText() {
        return text;
    }

    public ItemModel(int imgSrc, String text) {
        this.imgSrc = imgSrc;
        this.text = text;
    }

    public static ArrayList<ItemModel> getItemModelsFromJson(JSONArray languages) {
        if (languages==null)return null;
        ArrayList arrayList = new ArrayList<>();
        try {
            for (int i=0; i<languages.length(); i++) {
                JSONObject lan = languages.getJSONObject(i);
                arrayList.add(new ItemModel(R.mipmap.head_img, ""+lan.getString("name")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
