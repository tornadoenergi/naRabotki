package com.example.teacherapp.controllers;

import com.example.teacherapp.DataBase.DatabaseHandler;
import com.example.teacherapp.Storage.Storage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerTeacherTestApp extends BaseController implements Initializable {
    public static final String URL_FXML= "teacherTestApp.fxml";

    @FXML
    private Button Back_Button;

    @FXML
    private Button SingOut_Button;

    @FXML
    private TableView<ObservableList<String>> Table_students;

    @Override
    void initialize() throws SQLException {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getStudResult();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getStudResult() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet rs = dbHandler.GetResultForTeacher();

        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(rs.getMetaData().getColumnName(i + 1));
            column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(j)));

            Table_students.getColumns().add(column);
        }

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        while (rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }
        Table_students.setItems(data);

    }
}
