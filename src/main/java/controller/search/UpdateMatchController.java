/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import getway.MatchGetway;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Match;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class UpdateMatchController implements Initializable {

	@FXML
	private TextField tfLoaiga;
	@FXML
	private TextField tfMauao;
	@FXML
	private TextField tfMauquan;
	@FXML
	private TextField tfMaunon;
	@FXML
	private TextField tfSanchoi;
	@FXML
	private TextField tfKetqua;
	@FXML
	private TextField tfThongtinthem;
	@FXML
	private ImageView imgCockfighting;

	MatchGetway matchGetway = new MatchGetway();
	// Information information = new Information();

	private int idRow = 0;
	private SearchController mainController;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public void shutdown() {
		mainController.loadInformation();
	}

	@FXML
	private void cancelOnAction(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		final Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void deleteOnAction(ActionEvent event) {
		if (matchGetway.delete(idRow)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText(
					"\u0054\u0068\u00f4\u006e\u0067\u0020\u0074\u0069\u006e\u0020\u0111\u00e3\u0020\u0111\u01b0\u1ee3\u0063\u0020\u0078\u00f3\u0061\u002e");
			alert.showAndWait();
		}
	}

	public void setData(String lable, Match match, SearchController controller) {

		idRow = match.getId();

		tfLoaiga.setText(match.getLoaiga());
		tfMauao.setText(match.getMauao());
		tfMauquan.setText(match.getMauquan());
		tfMaunon.setText(match.getMaunon());
		tfSanchoi.setText(match.getSanchoi());
		tfKetqua.setText(match.getKetqua());
		tfThongtinthem.setText(match.getThongtinthem());

		if (match.getHinhanh() != null) {
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream(match.getHinhanh());
				Image image = SwingFXUtils.toFXImage(ImageIO.read(bis), null);
				imgCockfighting.setImage(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		mainController = controller;
	}
}
