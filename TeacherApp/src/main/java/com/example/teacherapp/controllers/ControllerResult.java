package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerResult {
    @FXML
    private Button Button_back;
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
        Button_back.setOnAction(event ->{
            OpenNewScene("/com/example/teacherapp/studentTestsApp.fxml");
        });
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
    public void OpenNewScene(String window){
        Button_back.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(window));


        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Учитель");
        stage.showAndWait();

    }

}
