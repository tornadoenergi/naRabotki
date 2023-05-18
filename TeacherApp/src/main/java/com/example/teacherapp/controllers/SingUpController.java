package com.example.teacherapp.controllers;

import com.example.teacherapp.DatabaseHandler;
import com.example.teacherapp.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private Button SingUpButton;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize(){
        SingUpButton.setOnAction(event -> {
            singUpNewUser();


        });
    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = new User(firstname,lastname,username,password);

        dbHandler.singUpUser(user);
    }
}

