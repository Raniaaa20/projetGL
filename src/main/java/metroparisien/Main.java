package metroparisien;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Station actuel = new Station(null, 0, false, 48.8924, 2.2356);
		Scanner scanner = new Scanner(System.in);
		ReseauMetro r = new ReseauMetro();
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
				Station.findNearestStation(r.stationsListe, actuel.latitude, actuel.longitude);
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
