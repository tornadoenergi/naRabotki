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
import java.util.ResourceBundle;

public class ControllerResult extends BaseController implements Initializable {
    public static final String URL_FXML ="result.fxml";
    @FXML
    private Button Button_back;
    @FXML
    private Text Name_test;

    @FXML
    private Text all_question;

    @FXML
    private Text result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Storage storage = StorageSingleton.getInstance();
        getResult(storage);
        Button_back.setOnAction(event ->{
            LoginApplication.getNavigation().load(ControllerTestsApp_student.URL_FXML).Show();
        });
    }
    @FXML
    void initialize() {

    }

    private void getResult(Storage storage) {
        Name_test.setText(storage.getNameTest());
        result.setText(storage.getGivenCorrect());

       //DatabaseHandler dbHandler = new DatabaseHandler();

       //int UserID = storage.getUserId();
       //int TestID = storage.getTestId();
       //int Resul = Integer.parseInt(storage.getGivenCorrect());

       //Result result1 = new Result(UserID,TestID,Resul);

       //dbHandler.SetResult(result1);
    }



}
