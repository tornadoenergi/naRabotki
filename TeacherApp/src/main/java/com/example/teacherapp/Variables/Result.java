package com.example.teacherapp.Variables;

public class Result {
    private Integer userID;
    private Integer testID;
    private String result;

    public Result(Integer userID, Integer testID, String result) {
        this.userID = userID;
        this.testID = testID;
        this.result = result;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
