package fr.ul.miage;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	

	public static void main(String[] args) {
		ReseauMetro.initialiserReseau();
		
		launch(args);
	}
}