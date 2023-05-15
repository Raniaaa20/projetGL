package metroparisien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Station> stations = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Station actuel = new Station(null, 0, false);
		stations.add(new Station("Anvers", 10, false, 48.882880, 2.344257));
		stations.add(new Station("Abbesses", 10, false, 48.884568, 2.337929));
		stations.add(new Station("Bastille", 10, false, 48.852987, 2.368858));
		stations.add(new Station("Chatelet", 10, false, 48.858427, 2.347556));
		stations.add(new Station("Gare du Nord", 10, false, 48.881459, 2.355404));
		stations.add(new Station("Gare de Lyon", 10, false, 48.844553, 2.374332));
		stations.add(new Station("Montparnasse-Bienvenue", 10, false, 48.842161, 2.321839));
		stations.add(new Station("Saint-Lazare", 10, false, 48.876875, 2.325573));
		stations.add(new Station("Republique", 10, false, 48.867621, 2.363701));
		stations.add(new Station("Bastille", 10, false, 48.852987, 2.368858));
		stations.add(new Station("Opera", 10, false, 48.870823, 2.332058));
		stations.add(new Station("Charles de Gaulle - Etoile", 10, false, 48.874778, 2.296691));
		stations.add(new Station("Nation", 10, false, 48.848371, 2.398153));
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
				Station.findNearestStation(stations, actuel.latitude, actuel.longitude);
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

		System.out.println(Menu.getMenuAccueil());

	}
}
