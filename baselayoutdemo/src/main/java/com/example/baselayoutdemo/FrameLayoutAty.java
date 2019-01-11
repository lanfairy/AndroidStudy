package com.example.baselayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FrameLayoutAty extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv1;
    private ImageView iv2;
    private FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_aty);

        fl = findViewById(R.id.fl);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);

        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.iv1) {
            iv2.setVisibility(View.VISIBLE);
        }else{
            iv1.setVisibility(View.VISIBLE);
        }
        v.setVisibility(View.INVISIBLE);

    }
}
