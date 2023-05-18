package metroparisien;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReseauMetro {

	public static List<Ligne> lignes;
	public static Map<String, Station> stations;

	public ReseauMetro() {

		// Création des stations
		// Ligne 1
		Station defense = new Station("La Défense - Grande Arche", 3, false);
		Station esplanadeDeLaDefense = new Station("Esplanade de la Défense", 3, false);
		Station pontDeNeuilly = new Station("Pont de Neuilly", 3, false);
		Station lesSablons = new Station("Les Sablons (Jardin d'Acclimatation)", 3, false);
		Station porteMaillot = new Station("Porte Maillot (Palais des Congrès)", 3, false);
		Station argentine = new Station("Argentine", 3, false);
		Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — Étoile", 3, false);
		Station georgeV = new Station("George V", 3, false);
		Station franklinDRoosevelt = new Station("Franklin D. Roosevelt", 3, false);
		Station champsElyseesClemenceau = new Station("Champs-Élysées — Clemenceau (Grand Palais)", 3, false);
		Station concorde = new Station("Concorde", 3, false);
		Station tuileries = new Station("Tuileries", 3, false);
		Station palaisRoyalMuseeDuLouvre = new Station("Palais Royal - Musée du Louvre", 3, false);
		Station louvreRivoli = new Station("Louvre — Rivoli", 3, false);
		Station chatelet = new Station("Châtelet", 3, false);
		Station hotelDeVille = new Station("Hôtel de Ville", 3, false);
		Station saintPaul = new Station("Saint-Paul (Le Marais)", 3, false);
		Station bastille = new Station("Bastille", 3, false);
		Station gareDeLyon = new Station("Gare de Lyon", 3, false);
		Station reuillyDiderot = new Station("Reuilly — Diderot", 3, false);
		Station nation = new Station("Nation", 3, false);
		Station porteDeVincennes = new Station("Porte de Vincennes", 3, false);
		Station saintMande = new Station("Saint-Mandé", 3, false);
		Station berault = new Station("Bérault", 3, false);
		Station chateauDeVincennes = new Station("Château de Vincennes", 3, false);

		Voie defense_esplanadeDeLaDefense = new Voie(defense, esplanadeDeLaDefense, 10, false);
		Voie esplanadeDeLaDefense_pontDeNeuilly = new Voie(esplanadeDeLaDefense, pontDeNeuilly, 10, false);
		Voie pontDeNeuilly_lesSablons = new Voie(pontDeNeuilly, lesSablons, 10, false);
		Voie lesSablons_porteMaillot = new Voie(lesSablons, porteMaillot, 10, false);
		Voie porteMaillot_argentine = new Voie(porteMaillot, argentine, 10, false);
		Voie argentine_charlesDeGaulleEtoile = new Voie(argentine, charlesDeGaulleEtoile, 10, false);
		Voie charlesDeGaulleEtoile_georgeV = new Voie(charlesDeGaulleEtoile, georgeV, 10, false);
		Voie georgeV_franklinDRoosevelt = new Voie(georgeV, franklinDRoosevelt, 10, false);
		Voie franklinDRoosevelt_champsElyseesClemenceau = new Voie(franklinDRoosevelt, champsElyseesClemenceau, 10,
				false);
		Voie champsElyseesClemenceau_concorde = new Voie(champsElyseesClemenceau, concorde, 10, false);
		Voie concorde_tuileries = new Voie(concorde, tuileries, 10, false);
		Voie tuileries_palaisRoyalMuseeDuLouvre = new Voie(tuileries, palaisRoyalMuseeDuLouvre, 10, false);
		Voie palaisRoyalMuseeDuLouvre_louvreRivoli = new Voie(palaisRoyalMuseeDuLouvre, louvreRivoli, 10, false);
		Voie louvreRivoli_chatelet = new Voie(louvreRivoli, chatelet, 10, false);
		Voie chatelet_hotelDeVille = new Voie(chatelet, hotelDeVille, 10, false);
		Voie hotelDeVille_saintPaul = new Voie(hotelDeVille, saintPaul, 10, false);
		Voie saintPaul_bastille = new Voie(saintPaul, bastille, 10, false);
		Voie bastille_gareDeLyon = new Voie(bastille, gareDeLyon, 10, false);
		Voie gareDeLyon_reuillyDiderot = new Voie(gareDeLyon, reuillyDiderot, 10, false);
		Voie reuillyDiderot_nation = new Voie(reuillyDiderot, nation, 10, false);
		Voie nation_porteDeVincennes = new Voie(nation, porteDeVincennes, 10, false);
		Voie porteDeVincennes_saintMande = new Voie(porteDeVincennes, saintMande, 10, false);
		Voie saintMande_berault = new Voie(saintMande, berault, 10, false);
		Voie berault_chateauDeVincennes = new Voie(berault, chateauDeVincennes, 10, false);

		List<Voie> voiesLigne1 = new ArrayList<Voie>();

		voiesLigne1.add(defense_esplanadeDeLaDefense);

		Ligne ligne1 = new Ligne("ligne 1", voiesLigne1);

		// ligne 2
		Station porteDauphine = new Station("Porte Dauphine (Maréchal de Lattre de Tassigny)", 3, false);
		Station victorHugo = new Station("Victor Hugo", 3, false);
		// charlesDeGaulleEtoile
		Station ternes = new Station("Ternes", 3, false);
		Station courcelles = new Station("Courcelles", 3, false);
		Station monceau = new Station("Monceau", 3, false);
		Station villiers = new Station("Villiers", 3, false);
		Station rome = new Station("Rome", 3, false);
		Station placeDeClichy = new Station("Place de Clichy", 3, false);
		Station blanche = new Station("Blanche", 3, false);
		Station pigalle = new Station("Pigalle", 3, false);
		Station anvers = new Station("Anvers (Sacré-Cœur)", 3, false);
		Station barbesRochechouart = new Station("Barbès - Rochechouart", 3, false);
		Station laChapelle = new Station("La Chapelle", 3, false);
		Station stalingrad = new Station("Stalingrad", 3, false);
		Station jaures = new Station("Jaurès", 3, false);
		Station colonelFabien = new Station("Colonel Fabien", 3, false);
		Station belleville = new Station("Belleville", 3, false);
		Station couronnes = new Station("Couronnes", 3, false);
		Station menilmontant = new Station("Ménilmontant", 3, false);
		Station pereLachaise = new Station("Père Lachaise", 3, false);
		Station philippeAuguste = new Station("Philippe Auguste", 3, false);
		Station alexandreDumas = new Station("Alexandre Dumas", 3, false);
		Station avron = new Station("Avron", 3, false);
		// nation

	}

	public void getPosition(Station station) {

	}

	public List<Voie> trouverCheminOptimal(Position positionUtilisateur, Position destination) {
		// Variables pour stocker les informations du chemin optimal
		List<Voie> cheminOptimal = null;
		int tempsTrajetOptimal = 0;

		// Parcourir toutes les lignes du réseau
		for (Ligne ligne : lignes) {
			// Trouver la station de départ la plus proche de la position de l'utilisateur
			Station stationDepartPlusProche = null;
			Ligne LigneDepartPlusProche = null;
			int distanceDepartMin = Integer.MAX_VALUE;
			for (Voie voie : ligne.getVoies()) {
				Station station = voie.getStationDepart();
				int distanceDepart = getDistance(positionUtilisateur, station.getPosition());
				
				
				if (distanceDepart < distanceDepartMin) {
					distanceDepartMin = distanceDepart;
					stationDepartPlusProche = station;
					}
				}
			}

			
			Station stationArriveePlusProche = null;
			int distanceArriveeMin = Integer.MAX_VALUE;
			for (Voie voie : ligne.getVoies()) {
				int distanceArrivee = getDistance(destination, voie.getStationArrivee().getPosition());
				if (distanceArrivee < distanceArriveeMin) {
					distanceArriveeMin = distanceArrivee;
					stationArriveePlusProche = voie.getStationArrivee();
				}
			}

			
			int tempsTrajet = calculerTempsParcours(stationDepartPlusProche, stationArriveePlusProche);

			tempsTrajet += calculerTempsMarche(positionUtilisateur, stationDepartPlusProche.getPosition());

			tempsTrajet += calculerTempsMarche(stationArriveePlusProche.getPosition(), destination);

			if (tempsTrajet < tempsTrajetOptimal) {
				tempsTrajetOptimal = tempsTrajet;
				cheminOptimal = new ArrayList<>();
				cheminOptimal.add(new Voie(stationDepartPlusProche, stationArriveePlusProche,
						stationArriveePlusProche.getTempsParcours(), stationArriveePlusProche.isAccident()));
			}
		

	return cheminOptimal;
}

}
