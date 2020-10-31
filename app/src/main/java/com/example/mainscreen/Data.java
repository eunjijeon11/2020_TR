package com.example.mainscreen;

import android.graphics.Bitmap;

public class Data {

    //for quiz_end recyclerview adapter

    private int oxId;
    private Bitmap oxquizid;

    public int getoxId() {
        return oxId;
    }

    public void setoxId(int resId) {
        this.oxId = resId;
    }

    public Bitmap getoxquizId() {
        return oxquizid;
    }

    public void setOxquizId(Bitmap oxquizid) {
        this.oxquizid = oxquizid;
    }

    //for frag3 recyclerview adapter

    private String unit;
    private String quizDate;
    private int quizScore;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String  unit) {
        this.unit = unit;
    }

    public String getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(String quizDate) {
        this.quizDate = quizDate;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }

}
