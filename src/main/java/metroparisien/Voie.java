package metroparisien;

public class Voie {
	
	Station stationDepart;
	Station stationArrivee;
	int tempsParcours; // Représente le "coût" de la voie dans l'algorithme
	boolean accident;
	private Incident incident;
	
	//Constructeur
	public Voie(Station stationDepart, Station stationArrivee, int tempsParcours, boolean accident) {
		super();
		this.stationDepart = stationDepart;
		this.stationArrivee = stationArrivee;
		this.tempsParcours = tempsParcours;
		this.accident = accident;
		this.incident = null; // Pas d'incident à l'initialisation
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


	public boolean isAccident() {
		return accident;
	}


	public void setAccident(boolean accident) {
		this.accident = accident;
	}
	
	public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    
    
}
