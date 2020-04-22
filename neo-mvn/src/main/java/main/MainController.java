package main;

import java.util.List;

import astro.Asteroid;
import astro.NasaDataProvider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

public class MainController {

//	@FXML
//	private TextField startDate;
//	@FXML
//	private TextField endDate;
//	@FXML
//	private TextArea outputWindow;
//
//	@FXML
//	public void getData() throws Exception {
//		
//		List<Asteroid> asteroids = new NasaDataProvider().getNeoAsteroids(startDate.getText(), endDate.getText());
//		
//		 for (Asteroid asteroid : asteroids) {
//			 outputWindow.appendText(asteroid.getDate() +
//					 				 String.format(" - diameter: %.2f km, distance: %5.1f mln km, ",
//					 				 asteroid.getDiamteter(), (asteroid.getDistance() / 1_000_000)) + 
//					 				(asteroid.isHazardous() ? "it's hazardous!" : "it's not hazardous") + "\n");
//		 }
//		 
//	}

	@FXML
	private TextField startDate;

	@FXML
	private TextField endDate;

	@FXML
	private TableView<Asteroid> tableView;

	@FXML
	private TableColumn<Asteroid, String> date;

	@FXML
	private TableColumn<Asteroid, Double> distance;

	@FXML
	private TableColumn<Asteroid, Float> diameter;

	@FXML
	private TableColumn<Asteroid, Boolean> hazardous;

	@FXML
	void getData() throws Exception {

		List<Asteroid> asteroids = new NasaDataProvider().getNeoAsteroids(startDate.getText(), endDate.getText());

		final ObservableList<Asteroid> data = FXCollections.observableArrayList(asteroids);

		date.setCellValueFactory(new PropertyValueFactory<Asteroid, String>("date"));
		diameter.setCellValueFactory(new PropertyValueFactory<Asteroid, Float>("diameter"));
		distance.setCellValueFactory(new PropertyValueFactory<Asteroid, Double>("distance"));
		hazardous.setCellValueFactory(new PropertyValueFactory<Asteroid, Boolean>("hazardous"));

		tableView.setItems(data);

	}

}
