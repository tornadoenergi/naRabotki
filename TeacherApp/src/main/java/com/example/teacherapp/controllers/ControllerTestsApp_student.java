package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Variables.Question;
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
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.teacherapp.ProcessedQuestions.TestID;
import static com.example.teacherapp.ProcessedQuestions.processedQuestions;


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
                int selectedIndex = Test_List.getSelectionModel().getSelectedIndex();
                GoTest_Button.setOnAction(event ->{
                    processedQuestions=new ArrayList<>();
                    getAnswerType(selectedIndex,processedQuestions);
                    TestID=selectedIndex;
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

        assert files != null;
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
    public void getAnswerType(int testId,List<String> processedQuestions) {
        String question = null;
        String[] answers = new String[4];
        int answerCount = 0;

        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Question question1 = new Question();
            question1.setTest_ID(testId);
            // Поиск вопроса по testId
            ResultSet rs = dbHandler.getQuestion(question1);
            if (rs.next()) {
                question = rs.getString("questions");
            } else {
                return; // Тест с таким id не найден
            }

            // Проверка, был ли уже обработан данный вопрос
            if (processedQuestions.contains(question)) {
                return; // Вопрос уже обработан
            } else {
                processedQuestions.add(question); // Добавляем в список обработанных
            }
            question1.setText_question(question);
            // Поиск ответов по testId и вопросу
            rs = dbHandler.getQuest(question1);
            while (rs.next()) {
                answers[answerCount++] = rs.getString("answer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (answerCount == 4) {
            OpenNewScene("/com/example/teacherapp/test3.fxml"); // Другое
        } else if (answerCount == 2) {
            OpenNewScene("/com/example/teacherapp/test1.fxml"); // 3 окно
        }
        else if (answerCount == 1){
            OpenNewScene("/com/example/teacherapp/test3.fxml");
        }

    }

}
