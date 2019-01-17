package com.example.baselayoutdemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.baselayoutdemo.dummy.DummyContent;
import com.example.baselayoutdemo.recyclerViewDemo.ListViewFragment;

public class RecyclerViewAty extends AppCompatActivity implements ListViewFragment.OnListFragmentInteractionListener {
//    private RecyclerView rv;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        rv = new RecyclerView(this);
//        setContentView(rv);
//
////        rv.setLayoutManager(new LinearLayoutManager(this));
////        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
////        rv.setLayoutManager(new GridLayoutManager(this, 3));
//        rv.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
////        rv.setLayoutManager(new StaggeredGridLayoutManager(4,
////                StaggeredGridLayoutManager.HORIZONTAL));
//        final MyAdapter adapter = new MyAdapter();
//        adapter.setOnItemClickLitener(new MyAdapter.OnItemClickLitener() {
//            @Override
//            public void onItemClick(View view, int position, String testStr) {
//                Toast.makeText(RecyclerViewAty.this, "数据 : "+testStr +"删除", Toast.LENGTH_SHORT)
//                        .show();
//                adapter.removeData(position);
//            }
//        });
//        rv.setAdapter(adapter);
//        rv.setItemAnimator(new DefaultItemAnimator());
//        rv.addItemDecoration(new DividerGridItemDecoration(this));
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_aty);
        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.RecyclerViewAtyContainer, ListViewFragment.newInstance(1))
                    .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, "id: " + item.id + " content: " + item.content + " details: " + item.details, Toast.LENGTH_LONG).show();
    }
}
