/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import getway.InformationGetway;
import getway.MatchGetway;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.Information;
import model.Match;
import model.Paginate;

/**
 * FXML Controller class
 *
 * @author HungS7
 */
public class SearchController implements Initializable {

	@FXML
	private TableView<Match> searchTable;
	@FXML
	private TableColumn<Integer, Integer> clID;
	@FXML
	private TableColumn<Integer, Integer> clLoaiga;
	@FXML
	private TableColumn<Match, String> clMauao;
	@FXML
	private TableColumn<Match, String> clMauquan;
	@FXML
	private TableColumn<Match, String> clMaunon;
	@FXML
	private TableColumn<Match, String> clSanchoi;
	@FXML
	private TableColumn<Match, String> clKetqua;
	@FXML
	private TableColumn<Match, String> clThongtinthem;
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
	private Label lblTotalDrug;
	@FXML
	private Label lblShowingDrug;

	private ObservableList<Match> matchs = FXCollections.observableArrayList();
	MatchGetway matchGetway = new MatchGetway();
	Paginate paginate = new Paginate();
	private boolean drugDefault = true;
	int totalDurg;
	int totalSearchDrug;

	InformationGetway informationGetway = new InformationGetway();
	String loaiga = "";
	String mauao = "";
	String mauquan = "";
	String maunon = "";
	String sanchoi = "";
	String ketqua = "";

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		lblTotalDrug.setText("\u0110\u0061\u006e\u0067 \u0074\u1ea3\u0069\u002e\u002e\u002e");
		Platform.runLater(() -> {
			totalDurg = matchGetway.totalMatch();
			loadInformation();
			lblTotalDrug.setText("\u0054\u1ed5\u006e\u0067\u003a " + String.valueOf(totalDurg));
			lblShowingDrug.setText("\u006b\u1ebf\u0074 \u0071\u0075\u1ea3 \u0074\u1eeb\u003a " + paginate.getStart()
					+ " \u0111\u1ebf\u006e " + paginate.getEnd());
			clearParam();
		});

		searchTable.setRowFactory(tv -> {
			TableRow<Match> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

					FXMLLoader fXMLLoader = new FXMLLoader();
					fXMLLoader.setLocation(getClass().getResource("/view/search/UpdateMatch.fxml"));

					Stage stage = new Stage();
					Scene scene = null;
					try {
						scene = new Scene(fXMLLoader.load());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					UpdateMatchController controller = fXMLLoader.<UpdateMatchController>getController();
					controller.setData("\u004c\u006f\u1ea1\u0069\u0020\u0067\u00e0", row.getItem(), this);
					stage.setScene(scene);
					stage.setTitle("\u0058\u0065\u006d \u0054\u0068\u00f4\u006e\u0067 \u0054\u0069\u006e \u0054\u0072\u1ead\u006e \u0110\u1ea5\u0075");
					stage.setOnHidden(e -> controller.shutdown());
					stage.show();
				}
			});
			return row;
		});

	}

	@FXML
	private void handlePrevButton(ActionEvent event) {
		if (paginate.getStart() > 0) {
			paginate.setStart(paginate.getStart() - paginate.getPerPage());
			paginate.setEnd(paginate.getStart() + paginate.getPerPage());
			if (drugDefault) {
				loadInformation();
			} else {
				searchMatchs();
			}
		}
	}

	@FXML
	private void handleNextButton(ActionEvent event) {
		System.out.println(paginate.getTotal());
		System.out.println(paginate.getEnd());
		paginate.setStart(paginate.getStart() + paginate.getPerPage());
		paginate.setEnd(paginate.getStart() + paginate.getPerPage());

		if (drugDefault) {
			loadInformation();
		} else {
			searchMatchs();
		}
	}

	@FXML
	private void tfLoaigaOnAction(ActionEvent event) {
		loaiga = tfLoaiga.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	@FXML
	private void tfMauaoOnAction(ActionEvent event) {
		mauao = tfMauao.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	@FXML
	private void tfMauquanOnAction(ActionEvent event) {
		mauquan = tfMauquan.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	@FXML
	private void tfMaunonOnAction(ActionEvent event) {
		maunon = tfMaunon.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	@FXML
	private void tfSanchoiOnAction(ActionEvent event) {
		sanchoi = tfSanchoi.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	@FXML
	private void tfKetquaOnAction(ActionEvent event) {
		ketqua = tfKetqua.getValue().getName();
		paginate.setStart(0);
		searchMatchs();
	}

	public void loadInformation() {
		drugDefault = true;
		paginate.setTotal(totalDurg);
		paginate.setPerPage(20);
		paginate.setEnd(20);
		searchTable.getItems().clear();
		matchs = matchGetway.Match(paginate);

		clID.setCellValueFactory(new PropertyValueFactory<>("id"));
		clLoaiga.setCellValueFactory(new PropertyValueFactory<>("loaiga"));
		clMauao.setCellValueFactory(new PropertyValueFactory<>("mauao"));
		clMauquan.setCellValueFactory(new PropertyValueFactory<>("mauquan"));
		clMaunon.setCellValueFactory(new PropertyValueFactory<>("maunon"));
		clSanchoi.setCellValueFactory(new PropertyValueFactory<>("sanchoi"));
		clKetqua.setCellValueFactory(new PropertyValueFactory<>("ketqua"));
		clThongtinthem.setCellValueFactory(new PropertyValueFactory<>("thongtinthem"));

		searchTable.setItems(matchs);

		tfLoaiga.getItems().clear();
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

		tfMauao.getItems().clear();
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

		tfMauquan.getItems().clear();
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

		tfMaunon.getItems().clear();
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

		tfSanchoi.getItems().clear();
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

		tfKetqua.getItems().clear();
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

		showPagenumber();
	}

	private void searchMatchs() {
		drugDefault = false;
		totalSearchDrug = matchGetway.totalSearchMatch(loaiga, mauao, mauquan, maunon, sanchoi, ketqua);
		paginate.setTotal(totalSearchDrug);
		paginate.setPerPage(20);
		paginate.setEnd(20);
		searchTable.getItems().clear();
		matchs.clear();
		matchs = matchGetway.searchMatch(paginate, loaiga, mauao, mauquan, maunon, sanchoi, ketqua);

		clID.setCellValueFactory(new PropertyValueFactory<>("id"));
		clLoaiga.setCellValueFactory(new PropertyValueFactory<>("loaiga"));
		clMauao.setCellValueFactory(new PropertyValueFactory<>("mauao"));
		clMauquan.setCellValueFactory(new PropertyValueFactory<>("mauquan"));
		clMaunon.setCellValueFactory(new PropertyValueFactory<>("maunon"));
		clSanchoi.setCellValueFactory(new PropertyValueFactory<>("sanchoi"));
		clKetqua.setCellValueFactory(new PropertyValueFactory<>("ketqua"));
		clThongtinthem.setCellValueFactory(new PropertyValueFactory<>("thongtinthem"));

		searchTable.setItems(matchs);
		showPagenumber();
	}

	private void clearParam() {
		loaiga = "";
		mauao = "";
		mauquan = "";
		maunon = "";
		sanchoi = "";
		ketqua = "";
	}

	private void showPagenumber() {
		if (drugDefault) {
			lblShowingDrug.setText("\u006b\u1ebf\u0074 \u0071\u0075\u1ea3 \u0074\u1eeb\u003a " + paginate.getStart()
					+ " \u0111\u1ebf\u006e " + (paginate.getStart() + paginate.getPerPage()));
		} else {
			lblTotalDrug.setText("Total : " + String.valueOf(totalSearchDrug));
			lblShowingDrug.setText("\u006b\u1ebf\u0074 \u0071\u0075\u1ea3 \u0074\u1eeb\u003a " + paginate.getStart()
					+ " \u0111\u1ebf\u006e " + (paginate.getStart() + paginate.getPerPage()));
		}
	}
}
