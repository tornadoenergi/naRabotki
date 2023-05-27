package com.example.teacherapp.Storage;

public class Storage {
    private String[] Questions= new String[5];
    private int givenCorrect;
    private int UserId;
    private int TestId;
    private String[] Answers = new String[5];
    private String[] Correct = new String[5];
    private String NameTest;
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = userId;
    }

    public String getAnswers(int i) {
        return Answers[i];
    }

    public void setAnswers(String[] answers) {
        Answers = answers;
    }

    public String getCorrect(int i) {
        return Correct[i];
    }

    public void setCorrect(String[] correct) {
        Correct = correct;
    }

    public String getQuestions(int i) {
        return Questions[i];
    }

    public void setQuestions(String[] Questions) {
        this.Questions= Questions;
    }
    public int getTestId() {
        return TestId;
    }

    public void setTestId(int testId) {
        TestId = testId;
    }

    public String getNameTest() {
        return NameTest;
    }

    public void setNameTest(String nameTest) {
        NameTest = nameTest;
    }

    public String getGivenCorrect() {
        return String.valueOf(givenCorrect);
    }

    public void setGivenCorrect(int givenCorrect) {
        this.givenCorrect = givenCorrect;
    }
}
