package fr.ul.miage;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Queue;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class ReseauMetro {


	static List<Ligne> lignes = new ArrayList<>();
	static Map<String, Station> stations;
	static List<Station> listeStations;
	static List<String> lignesOptimalesParcourues;
	static List<Station> stationsOptimalesParcourues;
	static double tempsTrajetOptimal;

    public static List<Ligne> lignes = new ArrayList<Ligne>();;
    public static Map<String, Station> stations = new HashMap<String, Station>();
    public static List<Station> listeStations = new ArrayList<Station>();

    public static List<Voie> voies = new ArrayList<Voie>();

   
    
    static Ligne ligneOptimale;
    static List<Voie> voiesOptimalesParcourus;
    static int tempsTrajetOptimal;


	static Ligne ligneOptimale;
	static List<Voie> voiesOptimalesParcourus;

	static void ajouterLigne(Ligne ligne) {
		lignes.add(ligne);
	}

	public static void ajouterStation(String nom, Station station) {
		stations.put(nom, station);
		listeStations.add(station);
	}

	public Ligne getLigneOptimale() {
		return ligneOptimale;
	}

	public List<Voie> getVoiesOptimalesParcourus() {
		return voiesOptimalesParcourus;
	}

	public static List<Voie> voies;

	public ReseauMetro() {

	}

	public void afficherLigne(Ligne ligne) {
		System.out.println("Ligne : " + ligne.getNom());


		List<Voie> voies = ligne.getVoies();
		for (Voie voie : voies) {
			Station stationDepart = voie.getStationDepart();
			Station stationArrivee = voie.getStationArrivee();


			System.out.println("Voie de " + stationDepart.getNom() + " a " + stationArrivee.getNom() + " (Distance "
					+ voie.gettempsParcours() + " minutes)");

    public ReseauMetro() {
	
    }

    public static void ajouterLigne(Ligne ligne) {
	lignes.add(ligne);
    }

    public void afficherLigne(Ligne ligne) {
	System.out.println("Ligne : " + ligne.getNom());

	List<Voie> voies = ligne.getVoies();
	for (Voie voie : voies) {
	    Station stationDepart = voie.getStationDepart();
	    Station stationArrivee = voie.getStationArrivee();

	    System.out.println("Voie de " + stationDepart.getNom() + " a " + stationArrivee.getNom() + " (Distance "
		    + voie.gettempsParcours() + " minutes)");
	}
    }

}}}