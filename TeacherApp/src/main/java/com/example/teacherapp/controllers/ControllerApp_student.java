package com.example.teacherapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerApp_student {

    @FXML
    private Button SingOut_Button;

    @FXML
    private Button lectorButton;

    @FXML
    private ListView<?> lector_list;

    @FXML
    private TextArea lector_text;

    @FXML
    private Button test_Button;

    @FXML
    void initialize() {
        SingOut_Button.setOnAction(event ->{
            OpenNewScene("com/example/teacherapp/loginApp.fxml");
        });
        test_Button.setOnAction(event1 ->{
            OpenNewScene("");
        });

    }
    public void OpenNewScene(String window){
        SingOut_Button.getScene().getWindow().hide();

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
