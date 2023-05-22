package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.ProcessedQuestions;
import com.example.teacherapp.Variables.Question;
import com.example.teacherapp.Variables.Result;
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

import static com.example.teacherapp.ProcessedQuestions.processedQuestions;

public class ControllerTest1 {
    int TestID;

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int testID) {
        TestID = testID;
    }
    String QuestionText;

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String question) {
        QuestionText = question;
    }

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
        Results results = new Results();
        ShowQuestion(TestID);
        NextButton.setOnAction(event ->{
            getAnswerType(TestID, processedQuestions);
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
    public void ShowQuestion(int testID) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Question question = new Question();
        question.setTest_ID(testID);
        question.setText_question(QuestionText);
        ResultSet result = dbHandler.getQuestions(question);

        List<String> Answer = new ArrayList<String>();

        try {
            while (result.next()){
                TextQuestion.setText(result.getString("questions"));
                correct = result.getString("correct");

                Answer.add(result.getString("answer"));
                //System.out.println(Answer);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        RadioButtonYes.setText(Answer.get(0));
        RadioButtonNo.setText(Answer.get(1));


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
            //System.out.println(answers);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answerCount;
    }
    //public void checkCorrect(String value) throws SQLException {
        //    DatabaseHandler dbHandler = new DatabaseHandler();
        //    Question question = new Question();
        //    question.setTest_ID(TestID);
        //    question.setText_question(Test_text.getText());
        //    question.setCorrect(value);
        //    ResultSet result = dbHandler.getQuestion(question);

        //    while (result.next()){
            //        Correct correct = new Correct()
                    //    }
        //}
    // public ControllerTest1(int TestId){
        //     TestID = TestId;
        // }
}
