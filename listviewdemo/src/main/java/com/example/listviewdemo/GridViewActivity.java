package com.example.listviewdemo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.AccessMode;
import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    private GridView gridView;
    private ArrayList<ItemModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initData();
        initView();
    }
    private JSONArray getJson() {
        StringBuilder builder = new StringBuilder();

        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("test.json"),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null){
                builder.append(line);
            }
            JSONObject rootJson = new JSONObject(builder.toString());
            JSONArray languages = rootJson.getJSONArray("languages");
            return  languages;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    private void initData() {
    arrayList = new ArrayList<>();
    ArrayList list = ItemModel.getItemModelsFromJson(getJson());
    if (list != null)
        arrayList = list;
//        for (int i=0; i<40; i++){
//            arrayList.add(new ItemModel(R.mipmap.head_img, "head img"+(i+1)));
//        }
//        JSONArray languages = getJson();
//        if (languages != null) {
//            try {
//                for (int i=0; i<languages.length(); i++) {
//                    JSONObject lan = languages.getJSONObject(i);
//                    arrayList.add(new ItemModel(R.mipmap.head_img, ""+lan.getString("name")));
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
    private void initView() {
        gridView = findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(this, arrayList);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(GridViewActivity.this, SpinnerActivity.class));
                startActivity(new Intent(GridViewActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

        });
        gridView.setAdapter(adapter);
    }
}
