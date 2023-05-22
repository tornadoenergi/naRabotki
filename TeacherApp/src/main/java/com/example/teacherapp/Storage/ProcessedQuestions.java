package com.example.teacherapp.Storage;

import java.util.ArrayList;
import java.util.List;

public class ProcessedQuestions {
    public static List<String> processedQuestions = new ArrayList<>();
    public static int TestID;

    public static String getTextQuest() {
        return TextQuest;
    }

    public static void setTextQuest(String textQuest) {
        TextQuest = textQuest;
    }

    public static String TextQuest;
    public static boolean contains(String question) {
        return processedQuestions.contains(question);
    }

    public static void add(String question) {
        processedQuestions.add(question);
    }
}