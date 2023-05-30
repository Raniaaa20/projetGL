package fr.ul.miage;

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
	
	@FXML 
	private Button admin;
	
	@FXML 
	private Button util;
	
	@FXML 
	private Button ok;
	
	@FXML 
	private TextField mdp;
	
	@FXML
	public void initialize() {
		// Afficher seulement les boutons deplacer1 et deplacer2 au départ
		admin.setVisible(true);
		util.setVisible(true);
		mdp.setVisible(false);
		ok.setVisible(false);
		deplacer1.setVisible(false);
		deplacer2.setVisible(false);
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
	}
	
	@FXML 
	public void connexionADMIN() {
		mdp.setVisible(true);
		ok.setVisible(true);
		deplacer1.setVisible(false);
		deplacer2.setVisible(false);
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
		
	}
	
	@FXML 
	public void connexionUtilisateur() {
		// Afficher seulement les boutons deplacer1 et deplacer2 au départ
		mdp.setVisible(false);
		ok.setVisible(false);
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
	}
	
	@FXML 
	public void connectAdmin() {
		String password = mdp.getText(); // Récupérer le champ saisi dans "mdp"

	    if (password.equals("2023")) {
	        interfaceAdmin(); 
	    } else {
	        erreur.setText("Mot de passe incorrect"); 
	    }
	}
	
	private void interfaceAdmin() {
		// TODO Auto-generated method stub
		
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

		adresseD.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});

		adresseA.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});
		
		
	}
	
	@FXML
	public void onDeplacer2Clicked() {
		// Afficher paneOp2 si l'utilisateur choisit deplacer2
		
		paneOptions.setVisible(false);
		adresseD.setVisible(true);
		adresseA.setVisible(true);
		statA.setVisible(false);
		statD.setVisible(false);
		String statDText = statD.getText();
		String statAText = statA.getText();
		
		
		statD.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});

		statA.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});
		
		
		
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
}
