package com.example.elly.learnfragment.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.example.elly.learnfragment.MainActivity;
import com.example.elly.learnfragment.NavigationDrawer;
import com.example.elly.learnfragment.R;
import com.example.elly.learnfragment.TabbedActivity;

public class  MainFragment extends Fragment {

    private MainViewModel mViewModel;
    public static MainFragment newInstance() {
        return new MainFragment();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("0","MainFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("0","MainFragment onCreate");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.v("0","MainFragment onCreateView");
        final View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        rootView.findViewById(R.id.showAnotherFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alpha
//                代码
                /*AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                fadeIn.setDuration(1000);*/
//                xml方式
                Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                fadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        getFragmentManager().beginTransaction()
                                .replace(R.id.container, new BlankFragment())
                                .addToBackStack(null)
                                .commit();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(fadeIn);



            }
        });
        rootView.findViewById(R.id.showDrawerActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RELATIVE_TO_SELF 锚点位置相对自己 定位
//                ScaleAnimation zoomOut = new ScaleAnimation(1.0f,1.5f,1.0f,1.5f,Animation.RELATIVE_TO_SELF,0.5f, Animation.INFINITE,0.5f);
//                zoomOut.setDuration(1000);
                ScaleAnimation zoomOut = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.zoom_out);
                v.startAnimation(zoomOut);
                zoomOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        startActivity(new Intent(getActivity(), NavigationDrawer.class));

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        rootView.findViewById(R.id.showTabActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RELATIVE_TO_SELF
//                TranslateAnimation moveLtr = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.f, Animation.RELATIVE_TO_SELF, 1.f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
//                TranslateAnimation moveLtr = new TranslateAnimation(0.f, 200f, 0f, 0f);
//                moveLtr.setDuration(1000);
                TranslateAnimation moveLtr = (TranslateAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.move_left_to_right);
                v.startAnimation(moveLtr);
                moveLtr.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        startActivity(new Intent(getActivity(), TabbedActivity.class));

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        rootView.findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotate = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
//                RotateAnimation rotate = (RotateAnimation)AnimationUtils.loadAnimation(getContext(), R.anim.rotate_one);
                v.startAnimation(rotate);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("0","MainFragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("0","MainFragment onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("0","MainFragment onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("0","MainFragment onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("0","MainFragment onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("0","MainFragment onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("0","MainFragment onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("0","MainFragment onDetach");

    }

}
