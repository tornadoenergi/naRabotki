package com.example.teacherapp.Variables;

import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;

public class Results {
    private int correctAnswers = 0;

    public Results() {
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
