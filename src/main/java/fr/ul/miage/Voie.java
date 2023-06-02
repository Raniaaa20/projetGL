package fr.ul.miage;

public class Voie {
	
	Station stationDepart;
	Station stationArrivee;
	int tempsParcours; // Représente le "coût" de la voie dans l'algorithme
	boolean accident;

	
	//Constructeur
	public Voie(Station stationDepart, Station stationArrivee, int tempsParcours, boolean accident) {
		super();
		this.stationDepart = stationDepart;
		this.stationArrivee = stationArrivee;
		this.tempsParcours = tempsParcours;
		this.accident = accident;

	}


	//Getters & setters 
	public Station getStationDepart() {
		return stationDepart;
	}


	public void setStationDepart(Station stationDepart) {
		this.stationDepart = stationDepart;
	}


	public Station getStationArrivee() {
		return stationArrivee;
	}


	public void setStationArrivee(Station stationArrivee) {
		this.stationArrivee = stationArrivee;
	}

    // Méthode renommée pour être plus conforme à son utilisation dans l'algorithme de recherche de chemin
	public int gettempsParcours() {
		return tempsParcours;
	}


	public void setTempsParcours(int tempsParcours) {
		this.tempsParcours = tempsParcours;
	}


	public boolean getAccident() {
		return accident;
	}


	public void setAccident(boolean accident) {
		this.accident = accident;
	}
	
    
}
