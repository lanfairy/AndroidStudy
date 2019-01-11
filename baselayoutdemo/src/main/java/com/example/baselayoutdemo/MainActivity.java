package com.example.baselayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout;

    private Button btnClickMe;

    public LinearLayout getLinearLayout() {
        if (linearLayout==null){
            linearLayout = new LinearLayout(this);
//            linearLayout.setOrientation(LinearLayout.VERTICAL);
            //        linearLayout.addView(getBtnClickMe());
//        linearLayout.addView(getBtnClickMe(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.weight = 1;
            for (int i = 0; i < 5; i++) {
                Button btn = new Button(this);
                btn.setOnClickListener(this);
                btn.setText(String.format("%d click me",i+1));
                linearLayout.addView(btn, lp);
            }
        }
        return linearLayout;
    }

    public Button getBtnClickMe() {
        if (btnClickMe==null) {
            btnClickMe = new Button(this);
            btnClickMe.setText("click me");
        }
        return btnClickMe;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLinearLayout());

    }

    @Override
    public void onClick(View v) {
        linearLayout.removeView(v);
    }
}
