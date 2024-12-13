package com.example.szamologep;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField num1Field;

    @FXML
    private TextField num2Field;

    @FXML
    private Label resultLabel;

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Beviteli hiba");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validateInputs() {
        if (num1Field.getText().isEmpty() || num2Field.getText().isEmpty()) {
            showAlert("Minden mező kitöltése kötelező!");
            return false;
        }
        try {
            Double.parseDouble(num1Field.getText());
            Double.parseDouble(num2Field.getText());
        } catch (NumberFormatException e) {
            showAlert("Csak számot adhat meg.");
            return false;
        }
        return true;
    }

    @FXML
    private void add() {
        if (validateInputs()) {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultLabel.setText("Eredmény: " + (num1 + num2));
        }
    }

    @FXML
    private void subtract() {
        if (validateInputs()) {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultLabel.setText("Eredmény: " + (num1 - num2));
        }
    }

    @FXML
    private void multiply() {
        if (validateInputs()) {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            resultLabel.setText("Eredmény: " + (num1 * num2));
        }
    }

    @FXML
    private void divide() {
        if (validateInputs()) {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            if (num2 == 0) {
                showAlert("Nullával nem osztható.");
            } else {
                resultLabel.setText("Eredmény: " + (num1 / num2));
            }
        }
    }

    @FXML
    private void modulus() {
        if (validateInputs()) {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            if (num2 == 0) {
                showAlert("Nullával nem osztható.");
            } else {
                resultLabel.setText("Eredmény: " + (num1 % num2));
            }
        }
    }
}
