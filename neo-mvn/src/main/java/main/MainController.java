package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import space.Asteroid;


public class MainController {

	@FXML
	TextField startDate;
	@FXML
	TextField endDate;

	@FXML
	public void getData() throws Exception {
		new Asteroid().getNeoAsteroids(startDate.getText(), endDate.getText());
	}

}
