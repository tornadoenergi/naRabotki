package com.example.teacherapp;

import java.util.ArrayList;
import java.util.List;

public class ProcessedQuestions {
    public static List<String> processedQuestions = new ArrayList<>();
    public static int TestID;
    public static boolean contains(String question) {
        return processedQuestions.contains(question);
    }

    public static void add(String question) {
        processedQuestions.add(question);
    }
}