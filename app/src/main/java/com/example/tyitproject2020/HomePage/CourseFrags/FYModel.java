package com.example.tyitproject2020.HomePage.CourseFrags;

public class FYModel {
    String year;
    String subject;
    String subjectCode;
    int imageResId;



    public FYModel(String year, String subject, int imageResId, String subjectCode) {
        this.year = year;
        this.subject = subject;
        this.imageResId = imageResId;
        this.subjectCode = subjectCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
