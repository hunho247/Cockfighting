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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnLogin;

    AuthGetway auth = new AuthGetway();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) {
        if (isValid()) {
            if (auth.authenticate(tfUserName.getText(), pfPassword.getText())) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
                    //root.getStylesheets().add("../css/main.css");
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("Gachoi");
                    stage.setScene(scene);
                    stage.show();

                    Stage nStage = (Stage) btnLogin.getScene().getWindow();
                    nStage.close();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("\u0054\u0068\u00f4\u006e\u0067 \u0062\u00e1\u006f");
                alert.setHeaderText("\u0054\u00e0\u0069 \u006b\u0068\u006f\u1ea3\u006e \u0076\u00e0 \u006d\u1ead\u0074 \u006b\u0068\u1ea9\u0075 \u006b\u0068\u00f4\u006e\u0067 \u0068\u1ee3\u0070 \u006c\u1ec7\u002e");
                alert.show();
            }
        }
    }

    @FXML
    private void hlForgetPassword(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/auth/ForgetPassword.fxml"));
            //root.getStylesheets().add("../css/main.css");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Gachoi");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isValid() {
        boolean valid = false;
        if (tfUserName.getText().isEmpty() || pfPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("\u0054\u0068\u00f4\u006e\u0067 \u0062\u00e1\u006f");
            alert.setHeaderText("\u0056\u0075\u0069 \u006c\u00f2\u006e\u0067 \u006e\u0068\u1ead\u0070 \u0111\u1ea7\u0079 \u0111\u1ee7 \u0076\u00e0 \u0063\u0068\u00ed\u006e\u0068 \u0078\u00e1\u0063 \u0074\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u0074\u00e0\u0069 \u006b\u0068\u006f\u1ea3\u006e\u002e");
            alert.show();
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

}
