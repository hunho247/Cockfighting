/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import support.BtnCss;
import getway.AuthGetway;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class HomeController implements Initializable {

    @FXML
    private StackPane mainContent;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnMatch;
    @FXML
    private Button btnInformation;
    @FXML
    private Button btnSetting;

    BtnCss css = new BtnCss();
    User user = new User();
    AuthGetway auth = new AuthGetway();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = auth.getUser();

        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/search/Search.fxml")));
            homeActive();
            Platform.runLater(() -> {
                user = auth.getUser();
            });
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homeOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Gochoi");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/search/Search.fxml")));
            homeActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void matchOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Gochoi");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/match/NewMatch.fxml")));
            matchActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void informationOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Gochoi");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/information/Information.fxml")));
            informationActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void settingOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Gochoi");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Setting.fxml")));
            settingActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("Gachoi");
        stage.show();

        Stage nStage = (Stage) mainContent.getScene().getWindow();
        nStage.close();
    }

    private void homeActive() {
        btnHome.setStyle(css.homeActive);
        btnMatch.setStyle("");
        btnInformation.setStyle("");
        btnSetting.setStyle("");
    }
    
    private void matchActive() {
        btnMatch.setStyle(css.homeActive);
        btnHome.setStyle("");
        btnInformation.setStyle("");
        btnSetting.setStyle("");
    }

    private void informationActive() {
        btnInformation.setStyle(css.homeActive);
        btnHome.setStyle("");
        btnMatch.setStyle("");
        btnSetting.setStyle("");
    }

    private void settingActive() {
        btnSetting.setStyle(css.settingActive);
        btnHome.setStyle("");
        btnMatch.setStyle("");
        btnInformation.setStyle("");
    }
}
