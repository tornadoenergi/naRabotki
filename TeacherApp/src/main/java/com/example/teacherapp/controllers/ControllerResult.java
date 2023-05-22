package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Test;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerResult {

    @FXML
    private Text Name_test;

    @FXML
    private Text all_question;

    @FXML
    private Text result;

    @FXML
    void initialize() throws SQLException {
        Storage storage = StorageSingleton.getInstance();
        setResult(storage);

        result.setText(String.valueOf(storage.getCorrect()));
    }

    private void setResult(Storage storage) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        int UserId = storage.getUserId();
        int TestId = storage.getTestId();
        Test test = new Test(TestId,UserId);
        ResultSet result = dbHandler.getTest(test);

        while (result.next()){
            Name_test.setText(result.getString("name"));
        }

    }

}
