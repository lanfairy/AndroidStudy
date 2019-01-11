package com.example.baselayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RelativeLayoutAty extends AppCompatActivity {
    private RelativeLayout layout;
    private TextView text;

    public RelativeLayout getLayout() {
        if (layout == null){
            layout = new RelativeLayout(this);
        }
        return layout;
    }

    public TextView getText() {
        if (text == null) {
            text = new TextView(this);
            text.setText("Android");
        }
        return text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 50;
        lp.topMargin = 50;
        setContentView(getLayout());
        layout.addView(getText(), lp);
    }
}
