package com.example.teacherapp.Variables;


public class Test {
    private String TestName;
    private int Test_ID;
    private java.sql.Timestamp Date;
    private int userID;

    public Test(String testName, java.sql.Timestamp date, int userID,int test_ID) {
        TestName = testName;
        Date = date;
        this.userID = userID;
    }

    public Test(int test_ID, int userID) {
        Test_ID = test_ID;
        this.userID = userID;
    }

    public int getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(int test_ID) {
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

    public java.sql.Timestamp getDate() {
        return Date;
    }

    public void setDate(java.sql.Timestamp date) {
        Date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
