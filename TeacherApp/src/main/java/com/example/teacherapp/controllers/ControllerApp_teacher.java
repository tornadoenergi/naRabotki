package com.example.teacherapp.controllers;

import com.example.teacherapp.LoginApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerApp_teacher extends BaseController implements Initializable {
    public static final String URL_FXML ="teacherMainApp.fxml";
    @FXML
    private Button Create_Button;

    @FXML
    private ListView<String> lector_list;

    @FXML
    private TextArea lector_text;

    @FXML
    private Button SingOut_Button;

    @FXML
    private Button lector_Button;

    @FXML
    private Button test_Button;

    @FXML
    void initialize() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Create_Button.setOnAction(event -> {
            LoginApplication.getNavigation().load(SingUpController.URL_FXML).Show();
        });
        test_Button.setOnAction(event1 ->{

        });
        lector_Button.setOnAction(event2 ->{

        });
        SingOut_Button.setOnAction(event3 ->{

        });
    }
    public void OpenNewScene(String window){
        Create_Button.getScene().getWindow().hide();

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
