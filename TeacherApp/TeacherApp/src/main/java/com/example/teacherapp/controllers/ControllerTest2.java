package com.example.teacherapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTest2 extends BaseController implements Initializable {
    public static final String URL_FXML = "test2.fxml";
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


    @FXML
    void initialize(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
