package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.ProcessedQuestions;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Question;
import com.example.teacherapp.Variables.Results;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.teacherapp.Storage.ProcessedQuestions.*;

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
