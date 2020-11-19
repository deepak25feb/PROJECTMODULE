package com.example.tyitproject2020.HomePage;

public class HomeFragCourseModel {
    String text;
    int resId;

    public HomeFragCourseModel(String text, int resId) {
        this.text = text;
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
