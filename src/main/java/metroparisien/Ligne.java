package metroparisien;

import java.util.ArrayList;
import java.util.List;

public class Ligne {
    private int numero;
    private String nom;
    private List<Voie> voies;
    private List<Station> stations;

    // Constructeur
    public Ligne(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
        this.voies = new ArrayList<>();
        this.stations = new ArrayList<>();
    }

    // Getters et setters

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public List<Station> getStations() {
        return stations;
    }

    // Méthode pour ajouter une voie à la ligne
    public void addVoie(Voie voie) {
        voies.add(voie);
    }

    // Méthode pour ajouter une station à la ligne
    public void addStation(Station station) {
        stations.add(station);
    }
    
    public void afficherLigne() {
	    System.out.println("Stations de la ligne " + numero + ":");
	    for (Station station : stations) {
	        System.out.println(station.getNom());
	    }
	}

}
