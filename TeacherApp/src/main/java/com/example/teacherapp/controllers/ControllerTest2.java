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

public class ControllerTest2 {

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton answer_radio_1;

    @FXML
    private RadioButton answer_radio_2;

    @FXML
    private RadioButton answer_radio_3;

    @FXML
    private RadioButton answer_radio_4;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Label question_text;
    void initialize(){
        NextButton.setOnAction(event ->{
            answers.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == answer_radio_1) {
                    answer_radio_1.getText();

                } else if (newValue == answer_radio_2) {

                } else if (newValue == answer_radio_3) {

                } else if (newValue == answer_radio_4) {

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
