package com.example.teacherapp.Variables;

import java.sql.Timestamp;

public class Result {
    private int userID;
    private int testID;
    private int result;
    private String firstName;
    private String LastName;
    private java.sql.Timestamp Date;
    private String TestName;

    public Result(int userID, int testID, int result, String firstName, String lastName, Timestamp date, String testName) {
        this.userID = userID;
        this.testID = testID;
        this.result = result;
        this.firstName = firstName;
        LastName = lastName;
        Date = date;
        TestName = testName;
    }

    public Result(int userID, int testID, int result) {
        this.userID = userID;
        this.testID = testID;
        this.result = result;
    }

    public Result() {

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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }
}
