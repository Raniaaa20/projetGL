package metroparisien;

public class Voie {
	
	Station stationDepart;
	Station stationArrivee;
	int tempsParcours;
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


	public int getTempsParcours() {
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
	
	
	
	
	
	

}
