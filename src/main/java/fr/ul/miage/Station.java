package fr.ul.miage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Station {
    private String nom;
    int tempsArret;
    boolean accident;
    double latitude;
    double longitude;
    List<Voie> voies;
    private List<Ligne> lignes;

    // Constructeur
    public Station(String nom, int tempsArret, boolean accident) {
	super();
	this.nom = nom;
	this.tempsArret = tempsArret;
	this.accident = accident;
    }

    public Station(String nom, int tempsArret, boolean accident, double latitude, double longitude) {
	this.nom = nom;
	this.latitude = latitude;
	this.longitude = longitude;
	this.voies = new ArrayList<>(); // Initialisation de la liste des voies
	this.lignes = new ArrayList<>();

    }

   
    public static Station findNearestStation(List<Station> stations, double latitude, double longitude) {
	Station nearestStation = null;
	double minDistance = Double.MAX_VALUE;
	for (Station station : stations) {
	    double distance = station.distanceTo(latitude, longitude);
	    if (distance < minDistance) {
		minDistance = distance;
		nearestStation = station;
	    }
	}

	if (nearestStation != null) {
	    System.out.println("La station de metro la plus proche est : " + nearestStation.getNom());
	}
		return nearestStation;
    }

    void setPosition(Scanner scanner) throws IOException {
	System.out.println("Entrez un nom de rue a Paris :");
	String streetName = scanner.nextLine();
	String encodedStreetName = URLEncoder.encode(streetName, StandardCharsets.UTF_8.toString());
	String urlString = "https://nominatim.openstreetmap.org/search?street=" + encodedStreetName
		+ "&city=Paris&country=France&format=json";
	URL url = new URL(urlString);
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	connection.setRequestProperty("User-Agent", "Java Geocoding Application");
	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	StringBuilder jsonResult = new StringBuilder();
	String line;
	while ((line = reader.readLine()) != null) {
	    jsonResult.append(line);
	}

	JSONArray jsonArray = new JSONArray(jsonResult.toString());
	if (jsonArray.length() > 0) {
	    JSONObject jsonObject = jsonArray.getJSONObject(0);
	    Double latitude = jsonObject.getDouble("lat");
	    Double longitude = jsonObject.getDouble("lon");
	    this.latitude = latitude;
	    this.longitude = longitude;
	    System.out.println("Votre position actuelle est :");
	    System.out.printf("Latitude: %.6f, Longitude: %.6f\n", latitude, longitude);
	} else {
	    System.out.println(
		    "La rue que vous avez saisie n'a pas ete trouvee. Veuillez verifier votre saisie et reessayer.");
	}
    }

    public double distanceTo(double latitude, double longitude) {
	final int R = 6371;
	double latDistance = Math.toRadians(latitude - this.latitude);
	double lonDistance = Math.toRadians(longitude - this.longitude);
	double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(this.latitude))
		* Math.cos(Math.toRadians(latitude)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	return R * c;
    }

    public List<Voie> getVoies() {
	return voies;
    }

    public void addVoie(Voie voie) {
	this.voies.add(voie);
    }

    public Ligne[] getLignes() {
	// Convertir la liste de lignes en tableau
	Ligne[] lignesArray = new Ligne[lignes.size()];
	lignesArray = lignes.toArray(lignesArray);
	return lignesArray;
    }

    public void setLigne(Ligne l) {
	this.lignes.add(l);
    }
    
    // Getters et setters
    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public boolean isAccident() {
	return accident;
    }

    public void setAccident(boolean accident) {
	this.accident = accident;
    }

    public int getTempsArret() {
	return tempsArret;
    }

    public void setTempsArret(int tempsArret) {
	this.tempsArret = tempsArret;
    }


}
