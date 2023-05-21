package com.example.teacherapp.Variables;

public class Question {
    private Integer Test_ID;
    private Integer Test_Question_ID;
    private String Text_question;
    private String answer;
    private String answer2;
    private String answer3;
    private String answer4;

    public Question(Integer test_ID, Integer test_Question_ID, String text_question, String answer, String answer2, String answer3, String answer4) {
        Test_ID = test_ID;
        Test_Question_ID = test_Question_ID;
        Text_question = text_question;
        this.answer = answer;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public Question(Integer test_ID, Integer test_Question_ID, String text_question) {
        Test_ID = test_ID;
        Test_Question_ID = test_Question_ID;
        Text_question = text_question;
    }

    public Question(String text_question, String answer, String answer2) {
        Text_question = text_question;
        this.answer = answer;
        this.answer2 = answer2;
    }

    public Question(){

    }

    public Integer getTest_Question_ID() {
        return Test_Question_ID;
    }

    public void setTest_Question_ID(Integer test_Question_ID) {
        Test_Question_ID = test_Question_ID;
    }

    public Integer getTest_ID() {
        return Test_ID;
    }

    public void setTest_ID(Integer test_ID) {
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
