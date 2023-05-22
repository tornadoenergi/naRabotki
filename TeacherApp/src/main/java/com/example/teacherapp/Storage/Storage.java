package com.example.teacherapp.Storage;

public class Storage {

    private int Correct;
    private int UserId;
    private int TestId;
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = userId;
    }

    public void setCorrect(int correct) {
        this.Correct = correct;
    }

    public int getCorrect() {
        return Correct;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int testId) {
        TestId = testId;
    }
}
