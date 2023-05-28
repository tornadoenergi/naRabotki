package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Result;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ControllerTest1 extends BaseController implements Initializable {
    public static final String URL_FXML = "test1.fxml";

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton RadioButtonNo;

    @FXML
    private RadioButton RadioButtonYes;

    @FXML
    private Label TextQuestion;

    @FXML
    private RadioButton answer1;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private ToggleGroup answers;



    @FXML
    void initialize() throws SQLException {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Storage storage = StorageSingleton.getInstance();
        AtomicInteger cor = new AtomicInteger();
        AtomicInteger i= new AtomicInteger();
        ShowQuestion(i.get());

        NextButton.setOnAction(event -> {
            String selectedAnswer = ((RadioButton) answers.getSelectedToggle()).getText();
            if (i.get() <4) {
                String correct =storage.getCorrect(i.get());
                i.getAndIncrement();
                ShowQuestion(i.get());
                if (Objects.equals(correct, selectedAnswer)){
                    cor.getAndIncrement();
                }
                //getAnswerType(finalI, storage);
            }else {
                try {
                    Resul(storage,cor.get());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                storage.setGivenCorrect(cor.get());
                LoginApplication.getNavigation().load(ControllerResult.URL_FXML).Show();
            }
        });
    }
    public void ShowQuestion(int i) {
        Storage storage = StorageSingleton.getInstance();
        if (i<5) {
            TextQuestion.setText(storage.getQuestions(i));
            String[] answerArray = storage.getAnswers(i).split(";");
            System.out.println(Arrays.toString(answerArray));
            if (answerArray.length == 2) {
                if(RadioButtonYes.isSelected()) {
                    RadioButtonYes.setSelected(false);
                }
                RadioButtonYes.setVisible(true);
                RadioButtonYes.setText(answerArray[0]);
                RadioButtonNo.setVisible(true);
                if(RadioButtonNo.isSelected()) {
                    RadioButtonNo.setSelected(false);
                }
                RadioButtonNo.setText(answerArray[1]);
                answer1.setVisible(false);
                answer2.setVisible(false);
                answer3.setVisible(false);
                answer4.setVisible(false);
            } else if (answerArray.length == 4) {
                answer1.setVisible(true);
                answer2.setVisible(true);
                answer3.setVisible(true);
                answer4.setVisible(true);
                if(answer1.isSelected()){
                    answer1.setSelected(false);
                }
                if(answer2.isSelected()){
                    answer2.setSelected(false);
                }
                if(answer3.isSelected()){
                    answer3.setSelected(false);
                }
                if(answer4.isSelected()){
                    answer4.setSelected(false);
                }
                answer1.setText(answerArray[0]);
                answer2.setText(answerArray[1]);
                answer3.setText(answerArray[2]);
                answer4.setText(answerArray[3]);
                RadioButtonNo.setVisible(false);
                RadioButtonYes.setVisible(false);
                System.out.println(Arrays.toString(answerArray));
            }

        }
    }

    private void Resul(Storage storage,int Resultat) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        int TestID =storage.getTestId();
        int UserID =storage.getUserId();
        String NameTest = storage.getNameTest();
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String FirstName = storage.getFirstName();
        String LastName = storage.getLastName();

        Result result = new Result(UserID,TestID,Resultat,FirstName,LastName,date,NameTest);
        Result result1 = new Result(UserID,TestID,Resultat);
        ResultSet rs = dbHandler.GetResultat(result1);
        try {
            if (rs.next()){dbHandler.SetNewResult(result);}
            else {dbHandler.SetResult(result);}
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
