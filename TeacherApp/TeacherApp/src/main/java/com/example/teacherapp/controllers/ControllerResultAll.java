package com.example.teacherapp.controllers;

import com.example.teacherapp.Const;
import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.LoginApplication;
import com.example.teacherapp.Storage.Storage;
import com.example.teacherapp.Storage.StorageSingleton;
import com.example.teacherapp.Variables.Result;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ControllerResultAll extends BaseController implements Initializable {
    public static final String URL_FXML ="resultAll.fxml";

    String dir = ("C:\\Users\\admin\\Desktop\\TeacherApp\\lectures");
    @FXML
    private Button Button_back;
    @FXML
    private Text Result1;

    @FXML
    private Text Result2;

    @FXML
    private Text Result3;

    @FXML
    private Text Result4;

    @FXML
    private Text Result5;

    @FXML
    private Text Result6;

    @FXML
    private Text Test1;
    @FXML
    private Text Test2;

    @FXML
    private Text Test3;

    @FXML
    private Text Test4;

    @FXML
    private Text Test5;

    @FXML
    private Text Test6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            GetTestName(dir);
            getResults();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button_back.setOnAction(event ->{
            LoginApplication.getNavigation().load(ControllerTestsApp_student.URL_FXML).Show();
        });
    }
    @FXML
    void initialize() throws SQLException {

    }

    public void getResults() throws SQLException {
        Storage storage = StorageSingleton.getInstance();
        DatabaseHandler dbHandler = new DatabaseHandler();
        int[] resul = new int[6];
        int[] testID = new int[6];
        int i=0;

        Result result1 = new Result(storage.getUserId());
        ResultSet result = dbHandler.GetResult(result1);
        while (result.next()){
            resul[i]= result.getInt(Const.RESULT_CORRECT);
            testID[i] = result.getInt(Const.RESULT_TEST_ID);
            i++;
        }
        Pair<Integer, Integer>[] pairs = new Pair[testID.length];
        for ( i = 0; i < testID.length; i++) {
            pairs[i] = new Pair<>(testID[i], i);
        }

// сортируем пары по первому элементу
        Arrays.sort(pairs, Comparator.comparing(Pair::getKey));

// обновляем индексы элементов во втором массиве
        for ( i = 0; i < pairs.length; i++) {
            int oldIndex = pairs[i].getValue();
            int newIndex = i;
            resul[oldIndex] = resul[pairs[newIndex].getValue()];
        }
        for (int j = 0; j<6;j++) {
            if (testID[j] == 0) {
                Result1.setText(String.valueOf(resul[0]));
            }
            if (testID[j] == 1) {
                Result2.setText(String.valueOf(resul[1]));
            }
            if (testID[j] == 2) {
                Result3.setText(String.valueOf(resul[2]));
            }
            if (testID[j] == 3) {
                Result4.setText(String.valueOf(resul[3]));
            }
            if (testID[j] == 4) {
                Result5.setText(String.valueOf(resul[4]));
            }
            if (testID[j] == 5) {
                Result6.setText(String.valueOf(resul[5]));
            }

        }



    }


    public void GetTestName( String dir) {
        File folder = new File(dir);
        File[] files = folder.listFiles();
        String[] mdFiles = new String[6];
        int i = 0;
        assert files != null;
        for (File file : files) {
            if (file.getName().endsWith(".md")) {
                String fileName = file.getName();
                String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
                mdFiles[i]=nameWithoutExtension;
                i++;

            }
        }
        Test1.setText(mdFiles[0]+ " : ");
        Test2.setText(mdFiles[1]+ " : ");
        Test3.setText(mdFiles[2]+ " : ");
        Test4.setText(mdFiles[3]+ " : ");
        Test5.setText(mdFiles[4]+ " : ");
        Test6.setText(mdFiles[5]+ " : ");
    }


}
