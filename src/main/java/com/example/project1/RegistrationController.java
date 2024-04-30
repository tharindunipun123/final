package com.example.project1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField contactInfoField;

    private RegistrationModel model = new RegistrationModel();

    @FXML
    private void handleRegisterAction() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String email = emailField.getText();
        String contactInfo = contactInfoField.getText();

        if (!password.equals(confirmPassword)) {
            showAlert("Password Error", "Passwords do not match!");
            return;
        }

        if (model.registerUser(name, username, password, email, contactInfo)) {
            showAlert("Registration Successful", "User has been registered successfully.");
        } else {
            showAlert("Registration Failed", "User could not be registered.");
        }
    }

    @FXML
    private void handleBackAction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 358, 348);
        Stage stage= new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.close();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

