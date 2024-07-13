package com.example.project1.controller;

import com.example.project1.HelloApplication;
import com.example.project1.bo.BOFactory;
import com.example.project1.bo.custom.LoginBO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);

    @FXML
    private void onLoginButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (loginBO.isLogin(username, password)) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainDashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 682, 115);
                Stage stage = new Stage();
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
                Stage currentStage = (Stage) usernameField.getScene().getWindow();
                currentStage.close();
                displayAlert("Login Successful", "Welcome, " + username + "!");
            } else {
                displayAlert("Login Failed", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            displayAlert("Login Failed", "An error occurred.");
        }
    }

    @FXML
    private void onRegisterButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistrationView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.close();
    }

    private void displayAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
