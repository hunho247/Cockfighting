/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import getway.AuthGetway;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class RegistrationController implements Initializable {

    @FXML
    private Button btnSignUp;
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfPass;
    @FXML
    private PasswordField pfRePass;

    AuthGetway auth = new AuthGetway();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfUserName.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty()) {
                if (!newValue.matches("^[^\\d\\s]+$")) {
                    tfUserName.setText(oldValue);
                }
            }
        });
    }

    /**
     * Sign up
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void signUpOnAction(ActionEvent event) throws IOException {
        if (isValid() && isPassMatch()) {
            auth.save(new User(tfUserName.getText(), pfPass.getText()));
            Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
            //root.getStylesheets().add("../css/main.css");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage nStage = (Stage) btnSignUp.getScene().getWindow();
            nStage.close();
        }
    }

    /**
     * Check required text field are not empty
     *
     * @return
     */
    private boolean isValid() {
        boolean valid = true;
        if (tfUserName.getText().isEmpty() || pfPass.getText().isEmpty() || pfRePass.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thi?u thông tin");
            alert.setContentText("C?n ?i?n ??y ?? thông tin tài kho?n.");
            alert.show();
            valid = false;
        }
        return valid;
    }

    /**
     * Check passwords are matched show alert if not match
     *
     * @return
     */
    private boolean isPassMatch() {
        boolean valid = false;
        if (pfPass.getText().matches(pfRePass.getText())) {
            valid = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password not match");
            alert.setHeaderText("Password not match");
            alert.show();
        }

        return valid;
    }
}
