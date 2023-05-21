package com.example.teacherapp.Variables;


public class Test {
    private String TestName;
    private Integer Test_ID;
    private java.sql.Date Date;
    private int userID;

    public Test(String testName, java.sql.Date date, int userID) {
        TestName = testName;
        Date = date;
        this.userID = userID;
    }

    public Integer getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(Integer test_ID) {
        Test_ID = test_ID;
    }

    public Test() {
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
