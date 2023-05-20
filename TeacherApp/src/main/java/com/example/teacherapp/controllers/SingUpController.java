package com.example.teacherapp.controllers;

import com.example.teacherapp.DatabaseHandler;
import com.example.teacherapp.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SingUpController {

    @FXML
    private Button BackButton;
    @FXML
    private Button SingUpButton;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private ComboBox<String> ComboBoxChoice;

    @FXML
    void initialize(){
        SingUpButton.setOnAction(event -> {
            singUpNewUser();
        ComboBoxChoice.setItems(FXCollections.observableArrayList("Учитель","Студент"));
        BackButton.setOnAction(event1 -> {
            OpenNewScene("/com/example/teacherapp/teacherMainApp.fxml");
        });
        });
    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String teacher = null;
        if (Objects.equals(ComboBoxChoice.getItems().toString(), "Учитель")) teacher = "teacher";

        else if (Objects.equals(ComboBoxChoice.getItems().toString(), "Студент")) teacher = "student";
        User user = new User(firstname,lastname,username,password,teacher);

        dbHandler.singUpUser(user);
    }
    public void OpenNewScene(String window){
        BackButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

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

