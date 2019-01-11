package com.example.elly.learnfragment.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elly.learnfragment.R;

public class BlankFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v("0","BlankFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("0","BlankFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v("0","BlankFragment onCreateView");

        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        rootView.findViewById(R.id.backMainFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("0","BlankFragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("0","BlankFragment onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("0","BlankFragment onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("0","BlankFragment onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("0","BlankFragment onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("0","BlankFragment onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("0","BlankFragment onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("0","BlankFragment onDetach");

    }
}
