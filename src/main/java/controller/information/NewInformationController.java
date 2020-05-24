/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.information;

import getway.InformationGetway;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Information;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class NewInformationController implements Initializable {

    @FXML
    private Label lbInformation;
    @FXML
    private TextField tfInformation;

    InformationGetway informationGetway = new InformationGetway();
    Information information = new Information();

    private String tableName;
    private InformationController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancelOnAction(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void saveOnAction(ActionEvent event) {
        if (isVliadForm()) {
            if (informationGetway.insert(tableName, tfInformation.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
                alert.setHeaderText("\u0110\u00e3\u0020\u0074\u0068\u00ea\u006d\u0020\u0074\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u002e");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
                alert.setHeaderText("\u0054\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u0020\u0111\u00e3\u0020\u0074\u1ed3\u006e\u0020\u0074\u1ea1\u0069\u002c\u0020\u0076\u0075\u0069\u0020\u006c\u00f2\u006e\u0067\u0020\u006e\u0068\u1ead\u0070\u0020\u0074\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u0020\u006b\u0068\u00e1\u0063\u002e");
                alert.showAndWait();
            }
        }
    }

    public void shutdown() {
        mainController.loaInformation();
    }

    public void setData(String lable, String tableName, InformationController controller) {
        lbInformation.setText(lable);
        this.tableName = tableName;
        mainController = controller;
    }

    private boolean isVliadForm() {
        if (tfInformation.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
            alert.setHeaderText("\u0056\u0075\u0069\u0020\u006c\u00f2\u006e\u0067\u0020\u006e\u0068\u1ead\u0070\u0020\u0074\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u0020\u0111\u01b0\u1ee3\u0063\u0020\u0079\u00ea\u0075\u0020\u0063\u1ea7\u0075");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
