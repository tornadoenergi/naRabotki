package com.example.teacherapp.controllers;

import com.example.teacherapp.LoginApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerApp_teacher extends BaseController implements Initializable {
    public static final String URL_FXML ="teacherMainApp.fxml";
    String dir = ("C:\\Users\\admin\\Desktop\\123\\TeacherApp\\lectures");
    @FXML
    private Button Create_Button;

    @FXML
    private ListView<String> Lector_list;

    @FXML
    private TextArea Lector_text;

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
        test_Button.setOnAction(event ->{
            LoginApplication.getNavigation().load(ControllerTestsApp_student.URL_FXML).Show();
        });
        lector_Button.setOnAction(event ->{

        });
        SingOut_Button.setOnAction(event ->{
            LoginApplication.getNavigation().load(ControllerLogin.URL_FXML).Show();
        });
        populateListView(Lector_list,dir);
        Lector_list.setCellFactory(cell -> {
            return new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);

                        // decide to add a new styleClass
                        // getStyleClass().add("costume style");
                        // decide the new font size
                        setFont(Font.font(16));
                    }
                }
            };
        });
        Lector_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Lector_text.clear();
                viewMdToScreen(t1,Lector_text,dir);
                //try {
                //    viewPdfToScreen(t1, dir);
                //} catch (IOException e) {
                //    throw new RuntimeException(e);
                //}
            }
        });
    }
    public void populateListView(ListView<String> listView, String dir) {
        File folder = new File(dir);
        File[] files = folder.listFiles();
        ArrayList<String> mdFiles = new ArrayList<>();


        for (File file : files) {
            if (file.getName().endsWith(".md")) {
                String fileName = file.getName();
                String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
                mdFiles.add(nameWithoutExtension);
            }
        }

        ObservableList<String> observableList = FXCollections.observableArrayList(mdFiles);

        listView.setItems(observableList);
    }
    public void viewMdToScreen(String fileName, TextArea textArea,String dir) {
        try (BufferedReader br = new BufferedReader(new FileReader(dir+"\\"+fileName+".md"))) {
            String line;

            while ((line = br.readLine()) != null) { // читаем файл построчно
                textArea.appendText(line + "\n"); // добавляем текст в TextArea
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
