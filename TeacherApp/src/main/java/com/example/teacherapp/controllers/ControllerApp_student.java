package com.example.teacherapp.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import com.aspose.words.*;

import java.io.*;
import java.util.Scanner;

public class ControllerApp_student {
    File folder = new File("lectures/");
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
    void initialize() throws IOException {
        SingOut_Button.setOnAction(event ->{
            OpenNewScene("com/example/teacherapp/loginApp.fxml");
        });
        test_Button.setOnAction(event1 ->{
            OpenNewScene("");
        });

        WordToMd();

        lector_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                readMarkdownFile(t1,lector_text);
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


    public void WordToMd() {
        try {
            // указываем путь к директории с файлами
            File directory = new File("src/lectures");
            File[] files = directory.listFiles();

            assert files != null;
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".docx")) {

                    Document doc = new Document(file.getName());
                    doc.save(file.getName()+".md");
                    lector_list.getItems().addAll(file.getName());

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void readMarkdownFile(String fileName, TextArea textArea) {
        try {
            File file = new File(fileName);
            if (file.isFile() && file.getName().endsWith(".md")) {
                FileInputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis);

                // считываем текст из файла и выводим его в TextArea
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine()).append("\n");
                }
                textArea.setText(sb.toString());

                // закрываем потоки
                scanner.close();
                fis.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
