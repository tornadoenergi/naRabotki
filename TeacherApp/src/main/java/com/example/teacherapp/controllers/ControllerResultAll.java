package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerResultAll {

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
    private Text Test3;

    @FXML
    private Text Test4;

    @FXML
    private Text Test5;

    @FXML
    void initialize(){
        getName();
    }
    public void getName(){
        DatabaseHandler dbHandler = new DatabaseHandler();

    }
}
