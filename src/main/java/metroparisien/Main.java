package metroparisien;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Les mots de passe pour les types d'utilisateurs
    private static final String MDP_ADMIN = "2023";
    private static final String MDP_USER = "2024";

    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Scanner scanner = new Scanner(System.in);
        Station actuel = new Station(null, 0, false, 48.8924, 2.2356);

        ReseauMetro r = new ReseauMetro();
        r.initialiserReseau();
        // Création des stations
        // ...

        System.out.println("1. Se connecter en tant qu'Admin");
        System.out.println("2. Se connecter en tant qu'Utilisateur");
        System.out.print("Choisissez une option : ");
        int loginChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        if (loginChoice == 1 && !MDP_ADMIN.equals(password)) {
            System.out.println("Mot de passe incorrect pour l'Admin!");
            return;
        } else if (loginChoice == 2 && !MDP_USER.equals(password)) {
            System.out.println("Mot de passe incorrect pour l'Utilisateur!");
            return;
        }

        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Trouver la station la plus proche");
            System.out.println("2. Trouver l'itinéraire le plus rapide");
            System.out.println("3. Afficher une ligne de métro");
            if (loginChoice == 1) { // Si admin
                System.out.println("4. Afficher l'incident");
            }
            System.out.println("0. Quitter");
            // Demander a l'utilisateur de faire un choix avant d'entrer dans le switch
            System.out.print("Choisissez une option : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre pour votre choix");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    actuel.setPosition(scanner);
                    Station.findNearestStation(r.listeStations, actuel.latitude, actuel.longitude);
                    break;
                case 2:
                    System.out.println("Entrer le nom de la station de départ :");
                    String nomStationDepart = scanner.nextLine();
                    System.out.println("Entrer le nom de la station d'arrivée :");
                    String nomStationArrivee = scanner.nextLine();
                    Station stationDepart = r.getStation(nomStationDepart);
                    Station stationArrivee = r.getStation(nomStationArrivee);
                    if (stationDepart == null || stationArrivee == null) {
                        System.out.println("Station de départ ou d'arrivée inconnue");
                    } else {
                        List<Station> itineraire = r.trouverItineraireLePlusRapide(stationDepart, stationArrivee);
                        //List<Station> itineraire = r.trouverItineraire(stationDepart, stationArrivee);

                        if (itineraire != null) {
                            System.out.println("L'itinéraire le plus rapide est :");
                            for (Station station : itineraire) {
                                System.out.println(station.getNom());
                            }
                        } else {
                            System.out.println("Aucun itinéraire trouvé entre ces deux stations.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Entrer le numéro de la ligne :");
                    int numeroLigne = scanner.nextInt();
                    scanner.nextLine();

                    Ligne ligne = r.getLigne(numeroLigne);
                    if (ligne != null) {
                        ligne.afficherLigne();
                    } else {
                        System.out.println("Ligne inconnue");
                    }
                    break;


                case 4:
                    if (loginChoice == 1) { // Si admin
                        System.out.println("2. Afficher l'incident");
                        System.out.println("Voulez-vous afficher les incidents ? (oui/non)");
                        String reponse = sc.nextLine();
                        if (reponse.equalsIgnoreCase("oui")) {
                            System.out.println("Choisissez le nom de la voie (format: 'nomStationDepart - nomStationArrivee')");
                            String nomVoie = sc.nextLine();
                            for (Voie voie : r.getLignes().get(0).getVoies()) {
                                if ((voie.getStationDepart().getNom() + " - " + voie.getStationArrivee().getNom())
                                        .equals(nomVoie)) {
                                    if (voie.isAccident()) {
                                        System.out.println("Il y a un incident sur la voie " + nomVoie);
                                    } else {
                                        System.out.println("Il n'y a pas d'incident sur la voie " + nomVoie);
                                    }
                                }
                            }
                        }
                    }
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
