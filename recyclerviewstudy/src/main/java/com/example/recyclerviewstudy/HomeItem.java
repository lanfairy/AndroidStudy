package com.example.recyclerviewstudy;

public class HomeItem {
    private String title;
    private Class<?> activity;
    private int imageResource;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {

        return title;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public int getImageResource() {
        return imageResource;
    }
}
