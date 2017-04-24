package com.example.android.inclassassignment11_katiebtake2;

import java.io.Serializable;

/**
 * Created by katie on 4/24/17.
 */

public class Mood implements Serializable {
    public String id;
    public String moodName;
    public int moodOutOfTen;
    public boolean moodDiscussed;

    public Mood(String id, String moodName, int moodOutOfTen, boolean moodDiscussed) {
        this.id = id;
        this.moodName = moodName;
        this.moodOutOfTen = moodOutOfTen;
        this.moodDiscussed = moodDiscussed;
    }

    public Mood() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public int getMoodOutOfTen() {
        return moodOutOfTen;
    }

    public void setMoodOutOfTen(int moodOutOfTen) {
        this.moodOutOfTen = moodOutOfTen;
    }

    public boolean isMoodDiscussed() {
        return moodDiscussed;
    }

    public void setMoodDiscussed(boolean moodDiscussed) {
        this.moodDiscussed = moodDiscussed;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "id='" + id + '\'' +
                ", moodName='" + moodName + '\'' +
                ", moodOutOfTen=" + moodOutOfTen +
                ", moodDiscussed=" + moodDiscussed +
                '}';
    }
}
