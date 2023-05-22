package com.example.teacherapp.controllers;


import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Variables.User;
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
import java.util.Objects;

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
            if(!loginText.equals("") && !loginPassword.equals("")) {
                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else
                System.out.println("Login or password empty");
        });



    }

    private void loginUser(String loginText, String loginPassword) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result= dbHandler.getUser(user);

        String role = null;
        int userID = 0;
        int counter = 0;
        try {
            while(result.next()){
                counter++;
                role = result.getString("teacher");
                userID = result.getInt("userid");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if (counter>=1){
            if(Objects.equals(role, "teacher")){
            OpenNewScene("/com/example/teacherapp/teacherMainApp.fxml");}
            else if(Objects.equals(role, "student")){OpenNewScene("/com/example/teacherapp/studentMainApp.fxml");}
            //user.setUserID(result.getInt("usersid"));
            user.setUserID(userID);
            //System.out.println(result.getInt("userid"));
        }
        else System.out.println("неверный логин или пароль");

    }

    public void OpenNewScene(String window){
        AuthSigInButton.getScene().getWindow().hide();

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
