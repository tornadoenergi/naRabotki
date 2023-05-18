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
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerApp_student {
    File folder = new File("lectures/");
    @FXML
    private Button SingOut_Button;

    @FXML
    private Button lectorButton;

    @FXML
    private ListView<File> lector_list;

    @FXML
    private TextArea lector_text;

    @FXML
    private Button test_Button;

    @FXML
    void initialize() throws IOException {
        SingOut_Button.setOnAction(event ->{
            OpenNewScene("com/example/teacherapp/loginApp.fxml");
        });
        test_Button.setOnAction(event1 ->{
            OpenNewScene("");
        });

        //fillListViewWithDocs(lector_list);

        loadFilesFromFolder(folder,lector_list);
        lector_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<File>() {
            @Override
            public void changed(ObservableValue<? extends File> observableValue, File file, File t1) {
                displayDocxFile(t1,lector_text);
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

    public void loadFilesFromFolder(File folder, ListView<File> listView) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    listView.getItems().add(file);
                }
            }
        }
    }

    public void fillListViewWithDocs(ListView<String> listView) {

        File folder = new File("lectures");

        File[] files = folder.listFiles();

        if (files != null) {
            ObservableList<String> fileNames = FXCollections.observableArrayList();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".docx")) {
                    fileNames.add(file.getName());
                }
            }

            listView.setItems(fileNames);
        }
    }
    public void displayDocxFile(File file, TextArea textArea) {
        try {

            FileInputStream fis = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String text = extractor.getText();
            textArea.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
