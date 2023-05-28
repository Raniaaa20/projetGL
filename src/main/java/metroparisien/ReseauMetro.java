package metroparisien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReseauMetro {

    public static List<Ligne> lignes;
    public Map<String, Station> stations;
    public List<Station> listeStations = new ArrayList<>();

    private Map<String, Voie> voies;

    public ReseauMetro() {
	this.stations = new HashMap<>();
	this.voies = new HashMap<>();
        this.lignes = new ArrayList<>(); // Initialisation de la liste de lignes
	Station defense = new Station("La Défense - Grande Arche", 1, false, 48.891922, 2.238375);
	Station esplanadeDeLaDefense = new Station("Esplanade de la Défense", 1, false, 48.891522, 2.240573);
	Station pontDeNeuilly = new Station("Pont de Neuilly", 1, false, 48.885648, 2.259503);
	Station lesSablons = new Station("Les Sablons (Jardin d'Acclimatation)", 1, false, 48.879345, 2.272216);
	Station porteMaillot = new Station("Porte Maillot (Palais des Congrès)", 1, false, 48.877461, 2.282395);
	Station argentine = new Station("Argentine", 1, false, 48.875377, 2.291282);
	Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — Étoile", 1, false, 48.873962, 2.295167);

	// Création des voies
	Voie voie1 = new Voie(defense, esplanadeDeLaDefense, 5, false);
	Voie voie2 = new Voie(esplanadeDeLaDefense, pontDeNeuilly, 5, false);
	Voie voie3 = new Voie(pontDeNeuilly, lesSablons, 5, false);
	Voie voie4 = new Voie(lesSablons, porteMaillot, 5, false);
	Voie voie5 = new Voie(porteMaillot, argentine, 5, false);
	Voie voie6 = new Voie(argentine, charlesDeGaulleEtoile, 5, false);

	// Ajout des voies aux stations
	defense.addVoie(voie1);
	esplanadeDeLaDefense.addVoie(voie1);
	esplanadeDeLaDefense.addVoie(voie2);
	pontDeNeuilly.addVoie(voie2);
	pontDeNeuilly.addVoie(voie3);
	lesSablons.addVoie(voie3);
	lesSablons.addVoie(voie4);
	porteMaillot.addVoie(voie4);
	porteMaillot.addVoie(voie5);
	argentine.addVoie(voie5);
	argentine.addVoie(voie6);
	charlesDeGaulleEtoile.addVoie(voie6);

	// Ajout des stations au réseau métro
	this.ajouterStation("La Défense - Grande Arche", defense);
	this.ajouterStation("Esplanade de la Défense", esplanadeDeLaDefense);
	this.ajouterStation("Pont de Neuilly", pontDeNeuilly);
	this.ajouterStation("Les Sablons (Jardin d'Acclimatation)", lesSablons);
	this.ajouterStation("Porte Maillot (Palais des Congrès)", porteMaillot);
	this.ajouterStation("Argentine", argentine);
	this.ajouterStation("Charles de Gaulle — Étoile", charlesDeGaulleEtoile);

	// Création de la ligne 1
	Ligne ligne1 = new Ligne(1, "Ligne 1");

	// Ajout des voies à la ligne 1
	ligne1.addVoie(voie1);
	ligne1.addVoie(voie2);
	ligne1.addVoie(voie3);
	ligne1.addVoie(voie4);
	ligne1.addVoie(voie5);
	ligne1.addVoie(voie6);

	// Ajout des stations à la ligne 1
	ligne1.addStation(defense);
	ligne1.addStation(esplanadeDeLaDefense);
	ligne1.addStation(pontDeNeuilly);
	ligne1.addStation(lesSablons);
	ligne1.addStation(porteMaillot);
	ligne1.addStation(argentine);
	ligne1.addStation(charlesDeGaulleEtoile);

	// Ajout de la ligne 1 au réseau métro
	this.ajouterLigne(ligne1);

    }

    public void ajouterLigne(Ligne ligne) {
	    lignes.add(ligne);
	}

    public void afficherLigne(Ligne ligne) {
	System.out.println("Ligne : " + ligne.getNom());

	List<Voie> voies = ligne.getVoies();
	for (Voie voie : voies) {
	    Station stationDepart = voie.getStationDepart();
	    Station stationArrivee = voie.getStationArrivee();

	    System.out.println("Voie de " + stationDepart.getNom() + " à " + stationArrivee.getNom() + " (Distance "
		    + voie.getDistance() + " minutes)");
	}
    }

    public void ajouterStation(String nom, Station station) {
	this.stations.put(nom, station);
	this.listeStations.add(station);
    }

    public void ajouterVoie(String nom, Voie voie) {
	this.voies.put(nom, voie);
    }

    public Station getStation(String nom) {
	return this.stations.get(nom);
    }

    public Voie getVoie(String nom) {
	return this.voies.get(nom);
    }

    public List<Station> trouverItineraireLePlusRapide(Station depart, Station arrivee) {
	// Implementation de l'algorithme de Dijkstra ou A*
	// Cette méthode retournerait une liste de stations représentant l'itinéraire le
	// plus rapide entre "depart" et "arrivee"
	// Vous pouvez utiliser la distance entre les stations comme le "coût" de chaque
	// voie

	Map<Station, Station> precedenteStation = new HashMap<>();
	Map<Station, Integer> distances = new HashMap<>();
	PriorityQueue<Station> stationsNonVisitees = new PriorityQueue<>(Comparator.comparingInt(distances::get));

	for (Station station : listeStations) {
	    distances.put(station, station.equals(depart) ? 0 : Integer.MAX_VALUE);
	    stationsNonVisitees.add(station);
	}

	while (!stationsNonVisitees.isEmpty()) {
	    Station current = stationsNonVisitees.poll();

	    if (current.equals(arrivee)) {
		break;
	    }

	    for (Voie voie : current.getVoies()) {
		Station voisin = voie.getStationArrivee();
		int nouvelleDistance = distances.get(current) + voie.getDistance();

		if (nouvelleDistance < distances.get(voisin)) {
		    distances.put(voisin, nouvelleDistance);
		    precedenteStation.put(voisin, current);
		    stationsNonVisitees.remove(voisin);
		    stationsNonVisitees.add(voisin);
		}
	    }
	}

	List<Station> itineraire = new ArrayList<>();
	for (Station station = arrivee; station != null; station = precedenteStation.get(station)) {
	    itineraire.add(0, station);
	}

	if (itineraire.get(0).equals(depart)) {
	    return itineraire;
	} else {
	    return null; // Il n'y a pas d'itinéraire entre "depart" et "arrivee"
	}
    }

    public static List<Ligne> getLignes() {
	return lignes;
    }

    public Ligne getLigne(int numeroLigne) {
	for (Ligne ligne : lignes) {
	    if (ligne.getNumero() == numeroLigne) {
		return ligne;
	    }
	}
	return null; // Si aucune ligne ne correspond au numéro spécifié
    }

    /*
     * public ReseauMetro() {
     * 
     * // Création des stations // Ligne 1 Station defense = new
     * Station("La Défense - Grande Arche", 1, false, 48.891922, 2.238375); Station
     * esplanadeDeLaDefense = new Station("Esplanade de la Défense", 1, false,
     * 48.891522, 2.240573); Station pontDeNeuilly = new Station("Pont de Neuilly",
     * 1, false, 48.885648, 2.259503); Station lesSablons = new
     * Station("Les Sablons (Jardin d'Acclimatation)", 1, false, 48.879345,
     * 2.272216); Station porteMaillot = new
     * Station("Porte Maillot (Palais des Congrès)", 1, false, 48.877461, 2.282395);
     * Station argentine = new Station("Argentine", 1, false, 48.875377, 2.291282);
     * Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — Étoile", 1,
     * false, 48.873962, 2.295167); Station georgeV = new Station("George V", 1,
     * false, 48.872074, 2.300816); Station franklinDRoosevelt = new
     * Station("Franklin D. Roosevelt", 1, false, 48.869263, 2.307766); Station
     * champsElyseesClemenceau = new
     * Station("Champs-Élysées — Clemenceau (Grand Palais)", 1, false, 48.867603,
     * 2.312631); Station concorde = new Station("Concorde", 1, false, 48.865165,
     * 2.321428); Station tuileries = new Station("Tuileries", 1, false, 48.863788,
     * 2.327102); Station palaisRoyalMuseeDuLouvre = new
     * Station("Palais Royal - Musée du Louvre", 1, false, 48.862508, 2.336204);
     * Station louvreRivoli = new Station("Louvre — Rivoli", 1, false, 48.860647,
     * 2.340474); Station chatelet = new Station("Châtelet", 1, false, 48.858747,
     * 2.347079); Station hotelDeVille = new Station("Hôtel de Ville", 1, false,
     * 48.857368, 2.351816); Station saintPaul = new
     * Station("Saint-Paul (Le Marais)", 1, false, 48.855452, 2.360816); Station
     * bastille = new Station("Bastille", 1, false, 48.853299, 2.369553); Station
     * gareDeLyon = new Station("Gare de Lyon", 1, false, 48.844945, 2.374570);
     * Station reuillyDiderot = new Station("Reuilly — Diderot", 1, false,
     * 48.847222, 2.387222); Station nation = new Station("Nation", 1, false,
     * 48.848222, 2.397222); Station porteDeVincennes = new
     * Station("Porte de Vincennes", 1, false, 48.847222, 2.407222); Station
     * saintMande = new Station("Saint-Mandé", 1, false, 48.846222, 2.417222);
     * Station berault = new Station("Bérault", 1, false, 48.845222, 2.427222);
     * Station chateauDeVincennes = new Station("Château de Vincennes", 1, false,
     * 48.844222, 2.437222); listeStations.add(defense);
     * listeStations.add(esplanadeDeLaDefense); listeStations.add(pontDeNeuilly);
     * listeStations.add(lesSablons); listeStations.add(porteMaillot);
     * listeStations.add(argentine); listeStations.add(charlesDeGaulleEtoile);
     * listeStations.add(georgeV); listeStations.add(franklinDRoosevelt);
     * listeStations.add(champsElyseesClemenceau); listeStations.add(concorde);
     * listeStations.add(tuileries); listeStations.add(palaisRoyalMuseeDuLouvre);
     * listeStations.add(louvreRivoli); listeStations.add(chatelet);
     * listeStations.add(hotelDeVille); listeStations.add(saintPaul);
     * listeStations.add(bastille); listeStations.add(gareDeLyon);
     * listeStations.add(reuillyDiderot); listeStations.add(nation);
     * listeStations.add(porteDeVincennes); listeStations.add(saintMande);
     * listeStations.add(berault); listeStations.add(chateauDeVincennes);
     * 
     * Voie defense_esplanadeDeLaDefense = new Voie(defense, esplanadeDeLaDefense,
     * 1, false); Voie esplanadeDeLaDefense_pontDeNeuilly = new
     * Voie(esplanadeDeLaDefense, pontDeNeuilly, 2, false); Voie
     * pontDeNeuilly_lesSablons = new Voie(pontDeNeuilly, lesSablons, 1, false);
     * Voie lesSablons_porteMaillot = new Voie(lesSablons, porteMaillot, 2, false);
     * Voie porteMaillot_argentine = new Voie(porteMaillot, argentine, 1, false);
     * Voie argentine_charlesDeGaulleEtoile = new Voie(argentine,
     * charlesDeGaulleEtoile, 2, false); Voie charlesDeGaulleEtoile_georgeV = new
     * Voie(charlesDeGaulleEtoile, georgeV, 1, false); Voie
     * georgeV_franklinDRoosevelt = new Voie(georgeV, franklinDRoosevelt, 1, false);
     * Voie franklinDRoosevelt_champsElyseesClemenceau = new
     * Voie(franklinDRoosevelt, champsElyseesClemenceau, 2, false); Voie
     * champsElyseesClemenceau_concorde = new Voie(champsElyseesClemenceau,
     * concorde, 1, false); Voie concorde_tuileries = new Voie(concorde, tuileries,
     * 1, false); Voie tuileries_palaisRoyalMuseeDuLouvre = new Voie(tuileries,
     * palaisRoyalMuseeDuLouvre, 2, false); Voie
     * palaisRoyalMuseeDuLouvre_louvreRivoli = new Voie(palaisRoyalMuseeDuLouvre,
     * louvreRivoli, 1, false); Voie louvreRivoli_chatelet = new Voie(louvreRivoli,
     * chatelet, 1, false); Voie chatelet_hotelDeVille = new Voie(chatelet,
     * hotelDeVille, 1, false); Voie hotelDeVille_saintPaul = new Voie(hotelDeVille,
     * saintPaul, 2, false); Voie saintPaul_bastille = new Voie(saintPaul, bastille,
     * 2, false); Voie bastille_gareDeLyon = new Voie(bastille, gareDeLyon, 2,
     * false); Voie gareDeLyon_reuillyDiderot = new Voie(gareDeLyon, reuillyDiderot,
     * 2, false); Voie reuillyDiderot_nation = new Voie(reuillyDiderot, nation, 2,
     * false); Voie nation_porteDeVincennes = new Voie(nation, porteDeVincennes, 1,
     * false); Voie porteDeVincennes_saintMande = new Voie(porteDeVincennes,
     * saintMande, 2, false); Voie saintMande_berault = new Voie(saintMande,
     * berault, 2, false); Voie berault_chateauDeVincennes = new Voie(berault,
     * chateauDeVincennes, 2, false);
     * 
     * List<Voie> voiesLigne1 = new ArrayList<Voie>();
     * 
     * voiesLigne1.add(defense_esplanadeDeLaDefense);
     * voiesLigne1.add(defense_esplanadeDeLaDefense);
     * voiesLigne1.add(esplanadeDeLaDefense_pontDeNeuilly);
     * voiesLigne1.add(pontDeNeuilly_lesSablons);
     * voiesLigne1.add(lesSablons_porteMaillot);
     * voiesLigne1.add(porteMaillot_argentine);
     * voiesLigne1.add(argentine_charlesDeGaulleEtoile);
     * voiesLigne1.add(charlesDeGaulleEtoile_georgeV);
     * voiesLigne1.add(georgeV_franklinDRoosevelt);
     * voiesLigne1.add(franklinDRoosevelt_champsElyseesClemenceau);
     * voiesLigne1.add(champsElyseesClemenceau_concorde);
     * voiesLigne1.add(concorde_tuileries);
     * voiesLigne1.add(tuileries_palaisRoyalMuseeDuLouvre);
     * voiesLigne1.add(palaisRoyalMuseeDuLouvre_louvreRivoli);
     * voiesLigne1.add(louvreRivoli_chatelet);
     * voiesLigne1.add(chatelet_hotelDeVille);
     * voiesLigne1.add(hotelDeVille_saintPaul); voiesLigne1.add(saintPaul_bastille);
     * voiesLigne1.add(bastille_gareDeLyon);
     * voiesLigne1.add(gareDeLyon_reuillyDiderot);
     * voiesLigne1.add(reuillyDiderot_nation);
     * voiesLigne1.add(nation_porteDeVincennes);
     * voiesLigne1.add(porteDeVincennes_saintMande);
     * voiesLigne1.add(saintMande_berault);
     * voiesLigne1.add(berault_chateauDeVincennes);
     * 
     * Ligne ligne1 = new Ligne("ligne 1", voiesLigne1);
     * 
     * // ligne 2 Station porteDauphine = new
     * Station("Porte Dauphine (Maréchal de Lattre de Tassigny)", 1, false, 48.8715,
     * 2.2745); Station victorHugo = new Station("Victor Hugo", 1, false, 48.8692,
     * 2.2849); Station ternes = new Station("Ternes", 1, false, 48.8785, 2.2984);
     * Station courcelles = new Station("Courcelles", 1, false, 48.8792, 2.3066);
     * Station monceau = new Station("Monceau", 1, false, 48.8817, 2.3147); Station
     * villiers = new Station("Villiers", 1, false, 48.8828, 2.3220); Station rome =
     * new Station("Rome", 1, false, 48.8836, 2.3278); Station placeDeClichy = new
     * Station("Place de Clichy", 1, false, 48.8846, 2.3322); Station blanche = new
     * Station("Blanche", 1, false, 48.8826, 2.3378); Station pigalle = new
     * Station("Pigalle", 1, false, 48.8821, 2.3424); Station anvers = new
     * Station("Anvers (Sacré-Cœur)", 1, false, 48.8827, 2.3449); Station
     * barbesRochechouart = new Station("Barbès - Rochechouart", 1, false, 48.8833,
     * 2.3499); Station laChapelle = new Station("La Chapelle", 1, false, 48.8836,
     * 2.3587); Station stalingrad = new Station("Stalingrad", 1, false, 48.8834,
     * 2.3692); Station jaures = new Station("Jaurès", 1, false, 48.8809, 2.3697);
     * Station colonelFabien = new Station("Colonel Fabien", 1, false, 48.8769,
     * 2.3707); Station belleville = new Station("Belleville", 1, false, 48.8718,
     * 2.3762); Station couronnes = new Station("Couronnes", 1, false, 48.8695,
     * 2.3789); Station menilmontant = new Station("Ménilmontant", 1, false,
     * 48.8672, 2.3829); Station pereLachaise = new Station("Père Lachaise", 1,
     * false, 48.8628, 2.3929); Station philippeAuguste = new
     * Station("Philippe Auguste", 1, false, 48.8589, 2.3989); Station
     * alexandreDumas = new Station("Alexandre Dumas", 1, false, 48.8565, 2.4029);
     * Station avron = new Station("Avron", 1, false, 48.8532, 2.4056);
     * listeStations.add(porteDauphine); listeStations.add(victorHugo);
     * listeStations.add(ternes); listeStations.add(courcelles);
     * listeStations.add(monceau); listeStations.add(villiers);
     * listeStations.add(rome); listeStations.add(placeDeClichy);
     * listeStations.add(blanche); listeStations.add(pigalle);
     * listeStations.add(anvers); listeStations.add(barbesRochechouart);
     * listeStations.add(laChapelle); listeStations.add(stalingrad);
     * listeStations.add(jaures); listeStations.add(colonelFabien);
     * listeStations.add(belleville); listeStations.add(couronnes);
     * listeStations.add(menilmontant); listeStations.add(pereLachaise);
     * listeStations.add(philippeAuguste); listeStations.add(alexandreDumas);
     * listeStations.add(avron);
     * 
     * // nation
     * 
     * // Les voies de la deuxième ligne Voie porteDauphine_victorHugo = new
     * Voie(porteDauphine, victorHugo, 2, false); Voie
     * victorHugo_charlesDeGaulleEtoile = new Voie(victorHugo,
     * charlesDeGaulleEtoile, 2, false); Voie charlesDeGaulleEtoile_ternes = new
     * Voie(charlesDeGaulleEtoile, ternes, 1, false); Voie ternes_courcelles = new
     * Voie(ternes, courcelles, 1, false); Voie courcelles_monceau = new
     * Voie(courcelles, monceau, 1, false); Voie monceau_villiers = new
     * Voie(monceau, villiers, 2, false); Voie villiers_rome = new Voie(villiers,
     * rome, 1, false); Voie rome_placeDeClichy = new Voie(rome, placeDeClichy, 1,
     * false); Voie placeDeClichy_blanche = new Voie(placeDeClichy, blanche, 2,
     * false); Voie blanche_pigalle = new Voie(blanche, pigalle, 1, false); Voie
     * pigalle_anvers = new Voie(pigalle, anvers, 1, false); Voie
     * anvers_barbesRochechouart = new Voie(anvers, barbesRochechouart, 2, false);
     * Voie barbesRochechouart_laChapelle = new Voie(barbesRochechouart, laChapelle,
     * 1, false); Voie laChapelle_stalingrad = new Voie(laChapelle, stalingrad, 2,
     * false); Voie stalingrad_jaures = new Voie(stalingrad, jaures, 1, false); Voie
     * jaures_colonelFabien = new Voie(jaures, colonelFabien, 2, false); Voie
     * colonelFabien_belleville = new Voie(colonelFabien, belleville, 1, false);
     * Voie belleville_couronnes = new Voie(belleville, couronnes, 1, false); Voie
     * couronnes_menilmontant = new Voie(couronnes, menilmontant, 2, false); Voie
     * menilmontant_pereLachaise = new Voie(menilmontant, pereLachaise, 2, false);
     * Voie pereLachaise_philippeAuguste = new Voie(pereLachaise, philippeAuguste,
     * 1, false); Voie philippeAuguste_alexandreDumas = new Voie(philippeAuguste,
     * alexandreDumas, 1, false); Voie alexandreDumas_avron = new
     * Voie(alexandreDumas, avron, 2, false); Voie avron_nation = new Voie(avron,
     * nation, 3, false);
     * 
     * List<Voie> voiesLigne2 = new ArrayList<Voie>();
     * 
     * voiesLigne2.add(porteDauphine_victorHugo);
     * voiesLigne2.add(victorHugo_charlesDeGaulleEtoile);
     * voiesLigne2.add(charlesDeGaulleEtoile_ternes);
     * voiesLigne2.add(ternes_courcelles); voiesLigne2.add(courcelles_monceau);
     * voiesLigne2.add(monceau_villiers); voiesLigne2.add(villiers_rome);
     * voiesLigne2.add(rome_placeDeClichy); voiesLigne2.add(placeDeClichy_blanche);
     * voiesLigne2.add(blanche_pigalle); voiesLigne2.add(pigalle_anvers);
     * voiesLigne2.add(anvers_barbesRochechouart);
     * voiesLigne2.add(barbesRochechouart_laChapelle);
     * voiesLigne2.add(laChapelle_stalingrad); voiesLigne2.add(stalingrad_jaures);
     * voiesLigne2.add(jaures_colonelFabien);
     * voiesLigne2.add(colonelFabien_belleville);
     * voiesLigne2.add(belleville_couronnes);
     * voiesLigne2.add(couronnes_menilmontant);
     * voiesLigne2.add(menilmontant_pereLachaise);
     * voiesLigne2.add(pereLachaise_philippeAuguste);
     * voiesLigne2.add(philippeAuguste_alexandreDumas);
     * voiesLigne2.add(alexandreDumas_avron); voiesLigne2.add(avron_nation);
     * 
     * Ligne ligne2 = new Ligne("ligne 2", voiesLigne2);
     * 
     * // Ligne 3 Station pontDeLevalloisBecon = new
     * Station("Pont de Levallois — Bécon", 1, false, 48.8978, 2.2832); Station
     * anatoleFrance = new Station("Anatole France", 1, false, 48.8928, 2.2852);
     * Station louiseMichel = new Station("Louise Michel", 1, false, 48.8884,
     * 2.2871); Station porteDeChamperret = new Station("Porte de Champerret", 1,
     * false, 48.8851, 2.2889); Station pereireMarJ = new
     * Station("Pereire (Maréchal Juin)", 1, false, 48.8825, 2.2961); Station wagram
     * = new Station("Wagram", 1, false, 48.8828, 2.3004); Station malesherbes = new
     * Station("Malesherbes", 1, false, 48.8822, 2.3062); Station europe = new
     * Station("Europe", 1, false, 48.8791, 2.3261); Station stLazare = new
     * Station("Saint-Lazare", 1, false, 48.8755, 2.3256); Station havreCaumartin =
     * new Station("Havre — Caumartin", 1, false, 48.8735, 2.3295); Station opera =
     * new Station("Opéra", 1, false, 48.8713, 2.3323); Station quatreSeptembre =
     * new Station("Quatre-Septembre", 1, false, 48.8693, 2.3356); Station bourse =
     * new Station("Bourse", 1, false, 48.8688, 2.3405); Station sentier = new
     * Station("Sentier", 1, false, 48.8686, 2.3462); Station reaumurSebastopol =
     * new Station("Réaumur — Sébastopol", 1, false, 48.8663, 2.3523); Station
     * artsMetiers = new Station("Arts et Métiers", 1, false, 48.8656, 2.3564);
     * Station temple = new Station("Temple", 1, false, 48.8667, 2.3616); Station
     * republique = new Station("République", 1, false, 48.8675, 2.3638); Station
     * parmentier = new Station("Parmentier", 1, false, 48.8657, 2.3746); Station
     * rueStMaur = new Station("Rue Saint-Maur", 1, false, 48.8642, 2.3781); Station
     * gambetta = new Station("Gambetta", 1, false, 48.8649, 2.3981); Station
     * porteDeBagnolet = new Station("Porte de Bagnolet", 1, false, 48.8641,
     * 2.4092); Station gallieni = new Station("Gallieni (Parc de Bagnolet)", 1,
     * false, 48.8648, 2.4168); listeStations.add(pontDeLevalloisBecon);
     * listeStations.add(anatoleFrance); listeStations.add(louiseMichel);
     * listeStations.add(porteDeChamperret); listeStations.add(pereireMarJ);
     * listeStations.add(wagram); listeStations.add(malesherbes);
     * listeStations.add(europe); listeStations.add(stLazare);
     * listeStations.add(havreCaumartin); listeStations.add(opera);
     * listeStations.add(quatreSeptembre); listeStations.add(bourse);
     * listeStations.add(sentier); listeStations.add(reaumurSebastopol);
     * listeStations.add(artsMetiers); listeStations.add(temple);
     * listeStations.add(republique); listeStations.add(parmentier);
     * listeStations.add(rueStMaur); listeStations.add(gambetta);
     * listeStations.add(porteDeBagnolet); listeStations.add(gallieni); // Station
     * gareEurolines = new Station("Gare Routière Internationale Eurolines", // 3,
     * false);
     * 
     * // Création des voies de la ligne 3 Voie pontDeLevalloisBecon_anatoleFrance =
     * new Voie(pontDeLevalloisBecon, anatoleFrance, 1, false); Voie
     * anatoleFrance_louiseMichel = new Voie(anatoleFrance, louiseMichel, 2, false);
     * Voie louiseMichel_porteDeChamperret = new Voie(louiseMichel,
     * porteDeChamperret, 2, false); Voie porteDeChamperret_pereireMarJ = new
     * Voie(porteDeChamperret, pereireMarJ, 1, false); Voie pereireMarJ_wagram = new
     * Voie(pereireMarJ, wagram, 2, false); Voie wagram_malesherbes = new
     * Voie(wagram, malesherbes, 1, false); Voie malesherbes_villiers = new
     * Voie(malesherbes, villiers, 1, false); Voie villiers_europe = new
     * Voie(villiers, europe, 2, false); Voie europe_stLazare = new Voie(europe,
     * stLazare, 2, false); Voie stLazare_havreCaumartin = new Voie(stLazare,
     * havreCaumartin, 1, false); Voie havreCaumartin_opera = new
     * Voie(havreCaumartin, opera, 1, false); Voie opera_quatreSeptembre = new
     * Voie(opera, quatreSeptembre, 1, false); Voie quatreSeptembre_bourse = new
     * Voie(quatreSeptembre, bourse, 1, false); Voie bourse_sentier = new
     * Voie(bourse, sentier, 2, false); Voie sentier_reaumurSebastopol = new
     * Voie(sentier, reaumurSebastopol, 1, false); Voie
     * reaumurSebastopol_artsMetiers = new Voie(reaumurSebastopol, artsMetiers, 1,
     * false); Voie artsMetiers_temple = new Voie(artsMetiers, temple, 1, false);
     * Voie temple_republique = new Voie(temple, republique, 1, false); Voie
     * republique_parmentier = new Voie(republique, parmentier, 2, false); Voie
     * parmentier_rueStMaur = new Voie(parmentier, rueStMaur, 1, false); Voie
     * rueStMaur_pereLachaise = new Voie(rueStMaur, pereLachaise, 1, false); Voie
     * pereLachaise_gambetta = new Voie(pereLachaise, gambetta, 2, false); Voie
     * gambetta_porteDeBagnolet = new Voie(gambetta, porteDeBagnolet, 2, false);
     * Voie porteDeBagnolet_gallieni = new Voie(porteDeBagnolet, gallieni, 2,
     * false);
     * 
     * List<Voie> voiesLigne3 = new ArrayList<Voie>();
     * 
     * voiesLigne3.add(pontDeLevalloisBecon_anatoleFrance);
     * voiesLigne3.add(anatoleFrance_louiseMichel);
     * voiesLigne3.add(louiseMichel_porteDeChamperret);
     * voiesLigne3.add(porteDeChamperret_pereireMarJ);
     * voiesLigne3.add(pereireMarJ_wagram); voiesLigne3.add(wagram_malesherbes);
     * voiesLigne3.add(malesherbes_villiers); voiesLigne3.add(villiers_europe);
     * voiesLigne3.add(europe_stLazare); voiesLigne3.add(stLazare_havreCaumartin);
     * voiesLigne3.add(havreCaumartin_opera);
     * voiesLigne3.add(opera_quatreSeptembre);
     * voiesLigne3.add(quatreSeptembre_bourse); voiesLigne3.add(bourse_sentier);
     * voiesLigne3.add(sentier_reaumurSebastopol);
     * voiesLigne3.add(reaumurSebastopol_artsMetiers);
     * voiesLigne3.add(artsMetiers_temple); voiesLigne3.add(temple_republique);
     * voiesLigne3.add(republique_parmentier);
     * voiesLigne3.add(parmentier_rueStMaur);
     * voiesLigne3.add(rueStMaur_pereLachaise);
     * voiesLigne3.add(pereLachaise_gambetta);
     * voiesLigne3.add(gambetta_porteDeBagnolet);
     * voiesLigne3.add(porteDeBagnolet_gallieni);
     * 
     * Ligne ligne3 = new Ligne("ligne 3", voiesLigne3);
     * 
     * // Ligne 3bis
     * 
     * Station porteDesLilas = new Station("Porte des Lilas", 1, false); Station
     * saintFargeau = new Station("Saint-Fargeau", 1, false); Station pelleport =
     * new Station("Pelleport", 1, false); // gambetta
     * 
     * Voie porteDesLilas_saintFargeau = new Voie(porteDesLilas, saintFargeau, 1,
     * false); Voie saintFargeau_pelleport = new Voie(saintFargeau, pelleport, 1,
     * false); Voie pelleport_gambetta = new Voie(pelleport, gambetta, 1, false);
     * 
     * List<Voie> voiesLigne3bis = new ArrayList<Voie>();
     * 
     * voiesLigne3bis.add(porteDesLilas_saintFargeau);
     * voiesLigne3bis.add(saintFargeau_pelleport);
     * voiesLigne3bis.add(pelleport_gambetta);
     * 
     * Ligne ligne3bis = new Ligne("ligne 3bis", voiesLigne3bis);
     * 
     * // Ligne 4
     * 
     * Station porteDeClignancourt = new Station("Porte de Clignancourt", 1, false,
     * 48.8998, 2.3446); Station simplon = new Station("Simplon", 1, false, 48.8921,
     * 2.3483); Station marcadetPoissonniers = new
     * Station("Marcadet — Poissonniers", 1, false, 48.8902, 2.3495); Station
     * chateauRouge = new Station("Château Rouge", 1, false, 48.8885, 2.3507);
     * Station gareDuNord = new Station("Gare du Nord", 1, false, 48.8805, 2.3553);
     * Station gareDeLEstVerdun = new Station("Gare de l'Est (Verdun)", 1, false,
     * 48.8772, 2.3582); Station chateauDEau = new Station("Château d'Eau", 1,
     * false, 48.8728, 2.3542); Station strasbourgSaintDenis = new
     * Station("Strasbourg — Saint-Denis", 1, false, 48.8696, 2.3543); Station
     * etienneMarcel = new Station("Étienne Marcel", 1, false, 48.8638, 2.3485);
     * Station lesHalles = new Station("Les Halles", 1, false, 48.8616, 2.3471);
     * Station cite = new Station("Cité", 1, false, 48.8554, 2.3474); Station
     * saintMichel = new Station("Saint-Michel", 1, false, 48.8534, 2.3444); Station
     * odeon = new Station("Odéon", 1, false, 48.8516, 2.3398); Station
     * saintGermainDesPres = new Station("Saint-Germain-des-Prés", 1, false,
     * 48.8516, 2.3333); Station saintSulpice = new Station("Saint-Sulpice", 1,
     * false, 48.8507, 2.3332); Station saintPlacide = new Station("Saint-Placide",
     * 1, false, 48.8465, 2.3279); Station montparnasseBienvenue = new
     * Station("Montparnasse — Bienvenüe", 1, false, 48.8421, 2.3219); Station vavin
     * = new Station("Vavin", 1, false, 48.8405, 2.3329); Station raspail = new
     * Station("Raspail", 1, false, 48.8381, 2.3314); Station denfertRochereau = new
     * Station("Denfert-Rochereau (Colonel Rol-Tanguy)", 1, false, 48.8338, 2.3324);
     * Station moutonDuvernet = new Station("Mouton-Duvernet", 1, false, 48.8317,
     * 2.3306); Station alesia = new Station("Alésia", 1, false, 48.8284, 2.3285);
     * Station porteDOrleansLeclerc = new
     * Station("Porte d'Orléans (Général Leclerc)", 1, false, 48.8231, 2.3257);
     * Station mairieDeMontrouge = new Station("Mairie de Montrouge", 1, false,
     * 48.8192, 2.3187); listeStations.add(porteDeClignancourt);
     * listeStations.add(simplon); listeStations.add(marcadetPoissonniers);
     * listeStations.add(chateauRouge); listeStations.add(barbesRochechouart);
     * listeStations.add(gareDuNord); listeStations.add(gareDeLEstVerdun);
     * listeStations.add(chateauDEau); listeStations.add(strasbourgSaintDenis);
     * listeStations.add(reaumurSebastopol); listeStations.add(etienneMarcel);
     * listeStations.add(lesHalles); listeStations.add(chatelet);
     * listeStations.add(cite); listeStations.add(saintMichel);
     * listeStations.add(odeon); listeStations.add(saintGermainDesPres);
     * listeStations.add(saintSulpice); listeStations.add(saintPlacide);
     * listeStations.add(montparnasseBienvenue); listeStations.add(vavin);
     * listeStations.add(raspail); listeStations.add(denfertRochereau);
     * listeStations.add(moutonDuvernet); listeStations.add(alesia);
     * listeStations.add(porteDOrleansLeclerc);
     * listeStations.add(mairieDeMontrouge);
     * 
     * // Voies de la ligne 4 // Création des voies de la ligne 4 Voie
     * porteDeClignancourt_simplon = new Voie(porteDeClignancourt, simplon, 1,
     * false); Voie simplon_marcadetPoissonniers = new Voie(simplon,
     * marcadetPoissonniers, 1, false); Voie marcadetPoissonniers_chateauRouge = new
     * Voie(marcadetPoissonniers, chateauRouge, 1, false); Voie
     * chateauRouge_barbesRochechouart = new Voie(chateauRouge, barbesRochechouart,
     * 1, false); Voie barbesRochechouart_gareDuNord = new Voie(barbesRochechouart,
     * gareDuNord, 2, false); Voie gareDuNord_gareDeLEstVerdun = new
     * Voie(gareDuNord, gareDeLEstVerdun, 2, false); Voie
     * gareDeLEstVerdun_chateauDEau = new Voie(gareDeLEstVerdun, chateauDEau, 1,
     * false); Voie chateauDEau_strasbourgSaintDenis = new Voie(chateauDEau,
     * strasbourgSaintDenis, 1, false); Voie strasbourgSaintDenis_reaumurSebastopol
     * = new Voie(strasbourgSaintDenis, reaumurSebastopol, 1, false); Voie
     * reaumurSebastopol_etienneMarcel = new Voie(reaumurSebastopol, etienneMarcel,
     * 2, false); Voie etienneMarcel_lesHalles = new Voie(etienneMarcel, lesHalles,
     * 1, false); Voie lesHalles_chatelet = new Voie(lesHalles, chatelet, 1, false);
     * Voie chatelet_cite = new Voie(chatelet, cite, 2, false); Voie
     * cite_saintMichel = new Voie(cite, saintMichel, 1, false); Voie
     * saintMichel_odeon = new Voie(saintMichel, odeon, 1, false); Voie
     * odeon_saintGermainDesPres = new Voie(odeon, saintGermainDesPres, 1, false);
     * Voie saintGermainDesPres_saintSulpice = new Voie(saintGermainDesPres,
     * saintSulpice, 1, false); Voie saintSulpice_saintPlacide = new
     * Voie(saintSulpice, saintPlacide, 1, false); Voie
     * saintPlacide_montparnasseBienvenue = new Voie(saintPlacide,
     * montparnasseBienvenue, 2, false); Voie montparnasseBienvenue_vavin = new
     * Voie(montparnasseBienvenue, vavin, 1, false); Voie vavin_raspail = new
     * Voie(vavin, raspail, 1, false); Voie raspail_denfertRochereau = new
     * Voie(raspail, denfertRochereau, 2, false); Voie
     * denfertRochereau_moutonDuvernet = new Voie(denfertRochereau, moutonDuvernet,
     * 1, false); Voie moutonDuvernet_alesia = new Voie(moutonDuvernet, alesia, 1,
     * false); Voie alesia_porteDOrleansLeclerc = new Voie(alesia,
     * porteDOrleansLeclerc, 1, false); Voie porteDOrleansLeclerc_mairieDeMontrouge
     * = new Voie(porteDOrleansLeclerc, mairieDeMontrouge, 2, false);
     * 
     * List<Voie> voiesLigne4 = new ArrayList<Voie>();
     * 
     * voiesLigne4.add(porteDeClignancourt_simplon);
     * voiesLigne4.add(simplon_marcadetPoissonniers);
     * voiesLigne4.add(marcadetPoissonniers_chateauRouge);
     * voiesLigne4.add(chateauRouge_barbesRochechouart);
     * voiesLigne4.add(barbesRochechouart_gareDuNord);
     * voiesLigne4.add(gareDuNord_gareDeLEstVerdun);
     * voiesLigne4.add(gareDeLEstVerdun_chateauDEau);
     * voiesLigne4.add(chateauDEau_strasbourgSaintDenis);
     * voiesLigne4.add(strasbourgSaintDenis_reaumurSebastopol);
     * voiesLigne4.add(reaumurSebastopol_etienneMarcel);
     * voiesLigne4.add(etienneMarcel_lesHalles);
     * voiesLigne4.add(lesHalles_chatelet); voiesLigne4.add(chatelet_cite);
     * voiesLigne4.add(cite_saintMichel); voiesLigne4.add(saintMichel_odeon);
     * voiesLigne4.add(odeon_saintGermainDesPres);
     * voiesLigne4.add(saintGermainDesPres_saintSulpice);
     * voiesLigne4.add(saintSulpice_saintPlacide);
     * voiesLigne4.add(saintPlacide_montparnasseBienvenue);
     * voiesLigne4.add(montparnasseBienvenue_vavin); voiesLigne4.add(vavin_raspail);
     * voiesLigne4.add(raspail_denfertRochereau);
     * voiesLigne4.add(denfertRochereau_moutonDuvernet);
     * voiesLigne4.add(moutonDuvernet_alesia);
     * voiesLigne4.add(alesia_porteDOrleansLeclerc);
     * voiesLigne4.add(porteDOrleansLeclerc_mairieDeMontrouge);
     * 
     * Ligne ligne4 = new Ligne("ligne 4", voiesLigne4);
     * 
     * // Ligne 7 Station courneuve8Mai1945 = new
     * Station("La Courneuve — 8 Mai 1945", 1, false, 48.9244, 2.4008); Station
     * fortdaubervilliers = new Station("Fort d'Aubervilliers", 1, false, 48.9163,
     * 2.3839); Station aubervilliersPantinQuatreChemins = new
     * Station("Aubervilliers — Pantin — Quatre Chemins", 1, false, 48.9057,
     * 2.3821); Station porteDeLaVillette = new
     * Station("Porte de la Villette (Cité des Sciences et de l'Industrie)", 1,
     * false, 48.8966, 2.3853); Station corentinCariou = new
     * Station("Corentin Cariou", 1, false, 48.8935, 2.3817); Station crimee = new
     * Station("Crimée", 1, false, 48.8895, 2.3785); Station riquet = new
     * Station("Riquet", 1, false, 48.8848, 2.3741); Station louisBlanc = new
     * Station("Louis Blanc", 1, false, 48.8826, 2.3652); Station chateauLandon =
     * new Station("Château-Landon", 1, false, 48.8786, 2.3628); Station
     * poissonniere = new Station("Poissonnière", 1, false, 48.8770, 2.3488);
     * Station cadet = new Station("Cadet", 1, false, 48.8735, 2.3442); Station
     * lePeletier = new Station("Le Peletier", 1, false, 48.8720, 2.3416); Station
     * chausseeDAntinLaFayette = new Station("Chaussée d'Antin — La Fayette", 1,
     * false, 48.8713, 2.3325); Station pyramides = new Station("Pyramides", 1,
     * false, 48.8663, 2.3348); Station palaisRoyalMuseeLouvre = new
     * Station("Palais Royal — Musée du Louvre", 1, false, 48.8636, 2.3363); Station
     * pontNeuf = new Station("Pont Neuf", 1, false, 48.8592, 2.3417); Station
     * pontMarie = new Station("Pont Marie (Cité des Arts)", 1, false, 48.8534,
     * 2.3571); Station sullyMorland = new Station("Sully — Morland", 1, false,
     * 48.8505, 2.3615); Station jussieu = new Station("Jussieu", 1, false, 48.8461,
     * 2.3546); Station placeMonge = new
     * Station("Place Monge (Jardin des Plantes - Arènes de Lutèce)", 1, false,
     * 48.8433, 2.3523); Station censierDaubenton = new
     * Station("Censier — Daubenton", 1, false, 48.8396, 2.3522); Station
     * lesGobelins = new Station("Les Gobelins", 1, false, 48.8355, 2.3521); Station
     * placeDItalie = new Station("Place d'Italie", 1, false, 48.8318, 2.3557);
     * Station tolbiac = new Station("Tolbiac", 1, false, 48.8267, 2.3572); Station
     * maisonBlanche = new Station("Maison Blanche", 1, false, 48.8223, 2.3581);
     * listeStations.add(courneuve8Mai1945); listeStations.add(fortdaubervilliers);
     * listeStations.add(aubervilliersPantinQuatreChemins);
     * listeStations.add(porteDeLaVillette); listeStations.add(corentinCariou);
     * listeStations.add(crimee); listeStations.add(riquet);
     * listeStations.add(louisBlanc); listeStations.add(chateauLandon);
     * listeStations.add(poissonniere); listeStations.add(cadet);
     * listeStations.add(lePeletier); listeStations.add(chausseeDAntinLaFayette);
     * listeStations.add(pyramides); listeStations.add(palaisRoyalMuseeLouvre);
     * listeStations.add(pontNeuf); listeStations.add(pontMarie);
     * listeStations.add(sullyMorland); listeStations.add(jussieu);
     * listeStations.add(placeMonge); listeStations.add(censierDaubenton);
     * listeStations.add(lesGobelins); listeStations.add(placeDItalie);
     * listeStations.add(tolbiac); listeStations.add(maisonBlanche);
     * 
     * // Les voies de la ligne 7 Voie courneuve8Mai1945_fortdaubervilliers = new
     * Voie(courneuve8Mai1945, aubervilliersPantinQuatreChemins, 2, false); Voie
     * fortdaubervilliers_aubervilliersPantinQuatreChemins = new
     * Voie(fortdaubervilliers, aubervilliersPantinQuatreChemins, 2, false); Voie
     * aubervilliersPantinQuatreChemins_porteDeLaVillette = new
     * Voie(aubervilliersPantinQuatreChemins, porteDeLaVillette, 2, false); Voie
     * porteDeLaVillette_corentinCariou = new Voie(porteDeLaVillette,
     * corentinCariou, 2, false); Voie corentinCariou_crimee = new
     * Voie(corentinCariou, crimee, 1, false); Voie crimee_riquet = new Voie(crimee,
     * riquet, 1, false); Voie riquet_stalingrad = new Voie(riquet, stalingrad, 1,
     * false); Voie stalingrad_louisBlanc = new Voie(stalingrad, louisBlanc, 2,
     * false); Voie louisBlanc_chateauLandon = new Voie(louisBlanc, chateauLandon,
     * 1, false); Voie chateauLandon_gareDeLEstVerdun = new Voie(chateauLandon,
     * gareDeLEstVerdun, 2, false); Voie gareDeLEstVerdun_poissonniere = new
     * Voie(gareDeLEstVerdun, poissonniere, 2, false); Voie poissonniere_cadet = new
     * Voie(poissonniere, cadet, 1, false); Voie cadet_lePeletier = new Voie(cadet,
     * lePeletier, 1, false); Voie lePeletier_chausseeDAntinLaFayette = new
     * Voie(lePeletier, chausseeDAntinLaFayette, 1, false); Voie
     * chausseeDAntinLaFayette_opera = new Voie(chausseeDAntinLaFayette, opera, 2,
     * false); Voie opera_pyramides = new Voie(opera, pyramides, 1, false); Voie
     * pyramides_palaisRoyalMuseeLouvre = new Voie(pyramides,
     * palaisRoyalMuseeLouvre, 2, false); Voie palaisRoyalMuseeLouvre_pontNeuf = new
     * Voie(palaisRoyalMuseeLouvre, pontNeuf, 1, false); Voie pontNeuf_chatelet =
     * new Voie(pontNeuf, chatelet, 2, false); Voie chatelet_pontMarie = new
     * Voie(chatelet, pontMarie, 1, false); Voie pontMarie_sullyMorland = new
     * Voie(pontMarie, sullyMorland, 2, false); Voie sullyMorland_jussieu = new
     * Voie(sullyMorland, jussieu, 1, false); Voie jussieu_placeMonge = new
     * Voie(jussieu, placeMonge, 2, false); Voie placeMonge_censierDaubenton = new
     * Voie(placeMonge, censierDaubenton, 1, false); Voie
     * censierDaubenton_lesGobelins = new Voie(censierDaubenton, lesGobelins, 1,
     * false); Voie lesGobelins_placeDItalie = new Voie(lesGobelins, placeDItalie,
     * 2, false); Voie placeDItalie_tolbiac = new Voie(placeDItalie, tolbiac, 1,
     * false); Voie tolbiac_maisonBlanche = new Voie(tolbiac, maisonBlanche, 1,
     * false);
     * 
     * List<Voie> voiesLigne7 = new ArrayList<Voie>();
     * 
     * voiesLigne7.add(courneuve8Mai1945_fortdaubervilliers);
     * voiesLigne7.add(fortdaubervilliers_aubervilliersPantinQuatreChemins);
     * voiesLigne7.add(aubervilliersPantinQuatreChemins_porteDeLaVillette);
     * voiesLigne7.add(porteDeLaVillette_corentinCariou);
     * voiesLigne7.add(corentinCariou_crimee); voiesLigne7.add(crimee_riquet);
     * voiesLigne7.add(riquet_stalingrad); voiesLigne7.add(stalingrad_louisBlanc);
     * voiesLigne7.add(louisBlanc_chateauLandon);
     * voiesLigne7.add(chateauLandon_gareDeLEstVerdun);
     * voiesLigne7.add(gareDeLEstVerdun_poissonniere);
     * voiesLigne7.add(poissonniere_cadet); voiesLigne7.add(cadet_lePeletier);
     * voiesLigne7.add(lePeletier_chausseeDAntinLaFayette);
     * voiesLigne7.add(chausseeDAntinLaFayette_opera);
     * voiesLigne7.add(opera_pyramides);
     * voiesLigne7.add(pyramides_palaisRoyalMuseeLouvre);
     * voiesLigne7.add(palaisRoyalMuseeLouvre_pontNeuf);
     * voiesLigne7.add(pontNeuf_chatelet); voiesLigne7.add(chatelet_pontMarie);
     * voiesLigne7.add(pontMarie_sullyMorland);
     * voiesLigne7.add(sullyMorland_jussieu); voiesLigne7.add(jussieu_placeMonge);
     * voiesLigne7.add(placeMonge_censierDaubenton);
     * voiesLigne7.add(censierDaubenton_lesGobelins);
     * voiesLigne7.add(lesGobelins_placeDItalie);
     * voiesLigne7.add(placeDItalie_tolbiac);
     * voiesLigne7.add(tolbiac_maisonBlanche);
     * 
     * Ligne ligne7 = new Ligne("ligne 7", voiesLigne7);
     * 
     * }
     * 
     * public List<Voie> trouverCheminOptimal(double longitudeUtil, double
     * latitudeUtil, double longitudeDestination, double latitudeDestination) { //
     * Variables pour stocker les informations du chemin optimal List<List<Voie>>
     * cheminsOptimaux = new ArrayList<>(); int tempsTrajetOptimal =
     * Integer.MAX_VALUE;
     * 
     * // Parcourir toutes les lignes du réseau for (Ligne ligne : lignes) { //
     * Trouver la station de départ la plus proche de la position de l'utilisateur
     * Station stationDepartPlusProche = null; double distanceDepartMin =
     * Integer.MAX_VALUE;
     * 
     * for (Voie voie : ligne.getVoies()) { Station station =
     * voie.getStationDepart(); double distanceDepart =
     * station.distanceTo(latitudeUtil, longitudeUtil);
     * 
     * if (distanceDepart < distanceDepartMin) { distanceDepartMin = distanceDepart;
     * stationDepartPlusProche = station; } }
     * 
     * // Trouver la station d'arrivée la plus proche de la destination Station
     * stationArriveePlusProche = null; double distanceArriveeMin =
     * Integer.MAX_VALUE;
     * 
     * for (Voie voie : ligne.getVoies()) { Station station =
     * voie.getStationDepart(); double distanceArrivee =
     * station.distanceTo(longitudeDestination, latitudeDestination);
     * 
     * if (distanceArrivee < distanceArriveeMin) { distanceArriveeMin =
     * distanceArrivee; stationArriveePlusProche = station; } }
     * 
     * // Calculer le temps de trajet
     * 
     * List<Voie> voiesParcourus = trouverVoiesEntreStations(ligne,
     * stationDepartPlusProche, stationArriveePlusProche);
     * 
     * int tempsTrajet = calculerTempsTrajet(voiesParcourus); tempsTrajet +=
     * calculerTempsMarche(stationDepartPlusProche, latitudeUtil, longitudeUtil);
     * tempsTrajet += calculerTempsMarche(stationArriveePlusProche, latitudeUtil,
     * longitudeUtil);
     * 
     * // Vérifier si le chemin est optimal if (tempsTrajet < tempsTrajetOptimal) {
     * 
     * tempsTrajetOptimal = tempsTrajet;
     * 
     * cheminsOptimaux.clear(); cheminsOptimaux.add(voiesParcourus); }
     * 
     * } return cheminsOptimaux.get(0); }
     * 
     * public List<Voie> trouverVoiesEntreStations(Ligne ligne, Station
     * stationDepart, Station stationArrivee) { List<Voie> voiesEntreStations = new
     * ArrayList<>(); boolean enregistrement = false;
     * 
     * for (Voie voie : ligne.getVoies()) { if (voie.getStationDepart() ==
     * stationDepart) { enregistrement = true; }
     * 
     * if (enregistrement) { voiesEntreStations.add(voie); }
     * 
     * if (voie.getStationArrivee() == stationArrivee) { break; } }
     * 
     * return voiesEntreStations; }
     * 
     * public int calculerTempsTrajet(List<Voie> voies) { int tempsTrajetTotal = 0;
     * 
     * for (int i = 0; i < voies.size(); i++) { Voie voie = voies.get(i); Station
     * stationDepart = voie.getStationDepart(); Station stationArrivee =
     * voie.getStationArrivee();
     * 
     * int tempsParcours = voie.getTempsParcours(); int tempsArretDepart =
     * stationDepart.getTempsArret(); int tempsArretArrivee =
     * stationArrivee.getTempsArret();
     * 
     * tempsTrajetTotal += tempsArretDepart + tempsParcours;
     * 
     * // Si ce n'est pas la dernière voie, ajouter le temps d'arrêt à la station //
     * d'arrivée if (i < voies.size() - 1) { tempsTrajetTotal += tempsArretArrivee;
     * } }
     * 
     * return tempsTrajetTotal; }
     * 
     * public double calculerTempsMarche(Station station, double latitude, double
     * longitude) { // Calculer la distance entre la position de l'utilisateur et la
     * position de la // station double distance = station.distanceTo(latitude,
     * longitude);
     * 
     * // Supposer une vitesse de marche moyenne de 5 km/h (environ 1.4 m/s) double
     * vitesseMarche = 1.4; int tempsMarche = (int) Math.ceil(distance /
     * (vitesseMarche * 60));
     * 
     * return tempsMarche; }
     * 
     */
}