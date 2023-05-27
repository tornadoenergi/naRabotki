package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Variables.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SingUpController extends BaseController implements Initializable {
    public static final String URL_FXML ="singUpApp.fxml";

    @FXML
    private Button BackButton;

    @FXML
    private ComboBox<String> ComboBox;

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
            singUpNewUser();});
        ComboBox.setItems(FXCollections.observableArrayList("Учитель","Студент"));


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SingUpButton.setOnAction(event -> {
            singUpNewUser();});
        ComboBox.setItems(FXCollections.observableArrayList("Учитель","Студент"));

        BackButton.setOnAction(event1 -> {
            LoginApplication.getNavigation().load(ControllerApp_teacher.URL_FXML).Show();
        });
    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String teacher = null;
        if (Objects.equals(ComboBox.getValue(), "Учитель")) {teacher = "teacher";}
        else if (Objects.equals(ComboBox.getValue(), "Студент")) {teacher = "student";}

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

