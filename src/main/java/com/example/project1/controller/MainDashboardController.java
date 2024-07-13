package com.example.project1.controller;

import com.example.project1.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    @FXML
    private Label lblContent;

    @FXML
    private void onStock() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StocksOverview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 342, 497);
        Stage stage = new Stage();
        stage.setTitle("Manage Stocks");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void onTrade() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("showorders.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 342, 497);
        Stage stage = new Stage();
        stage.setTitle("Manage Stocks");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void onAccount() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccountsManagement1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 342, 497);
        Stage stage = new Stage();
        stage.setTitle("Manage Stocks");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void onPrediction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AccountsManagement1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 342, 497);
        Stage stage = new Stage();
        stage.setTitle("Manage Stocks");
        stage.setScene(scene);
        stage.show();

    }



}
