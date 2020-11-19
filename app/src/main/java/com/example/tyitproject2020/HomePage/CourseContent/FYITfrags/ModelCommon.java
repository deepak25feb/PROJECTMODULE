package com.example.tyitproject2020.HomePage.CourseContent.FYITfrags;

public class ModelCommon {
    int unitImage;
    String title;
    int chekSign;

    public ModelCommon(int unitImage, String title, int chekSign) {
        this.unitImage = unitImage;
        this.title = title;
        this.chekSign = chekSign;
    }

    public int getUnitImage() {
        return unitImage;
    }

    public void setUnitImage(int unitImage) {
        this.unitImage = unitImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChekSign() {
        return chekSign;
    }

    public void setChekSign(int chekSign) {
        this.chekSign = chekSign;
    }
}
