package com.example.teacherapp.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerTestsApp_student {
    String dir = ("C:\\Users\\admin\\Desktop\\TeacherApp\\lectures");
    @FXML
    private Button GoTest_Button;

    @FXML
    private Button Results_Button;

    @FXML
    private Button SingOut_Button;

    @FXML
    private ListView<String> Test_List;

    @FXML
    private Button lectorButton;

    @FXML
    private Button test_Button;

    @FXML
    void initialize(){
        populateListView(Test_List,dir);
        Test_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                GoTest_Button.setOnAction(event ->{

                });
            }
        });
        lectorButton.setOnAction(event -> {
            OpenNewScene("/com/example/teacherapp/studentMainApp.fxml");
        });
        SingOut_Button.setOnAction(event -> {
            OpenNewScene("/com/example/teacherapp/loginApp.fxml");
        });
        Results_Button.setOnAction(event -> {
            OpenNewScene("/com/example/teacherapp/resultsAll.fxml");
        });

    }

    public void OpenNewScene(String window){
        lectorButton.getScene().getWindow().hide();

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
    public void populateListView(ListView<String> listView,String dir) {
        File folder = new File(dir);
        File[] files = folder.listFiles();
        ArrayList<String> mdFiles = new ArrayList<>();


        for (File file : files) {
            if (file.getName().endsWith(".md")) {
                String fileName =file.getName();
                String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
                mdFiles.add(nameWithoutExtension);
            }
        }

        ObservableList<String> observableList = FXCollections.observableArrayList(mdFiles);
        listView.setItems(observableList);
    }


}
