package com.example.teacherapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTest1 {

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton RadioButtonNo;

    @FXML
    private RadioButton RadioButtonYes;

    @FXML
    private Label Test_text;

    @FXML
    private ToggleGroup answers;

    @FXML
    void initialize(){

        NextButton.setOnAction(event ->{
            answers.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == RadioButtonYes) {



                } else if (newValue == RadioButtonNo) {



                }
            });
            OpenNewScene("");
        });



    }
    public void OpenNewScene(String window){
        NextButton.getScene().getWindow().hide();

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
