module com.example.project1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.project1 to javafx.fxml;
    exports com.example.project1;
    exports com.example.project1.controller;
    opens com.example.project1.controller to javafx.fxml;
    exports com.example.project1.model;
    opens com.example.project1.model to javafx.fxml;
    exports com.example.project1.db;
    opens com.example.project1.db to javafx.fxml;
}