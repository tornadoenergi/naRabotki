package com.example.teacherapp;

import com.example.teacherapp.controllers.Controller;
import com.example.teacherapp.controllers.ControllerLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    private static Navigation navigation;
    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        navigation = new Navigation(primaryStage);

        primaryStage.setTitle("VA navigation");
        primaryStage.show();

        //navigate to first view
        LoginApplication.getNavigation().load(ControllerLogin.URL_FXML).Show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}