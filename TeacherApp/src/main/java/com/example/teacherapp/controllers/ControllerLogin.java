package com.example.teacherapp.controllers;


import com.example.teacherapp.DatabaseHandler;
import com.example.teacherapp.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerLogin {

    @FXML
    private Button AuthSigInButton;

    @FXML
    private AnchorPane Pane_auto;
    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    void initialize() {
        AuthSigInButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login or password empty");
        });



    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result= dbHandler.getUser(user);

        int counter = 0;
        try {
            while(result.next()){
                counter++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if (counter>=1){
            OpenNewScene("src/main/resources/com/example/teacherapp/teacherMainApp.fxml");
        }
        else System.out.println("неверный логин или пароль");

    }

    public void OpenNewScene(String window){
        AuthSigInButton.getScene().getWindow().hide();
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
        stage.showAndWait();
    }
}
