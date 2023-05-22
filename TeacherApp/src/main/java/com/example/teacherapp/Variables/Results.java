package com.example.teacherapp.Variables;

public class Results {
    private int correctAnswers;

    public Results() {
        correctAnswers = 0;
    }

    public void addAnswer(boolean isCorrect) {
        if (isCorrect) {
            correctAnswers++;
        }
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }
}
