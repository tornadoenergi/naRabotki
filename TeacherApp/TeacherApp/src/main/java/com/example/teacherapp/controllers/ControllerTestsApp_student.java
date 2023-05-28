package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.ProcessedQuestions;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Question;
import com.example.teacherapp.Variables.Test;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import static com.example.teacherapp.Storage.ProcessedQuestions.TestID;
import static com.example.teacherapp.Storage.ProcessedQuestions.processedQuestions;


public class ControllerTestsApp_student extends BaseController implements Initializable {
    public static final String URL_FXML ="studentTestsApp.fxml";
    String dir = ("C:\\Users\\admin\\Desktop\\123\\TeacherApp\\lectures");
    @FXML
    private Button GoTest_Button;

    @FXML
    private Button ResultsAll_Button;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Storage storage = StorageSingleton.getInstance();

        populateListView(Test_List,dir);
        Test_List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int selectedIndex = Test_List.getSelectionModel().getSelectedIndex();
                GoTest_Button.setOnAction(event ->{
                    try {
                        SetTest(t1,selectedIndex,storage.getUserId());
                        storage.setNameTest(t1);
                        storage.setTestId(selectedIndex);
                        getQuestion(selectedIndex);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    LoginApplication.getNavigation().load(ControllerTest1.URL_FXML).Show();
                });
            }
        });
        lectorButton.setOnAction(event -> {
            LoginApplication.getNavigation().load(ControllerApp_student.URL_FXML).Show();

        });
        SingOut_Button.setOnAction(event -> {
            LoginApplication.getNavigation().load(ControllerLogin.URL_FXML).Show();
        });
        Results_Button.setOnAction(event -> {
            LoginApplication.getNavigation().load(ControllerResult.URL_FXML).Show();
        });
        ResultsAll_Button.setOnAction(event -> {
            LoginApplication.getNavigation().load(ControllerResultAll.URL_FXML).Show();
        });

    }

    @FXML
    void initialize(){

    }

    private void SetTest(String name,int testId, int userid) {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Timestamp date = new Timestamp(System.currentTimeMillis());
        Test test = new Test(name,date,userid,testId);
        dbHandler.setTest(test);
    }

    public void getQuestion(int testId) throws SQLException {
        Storage storage = StorageSingleton.getInstance();
        DatabaseHandler dbHandler = new DatabaseHandler();
        Question question =new Question();
        question.setTest_ID(testId);
        ResultSet rs = dbHandler.getQuestions(question);
        String[] quest = new String[5];
        String[] answer = new String[5];
        String[] correct = new String[5];
        int i=0;
        while (rs.next()&& i!=5){
            quest[i]=rs.getString("questions");
            answer[i]=rs.getString("answer");
            correct[i]=rs.getString("correct");
            i++;

        }
        System.out.println(Arrays.toString(quest));
        storage.setQuestions(quest);
        storage.setAnswers(answer);
        storage.setCorrect(correct);
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



}
