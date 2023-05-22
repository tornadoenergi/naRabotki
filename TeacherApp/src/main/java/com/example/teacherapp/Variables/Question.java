package com.example.teacherapp.Variables;

public class Question {
    private int Test_ID;
    private int Test_Question_ID;
    private String Text_question;
    private String correct;
    private String answer;
    private String answer2;
    private String answer3;
    private String answer4;

    public Question(int test_ID, int test_Question_ID, String text_question, String answer, String answer2, String answer3, String answer4) {
        Test_ID = test_ID;
        Text_question = text_question;
        this.answer = answer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public Question(int test_ID) {
        Test_ID = test_ID;
    }

    public Question(int test_ID, String text_question, String answer, String answer2) {
        Test_ID = test_ID;
        Text_question = text_question;
        this.answer = answer;
        this.answer2 = answer2;
    }

    public Question(){

    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public int getTest_Question_ID() {
        return Test_Question_ID;
    }

    public void setTest_Question_ID(int test_Question_ID) {
        Test_Question_ID = test_Question_ID;
    }

    public int getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(int test_ID) {
        Test_ID = test_ID;
    }

    public String getText_question() {
        return Text_question;
    }

    public void setText_question(String text_question) {
        Text_question = text_question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
}
