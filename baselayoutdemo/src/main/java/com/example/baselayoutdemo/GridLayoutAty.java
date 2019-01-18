package com.example.baselayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class GridLayoutAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_aty);
    }

    public void onClick(View v) {

//        setContentView(R.layout.activity_main);
        setContentView(LayoutInflater.from(GridLayoutAty.this).inflate(R.layout.activity_main, null));
//        Toast.makeText(GridLayoutAty.this, "哈哈...", Toast.LENGTH_LONG).show();
    }
}
