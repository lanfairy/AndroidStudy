package com.example.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SpinnerActivity extends AppCompatActivity {
    private Spinner sp;
    private ArrayAdapter adapter;
    private ArrayAdapter<CharSequence> adapterXML;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        sp = findViewById(R.id.spinner);

        createByXML();
    }

    private void createByXML() {
        adapterXML = ArrayAdapter.createFromResource(this, R.array.datalist, android.R.layout.simple_list_item_1);
        sp.setAdapter(adapterXML);
        textView = findViewById(R.id.tvhaha);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(adapterXML.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

   private void createByList() {
        ArrayList data = new ArrayList<String>();
        for (int i=0; i<6; i++) {
            data.add("数据 "+i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adapter);
    }


}
