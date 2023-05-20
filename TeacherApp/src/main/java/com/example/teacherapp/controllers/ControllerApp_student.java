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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ControllerApp_student {
    String dir = ("C:\\Users\\admin\\Desktop\\TeacherApp\\src\\lectures");

    @FXML
    private Button SingOut_Button;

    @FXML
    private Button lectorButton;

    @FXML
    private ListView<String> lector_list;

    @FXML
    private TextArea lector_text;

    @FXML
    private Button test_Button;

    @FXML
    void initialize(){
        SingOut_Button.setOnAction(event ->{
            OpenNewScene("/com/example/teacherapp/loginApp.fxml");
        });
        test_Button.setOnAction(event1 ->{
            OpenNewScene("");
        });
        populateListView(lector_list,dir);
        lector_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                viewMdToScreen(t1,lector_text,dir);
            }
        });

    }
    public void OpenNewScene(String window){
        SingOut_Button.getScene().getWindow().hide();

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

    public void populateListView(ListView<String> listView,String dir) {
        File folder = new File(dir);
        File[] files = folder.listFiles();
        ArrayList<String> mdFiles = new ArrayList<>();


        for (File file : files) {
            if (file.getName().endsWith(".md")) {
                mdFiles.add(file.getName());
            }
        }

        ObservableList<String> observableList = FXCollections.observableArrayList(mdFiles);
        listView.setItems(observableList);
    }
    public void viewMdToScreen(String fileName, TextArea textArea,String dir) {
        try (BufferedReader br = new BufferedReader(new FileReader(dir+"\\"+fileName))) {
            String line;
            while ((line = br.readLine()) != null) { // читаем файл построчно
                textArea.appendText(line + "\n"); // добавляем текст в TextArea
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
