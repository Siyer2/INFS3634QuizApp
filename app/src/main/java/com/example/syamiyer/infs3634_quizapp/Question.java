package com.example.syamiyer.infs3634_quizapp;

public class Question {
    private String mTextResId;
    private boolean mAnswerTrue;

    public Question(String mTextResId, boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public String getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(String mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean getmAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
