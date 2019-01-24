package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mlistView;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = findViewById(R.id.listView);
        initData();

        mlistView.setAdapter(new MyAdater(MainActivity.this, mData));
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position: "+position, Toast.LENGTH_LONG).show();
            }
        });
        mlistView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.v("哈哈", view.toString());
                view.setEnabled(false);
            }
        });
    }
    void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            mData.add(" I/WindowManager: Destroying surface Surface(name=Starting com.example.elly.learnfragment) called by com.android.server.wm.WindowStateAnimator.destroySurface:2016 com.android.server.wm.WindowStateAnimator.destroySurfaceLocked:882 com.android.server.wm.WindowState.destroyOrSaveSurface:2100 com.android.server.wm.AppWindowToken.destroySurfaces:363 com.android.server.wm.WindowStateAnimator.finishExit:565 com.android.server.wm.WindowStateAnimator.stepAnimationLocked:491 com.android.server.wm.WindowAnimator.updateWindowsLocked:303 com.android.server.wm.WindowAnimator.animateLocked:704  " + (i+1));
        }
    }
}
