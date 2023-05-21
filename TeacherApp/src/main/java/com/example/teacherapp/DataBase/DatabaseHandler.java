package com.example.teacherapp.DataBase;

import com.example.teacherapp.Const;
import com.example.teacherapp.Variables.Question;
import com.example.teacherapp.Variables.Result;
import com.example.teacherapp.Variables.Test;
import com.example.teacherapp.Variables.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return dbConnection;
    }

    public void singUpUser(User user)  {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_USERNAME + "," + Const.USER_PASS + "," + Const.USER_ROLE + ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFirstname());
            prSt.setString(2,user.getLastname());
            prSt.setString(3,user.getUsername());
            prSt.setString(4,user.getPassword());
            prSt.setString(5,user.getTeacher());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " +Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASS + "=? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1,user.getUsername());
            prSt.setString(2,user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public ResultSet getTest(Test test){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TEST_TABLE + " WHERE " + Const.TEST_TEST_ID + "=? AND " + Const.TEST_ID + "=? AND " + Const.TEST_NAME + "=? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1,test.getTest_ID());
            prSt.setInt(2,test.getUserID());
            prSt.setString(3,test.getTestName());

            resSet = prSt.executeQuery();

        } catch (Exception e){
            e.printStackTrace();
        }

        return resSet;
    }
    public ResultSet getQuestion(Question question){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.TEST_TABLE + " WHERE " + Const.TEST_ID + "=? AND "+Const.QUESTION_TEST
                + "=? AND " + Const.TEST_NAME + "=? ";
                //+ Const.QUESTION_QUESTION + "=? AND " + Const.QUESTION_ANSWER + "=? And " + Const.QUESTION_CORRECT + "=? And "  ;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            
            prSt.setInt(1, question.getTest_ID());
            prSt.setInt(2, question.getTest_Question_ID());
            prSt.setString(3, question.getText_question());

            resSet = prSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resSet;
    }
    public void SetResult(Result result){
        String insert =  "INSERT INTO " + Const.RESULT_TABLE + "(" + Const.RESULT_TEST_ID + " , " + Const.RESULT_USER + ","
                + Const.RESULT_CORRECT + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1,result.getTestID());
            prSt.setInt(2,result.getUserID());
            prSt.setString(3,result.getResult());


            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getResult(Result result){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.RESULT_TABLE + " WHERE " + Const.RESULT_TEST_ID + "=? AND " + Const.RESULT_USER
                + "=? AND " + Const.RESULT_CORRECT + "=? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1,result.getTestID());
            prSt.setInt(2,result.getUserID());
            prSt.setString(3, result.getResult());

            resSet = prSt.executeQuery();

        } catch (Exception e){
            e.printStackTrace();
        }

        return resSet;
    }
}
