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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import model.Information;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class InformationController implements Initializable {

	@FXML
	private Button btnLoaiga;
	@FXML
	private TableView<Information> tvLoaiga;
	@FXML
	private TableColumn<Information, String> tcLoaiga;

	@FXML
	private Button btnMauao;
	@FXML
	private TableView<Information> tvMauao;
	@FXML
	private TableColumn<Information, String> tcMauao;

	@FXML
	private Button btnMauquan;
	@FXML
	private TableView<Information> tvMauquan;
	@FXML
	private TableColumn<Information, String> tcMauquan;

	@FXML
	private Button btnMaunon;
	@FXML
	private TableView<Information> tvMaunon;
	@FXML
	private TableColumn<Information, String> tcMaunon;

	@FXML
	private Button btnSanchoi;
	@FXML
	private TableView<Information> tvSanchoi;
	@FXML
	private TableColumn<Information, String> tcSanchoi;

	@FXML
	private Button btnKetqua;
	@FXML
	private TableView<Information> tvKetqua;
	@FXML
	private TableColumn<Information, String> tcKetqua;

	InformationGetway informationGetway = new InformationGetway();

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Platform.runLater(() -> {
			loaInformation();
		});

		tvLoaiga.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("loaiga", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

		tvMauao.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("mauao", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

		tvMauquan.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("mauquan", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

		tvMaunon.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("maunon", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

		tvSanchoi.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("sanchoi", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

		tvKetqua.setRowFactory(tv -> {
			TableRow<Information> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					Information clickedRow = row.getItem();
					try {
						deleteInformation("ketqua", clickedRow.getName());
					} catch (IOException ex) {
						Logger.getLogger(InformationController.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			});
			return row;
		});

	}

	@FXML
	private void btnLoaigaOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u004c\u006f\u1ea1\u0069\u0020\u0067\u00e0", "loaiga", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	@FXML
	private void btnMauaoOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u004d\u00e0\u0075\u0020\u00e1\u006f", "mauao", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	@FXML
	private void btnMauquanOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u004d\u00e0\u0075\u0020\u0071\u0075\u1ea7\u006e", "mauquan", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	@FXML
	private void btnMaunonOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u004d\u00e0\u0075\u0020\u006e\u00f3\u006e", "maunon", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	@FXML
	private void btnSanchoiOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u0053\u00e2\u006e\u0020\u0063\u0068\u01a1\u0069", "sanchoi", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	@FXML
	private void btnKetquaOnAction(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/NewInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		NewInformationController controller = fXMLLoader.<NewInformationController>getController();
		controller.setData("\u004b\u1ebf\u0074\u0020\u0071\u0075\u1ea3", "ketqua", this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();

	}

	public void loaInformation() {
		tvLoaiga.getItems().clear();
		ObservableList<Information> olLoaiga = informationGetway.select("loaiga");
		tcLoaiga.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvLoaiga.setItems(olLoaiga);

		tvMauao.getItems().clear();
		ObservableList<Information> olMauao = informationGetway.select("mauao");
		tcMauao.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvMauao.setItems(olMauao);

		tvMauquan.getItems().clear();
		ObservableList<Information> olMauquan = informationGetway.select("mauquan");
		tcMauquan.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvMauquan.setItems(olMauquan);

		tvMaunon.getItems().clear();
		ObservableList<Information> olMaunon = informationGetway.select("maunon");
		tcMaunon.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvMaunon.setItems(olMaunon);

		tvSanchoi.getItems().clear();
		ObservableList<Information> olSanchoi = informationGetway.select("sanchoi");
		tcSanchoi.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvSanchoi.setItems(olSanchoi);

		tvKetqua.getItems().clear();
		ObservableList<Information> olKetqua = informationGetway.select("ketqua");
		tcKetqua.setCellValueFactory(new PropertyValueFactory<>("name"));
		tvKetqua.setItems(olKetqua);
	}

	private void deleteInformation(String table, String name) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/information/UpdateInformation.fxml"));

		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		UpdateInformationController controller = fXMLLoader.<UpdateInformationController>getController();
		controller.setData("\u004c\u006f\u1ea1\u0069\u0020\u0067\u00e0", table, name, this);
		stage.setScene(scene);
		stage.setTitle("\u0054\u0068\u00ea\u006d\u0020\u006d\u1edb\u0069");
		stage.setOnHidden(e -> controller.shutdown());
		stage.show();
	}
}
