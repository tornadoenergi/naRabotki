package com.example.teacherapp.Variables;

public class Result {
    private int userID;
    private int testID;
    private String result;

    public Result(int userID, int testID, String result) {
        this.userID = userID;
        this.testID = testID;
        this.result = result;
    }

    public Result(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
