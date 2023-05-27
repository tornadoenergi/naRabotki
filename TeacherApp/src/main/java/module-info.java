module com.example.teacherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    requires java.desktop;


    opens com.example.teacherapp to javafx.fxml;
    exports com.example.teacherapp;
    exports com.example.teacherapp.controllers;
    opens com.example.teacherapp.controllers to javafx.fxml;
    exports com.example.teacherapp.Variables;
    opens com.example.teacherapp.Variables to javafx.fxml;
    exports com.example.teacherapp.DataBase;
    opens com.example.teacherapp.DataBase to javafx.fxml;
    exports com.example.teacherapp.Storage;
    opens com.example.teacherapp.Storage to javafx.fxml;
}