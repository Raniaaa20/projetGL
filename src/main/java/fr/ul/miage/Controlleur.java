package fr.ul.miage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controlleur {

	@FXML
	private Button deplacer1;

	@FXML
	private Button deplacer2;

	@FXML
	private Button valider;
	@FXML
	private Button validerCh1;
	@FXML
	private TextField adresseD;

	@FXML
	private TextField adresseA;

	@FXML
	private TextField statD;

	@FXML
	private TextField statA;

	@FXML
	private Pane paneOptions;

	@FXML
	private CheckBox rapide;

	@FXML
	private CheckBox corresp;

	@FXML
	private CheckBox stop;

	@FXML
	private TextField saisieStop;

	@FXML
	private Label erreur;

	@FXML
	private TextArea result;

	private double latitudeDep;
	private double longitudeDep;
	private double latitudeDes;
	private double longitudeDes;

	@FXML
	public void initialize() {
		// Afficher seulement les boutons deplacer1 et deplacer2 au départ
		validerCh1.setVisible(false);
		deplacer1.setVisible(true);
		deplacer2.setVisible(true);
		paneOptions.setVisible(false);
		rapide.setVisible(false);
		corresp.setVisible(false);
		stop.setVisible(false);
		saisieStop.setVisible(false);
		valider.setVisible(false);
		result.setVisible(false);
		adresseD.setVisible(false);
		adresseA.setVisible(false);
		statA.setVisible(false);
		statD.setVisible(false);
		adresseD.textProperty().addListener((observable, oldValue, newValue) -> {
			updateOptionsVisibility();
		});

		adresseA.textProperty().addListener((observable, oldValue, newValue) -> {
			updateOptionsVisibility();
		});

		statD.textProperty().addListener((observable, oldValue, newValue) -> {
			updateOptionsVisibility();
		});

		statA.textProperty().addListener((observable, oldValue, newValue) -> {
			updateOptionsVisibility();
		});
	}

	@FXML
	public void onDeplacer1Clicked() {
		// Afficher paneOp1 si l'utilisateur choisit deplacer1

		paneOptions.setVisible(false);

		statA.setVisible(true);
		statD.setVisible(true);
		adresseD.setVisible(false);
		adresseA.setVisible(false);
		String adresseDText = adresseD.getText();
		String adresseAText = adresseA.getText();
	}

	@FXML
	public void onDeplacer2Clicked() {
		// Afficher paneOp2 si l'utilisateur choisit deplacer2
		validerCh1.setVisible(true);
		paneOptions.setVisible(false);
		adresseD.setVisible(true);
		adresseA.setVisible(true);
		statA.setVisible(false);
		statD.setVisible(false);
		String statDText = statD.getText();
		String statAText = statA.getText();

	}

	private void updateOptionsVisibility() {
		String adresseDText = adresseD.getText();
		String adresseAText = adresseA.getText();
		String statDText = statD.getText();
		String statAText = statA.getText();

		if (!adresseDText.isEmpty() && !adresseAText.isEmpty() || !statDText.isEmpty() && !statAText.isEmpty()) {
			// Afficher paneOptions si les champs adresseD et adresseA sont remplis
			paneOptions.setVisible(true);
			rapide.setVisible(true);
			corresp.setVisible(true);
			stop.setVisible(true);
			valider.setVisible(true);
		} else {
			// Cacher paneOptions si les champs sont vides
			paneOptions.setVisible(false);
			rapide.setVisible(false);
			corresp.setVisible(false);
			stop.setVisible(false);
		}

	}

	@FXML
	public void onStopClicked() {
		// Afficher le textField saisieStop si le checkBox stop est cliqué
		if (stop.isSelected()) {
			saisieStop.setVisible(true);
		} else {
			saisieStop.setVisible(false);
		}
	}

	@FXML
	public void onValiderClicked() {
		result.setVisible(true);
		result.setWrapText(true);
		result.setText("Vous allez passez par les stations suivantes : \n");
		result.setText("Temps de trajet estimé : \n");
	}

	public void getCheminOptimal() {
	    String Depart = adresseD.getText();
	    String Arrivee = adresseA.getText();
	    try {

	        // ---------------Récupération des coordonnées de départ et d'arrivée-------------//

	        List<Double> coordonnéesDepart = Station.setPosition(Depart);
	        double latitudeDep = coordonnéesDepart.get(0);
	        double longitudeDep = coordonnéesDepart.get(1);
	        List<Double> coordonnéesDest = Station.setPosition(Arrivee);
	        double latitudeDes = coordonnéesDest.get(0);
	        double longitudeDes = coordonnéesDest.get(1);

	        // -----------Calcul du chemin avec les méthodes de la classe RéseauMetro-----//
	        
	        List<Station>listeStations = ReseauMetro.listeStations;
	        Station stationDep = Station.findNearestStation(listeStations, latitudeDep, longitudeDep);
	        Station stationDes = Station.findNearestStation(listeStations, latitudeDes, longitudeDes);

	        
	        ReseauMetro.trouverCheminOptimal (stationDep, stationDes);
	        result.setVisible(true);
	        result.setWrapText(true);

	        List<String> lignesOptimales = ReseauMetro.lignesOptimalesParcourues;
	        List<Station> stationsOptimales = ReseauMetro.stationsOptimalesParcourues;
	        double tempsTrajetOptimal = ReseauMetro.tempsTrajetOptimal;

	        if (lignesOptimales != null && stationsOptimales != null) {
	            result.appendText("Lignes par lesquelles vous allez passer : \n");
	            for (String ligne : lignesOptimales) {
	                result.appendText(ligne + "\n");
	            }

	            result.appendText("Stations par lesquelles vous allez passer : \n");
	            for (Station station : stationsOptimales) {
	                result.appendText(station.getNom() + "\n");
	            }

	            result.appendText("Temps de trajet estimé : " + tempsTrajetOptimal + "\n");
	        } else {
	            result.setText("Aucun chemin optimal trouvé.");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
