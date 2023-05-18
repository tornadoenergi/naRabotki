package com.example.teacherapp.controllers;

import com.example.teacherapp.DatabaseHandler;
import com.example.teacherapp.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        });
        });
    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        //if (ComboBoxChoice.getValue() == )
        String teacher = ComboBoxChoice.getItems().toString();

        User user = new User(firstname,lastname,username,password,teacher);

        dbHandler.singUpUser(user);
    }

}

