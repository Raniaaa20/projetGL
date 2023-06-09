package fr.ul.miage;




import java.util.List;

import java.io.IOException;
import java.util.ArrayList;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
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
    private ChoiceBox<String> statD;

    @FXML
    private ChoiceBox<String> statA;

    @FXML
    private Pane paneOptions;

    @FXML
    private CheckBox rapide;

    @FXML
    private CheckBox corresp;

    @FXML
    private CheckBox stop;

    @FXML
    private ChoiceBox<String> saisieStop;

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
    private PasswordField mdp;

    @FXML
    private Button incidentS;

    @FXML
    private Button incidentV;

    @FXML
    private ListView<String> listIncidents;

    @FXML
    private Button majIncidentsStat;
    
    @FXML 
    private Button majIncidentsVoie;

    @FXML
    private ObservableList<String> stationNames;

  
    @FXML
    public void initialize() {
        // Afficher seulement les boutons deplacer1 et deplacer2 au départ
        clean();
        admin.setVisible(true);
        util.setVisible(true);

        // Récupérer la liste des stations depuis la classe ReseauMetro
        List<Station> stations = ReseauMetro.listeStations;

        // Créer une liste de noms de stations
        ObservableList<String> stationNames = FXCollections.observableArrayList();
        for (Station station : stations) {
            stationNames.add(station.getNom());
        }

        // Configurer les ChoiceBox statA et statD
        statA.setItems(stationNames);
        statD.setItems(stationNames);
        saisieStop.setItems(stationNames);

        // Vérifier si la liste des stations n'est pas vide
        if (!stations.isEmpty()) {
            // Sélectionner la première et la dernière station possible
            statD.setValue(stations.get(0).getNom());
            statA.setValue(stations.get(stations.size() - 1).getNom());
        }
    }



	
	@FXML 
	public void connexionADMIN() {
		clean();
		mdp.setVisible(true);
		ok.setVisible(true);
		
		
	}
	
	@FXML 
	public void connexionUtilisateur() {
		// Afficher seulement les boutons deplacer1 et deplacer2 au départ

		
		clean();
		deplacer1.setVisible(true);
		deplacer2.setVisible(true);

		
	}
	
	@FXML 
	public void connectAdmin() {
		String password = mdp.getText(); // Récupérer le champ saisi dans "mdp"

	    if (password.equals("2023")) {
	    	incidentS.setVisible(true);
			incidentV.setVisible(true);
			mdp.setVisible(false);
			ok.setVisible(false);
			
	    } else {
	        erreur.setText("Mot de passe incorrect"); 
	    }
	}
	
	
	@FXML
	private void incidentStation() {
	    clean();
	    listIncidents.setVisible(true);
	    incidentS.setVisible(true);
	    incidentV.setVisible(true);

	    // Récupérer la liste des stations depuis la classe ReseauMetro
	    List<Station> stations = ReseauMetro.listeStations;

	    // Créer une liste observable pour les noms des stations avec les booléens d'accidents
	    ObservableList<String> stationNames = FXCollections.observableArrayList();
	    for (Station station : stations) {
	        String stationName = station.getNom() + " - " + (station.isAccident() ? "Accident" : "Pas d'accident");
	        stationNames.add(stationName);
	    }

	    // Alimenter la ListView avec les noms des stations et les booléens d'accidents
	    listIncidents.setItems(stationNames);

	    // Configurer un gestionnaire d'événements pour le clic sur les éléments de la ListView
	    listIncidents.setOnMouseClicked(event -> {
	        // Récupérer l'index de la station sélectionnée
	        int selectedIndex = listIncidents.getSelectionModel().getSelectedIndex();
	        if (selectedIndex != -1) {
	            // Récupérer la station correspondante
	            Station selectedStation = stations.get(selectedIndex);
	            // Inverser l'état d'accident de la station
	            selectedStation.setAccident(!selectedStation.isAccident());

	            // Mettre à jour le nom de la station dans la liste observable
	            String updatedStationName = selectedStation.getNom() + " - " + (selectedStation.isAccident() ? "Accident" : "Pas d'accident");
	            stationNames.set(selectedIndex, updatedStationName);
	        }
	    });
	    majIncidentsStat.setVisible(true);
	}



	@FXML
	private void incidentVoie() {
	    clean();
	    listIncidents.setVisible(true);
	    incidentS.setVisible(true);
	    incidentV.setVisible(true);

	    // Récupérer la liste des voies depuis la liste "voies" dans ReseauMetro
	    List<Voie> voiesList = ReseauMetro.voies;

	    // Créer une liste observable pour les noms des voies avec les booléens d'accidents
	    ObservableList<String> voieNames = FXCollections.observableArrayList();
	    for (Voie voie : voiesList) {
	        String voieName = voie.getStationDepart().getNom() + " - " + voie.getStationArrivee().getNom() + " - " + (voie.getAccident() ? "Accident" : "Pas d'accident");
	        voieNames.add(voieName);
	    }

	    // Alimenter la ListView avec les noms des voies et les booléens d'accidents
	    listIncidents.setItems(voieNames);

	    // Configurer un gestionnaire d'événements pour le clic sur les éléments de la ListView
	    listIncidents.setOnMouseClicked(event -> {
	        // Récupérer l'index de la voie sélectionnée
	        int selectedIndex = listIncidents.getSelectionModel().getSelectedIndex();
	        if (selectedIndex != -1) {
	            // Récupérer la voie correspondante
	            Voie selectedVoie = voiesList.get(selectedIndex);
	            // Inverser l'état d'accident de la voie
	            selectedVoie.setAccident(!selectedVoie.getAccident());

	            // Mettre à jour le nom de la voie dans la liste observable
	            String updatedVoieName = selectedVoie.getStationDepart().getNom() + " - " + selectedVoie.getStationArrivee().getNom() + " - " + (selectedVoie.getAccident() ? "Accident" : "Pas d'accident");
	            voieNames.set(selectedIndex, updatedVoieName);
	        }
	    });
	    majIncidentsVoie.setVisible(true);
	}
	
	@FXML
	public void miseAjourIncidentsStations() {
	    // Récupérer la liste des stations depuis la classe ReseauMetro
	    List<Station> stations = ReseauMetro.listeStations;
	   
	    // Parcourir la liste des stations
	    for (Station station : stations) {
	        // Récupérer le nom de la station depuis la ListView
	        String stationName = listIncidents.getItems().get(stations.indexOf(station));

	        // Vérifier si la station a un accident
	        boolean accident = stationName.endsWith("Accident");

	        // Mettre à jour l'état de l'accident de la station
	        station.setAccident(accident);
	        
	    }

	   
	}


	@FXML
	public void miseAjourIncidentsVoies() {
	    // Récupérer la liste des voies depuis la liste "voies" dans ReseauMetro
	    List<Voie> voiesList = ReseauMetro.voies;

	    // Parcourir la liste des voies
	    for (Voie voie : voiesList) {
	        // Récupérer le nom de la voie depuis la ListView
	        String voieName = listIncidents.getItems().get(voiesList.indexOf(voie));

	        // Vérifier si la voie a un accident
	        boolean accident = voieName.endsWith("Accident");

	        // Mettre à jour l'état de l'accident de la voie
	        voie.setAccident(accident);
	        
	    }
	    
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


	    statD.valueProperty().addListener((observable, oldValue, newValue) -> {
	        updateOptionsVisibility();
	    });

	    statA.valueProperty().addListener((observable, oldValue, newValue) -> {
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

		adresseD.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});

		adresseA.textProperty().addListener((observable, oldValue, newValue) -> {
		    updateOptionsVisibility();
		});
		
		
		
		
		
	}
	
	private void updateOptionsVisibility() {
	    String adresseDText = adresseD.getText();
	    String adresseAText = adresseA.getText();
	    String statDSelection = statD.getValue();
	    String statASelection = statA.getValue();

	    if ((!adresseDText.isEmpty() && !adresseAText.isEmpty()) || (statDSelection != null && statASelection != null)) {
	        // Afficher paneOptions si les champs adresseD et adresseA sont remplis ou si les ChoiceBox sont sélectionnées
	        paneOptions.setVisible(true);
	        rapide.setVisible(true);
	        corresp.setVisible(true);
	        stop.setVisible(true);
	        valider.setVisible(true);
	    } else {
	        // Cacher paneOptions si les champs sont vides ou si les ChoiceBox ne sont pas sélectionnées
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
	public void onValiderClicked()  {
	    result.setVisible(true);

	    String stationDepartNom = "";
	    String stationArriveeNom = "";
	    // Réinitialisation du contenu de result si l'utilisateur clique à nouveau
	    result.setText("");
	    
	    
	    if (!adresseD.getText().isBlank() && !adresseA.getText().isBlank()) {
	    	// Les champs adresseD et adresseA sont remplis
	    	String Depart = adresseD.getText();
		    String Arrivee = adresseA.getText();
		    System.out.println(Depart+"  "+Arrivee);
		 // ---------------Récupération des coordonnées de départ et d'arrivée-------------//

			try {
				
		    	List<Double> coordonnéesDepart = Station.setPosition(Depart);
		    	
				double latitudeDep = coordonnéesDepart.get(0);
		        double longitudeDep = coordonnéesDepart.get(1);
		        List<Double> coordonnéesDest = Station.setPosition(Arrivee);
		        double latitudeDes = coordonnéesDest.get(0);
		        double longitudeDes = coordonnéesDest.get(1);
		        List<Station>listeStations = ReseauMetro.listeStations;
		        Station stationDep = Station.findNearestStation(listeStations, latitudeDep, longitudeDep);
		        Station stationDes = Station.findNearestStation(listeStations, latitudeDes, longitudeDes);
		        
		        stationDepartNom = stationDep.getNom();
		        stationArriveeNom = stationDes.getNom();
		        
		        System.out.println(stationDep.getNom());
		        System.out.println(stationDes.getNom());
		       
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
	    } else {
	     // Les champs statD et statA sont remplis
	        stationDepartNom = statD.getValue();
	        stationArriveeNom = statA.getValue();
	    } 
	    

	    // Vérifier si la CheckBox "Rapide" est cochée ou aucune CheckBox n'est cochée
	    boolean rapideSelected = rapide.isSelected() || (!rapide.isSelected() && !corresp.isSelected() && !stop.isSelected());

	    // Appel de la méthode trouverCheminOptimal en fonction des options sélectionnées
	    List<Station> res;
	    result.appendText("Trajet de : " + stationDepartNom + " à : " + stationArriveeNom + "\n\n");
	    if (rapideSelected) {
	        
	        res = ReseauMetro.trouverCheminOptimal(stationDepartNom, stationArriveeNom);
	       
	    } else {
	        res = new ArrayList<>(); // Liste vide si l'option rapide n'est pas sélectionnée
	    }

	    

	    // Vérifier si la CheckBox "Corresp" est cochée
	    if (corresp.isSelected()) {
	        // Appeler la méthode pour prendre en compte les correspondances
	        // MethodeCorrespondances(stationDepartNom, stationArriveeNom);
	    }

	    // Vérifier si la CheckBox "Stop" est cochée
	    if (stop.isSelected()) {
	        String stationIntermediaire = saisieStop.getValue();
	        // Appeler la méthode pour prendre en compte l'arrêt spécifié
	        
	        res = ReseauMetro.trouverCheminOptimalAvecIntermediaire(stationDepartNom,stationIntermediaire, stationArriveeNom);
	    }
	    

	    result.appendText("\n\nTemps de trajet estimé : " + ReseauMetro.tempsTrajetOptimal + "\n\n");
	}
	
	


	
	
	
	public void clean() {
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
		incidentS.setVisible(false);
		incidentV.setVisible(false);
		erreur.setVisible(false);
		listIncidents.setVisible(false);
		majIncidentsStat.setVisible(false);
		majIncidentsVoie.setVisible(false);
	}

	

}
