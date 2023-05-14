package metro_parisien;

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

public class MetroStation {
	private String name;
	private double latitude;
	private double longitude;
	private static List<MetroStation> stations = new ArrayList<>();

	public MetroStation(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
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

	public static MetroStation findNearestStation(List<MetroStation> stations, double latitude, double longitude) {
		MetroStation nearestStation = null;
		double minDistance = Double.MAX_VALUE;
		for (MetroStation station : stations) {
			double distance = station.distanceTo(latitude, longitude);
			if (distance < minDistance) {
				minDistance = distance;
				nearestStation = station;
			}
		}

		if (nearestStation != null) {
			System.out.println("La station de métro la plus proche est : " + nearestStation.getName());
		}
		return nearestStation;
	}

	private void setPosition(Scanner scanner) throws IOException {
		System.out.println("Entrez un nom de rue à Paris :");
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
					"La rue que vous avez saisie n'a pas été trouvée. Veuillez vérifier votre saisie et réessayer.");
		}
	}

	public static void main(String[] args) throws IOException {
		MetroStation actuel = new MetroStation(null, 0, 0);
		stations.add(new MetroStation("Anvers", 48.882880, 2.344257));
		stations.add(new MetroStation("Abbesses", 48.884568, 2.337929));
		stations.add(new MetroStation("Bastille", 48.852987, 2.368858));
		stations.add(new MetroStation("Châtelet", 48.858427, 2.347556));
		stations.add(new MetroStation("Gare du Nord", 48.881459, 2.355404));
		stations.add(new MetroStation("Gare de Lyon", 48.844553, 2.374332));
		stations.add(new MetroStation("Montparnasse-Bienvenüe", 48.842161, 2.321839));
		stations.add(new MetroStation("Saint-Lazare", 48.876875, 2.325573));
		stations.add(new MetroStation("République", 48.867621, 2.363701));
		stations.add(new MetroStation("Bastille", 48.852987, 2.368858));
		stations.add(new MetroStation("Opéra", 48.870823, 2.332058));
		stations.add(new MetroStation("Charles de Gaulle - Étoile", 48.874778, 2.296691));
		stations.add(new MetroStation("Nation", 48.848371, 2.398153));
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n---- Menu ----");
			System.out.println("1. Trouver la station la plus proche");
			System.out.println("2. Fixer la position");
			System.out.println("0. Quitter");
			System.out.print("Choisissez une option : ");
			while (!scanner.hasNextInt()) {
				System.out.println("Veuillez entrer votre choix");
				scanner.next();
			}
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				MetroStation.findNearestStation(stations, actuel.latitude, actuel.longitude);
				break;
			case 2:
				actuel.setPosition(scanner);
				break;
			case 0:
				System.out.println("Au revoir !");
				break;
			default:
				System.out.println("Option invalide. Veuillez choisir une option du menu.");
			}
		} while (choice != 0);
		scanner.close();
	}
}
