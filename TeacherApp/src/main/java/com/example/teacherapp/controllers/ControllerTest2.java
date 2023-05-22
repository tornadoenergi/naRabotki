package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Variables.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ControllerTest2 {
    String correct = null;
    @FXML
    private Button NextButton;

    @FXML
    private RadioButton answer_radio_1;

    @FXML
    private RadioButton answer_radio_2;

    @FXML
    private RadioButton answer_radio_3;

    @FXML
    private RadioButton answer_radio_4;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Label question_text;
    void initialize(){
        NextButton.setOnAction(event ->{
            answers.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == answer_radio_1) {
                    answer_radio_1.getText();

                } else if (newValue == answer_radio_2) {

                } else if (newValue == answer_radio_3) {

                } else if (newValue == answer_radio_4) {

                }
            });
            OpenNewScene("");

        });


    }

    public void OpenNewScene(String window){
        NextButton.getScene().getWindow().hide();

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
    public void getAnswerType(int testId, List<String> processedQuestions) {
        int answerCount = showAnswer(testId,processedQuestions);

        if (answerCount == 4) {
            OpenNewScene("/com/example/teacherapp/test2.fxml"); // Другое
        } else if (answerCount == 2) {
            OpenNewScene("/com/example/teacherapp/test1.fxml"); // 3 окно
        } else if (answerCount == 1) {
            OpenNewScene("/com/example/teacherapp/test3.fxml");
        }
    }
    public int showAnswer( int testId,List<String> processedQuestions){
        String question = null;
        String[] answers = new String[4];
        int answerCount = 0;

        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Question question1 = new Question();
            question1.setTest_ID(testId);
            // Поиск вопроса по testId
            System.out.println(processedQuestions);
            ResultSet rs = dbHandler.getQuestion(question1);
            while (rs.next()) {
                if (rs.next()) {
                    question = rs.getString("questions");
                } else {
                    return -1; // Тест с таким id не найден
                }

                // Проверка, был ли уже обработан данный вопрос
                if (processedQuestions.contains(question)) {
                    continue; // Вопрос уже обработан
                } else {
                    processedQuestions.add(question); // Добавляем в список обработанных
                }
                question1.setText_question(question);
            }
            // Поиск ответов по testId и вопросу
            rs = dbHandler.getQuest(question1);
            while (rs.next()) {
                answers[answerCount++] = rs.getString("answer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerCount;
    }
   //public void ShowQuestion(Integer testID) throws SQLException {
   //    DatabaseHandler dbHandler = new DatabaseHandler();

   //    Question question = new Question();
   //    question.setTest_ID(testID);
   //    ResultSet result = dbHandler.getQuestion(question);
   //    int i = 0;
   //    String[] answer = new String[4];
   //    try {
   //        while (result.next()){
   //            question_text.setText(result.getString("questions"));
   //            correct = result.getString("correct");
   //            System.out.println(correct);
   //            answer[i] = result.getString("answer");
   //            i++;

   //        }

   //    }catch (SQLException e){
   //        e.printStackTrace();
   //    }
   //    answer_radio_1.setText(answer[0]);
   //    answer_radio_2.setText(answer[1]);
   //    answer_radio_3.setText(answer[2]);
   //    answer_radio_4.setText(answer[3]);

   // }
    //String[] answer = new String[counter];
    //        while (result.next()) {
    //    answer[number] = result.getString("answer");
//
    //    number++;
    //}
}
