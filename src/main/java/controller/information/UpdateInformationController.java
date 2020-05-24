/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.information;

import getway.InformationGetway;
import java.io.IOException;
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
public class UpdateInformationController implements Initializable {

    @FXML
    private Label lbInformation;
    @FXML
    private TextField tfInformation;

    InformationGetway informationGetway = new InformationGetway();
    Information information = new Information();

    private String tableName;
    private String dataRow;
    private InformationController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void shutdown() {
        mainController.loaInformation();
    }

    @FXML
    private void cancelOnAction(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deleteOnAction(ActionEvent event) {
        if (informationGetway.delete(tableName, dataRow)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
            alert.setHeaderText("\u0054\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u0020\u0111\u00e3\u0020\u0111\u01b0\u1ee3\u0063\u0020\u0078\u00f3\u0061\u002e");
            alert.showAndWait();
        }
    }

    public void setData(String lable, String tableName, String row, InformationController controller) {
        lbInformation.setText(lable);
        this.tableName = tableName;
        this.dataRow = row;
        tfInformation.setText(row);
        mainController = controller;
    }
}
