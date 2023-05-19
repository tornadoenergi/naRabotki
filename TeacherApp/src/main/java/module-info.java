module com.example.teacherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires poi.ooxml;
    requires com.aspose.words;


    opens com.example.teacherapp to javafx.fxml;
    exports com.example.teacherapp;
    exports com.example.teacherapp.controllers;
    opens com.example.teacherapp.controllers to javafx.fxml;
}