package com.example.teacherapp.controllers;


import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerLogin extends BaseController implements Initializable {
    public static final String URL_FXML= "loginApp.fxml";
    @FXML
    private Button AuthSigInButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    void initialize() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        Storage storage = StorageSingleton.getInstance();
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
            LoginApplication.getNavigation().load(ControllerApp_teacher.URL_FXML).Show();storage.setUserId(userID);}
            else if(Objects.equals(role, "student")){LoginApplication.getNavigation().load(ControllerApp_student.URL_FXML).Show();storage.setUserId(userID);}


        }
        else System.out.println("неверный логин или пароль");

    }


}
