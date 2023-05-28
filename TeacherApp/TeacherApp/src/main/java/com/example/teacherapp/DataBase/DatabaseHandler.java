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
import java.util.ArrayList;
import java.util.List;

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

        String select = "SELECT * FROM " + Const.TEST_TABLE + " WHERE " + Const.TEST_TEST_ID
                + "=? AND " + Const.TEST_USER_ID + "=? AND " + Const.TEST_NAME + "=? ";
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
    public void setTest(Test test){
        String insert = "INSERT INTO " + Const.TEST_TABLE + "(" + Const.TEST_TEST_ID + "," + Const.TEST_USER_ID + ","
                + Const.TEST_NAME + "," + Const.TEST_DATE + ")" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1,test.getTest_ID());
            prSt.setInt(2,test.getUserID());
            prSt.setString(3,test.getTestName());
            prSt.setTimestamp(4,test.getDate());
            System.out.println("1234");
            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("4321");
            e.printStackTrace();
        }

    }

    public ResultSet getQuestions(Question question){
        ResultSet resSet = null;

        String select = "SELECT " +Const.QUESTION_QUESTION+","+Const.QUESTION_ANSWER+","+Const.QUESTION_QUESTION_ID+","+Const.QUESTION_CORRECT
                + " FROM " + Const.QUESTION_TABLE + " WHERE " + Const.QUESTION_TEST + "=? ";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1,question.getTest_ID());
            resSet = prSt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();

        }

        return resSet;
    }
    public ResultSet getCorrect(Question question){
        ResultSet resSet = null;
        String select = "SELECT " + Const.QUESTION_CORRECT + " FROM " + Const.QUESTION_TABLE + " WHERE " + Const.QUESTION_TEST + "=? AND " + Const.QUESTION_QUESTION + "=?";
        // + Const.QUESTION_QUESTION + "=? ";+ Const.QUESTION_ANSWER +"=? AND " + Const.QUESTION_CORRECT + "=? ";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1, question.getTest_ID());
            prSt.setString(2, question.getText_question());
            //prSt.setString(3,question.getAnswer());
            //prSt.setString(4,question.getCorrect());

            resSet = prSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resSet;
    }
    public void setQuestion (Question question){
        String insert = "INSERT INTO "+ Const.QUESTION_TABLE + "(" +Const.QUESTION_TEST + "," + Const.QUESTION_QUESTION
                + "," + Const.QUESTION_ANSWER + "," + Const.QUESTION_CORRECT + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1,question.getTest_ID());
            prSt.setString(2,question.getText_question());
            prSt.setString(3,question.getAnswer());
            prSt.setString(4,question.getCorrect());

            prSt.executeQuery();
        }catch (SQLException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }

    public void SetResult(Result result){
        String insert =  "INSERT INTO " + Const.RESULT_TABLE + "(" + Const.RESULT_TEST_ID + " , " + Const.RESULT_USER + ","
                + Const.RESULT_CORRECT +","+ Const.RESULT_DATE + "," + Const.TEST_NAME + "," + Const.RESULT_FIRSTNAME +
                "," + Const.RESULT_LASTNAME + ")" + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1,result.getTestID());
            prSt.setInt(2,result.getUserID());
            prSt.setInt(3,result.getResult());
            prSt.setTimestamp(4,result.getDate());
            prSt.setString(5,result.getTestName());
            prSt.setString(6,result.getFirstName());
            prSt.setString(7,result.getLastName());

            prSt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void SetNewResult(Result result){
        String update = "UPDATE " + Const.RESULT_TABLE + " SET " + Const.RESULT_CORRECT +"=? WHERE " + Const.RESULT_USER
                + " = ? AND " + Const.RESULT_TEST_ID + "=? AND " + Const.RESULT_DATE + "=?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(update);

            prSt.setInt(1,result.getResult());
            prSt.setInt(2,result.getUserID());
            prSt.setInt(3,result.getTestID());
            prSt.setTimestamp(4,result.getDate());
            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }
    }
    public ResultSet GetResult(Result result){
        ResultSet resSet = null;

        String select = "SELECT " + Const.RESULT_CORRECT +"," +Const.RESULT_TEST_ID + " FROM " + Const.RESULT_TABLE
                + " WHERE " + Const.RESULT_USER + "=? ";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1, result.getUserID());

            resSet = prSt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

        return resSet;
    }
    public ResultSet GetResultat(Result result){
        ResultSet resSet = null;

        String select = "SELECT " + Const.RESULT_CORRECT  + " FROM " + Const.RESULT_TABLE + " WHERE " + Const.RESULT_USER
                + "=? AND " + Const.RESULT_TEST_ID + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1, result.getUserID());
            prSt.setInt(2, result.getTestID());

            resSet = prSt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

        return resSet;
    }
    public ResultSet GetResultForTeacher(){
        ResultSet resSet = null;

        String select = "SELECT "+Const.RESULT_FIRSTNAME+"," + Const.RESULT_LASTNAME+","+ Const.RESULT_DATE + ","
                + Const.RESULT_NAME_TEST+"," +Const.RESULT_CORRECT + " FROM " + Const.RESULT_TABLE ;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

        return resSet;
    }

}
