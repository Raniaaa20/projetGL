package fr.ul.miage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ReseauMetro {

    static List<Ligne> lignes;
    static Map<String, Station> stations;
    static List<Station> listeStations = new ArrayList<>();
    
    static Ligne ligneOptimale;
    static List<Voie> voiesOptimalesParcourus;
    static int tempsTrajetOptimal;

  

    public Ligne getLigneOptimale() {
		return ligneOptimale;
	}

	

	public List<Voie> getVoiesOptimalesParcourus() {
		return voiesOptimalesParcourus;
	}

	

	public int getTempsTrajetOptimal() {
		return tempsTrajetOptimal;
	}

	


	private Map<String, Voie> voies;

    public ReseauMetro() {
	this.stations = new HashMap<>();
	this.voies = new HashMap<>();
	this.lignes = new ArrayList<>(); // Initialisation de la liste de lignes
	// Creation des stations

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

	    System.out.println("Voie de " + stationDepart.getNom() + " a " + stationArrivee.getNom() + " (Distance "
		    + voie.gettempsParcours() + " minutes)");
	}
    }

    public void ajouterStation(String nom, Station station) {
	this.stations.put(nom, station);
	this.listeStations.add(station);
    }

    public void ajouterVoie(String nom, Voie voie) {
	this.voies.put(nom, voie);
    }

    public Station getStation(String nomStation) {
	return this.stations.get(nomStation);
    }

    public Voie getVoie(String nom) {
	return this.voies.get(nom);
    }

    public List<Station> trouverItineraireLePlusRapide(Station depart, Station arrivee) {
	List<Station> itineraire = new ArrayList<>();
	Map<Station, Station> stationPrecedente = new HashMap<>();
	Set<Station> stationsVisitees = new HashSet<>();
	Queue<Station> aVisiter = new LinkedList<>();
	aVisiter.add(depart);

	while (!aVisiter.isEmpty()) {
	    Station stationActuelle = aVisiter.remove();
	    stationsVisitees.add(stationActuelle);

	    // Affiche la station actuelle et le nombre de voies
	    System.out.println("Station courante : " + stationActuelle.getNom() + "; "+stationActuelle.getVoies().size()+" voies");
	    // System.out.println("Nombre de voies : " +
	    // stationActuelle.getLignes().length);

	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    if (stationActuelle.equals(arrivee)) {
		while (stationActuelle != null) {
		    itineraire.add(0, stationActuelle);
		    stationActuelle = stationPrecedente.get(stationActuelle);
		}
		return itineraire;
	    }

	    for (Ligne ligne : stationActuelle.getLignes()) {
		for (Voie voie : ligne.getVoies()) {
		    if (voie.getStationDepart().equals(stationActuelle)) {
			Station prochaineStation = voie.getStationArrivee();
			if (!stationsVisitees.contains(prochaineStation)) {
			    aVisiter.add(prochaineStation);
			    if (!stationPrecedente.containsKey(prochaineStation)) {
				stationPrecedente.put(prochaineStation, stationActuelle);
			    }
			}

			// Vérifier si la prochaine station a un accident
			if (prochaineStation.isAccident()) {
			    System.out.println("Suivante : " + prochaineStation.getNom() + " : ACCIDENT.");
			} else {
			    System.out.println("Suivante : " + prochaineStation.getNom() + " : pas d'accident.");

			}
		    }
		}
	    }
	}

	// Si nous atteignons ce point, aucun itinéraire n'a été trouvé
	System.out.println("Aucun itinéraire trouvé.");
	return new ArrayList<>();
    }

    public List<Ligne> getLignes() {
	return this.lignes;
    }

    public Ligne getLigne(int numeroLigne) {
	for (Ligne ligne : lignes) {
	    if (ligne.getNumero() == numeroLigne) {
		return ligne;
	    }
	}
	return null; // Si aucune ligne ne correspond au numero specifie
    }

    void initialiserReseau() {

	Ligne ligne1 = new Ligne(1, "Ligne 1");

	Station defense = new Station("La Defense - Grande Arche", 1, false, 48.891922, 2.238375);
	Station esplanadeDeLaDefense = new Station("Esplanade de la Defense", 1, false, 48.891522, 2.240573);
	Station pontDeNeuilly = new Station("Pont de Neuilly", 1, false, 48.885648, 2.259503);
	Station lesSablons = new Station("Les Sablons (Jardin d'Acclimatation)", 1, false, 48.879345, 2.272216);
	Station porteMaillot = new Station("Porte Maillot (Palais des Congres)", 1, false, 48.877461, 2.282395);
	Station argentine = new Station("Argentine", 1, false, 48.875377, 2.291282);
	Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — etoile", 1, false, 48.873962, 2.295167);
	Station georgeV = new Station("George V", 1, true, 48.872074, 2.300816);
	Station franklinDRoosevelt = new Station("Franklin D. Roosevelt", 1, false, 48.869263, 2.307766);
	Station champsElyseesClemenceau = new Station("Champs-elysees — Clemenceau", 1, false, 48.867603, 2.312631);
	Station concorde = new Station("Concorde", 1, false, 48.865165, 2.321428);
	Station tuileries = new Station("Tuileries", 1, false, 48.863788, 2.327102);
	Station palaisRoyalMuseeDuLouvre = new Station("Palais Royal", 1, false, 48.862508, 2.336204);
	Station louvreRivoli = new Station("Louvre — Rivoli", 1, false, 48.860647, 2.340474);
	Station chatelet = new Station("Châtelet", 1, false, 48.858747, 2.347079);
	Station hotelDeVille = new Station("Hôtel de Ville", 1, false, 48.857368, 2.351816);
	Station saintPaul = new Station("Saint-Paul", 1, false, 48.855452, 2.360816);
	Station bastille = new Station("Bastille", 1, false, 48.853299, 2.369553);
	Station gareDeLyon = new Station("Gare de Lyon", 1, false, 48.844945, 2.374570);
	Station reuillyDiderot = new Station("Reuilly — Diderot", 1, false, 48.847222, 2.387222);
	Station nation = new Station("Nation", 1, false, 48.848222, 2.397222);
	Station porteDeVincennes = new Station("Porte de Vincennes", 1, false, 48.847222, 2.407222);
	Station saintMande = new Station("Saint-Mande", 1, false, 48.846222, 2.417222);
	Station berault = new Station("Berault", 1, false, 48.845222, 2.427222);
	Station chateauDeVincennes = new Station("Château de Vincennes", 1, false, 48.844222, 2.437222);

	Voie voie1 = new Voie(defense, esplanadeDeLaDefense, 5, false);
	Voie voie2 = new Voie(esplanadeDeLaDefense, pontDeNeuilly, 5, false);
	Voie voie3 = new Voie(pontDeNeuilly, lesSablons, 5, false);
	Voie voie4 = new Voie(lesSablons, porteMaillot, 5, false);
	Voie voie5 = new Voie(porteMaillot, argentine, 5, false);
	Voie voie6 = new Voie(argentine, charlesDeGaulleEtoile, 5, false);
	Voie voie7 = new Voie(charlesDeGaulleEtoile, georgeV, 5, false);
	Voie voie8 = new Voie(georgeV, franklinDRoosevelt, 5, false);
	Voie voie9 = new Voie(franklinDRoosevelt, champsElyseesClemenceau, 5, false);
	Voie voie10 = new Voie(champsElyseesClemenceau, concorde, 5, false);
	Voie voie11 = new Voie(concorde, tuileries, 5, false);
	Voie voie12 = new Voie(tuileries, palaisRoyalMuseeDuLouvre, 5, false);
	Voie voie13 = new Voie(palaisRoyalMuseeDuLouvre, louvreRivoli, 5, false);
	Voie voie14 = new Voie(louvreRivoli, chatelet, 5, false);
	Voie voie15 = new Voie(chatelet, hotelDeVille, 5, false);
	Voie voie16 = new Voie(hotelDeVille, saintPaul, 5, false);
	Voie voie17 = new Voie(saintPaul, bastille, 5, false);
	Voie voie18 = new Voie(bastille, gareDeLyon, 5, false);
	Voie voie19 = new Voie(gareDeLyon, reuillyDiderot, 5, false);
	Voie voie20 = new Voie(reuillyDiderot, nation, 5, false);
	Voie voie21 = new Voie(nation, porteDeVincennes, 5, false);
	Voie voie22 = new Voie(porteDeVincennes, saintMande, 5, false);
	Voie voie23 = new Voie(saintMande, berault, 5, false);
	Voie voie24 = new Voie(berault, chateauDeVincennes, 5, false);
	Voie voie1B = new Voie(chateauDeVincennes, defense, 5, false);

	defense.addVoie(voie1);
	defense.setLigne(ligne1);
	esplanadeDeLaDefense.addVoie(voie1);
	esplanadeDeLaDefense.setLigne(ligne1);

	esplanadeDeLaDefense.addVoie(voie2);
	pontDeNeuilly.addVoie(voie2);
	pontDeNeuilly.setLigne(ligne1);

	pontDeNeuilly.addVoie(voie3);
	lesSablons.addVoie(voie3);
	lesSablons.setLigne(ligne1);

	lesSablons.addVoie(voie4);
	porteMaillot.addVoie(voie4);
	porteMaillot.setLigne(ligne1);

	porteMaillot.addVoie(voie5);
	argentine.addVoie(voie5);
	argentine.setLigne(ligne1);

	argentine.addVoie(voie6);
	charlesDeGaulleEtoile.addVoie(voie6);
	charlesDeGaulleEtoile.setLigne(ligne1);

	charlesDeGaulleEtoile.addVoie(voie7);
	georgeV.addVoie(voie7);
	georgeV.setLigne(ligne1);

	georgeV.addVoie(voie8);
	franklinDRoosevelt.addVoie(voie8);
	franklinDRoosevelt.setLigne(ligne1);

	franklinDRoosevelt.addVoie(voie9);
	champsElyseesClemenceau.addVoie(voie9);
	champsElyseesClemenceau.setLigne(ligne1);

	champsElyseesClemenceau.addVoie(voie10);
	concorde.addVoie(voie10);
	concorde.setLigne(ligne1);

	concorde.addVoie(voie11);
	tuileries.addVoie(voie11);
	tuileries.setLigne(ligne1);

	tuileries.addVoie(voie12);
	palaisRoyalMuseeDuLouvre.addVoie(voie12);
	palaisRoyalMuseeDuLouvre.setLigne(ligne1);

	palaisRoyalMuseeDuLouvre.addVoie(voie13);
	louvreRivoli.addVoie(voie13);
	louvreRivoli.setLigne(ligne1);

	louvreRivoli.addVoie(voie14);
	chatelet.addVoie(voie14);
	chatelet.setLigne(ligne1);

	chatelet.addVoie(voie15);
	hotelDeVille.addVoie(voie15);
	hotelDeVille.setLigne(ligne1);

	hotelDeVille.addVoie(voie16);
	saintPaul.addVoie(voie16);
	saintPaul.setLigne(ligne1);

	saintPaul.addVoie(voie17);
	bastille.addVoie(voie17);
	bastille.setLigne(ligne1);

	bastille.addVoie(voie18);
	gareDeLyon.addVoie(voie18);
	gareDeLyon.setLigne(ligne1);

	gareDeLyon.addVoie(voie19);
	reuillyDiderot.addVoie(voie19);
	reuillyDiderot.setLigne(ligne1);

	reuillyDiderot.addVoie(voie20);
	nation.addVoie(voie20);
	nation.setLigne(ligne1);

	nation.addVoie(voie21);
	porteDeVincennes.addVoie(voie21);
	porteDeVincennes.setLigne(ligne1);

	porteDeVincennes.addVoie(voie22);
	saintMande.addVoie(voie22);
	saintMande.setLigne(ligne1);

	saintMande.addVoie(voie23);
	berault.addVoie(voie23);
	berault.setLigne(ligne1);

	berault.addVoie(voie24);
	chateauDeVincennes.addVoie(voie24);
	chateauDeVincennes.setLigne(ligne1);

	chateauDeVincennes.addVoie(voie1B);
	defense.addVoie(voie1B);

	ligne1.addVoie(voie1);
	ligne1.addVoie(voie2);
	ligne1.addVoie(voie3);
	ligne1.addVoie(voie4);
	ligne1.addVoie(voie5);
	ligne1.addVoie(voie6);
	ligne1.addVoie(voie7);
	ligne1.addVoie(voie8);
	ligne1.addVoie(voie9);
	ligne1.addVoie(voie10);
	ligne1.addVoie(voie11);
	ligne1.addVoie(voie12);
	ligne1.addVoie(voie13);
	ligne1.addVoie(voie14);
	ligne1.addVoie(voie15);
	ligne1.addVoie(voie16);
	ligne1.addVoie(voie17);
	ligne1.addVoie(voie18);
	ligne1.addVoie(voie19);
	ligne1.addVoie(voie20);
	ligne1.addVoie(voie21);
	ligne1.addVoie(voie22);
	ligne1.addVoie(voie23);
	ligne1.addVoie(voie24);
	ligne1.addVoie(voie1B);

	ligne1.addStation(defense);
	ligne1.addStation(esplanadeDeLaDefense);
	ligne1.addStation(pontDeNeuilly);
	ligne1.addStation(lesSablons);
	ligne1.addStation(porteMaillot);
	ligne1.addStation(argentine);
	ligne1.addStation(charlesDeGaulleEtoile);
	ligne1.addStation(georgeV);
	ligne1.addStation(franklinDRoosevelt);
	ligne1.addStation(champsElyseesClemenceau);
	ligne1.addStation(concorde);
	ligne1.addStation(tuileries);
	ligne1.addStation(palaisRoyalMuseeDuLouvre);
	ligne1.addStation(louvreRivoli);
	ligne1.addStation(chatelet);
	ligne1.addStation(hotelDeVille);
	ligne1.addStation(saintPaul);
	ligne1.addStation(bastille);
	ligne1.addStation(gareDeLyon);
	ligne1.addStation(reuillyDiderot);
	ligne1.addStation(nation);
	ligne1.addStation(porteDeVincennes);
	ligne1.addStation(saintMande);
	ligne1.addStation(berault);
	ligne1.addStation(chateauDeVincennes);

	this.ajouterStation("La Defense - Grande Arche", defense);
	this.ajouterStation("Esplanade de la Defense", esplanadeDeLaDefense);
	this.ajouterStation("Pont de Neuilly", pontDeNeuilly);
	this.ajouterStation("Les Sablons (Jardin d'Acclimatation)", lesSablons);
	this.ajouterStation("Porte Maillot (Palais des Congres)", porteMaillot);
	this.ajouterStation("Argentine", argentine);
	this.ajouterStation("Charles de Gaulle — etoile", charlesDeGaulleEtoile);
	this.ajouterStation("George V", georgeV);
	this.ajouterStation("Franklin D. Roosevelt", franklinDRoosevelt);
	this.ajouterStation("Champs-elysees — Clemenceau (Grand Palais)", champsElyseesClemenceau);
	this.ajouterStation("Concorde", concorde);
	this.ajouterStation("Tuileries", tuileries);
	this.ajouterStation("Palais Royal - Musee du Louvre", palaisRoyalMuseeDuLouvre);
	this.ajouterStation("Louvre — Rivoli", louvreRivoli);
	this.ajouterStation("Châtelet", chatelet);
	this.ajouterStation("Hôtel de Ville", hotelDeVille);
	this.ajouterStation("Saint-Paul (Le Marais)", saintPaul);
	this.ajouterStation("Bastille", bastille);
	this.ajouterStation("Gare de Lyon", gareDeLyon);
	this.ajouterStation("Reuilly — Diderot", reuillyDiderot);
	this.ajouterStation("Nation", nation);
	this.ajouterStation("Porte de Vincennes", porteDeVincennes);
	this.ajouterStation("Saint-Mande", saintMande);
	this.ajouterStation("Berault", berault);
	this.ajouterStation("Château de Vincennes", chateauDeVincennes);

	this.ajouterLigne(ligne1);

	Ligne ligne2 = new Ligne(2, "Ligne 2");

	Station porteDauphine = new Station("Porte Dauphine", 2, false, 48.8715, 2.2745);
	Station victorHugo = new Station("Victor Hugo", 2, false, 48.8692, 2.2849);
	Station ternes = new Station("Ternes", 2, false, 48.8785, 2.2984);
	Station courcelles = new Station("Courcelles", 2, false, 48.8792, 2.3066);
	Station monceau = new Station("Monceau", 2, false, 48.8817, 2.3147);
	Station villiers = new Station("Villiers", 2, false, 48.8828, 2.3220);
	Station rome = new Station("Rome", 2, false, 48.8836, 2.3278);
	Station placeDeClichy = new Station("Place de Clichy", 2, false, 48.8846, 2.3322);
	Station blanche = new Station("Blanche", 2, false, 48.8826, 2.3378);
	Station pigalle = new Station("Pigalle", 2, false, 48.8821, 2.3424);
	Station anvers = new Station("Anvers (Sacre-Cœur)", 2, false, 48.8827, 2.3449);
	Station barbesRochechouart = new Station("Barbes - Rochechouart", 2, false, 48.8833, 2.3484);
	Station laChapelle = new Station("La Chapelle", 2, false, 48.8842, 2.3596);
	Station stalingrad = new Station("Stalingrad", 2, false, 48.8828, 2.3695);
	Station jaures = new Station("Jaures", 2, false, 48.8827, 2.3708);
	Station colonelFabien = new Station("Colonel Fabien", 2, false, 48.8785, 2.3697);
	Station belleville = new Station("Belleville", 2, false, 48.8732, 2.3725);
	Station couronnes = new Station("Couronnes", 2, false, 48.8692, 2.3753);
	Station menilmontant = new Station("Menilmontant", 2, false, 48.8648, 2.3803);
	Station pereLachaise = new Station("Pere Lachaise", 2, false, 48.8596, 2.3873);
	Station philippeAuguste = new Station("Philippe Auguste", 2, false, 48.8565, 2.3893);
	Station alexandreDumas = new Station("Alexandre Dumas", 2, false, 48.8533, 2.3922);
	Station avron = new Station("Avron", 2, false, 48.8524, 2.4007);

	Voie voie25 = new Voie(porteDauphine, victorHugo, 5, false);
	Voie voie26 = new Voie(victorHugo, ternes, 5, false);
	Voie voie27 = new Voie(ternes, courcelles, 5, false);
	Voie voie28 = new Voie(courcelles, monceau, 5, false);
	Voie voie29 = new Voie(monceau, villiers, 5, false);
	Voie voie30 = new Voie(villiers, rome, 5, false);
	Voie voie31 = new Voie(rome, placeDeClichy, 5, false);
	Voie voie32 = new Voie(placeDeClichy, blanche, 5, false);
	Voie voie33 = new Voie(blanche, pigalle, 5, false);
	Voie voie34 = new Voie(pigalle, anvers, 5, false);
	Voie voie35 = new Voie(anvers, barbesRochechouart, 5, false);
	Voie voie36 = new Voie(barbesRochechouart, laChapelle, 5, false);
	Voie voie37 = new Voie(laChapelle, stalingrad, 5, false);
	Voie voie38 = new Voie(stalingrad, jaures, 5, false);
	Voie voie39 = new Voie(jaures, colonelFabien, 5, false);
	Voie voie40 = new Voie(colonelFabien, belleville, 5, false);
	Voie voie41 = new Voie(belleville, couronnes, 5, false);
	Voie voie42 = new Voie(couronnes, menilmontant, 5, false);
	Voie voie43 = new Voie(menilmontant, pereLachaise, 5, false);
	Voie voie44 = new Voie(pereLachaise, philippeAuguste, 5, false);
	Voie voie45 = new Voie(philippeAuguste, alexandreDumas, 5, false);
	Voie voie46 = new Voie(alexandreDumas, avron, 5, false);
	Voie voie47 = new Voie(avron, nation, 5, false);
	Voie voie25B = new Voie(nation, porteDauphine, 5, false);

	porteDauphine.addVoie(voie25);
	porteDauphine.setLigne(ligne2);
	victorHugo.addVoie(voie25);
	victorHugo.setLigne(ligne2);

	victorHugo.addVoie(voie26);
	ternes.addVoie(voie26);
	ternes.setLigne(ligne2);

	ternes.addVoie(voie27);
	courcelles.addVoie(voie27);
	courcelles.setLigne(ligne2);

	courcelles.addVoie(voie28);
	monceau.addVoie(voie28);
	monceau.setLigne(ligne2);

	monceau.addVoie(voie29);
	villiers.addVoie(voie29);
	villiers.setLigne(ligne2);

	villiers.addVoie(voie30);
	rome.addVoie(voie30);
	rome.setLigne(ligne2);

	rome.addVoie(voie31);
	placeDeClichy.addVoie(voie31);
	placeDeClichy.setLigne(ligne2);

	placeDeClichy.addVoie(voie32);
	blanche.addVoie(voie32);
	blanche.setLigne(ligne2);

	blanche.addVoie(voie33);
	pigalle.addVoie(voie33);
	pigalle.setLigne(ligne2);

	pigalle.addVoie(voie34);
	anvers.addVoie(voie34);
	anvers.setLigne(ligne2);

	anvers.addVoie(voie35);
	barbesRochechouart.addVoie(voie35);
	barbesRochechouart.setLigne(ligne2);

	barbesRochechouart.addVoie(voie36);
	laChapelle.addVoie(voie36);
	laChapelle.setLigne(ligne2);

	laChapelle.addVoie(voie37);
	stalingrad.addVoie(voie37);
	stalingrad.setLigne(ligne2);

	stalingrad.addVoie(voie38);
	jaures.addVoie(voie38);
	jaures.setLigne(ligne2);

	jaures.addVoie(voie39);
	colonelFabien.addVoie(voie39);
	colonelFabien.setLigne(ligne2);

	colonelFabien.addVoie(voie40);
	belleville.addVoie(voie40);
	belleville.setLigne(ligne2);

	belleville.addVoie(voie41);
	couronnes.addVoie(voie41);
	couronnes.setLigne(ligne2);

	couronnes.addVoie(voie42);
	menilmontant.addVoie(voie42);
	menilmontant.setLigne(ligne2);

	menilmontant.addVoie(voie43);
	pereLachaise.addVoie(voie43);
	pereLachaise.setLigne(ligne2);

	pereLachaise.addVoie(voie44);
	philippeAuguste.addVoie(voie44);
	philippeAuguste.setLigne(ligne2);

	philippeAuguste.addVoie(voie45);
	alexandreDumas.addVoie(voie45);
	alexandreDumas.setLigne(ligne2);

	alexandreDumas.addVoie(voie46);
	avron.addVoie(voie46);
	avron.setLigne(ligne2);

	avron.addVoie(voie47);
	nation.addVoie(voie47);
	nation.setLigne(ligne2);

	nation.addVoie(voie25B);
	porteDauphine.addVoie(voie25B);

	ligne2.addVoie(voie25);
	ligne2.addVoie(voie26);
	ligne2.addVoie(voie27);
	ligne2.addVoie(voie28);
	ligne2.addVoie(voie29);
	ligne2.addVoie(voie30);
	ligne2.addVoie(voie31);
	ligne2.addVoie(voie32);
	ligne2.addVoie(voie33);
	ligne2.addVoie(voie34);
	ligne2.addVoie(voie35);
	ligne2.addVoie(voie36);
	ligne2.addVoie(voie37);
	ligne2.addVoie(voie38);
	ligne2.addVoie(voie39);
	ligne2.addVoie(voie40);
	ligne2.addVoie(voie41);
	ligne2.addVoie(voie42);
	ligne2.addVoie(voie43);
	ligne2.addVoie(voie44);
	ligne2.addVoie(voie45);
	ligne2.addVoie(voie46);
	ligne2.addVoie(voie47);
	ligne2.addVoie(voie25B);

	ligne2.addStation(porteDauphine);
	ligne2.addStation(victorHugo);
	ligne2.addStation(ternes);
	ligne2.addStation(courcelles);
	ligne2.addStation(monceau);
	ligne2.addStation(villiers);
	ligne2.addStation(rome);
	ligne2.addStation(placeDeClichy);
	ligne2.addStation(blanche);
	ligne2.addStation(pigalle);
	ligne2.addStation(anvers);
	ligne2.addStation(barbesRochechouart);
	ligne2.addStation(laChapelle);
	ligne2.addStation(stalingrad);
	ligne2.addStation(jaures);
	ligne2.addStation(colonelFabien);
	ligne2.addStation(belleville);
	ligne2.addStation(couronnes);
	ligne2.addStation(menilmontant);
	ligne2.addStation(pereLachaise);
	ligne2.addStation(philippeAuguste);
	ligne2.addStation(alexandreDumas);
	ligne2.addStation(avron);
	ligne2.addStation(nation);

	this.ajouterStation("Porte Dauphine", porteDauphine);
	this.ajouterStation("Victor Hugo", victorHugo);
	this.ajouterStation("Ternes", ternes);
	this.ajouterStation("Courcelles", courcelles);
	this.ajouterStation("Monceau", monceau);
	this.ajouterStation("Villiers", villiers);
	this.ajouterStation("Rome", rome);
	this.ajouterStation("Place de Clichy", placeDeClichy);
	this.ajouterStation("Blanche", blanche);
	this.ajouterStation("Pigalle", pigalle);
	this.ajouterStation("Anvers (Sacre-Cœur)", anvers);
	this.ajouterStation("Barbes - Rochechouart", barbesRochechouart);
	this.ajouterStation("La Chapelle", laChapelle);
	this.ajouterStation("Stalingrad", stalingrad);
	this.ajouterStation("Jaures", jaures);
	this.ajouterStation("Colonel Fabien", colonelFabien);
	this.ajouterStation("Belleville", belleville);
	this.ajouterStation("Couronnes", couronnes);
	this.ajouterStation("Menilmontant", menilmontant);
	this.ajouterStation("Pere Lachaise", pereLachaise);
	this.ajouterStation("Philippe Auguste", philippeAuguste);
	this.ajouterStation("Alexandre Dumas", alexandreDumas);
	this.ajouterStation("Avron", avron);

	this.ajouterLigne(ligne2);

	Ligne ligne3 = new Ligne(3, "Ligne 3");

	Station pontDeLevalloisBecon = new Station("Pont de Levallois", 1, false, 48.8978, 2.2832);
	Station anatoleFrance = new Station("Anatole France", 1, false, 48.8928, 2.2852);
	Station louiseMichel = new Station("Louise Michel", 1, false, 48.8884, 2.2871);
	Station porteDeChamperret = new Station("Porte de Champerret", 1, false, 48.8851, 2.2889);
	Station pereireMarJ = new Station("Pereire (Marechal Juin)", 1, false, 48.8825, 2.2961);
	Station wagram = new Station("Wagram", 1, false, 48.8828, 2.3004);
	Station malesherbes = new Station("Malesherbes", 1, false, 48.8822, 2.3062);
	Station europe = new Station("Europe", 1, false, 48.8791, 2.3261);
	Station stLazare = new Station("Saint-Lazare", 1, false, 48.8755, 2.3256);
	Station opera = new Station("Opera", 1, false, 48.8713, 2.3323);
	Station quatreSeptembre = new Station("Quatre-Septembre", 1, false, 48.8693, 2.3356);
	Station bourse = new Station("Bourse", 1, false, 48.8688, 2.3405);
	Station sentier = new Station("Sentier", 1, false, 48.8686, 2.3462);
	Station reaumurSebastopol = new Station("Reaumur — Sebastopol", 1, false, 48.8663, 2.3523);
	Station artsMetiers = new Station("Arts et Metiers", 1, false, 48.8656, 2.3564);
	Station temple = new Station("Temple", 1, false, 48.8667, 2.3616);
	Station republique = new Station("Republique", 1, false, 48.8675, 2.3638);
	Station parmentier = new Station("Parmentier", 1, false, 48.8657, 2.3746);
	Station rueStMaur = new Station("Rue Saint-Maur", 1, false, 48.8642, 2.3781);
	Station gambetta = new Station("Gambetta", 1, false, 48.8649, 2.3981);
	Station porteDeBagnolet = new Station("Porte de Bagnolet", 1, false, 48.8641, 2.4092);
	Station gallieni = new Station("Gallieni", 1, false, 48.8648, 2.4168);

	Voie voie48 = new Voie(pontDeLevalloisBecon, anatoleFrance, 5, false);
	Voie voie49 = new Voie(anatoleFrance, louiseMichel, 5, false);
	Voie voie50 = new Voie(louiseMichel, porteDeChamperret, 5, false);
	Voie voie51 = new Voie(porteDeChamperret, pereireMarJ, 5, false);
	Voie voie52 = new Voie(pereireMarJ, wagram, 5, false);
	Voie voie53 = new Voie(wagram, malesherbes, 5, false);
	Voie voie54 = new Voie(malesherbes, europe, 5, false);
	Voie voie55 = new Voie(europe, stLazare, 5, false);
	Voie voie56 = new Voie(stLazare, jaures, 5, false);
	Voie voie57 = new Voie(jaures, opera, 5, false);
	Voie voie58 = new Voie(opera, quatreSeptembre, 5, false);
	Voie voie59 = new Voie(quatreSeptembre, bourse, 5, false);
	Voie voie60 = new Voie(bourse, sentier, 5, false);
	Voie voie61 = new Voie(sentier, reaumurSebastopol, 5, false);
	Voie voie62 = new Voie(reaumurSebastopol, artsMetiers, 5, false);
	Voie voie63 = new Voie(artsMetiers, temple, 5, false);
	Voie voie64 = new Voie(temple, republique, 5, false);
	Voie voie65 = new Voie(republique, parmentier, 5, false);
	Voie voie66 = new Voie(parmentier, rueStMaur, 5, false);
	Voie voie67 = new Voie(rueStMaur, gambetta, 5, false);
	Voie voie68 = new Voie(gambetta, porteDeBagnolet, 5, false);
	Voie voie69 = new Voie(porteDeBagnolet, gallieni, 5, false);
	Voie voie48B = new Voie(gallieni, pontDeLevalloisBecon, 5, false);

	pontDeLevalloisBecon.addVoie(voie48);
	pontDeLevalloisBecon.setLigne(ligne3);
	anatoleFrance.addVoie(voie48);
	anatoleFrance.setLigne(ligne3);

	anatoleFrance.addVoie(voie49);
	louiseMichel.addVoie(voie49);
	louiseMichel.setLigne(ligne3);

	louiseMichel.addVoie(voie50);
	porteDeChamperret.addVoie(voie50);
	porteDeChamperret.setLigne(ligne3);

	porteDeChamperret.addVoie(voie51);
	pereireMarJ.addVoie(voie51);
	pereireMarJ.setLigne(ligne3);

	pereireMarJ.addVoie(voie52);
	wagram.addVoie(voie52);
	wagram.setLigne(ligne3);

	wagram.addVoie(voie53);
	malesherbes.addVoie(voie53);
	malesherbes.setLigne(ligne3);

	malesherbes.addVoie(voie54);
	europe.addVoie(voie54);
	europe.setLigne(ligne3);

	europe.addVoie(voie55);
	stLazare.addVoie(voie55);
	stLazare.setLigne(ligne3);

	stLazare.addVoie(voie56);
	jaures.addVoie(voie56);
	jaures.setLigne(ligne3);

	jaures.addVoie(voie57);
	opera.addVoie(voie57);
	opera.setLigne(ligne3);

	opera.addVoie(voie58);
	quatreSeptembre.addVoie(voie58);
	quatreSeptembre.setLigne(ligne3);

	quatreSeptembre.addVoie(voie59);
	bourse.addVoie(voie59);
	bourse.setLigne(ligne3);

	bourse.addVoie(voie60);
	sentier.addVoie(voie60);
	sentier.setLigne(ligne3);

	sentier.addVoie(voie61);
	reaumurSebastopol.addVoie(voie61);
	reaumurSebastopol.setLigne(ligne3);

	reaumurSebastopol.addVoie(voie62);
	artsMetiers.addVoie(voie62);
	artsMetiers.setLigne(ligne3);

	artsMetiers.addVoie(voie63);
	temple.addVoie(voie63);
	temple.setLigne(ligne3);

	temple.addVoie(voie64);
	republique.addVoie(voie64);
	republique.setLigne(ligne3);

	republique.addVoie(voie65);
	parmentier.addVoie(voie65);
	parmentier.setLigne(ligne3);

	parmentier.addVoie(voie66);
	rueStMaur.addVoie(voie66);
	rueStMaur.setLigne(ligne3);

	rueStMaur.addVoie(voie67);
	gambetta.addVoie(voie67);
	gambetta.setLigne(ligne3);

	gambetta.addVoie(voie68);
	porteDeBagnolet.addVoie(voie68);
	porteDeBagnolet.setLigne(ligne3);

	porteDeBagnolet.addVoie(voie69);
	gallieni.addVoie(voie69);
	gallieni.setLigne(ligne3);

	gallieni.addVoie(voie48B);
	pontDeLevalloisBecon.addVoie(voie48B);

	ligne3.addVoie(voie48);
	ligne3.addVoie(voie49);
	ligne3.addVoie(voie50);
	ligne3.addVoie(voie51);
	ligne3.addVoie(voie52);
	ligne3.addVoie(voie53);
	ligne3.addVoie(voie54);
	ligne3.addVoie(voie55);
	ligne3.addVoie(voie56);
	ligne3.addVoie(voie57);
	ligne3.addVoie(voie58);
	ligne3.addVoie(voie59);
	ligne3.addVoie(voie60);
	ligne3.addVoie(voie61);
	ligne3.addVoie(voie62);
	ligne3.addVoie(voie63);
	ligne3.addVoie(voie64);
	ligne3.addVoie(voie65);
	ligne3.addVoie(voie66);
	ligne3.addVoie(voie67);
	ligne3.addVoie(voie68);
	ligne3.addVoie(voie69);
	ligne3.addVoie(voie48B);

	ligne3.addStation(pontDeLevalloisBecon);
	ligne3.addStation(anatoleFrance);
	ligne3.addStation(louiseMichel);
	ligne3.addStation(porteDeChamperret);
	ligne3.addStation(pereireMarJ);
	ligne3.addStation(wagram);
	ligne3.addStation(malesherbes);
	ligne3.addStation(europe);
	ligne3.addStation(stLazare);
	ligne3.addStation(jaures);
	ligne3.addStation(opera);
	ligne3.addStation(quatreSeptembre);
	ligne3.addStation(bourse);
	ligne3.addStation(sentier);
	ligne3.addStation(reaumurSebastopol);
	ligne3.addStation(artsMetiers);
	ligne3.addStation(temple);
	ligne3.addStation(republique);
	ligne3.addStation(parmentier);
	ligne3.addStation(rueStMaur);
	ligne3.addStation(gambetta);
	ligne3.addStation(porteDeBagnolet);
	ligne3.addStation(gallieni);

	this.ajouterStation("Pont de Levallois — Becon", pontDeLevalloisBecon);
	this.ajouterStation("Anatole France", anatoleFrance);
	this.ajouterStation("Louise Michel", louiseMichel);
	this.ajouterStation("Porte de Champerret", porteDeChamperret);
	this.ajouterStation("Pereire (Marechal Juin)", pereireMarJ);
	this.ajouterStation("Wagram", wagram);
	this.ajouterStation("Malesherbes", malesherbes);
	this.ajouterStation("Europe", europe);
	this.ajouterStation("Saint-Lazare", stLazare);
	this.ajouterStation("Opera", opera);
	this.ajouterStation("Quatre-Septembre", quatreSeptembre);
	this.ajouterStation("Bourse", bourse);
	this.ajouterStation("Sentier", sentier);
	this.ajouterStation("Reaumur — Sebastopol", reaumurSebastopol);
	this.ajouterStation("Arts et Metiers", artsMetiers);
	this.ajouterStation("Temple", temple);
	this.ajouterStation("Republique", republique);
	this.ajouterStation("Parmentier", parmentier);
	this.ajouterStation("Rue Saint-Maur", rueStMaur);
	this.ajouterStation("Gambetta", gambetta);
	this.ajouterStation("Porte de Bagnolet", porteDeBagnolet);
	this.ajouterStation("Gallieni", gallieni);

	this.ajouterLigne(ligne3);

    }



	static void trouverCheminOptimal(double longitudeUtil, double latitudeUtil, double longitudeDestination,
			double latitudeDestination) {
		// Variables pour stocker les informations du chemin optimal
		List<List<Voie>> cheminsOptimaux = new ArrayList<>();
		int tempsTrajetOptimal = Integer.MAX_VALUE;

		// Parcourir toutes les lignes du réseau
		for (Ligne ligne : lignes) {
			// Trouver la station de départ la plus proche de la position de l'utilisateur
			Station stationDepartPlusProche = null;
			double distanceDepartMin = Integer.MAX_VALUE;

			for (Voie voie : ligne.getVoies()) {
				Station station = voie.getStationDepart();
				double distanceDepart = station.distanceTo(latitudeUtil, longitudeUtil);

				if (distanceDepart < distanceDepartMin) {
					distanceDepartMin = distanceDepart;
					stationDepartPlusProche = station;
				}
			}

			// Trouver la station d'arrivée la plus proche de la destination
			Station stationArriveePlusProche = null;
			double distanceArriveeMin = Integer.MAX_VALUE;

			for (Voie voie : ligne.getVoies()) {
				Station station = voie.getStationDepart();
				double distanceArrivee = station.distanceTo(longitudeDestination, latitudeDestination);

				if (distanceArrivee < distanceArriveeMin) {
					distanceArriveeMin = distanceArrivee;
					stationArriveePlusProche = station;
				}
			}

			// Calculer le temps de trajet

			List<Voie> voiesParcourus = trouverVoiesEntreStations(ligne, stationDepartPlusProche,
					stationArriveePlusProche);

			int tempsTrajet = calculerTempsTrajet(voiesParcourus);
			tempsTrajet += calculerTempsMarche(stationDepartPlusProche, latitudeUtil, longitudeUtil);
			tempsTrajet += calculerTempsMarche(stationArriveePlusProche, latitudeDestination, longitudeDestination);

			// Vérifier si le chemin est optimal
			if (tempsTrajet < tempsTrajetOptimal) {

				tempsTrajetOptimal = tempsTrajet;

				cheminsOptimaux.clear();
				cheminsOptimaux.add(voiesParcourus);
				
				voiesOptimalesParcourus = cheminsOptimaux.get(0);
				ligneOptimale= ligne;
				tempsTrajetOptimal=tempsTrajet;
			}

		}
		
	}

	static List<Voie> trouverVoiesEntreStations(Ligne ligne, Station stationDepart, Station stationArrivee) {
		List<Voie> voiesEntreStations = new ArrayList<>();
		boolean enregistrement = false;
		for (Voie voie : ligne.getVoies()) {
			if (voie.getStationDepart() == stationDepart) {
				enregistrement = true;
			}
			if (enregistrement) {
				voiesEntreStations.add(voie);
			}
			if (voie.getStationArrivee() == stationArrivee) {
				break;
			}
		}
		return voiesEntreStations;
	}
	static int calculerTempsTrajet(List<Voie> voies) {
		int tempsTrajetTotal = 0;
		for (int i = 0; i < voies.size(); i++) {
			Voie voie = voies.get(i);
			Station stationDepart = voie.getStationDepart();
			Station stationArrivee = voie.getStationArrivee();
			int tempsParcours = voie.gettempsParcours();
			int tempsArretDepart = stationDepart.getTempsArret();
			int tempsArretArrivee = stationArrivee.getTempsArret();
			tempsTrajetTotal += tempsArretDepart + tempsParcours;
			// Si ce n'est pas la dernière voie, ajouter le temps d'arrêt à la station
			// d'arrivée
			if (i < voies.size() - 1) {
				tempsTrajetTotal += tempsArretArrivee;
			}
		}
		return tempsTrajetTotal;
	}
	static double calculerTempsMarche(Station station, double latitude, double longitude) {
		// Calculer la distance entre la position de l'utilisateur et la position de la
		// station
		double distance = station.distanceTo(latitude, longitude);
		// Supposer une vitesse de marche moyenne de 5 km/h (environ 1.4 m/s)
		double vitesseMarche = 1.4;
		int tempsMarche = (int) Math.ceil(distance / (vitesseMarche * 60));
		return tempsMarche;
	}
	
	
	//-------------------Méthode Trajet Intermediaire----------------//
	
	public List<Voie> passerParUneStation(double longitudeUtil, double latitudeUtil, double longitudeDestination,
			double latitudeDestination, Station stationIntermediaire){
		
		
			//------------Chemin Optimal 1 jusqu'à la station Intermédiaire-------------//
		
		// Variables pour stocker les informations du chemin optimal
		List<List<Voie>> cheminsOptimaux = new ArrayList<>();
		
		List <Voie> TrajetFinal = new ArrayList<>();
		int tempsTrajetOptimal = Integer.MAX_VALUE;

		// Parcourir toutes les lignes du réseau
		for (Ligne ligne : lignes) {
			// Trouver la station de départ la plus proche de la position de l'utilisateur
			Station stationDepartPlusProche = null;
			double distanceDepartMin = Integer.MAX_VALUE;

			for (Voie voie : ligne.getVoies()) {
				Station station = voie.getStationDepart();
				double distanceDepart = station.distanceTo(latitudeUtil, longitudeUtil);

				if (distanceDepart < distanceDepartMin) {
					distanceDepartMin = distanceDepart;
					stationDepartPlusProche = station;
				}
			}
			
			List<Voie> voiesParcourus = trouverVoiesEntreStations(ligne, stationDepartPlusProche,
					stationIntermediaire);

			int tempsTrajet = calculerTempsTrajet(voiesParcourus);
			tempsTrajet += calculerTempsMarche(stationDepartPlusProche, latitudeUtil, longitudeUtil);

			// Vérifier si le chemin est optimal
			if (tempsTrajet < tempsTrajetOptimal) {

				tempsTrajetOptimal = tempsTrajet;

				cheminsOptimaux.clear();
				cheminsOptimaux.add(voiesParcourus);
			}
			
		}
			
		
		
			TrajetFinal.addAll(cheminsOptimaux.get(0));
			
			
			//------------Chemin Optimal 2 de la station Intermédiaire jusqu'à destination-------------//

			
			List<List<Voie>> cheminsOptimauxBis = new ArrayList<>();
			int tempsTrajetOptimalBis = Integer.MAX_VALUE;
			
			for (Ligne ligneBis : lignes) {
				
				// Trouver la station d'arrivée la plus proche de la destination
				Station stationArriveePlusProche = null;
				double distanceArriveeMin = Integer.MAX_VALUE;

				for (Voie voie : ligneBis.getVoies()) {
					Station station = voie.getStationDepart();
					double distanceArrivee = station.distanceTo(longitudeDestination, latitudeDestination);

					if (distanceArrivee < distanceArriveeMin) {
						distanceArriveeMin = distanceArrivee;
						stationArriveePlusProche = station;
					}
				}

				// Calculer le temps de trajet

				List<Voie> voiesParcourusBis = trouverVoiesEntreStations(ligneBis, stationIntermediaire,
						stationArriveePlusProche);

				int tempsTrajetBis = calculerTempsTrajet(voiesParcourusBis);
				tempsTrajetBis += calculerTempsMarche(stationArriveePlusProche, latitudeDestination, longitudeDestination);

				// Vérifier si le chemin est optimal
				if (tempsTrajetBis < tempsTrajetOptimalBis) {

					tempsTrajetOptimalBis = tempsTrajetBis;

					cheminsOptimaux.clear();
					cheminsOptimaux.add(voiesParcourusBis);
				}
				TrajetFinal.addAll(cheminsOptimauxBis.get(0));


			}
			
			return TrajetFinal;
			
			
			
	}
	
	



}

