package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Result;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerResultAll extends BaseController implements Initializable {
    public static final String URL_FXML ="resultAll.fxml";

    @FXML
    private Button Button_back;
    @FXML
    private Text Result1;

    @FXML
    private Text Result2;

    @FXML
    private Text Result3;

    @FXML
    private Text Result4;

    @FXML
    private Text Result5;

    @FXML
    private Text Test1;
    @FXML
    private Text Test2;

    @FXML
    private Text Test3;

    @FXML
    private Text Test4;

    @FXML
    private Text Test5;


    public void getName() throws SQLException {
      // Storage storage = StorageSingleton.getInstance();
      // DatabaseHandler dbHandler = new DatabaseHandler();
      // ResultSet result = dbHandler.getTest1();
      // String[] name = new String[5];
      // int i=0;
      // while (result.next()){
      //     name[i]= result.getString("name");
      //     i++;
      // }
      // Test1.setText(name[0]);
      // Test2.setText(name[1]);
      // Test3.setText(name[2]);
      // Test4.setText(name[3]);
      // Test5.setText(name[4]);
      // i=0;

      // Result result1 = new Result();
      // result = dbHandler.getResult(result1);
      // while (result.next()){
      //     name[i]= result.getString("result");
      //     i++;
      // }
      // Result1.setText(name[0]);
      // Result2.setText(name[1]);
      // Result3.setText(name[2]);
      // Result4.setText(name[3]);
      // Result5.setText(name[4]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Button_back.setOnAction(event ->{
            LoginApplication.getNavigation().load(ControllerTestsApp_student.URL_FXML).Show();
        });
        try {
            getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void initialize() throws SQLException {

    }
}
