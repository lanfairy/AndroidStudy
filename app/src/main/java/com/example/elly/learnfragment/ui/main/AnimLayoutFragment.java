package com.example.elly.learnfragment.ui.main;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.elly.learnfragment.R;

/**布局内容改变动画
 * 这列表添加布局动画
 * 使用资源文件配置布局动画
 */
public class AnimLayoutFragment extends Fragment {


    private  LinearLayout rootView;
    private View.OnClickListener btnOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rootView.removeView(v);
        }
    };
private View.OnClickListener addBtnTvOnClick = new View.OnClickListener() {
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        Button btn = new Button(getContext());
        btn.setText("remove self");
        btn.setOnClickListener(btnOnclick);
        rootView.addView(btn);
    }
};


    public static AnimLayoutFragment newInstance() {
        return new AnimLayoutFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (LinearLayout)inflater.inflate(R.layout.fragment_anim_layout, container, false);
        rootView.findViewById(R.id.addButtonTv).setOnClickListener(addBtnTvOnClick);

        LayoutTransition transition = new LayoutTransition();
        rootView.setLayoutTransition(transition);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
