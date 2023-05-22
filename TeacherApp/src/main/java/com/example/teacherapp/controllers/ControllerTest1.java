package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Storage.ProcessedQuestions;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Question;
import com.example.teacherapp.Variables.Results;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.teacherapp.Storage.ProcessedQuestions.*;

public class ControllerTest1 {


    String correct = null;

    @FXML
    private Button NextButton;

    @FXML
    private RadioButton RadioButtonNo;

    @FXML
    private RadioButton RadioButtonYes;

    @FXML
    private Label TextQuestion;

    @FXML
    private ToggleGroup answers;

    @FXML
    void initialize() throws SQLException {
        Storage storage = StorageSingleton.getInstance();
        ShowQuestion(TestID,TextQuest);
        NextButton.setOnAction(event ->{
            String selectedAnswer = ((RadioButton) answers.getSelectedToggle()).getText();
            try {
                Resul(selectedAnswer,TestID,TextQuest,storage);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            getAnswerType(TestID, processedQuestions,storage);
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
        stage.setTitle("Тест ");
        stage.showAndWait();

    }
    public void ShowQuestion(int testID, String text) {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Question question = new Question();
        question.setTest_ID(testID);
        question.setText_question(text);
        ResultSet result = dbHandler.getQuest(question);

        List<String> Answer = new ArrayList<String>();

        try {
            while (result.next()){
                TextQuestion.setText(text);
                //correct = result.getString("correct");

                Answer.add(result.getString("answer"));
                //System.out.println(Answer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        RadioButtonYes.setText(Answer.get(0));
        RadioButtonNo.setText(Answer.get(1));
    }
    public void getAnswerType(int testId, List<String> processedQuestions, Storage storage) {
        String question = null;
        String[] answers = new String[4];
        int answerCount = 0;

        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Question question1 = new Question();
            question1.setTest_ID(testId);
            // Поиск вопроса по testId
            ResultSet rs = dbHandler.getQuestion(question1);
            while (rs.next()) {
                if (rs.next()) {
                    question = rs.getString("questions");
                } else {
                    // Нет новых вопросов, вызываем метод для получения результата
                    // в зависимости от количества правильных ответов в тесте

                    return;
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
            ProcessedQuestions.setTextQuest(question);
            rs = dbHandler.getQuest(question1);
            while (rs.next()) {
                answers[answerCount++] = rs.getString("answer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

// Если не было получено новых вопросов, мы уже вызвали метод getTestResult() выше
        if (processedQuestions.size()==4)
            OpenNewScene("/com/example/teacherapp/result.fxml");


        if (question != null) {
            // Продолжаем обработку вопроса
            if (answerCount == 4) {
                OpenNewScene("/com/example/teacherapp/test2.fxml"); // Другое
            } else if (answerCount == 2) {
                OpenNewScene("/com/example/teacherapp/test1.fxml"); // 3 окно
            } else if (answerCount == 1) {
                OpenNewScene("/com/example/teacherapp/test3.fxml");
            }
        }
    }

    private void Resul(String answer, int testID, String text, Storage storage) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Results results = new Results();
        Question question = new Question();
        question.setTest_ID(testID);
        question.setText_question(text);
        ResultSet result = dbHandler.getCorrect(question);
        String correct = null;

        while (result.next()){
            correct = result.getString("correct");
        }
        if (correct !=null){
            results.addAnswer(Objects.equals(answer, correct));
            storage.setCorrect(results.getCorrectAnswers());
            System.out.println(storage.getCorrect());
        }


    }
    
}
