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
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class SettingController implements Initializable {

	@FXML
	private TextField tfUserName;
	@FXML
	private PasswordField tfOldPassword;
	@FXML
	private PasswordField tfNewPassword;
	@FXML
	private PasswordField tfNewPassword2;

	AuthGetway auth = new AuthGetway();

	User user = new User();

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		tfUserName.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					if (!newValue.isEmpty()) {
						if (!newValue.matches("^[^\\d\\s]+$")) {
							tfUserName.setText(oldValue);
						}
					}
				});

		Platform.runLater(() -> {
			loadAuthUser();
		});
	}

	@FXML
	private void handleUpdateInformation(ActionEvent event) throws IOException {
		if (user.getPassword().equals(tfOldPassword.getText())
				&& tfNewPassword.getText().equals(tfNewPassword2.getText()) && !tfUserName.getText().isEmpty()
				&& !tfNewPassword.getText().isEmpty() && !tfNewPassword2.getText().isEmpty()) {
			
			user.setUserName(tfUserName.getText());
			user.setPassword(tfNewPassword.getText());
			auth.updateUser(user);
			
			tfOldPassword.clear();
			tfNewPassword.clear();
			tfNewPassword2.clear();
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText(
					"\u0054\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u0074\u00e0\u0069 \u006b\u0068\u006f\u1ea3\u006e \u0111\u00e3 \u0111\u01b0\u1ee3\u0063 \u0063\u1ead\u0070 \u006e\u0068\u1ead\u0074 \u0074\u0068\u00e0\u006e\u0068 \u0063\u00f4\u006e\u0067\u002e");
			alert.showAndWait();
		} else {
			tfOldPassword.clear();
			tfNewPassword.clear();
			tfNewPassword2.clear();
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText("\u0056\u0075\u0069 \u006c\u00f2\u006e\u0067 \u006e\u0068\u1ead\u0070 \u0111\u1ea7\u0079 \u0111\u1ee7 \u0076\u00e0 \u0063\u0068\u00ed\u006e\u0068 \u0078\u00e1\u0063 \u0074\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u0074\u00e0\u0069 \u006b\u0068\u006f\u1ea3\u006e\u002e");
			alert.showAndWait();
		}
	}

	void loadAuthUser() {
		user = auth.getUser();
		tfUserName.setText(user.getUserName());
	}

	boolean setSelected(int value) {
		boolean selected;
		selected = value == 1;
		return selected;
	}
}
