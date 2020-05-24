/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.match;

import getway.InformationGetway;
import getway.MatchGetway;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.Information;
import model.Match;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class NewMatchController implements Initializable {

	@FXML
	private ComboBox<Information> tfLoaiga;
	@FXML
	private ComboBox<Information> tfMauao;
	@FXML
	private ComboBox<Information> tfMauquan;
	@FXML
	private ComboBox<Information> tfMaunon;
	@FXML
	private ComboBox<Information> tfSanchoi;
	@FXML
	private ComboBox<Information> tfKetqua;
	@FXML
	private TextField tfThongtinthem;
	@FXML
	private ImageView imgCockfighting;

	InformationGetway informationGetway = new InformationGetway();
	MatchGetway matchGetway = new MatchGetway();

	ByteArrayOutputStream imageByteStream = null;

	File file = null;
	File copyFile = null;
	FileChooser chooser = new FileChooser();
	FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	String path = System.getProperty("user.home");

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Platform.runLater(() -> {
			loadInformation();
		});

	}

	@FXML
	private void saveMatch(ActionEvent event) {
		// Lock
		if (matchGetway.totalMatch() > 9) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText(
					"\u0050\u0068\u1ea7\u006e \u006d\u1ec1\u006d \u0064\u00f9\u006e\u0067 \u0074\u0068\u1eed\u002c \u0063\u0068\u1ec9 \u0063\u0068\u006f \u0070\u0068\u00e9\u0070 \u0074\u0068\u00ea\u006d \u0074\u1ed1\u0069 \u0111\u0061 \u0031\u0030 \u0074\u0072\u1ead\u006e \u0111\u1ea5\u0075\u002e \u0056\u0075\u0069 \u006c\u00f2\u006e\u0067 \u006c\u0069\u00ea\u006e \u0068\u1ec7\u003a \u0030\u0039\u0033\u0032\u0035\u0036\u0032\u0032\u0036\u0032 \u0028\u0048\u01b0\u006e\u0067\u0029");
			alert.showAndWait();
			return;
		}

		if (!tfLoaiga.getSelectionModel().isEmpty() && !tfMauao.getSelectionModel().isEmpty()
				&& !tfMauquan.getSelectionModel().isEmpty() && !tfMaunon.getSelectionModel().isEmpty()
				&& !tfSanchoi.getSelectionModel().isEmpty() && !tfKetqua.getSelectionModel().isEmpty()
				&& !tfThongtinthem.getText().isEmpty() && imageByteStream != null) {
			Match match = new Match();
			match.setLoaiga(tfLoaiga.getValue().getName());
			match.setMauao(tfMauao.getValue().getName());
			match.setMauquan(tfMauquan.getValue().getName());
			match.setMaunon(tfMaunon.getValue().getName());
			match.setSanchoi(tfSanchoi.getValue().getName());
			match.setKetqua(tfKetqua.getValue().getName());
			match.setThongtinthem(tfThongtinthem.getText());
			match.setHinhanh(imageByteStream.toByteArray());

			matchGetway.insert(match);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText(
					"\u0110\u00e3 \u006c\u01b0\u0075 \u0074\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u0074\u0072\u1ead\u006e \u0111\u1ea5\u0075\u002e");
			alert.showAndWait();

			tfLoaiga.getSelectionModel().clearSelection();
			tfMauao.getSelectionModel().clearSelection();
			tfMauquan.getSelectionModel().clearSelection();
			tfMaunon.getSelectionModel().clearSelection();
			tfSanchoi.getSelectionModel().clearSelection();
			tfKetqua.getSelectionModel().clearSelection();
			tfThongtinthem.clear();

			Image image = new Image("@../../image/no-image.png", 700, 700, false, false);
			imgCockfighting.setImage(image);
			imageByteStream = null;
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("\u0054\u0068\u00f4\u006e\u0067\u0020\u0062\u00e1\u006f");
			alert.setHeaderText(
					"\u0056\u0075\u0069 \u006c\u00f2\u006e\u0067 \u006e\u0068\u1ead\u0070 \u0111\u1ea7\u0079 \u0111\u1ee7 \u0074\u0068\u00f4\u006e\u0067 \u0074\u0069\u006e \u0074\u0072\u1ead\u006e \u0111\u1ea5\u0075\u002e");
			alert.showAndWait();
		}

	}

	@FXML
	private void selectCockfightingImage(ActionEvent event) {
		Stage stage = new Stage();
		stage.setTitle("Choos a thumbnail (Image only)");
		chooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
		file = chooser.showOpenDialog(stage);

		if (file == null)
			return;

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			imgCockfighting.setImage(image);

			imageByteStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", imageByteStream);
		} catch (IOException ex) {
			Logger.getLogger(NewMatchController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void loadInformation() {
		tfLoaiga.getItems().addAll(informationGetway.select("loaiga"));
		tfLoaiga.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});

		tfMauao.getItems().addAll(informationGetway.select("mauao"));
		tfMauao.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});

		tfMauquan.getItems().addAll(informationGetway.select("mauquan"));
		tfMauquan.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});

		tfMaunon.getItems().addAll(informationGetway.select("maunon"));
		tfMaunon.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});

		tfSanchoi.getItems().addAll(informationGetway.select("sanchoi"));
		tfSanchoi.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});

		tfKetqua.getItems().addAll(informationGetway.select("ketqua"));
		tfKetqua.setConverter(new StringConverter<Information>() {
			@Override
			public String toString(Information object) {
				return object.getName();
			}

			@Override
			public Information fromString(String string) {
				return tfLoaiga.getItems().stream().filter(ap -> ap.getName().equals(string)).findFirst().orElse(null);
			}
		});
	}
}
