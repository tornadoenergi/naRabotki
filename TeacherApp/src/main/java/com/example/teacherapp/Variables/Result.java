package com.example.teacherapp.Variables;

public class Result {
    private int userID;
    private int testID;
    private int result;


    public Result(int userID, int testID, int result) {
        this.userID = userID;
        this.testID = testID;
        this.result = result;
    }

    public Result() {

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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
