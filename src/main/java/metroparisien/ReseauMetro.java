package metroparisien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReseauMetro {

    public List<Ligne> lignes;
    public Map<String, Station> stations;
    public List<Station> listeStations = new ArrayList<>();

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

    public Station getStation(String nomStation) {
	for (Ligne ligne : lignes) {
	    for (Station station : ligne.getStations()) {
		if (station.getNom().equals(nomStation)) {
		    return station;
		}
	    }
	}
	return null; // Aucune station trouvée avec le nom donné
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
	Station georgeV = new Station("George V", 1, false, 48.872074, 2.300816);
	Station franklinDRoosevelt = new Station("Franklin D. Roosevelt", 1, false, 48.869263, 2.307766);
	Station champsElyseesClemenceau = new Station("Champs-elysees — Clemenceau (Grand Palais)", 1, false, 48.867603,
		2.312631);
	Station concorde = new Station("Concorde", 1, false, 48.865165, 2.321428);
	Station tuileries = new Station("Tuileries", 1, false, 48.863788, 2.327102);
	Station palaisRoyalMuseeDuLouvre = new Station("Palais Royal - Musee du Louvre", 1, false, 48.862508, 2.336204);
	Station louvreRivoli = new Station("Louvre — Rivoli", 1, false, 48.860647, 2.340474);
	Station chatelet = new Station("Châtelet", 1, false, 48.858747, 2.347079);
	Station hotelDeVille = new Station("Hôtel de Ville", 1, false, 48.857368, 2.351816);
	Station saintPaul = new Station("Saint-Paul (Le Marais)", 1, false, 48.855452, 2.360816);
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

	charlesDeGaulleEtoile.addVoie(voie7);
	georgeV.addVoie(voie7);

	georgeV.addVoie(voie8);
	franklinDRoosevelt.addVoie(voie8);

	franklinDRoosevelt.addVoie(voie9);
	champsElyseesClemenceau.addVoie(voie9);

	champsElyseesClemenceau.addVoie(voie10);
	concorde.addVoie(voie10);

	concorde.addVoie(voie11);
	tuileries.addVoie(voie11);

	tuileries.addVoie(voie12);
	palaisRoyalMuseeDuLouvre.addVoie(voie12);

	palaisRoyalMuseeDuLouvre.addVoie(voie13);
	louvreRivoli.addVoie(voie13);

	louvreRivoli.addVoie(voie14);
	chatelet.addVoie(voie14);

	chatelet.addVoie(voie15);
	hotelDeVille.addVoie(voie15);

	hotelDeVille.addVoie(voie16);
	saintPaul.addVoie(voie16);

	saintPaul.addVoie(voie17);
	bastille.addVoie(voie17);

	bastille.addVoie(voie18);
	gareDeLyon.addVoie(voie18);

	gareDeLyon.addVoie(voie19);
	reuillyDiderot.addVoie(voie19);

	reuillyDiderot.addVoie(voie20);
	nation.addVoie(voie20);

	nation.addVoie(voie21);
	porteDeVincennes.addVoie(voie21);

	porteDeVincennes.addVoie(voie22);
	saintMande.addVoie(voie22);

	saintMande.addVoie(voie23);
	berault.addVoie(voie23);

	berault.addVoie(voie24);
	chateauDeVincennes.addVoie(voie24);

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

	Station porteDauphine = new Station("Porte Dauphine (Marechal de Lattre de Tassigny)", 2, false, 48.8715,
		2.2745);
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
	Station nation2 = new Station("Nation", 2, false, 48.8482, 2.3972);

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
	Voie voie47 = new Voie(avron, nation2, 5, false);

	victorHugo.addVoie(voie25);
	ternes.addVoie(voie26);

	ternes.addVoie(voie27);
	courcelles.addVoie(voie27);

	courcelles.addVoie(voie28);
	monceau.addVoie(voie28);

	monceau.addVoie(voie29);
	villiers.addVoie(voie29);

	villiers.addVoie(voie30);
	rome.addVoie(voie30);

	rome.addVoie(voie31);
	placeDeClichy.addVoie(voie31);

	placeDeClichy.addVoie(voie32);
	blanche.addVoie(voie32);

	blanche.addVoie(voie33);
	pigalle.addVoie(voie33);

	pigalle.addVoie(voie34);
	anvers.addVoie(voie34);

	anvers.addVoie(voie35);
	barbesRochechouart.addVoie(voie35);

	barbesRochechouart.addVoie(voie36);
	laChapelle.addVoie(voie36);

	laChapelle.addVoie(voie37);
	stalingrad.addVoie(voie37);

	stalingrad.addVoie(voie38);
	jaures.addVoie(voie38);

	jaures.addVoie(voie39);
	colonelFabien.addVoie(voie39);

	colonelFabien.addVoie(voie40);
	belleville.addVoie(voie40);

	belleville.addVoie(voie41);
	couronnes.addVoie(voie41);

	couronnes.addVoie(voie42);
	menilmontant.addVoie(voie42);

	menilmontant.addVoie(voie43);
	pereLachaise.addVoie(voie43);

	pereLachaise.addVoie(voie44);
	philippeAuguste.addVoie(voie44);

	philippeAuguste.addVoie(voie45);
	alexandreDumas.addVoie(voie45);

	alexandreDumas.addVoie(voie46);
	avron.addVoie(voie46);

	avron.addVoie(voie47);
	nation2.addVoie(voie47);

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
	ligne2.addStation(nation2);
	
	this.ajouterStation("Porte Dauphine (Marechal de Lattre de Tassigny)", porteDauphine);
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
	this.ajouterStation("Nation", nation2);

	this.ajouterLigne(ligne2);


    }

    /*
     * 
     * // Creation des stations Station porteDauphine = new
     * Station("Porte Dauphine (Marechal de Lattre de Tassigny)", 2, false, 48.8715,
     * 2.2745); Station victorHugo = new Station("Victor Hugo", 2, false, 48.8692,
     * 2.2849); Station ternes = new Station("Ternes", 2, false, 48.8785, 2.2984);
     * Station courcelles = new Station("Courcelles", 2, false, 48.8792, 2.3066);
     * Station monceau = new Station("Monceau", 2, false, 48.8817, 2.3147); Station
     * villiers = new Station("Villiers", 2, false, 48.8828, 2.3220); Station rome =
     * new Station("Rome", 2, false, 48.8836, 2.3278); Station placeDeClichy = new
     * Station("Place de Clichy", 2, false, 48.8846, 2.3322); Station blanche = new
     * Station("Blanche", 2, false, 48.8826, 2.3378); Station pigalle = new
     * Station("Pigalle", 2, false, 48.8821, 2.3424); Station anvers = new
     * Station("Anvers (Sacre-Cœur)", 2, false, 48.8827, 2.3449); Station
     * barbesRochechouart = new Station("Barbes - Rochechouart", 2, false, 48.8833,
     * 2.3484); Station laChapelle = new Station("La Chapelle", 2, false, 48.8842,
     * 2.3596); Station stalingrad = new Station("Stalingrad", 2, false, 48.8828,
     * 2.3695); Station jaures = new Station("Jaures", 2, false, 48.8827, 2.3708);
     * Station colonelFabien = new Station("Colonel Fabien", 2, false, 48.8785,
     * 2.3697); Station belleville = new Station("Belleville", 2, false, 48.8732,
     * 2.3725); Station couronnes = new Station("Couronnes", 2, false, 48.8692,
     * 2.3753); Station menilmontant = new Station("Menilmontant", 2, false,
     * 48.8648, 2.3803); Station pereLachaise = new Station("Pere Lachaise", 2,
     * false, 48.8596, 2.3873); Station philippeAuguste = new
     * Station("Philippe Auguste", 2, false, 48.8565, 2.3893); Station
     * alexandreDumas = new Station("Alexandre Dumas", 2, false, 48.8533, 2.3922);
     * Station avron = new Station("Avron", 2, false, 48.8524, 2.4007); Station
     * nation2 = new Station("Nation", 2, false, 48.8482, 2.3972);
     * 
     * // Creation des voies Voie voie25 = new Voie(porteDauphine, victorHugo, 5,
     * false); Voie voie26 = new Voie(victorHugo, ternes, 5, false); Voie voie27 =
     * new Voie(ternes, courcelles, 5, false); Voie voie28 = new Voie(courcelles,
     * monceau, 5, false); Voie voie29 = new Voie(monceau, villiers, 5, false); Voie
     * voie30 = new Voie(villiers, rome, 5, false); Voie voie31 = new Voie(rome,
     * placeDeClichy, 5, false); Voie voie32 = new Voie(placeDeClichy, blanche, 5,
     * false); Voie voie33 = new Voie(blanche, pigalle, 5, false); Voie voie34 = new
     * Voie(pigalle, anvers, 5, false); Voie voie35 = new Voie(anvers,
     * barbesRochechouart, 5, false); Voie voie36 = new Voie(barbesRochechouart,
     * laChapelle, 5, false); Voie voie37 = new Voie(laChapelle, stalingrad, 5,
     * false); Voie voie38 = new Voie(stalingrad, jaures, 5, false); Voie voie39 =
     * new Voie(jaures, colonelFabien, 5, false); Voie voie40 = new
     * Voie(colonelFabien, belleville, 5, false); Voie voie41 = new Voie(belleville,
     * couronnes, 5, false); Voie voie42 = new Voie(couronnes, menilmontant, 5,
     * false); Voie voie43 = new Voie(menilmontant, pereLachaise, 5, false); Voie
     * voie44 = new Voie(pereLachaise, philippeAuguste, 5, false); Voie voie45 = new
     * Voie(philippeAuguste, alexandreDumas, 5, false); Voie voie46 = new
     * Voie(alexandreDumas, avron, 5, false); Voie voie47 = new Voie(avron, nation2,
     * 5, false);
     * 
     * // Ajout des voies aux stations porteDauphine.addVoie(voie25);
     * victorHugo.addVoie(voie26); ternes.addVoie(voie27);
     * courcelles.addVoie(voie28); monceau.addVoie(voie29);
     * villiers.addVoie(voie30); rome.addVoie(voie31);
     * placeDeClichy.addVoie(voie32); blanche.addVoie(voie33);
     * pigalle.addVoie(voie34); anvers.addVoie(voie35);
     * barbesRochechouart.addVoie(voie36); laChapelle.addVoie(voie37);
     * stalingrad.addVoie(voie38); jaures.addVoie(voie39);
     * colonelFabien.addVoie(voie40); belleville.addVoie(voie41);
     * couronnes.addVoie(voie42); menilmontant.addVoie(voie43);
     * pereLachaise.addVoie(voie44); philippeAuguste.addVoie(voie45);
     * alexandreDumas.addVoie(voie46); avron.addVoie(voie47);
     * 
     * // Ajout des stations a la ligne ligne2.addStation(porteDauphine);
     * ligne2.addStation(victorHugo); ligne2.addStation(ternes);
     * ligne2.addStation(courcelles); ligne2.addStation(monceau);
     * ligne2.addStation(villiers); ligne2.addStation(rome);
     * ligne2.addStation(placeDeClichy); ligne2.addStation(blanche);
     * ligne2.addStation(pigalle); ligne2.addStation(anvers);
     * ligne2.addStation(barbesRochechouart); ligne2.addStation(laChapelle);
     * ligne2.addStation(stalingrad); ligne2.addStation(jaures);
     * ligne2.addStation(colonelFabien); ligne2.addStation(belleville);
     * ligne2.addStation(couronnes); ligne2.addStation(menilmontant);
     * ligne2.addStation(pereLachaise); ligne2.addStation(philippeAuguste);
     * ligne2.addStation(alexandreDumas); ligne2.addStation(avron);
     * ligne2.addStation(nation2);
     * 
     * // Creation des stations Station pontDeLevalloisBecon = new
     * Station("Pont de Levallois — Becon", 1, false, 48.8978, 2.2832); Station
     * anatoleFrance = new Station("Anatole France", 1, false, 48.8928, 2.2852);
     * Station louiseMichel = new Station("Louise Michel", 1, false, 48.8884,
     * 2.2871); Station porteDeChamperret = new Station("Porte de Champerret", 1,
     * false, 48.8851, 2.2889); Station pereireMarJ = new
     * Station("Pereire (Marechal Juin)", 1, false, 48.8825, 2.2961); Station wagram
     * = new Station("Wagram", 1, false, 48.8828, 2.3004); Station malesherbes = new
     * Station("Malesherbes", 1, false, 48.8822, 2.3062); Station europe = new
     * Station("Europe", 1, false, 48.8791, 2.3261); Station stLazare = new
     * Station("Saint-Lazare", 1, false, 48.8755, 2.3256); Station havreCaumartin =
     * new Station("Havre — Caumartin", 1, false, 48.8735, 2.3295); Station opera =
     * new Station("Opera", 1, false, 48.8713, 2.3323); Station quatreSeptembre =
     * new Station("Quatre-Septembre", 1, false, 48.8693, 2.3356); Station bourse =
     * new Station("Bourse", 1, false, 48.8688, 2.3405); Station sentier = new
     * Station("Sentier", 1, false, 48.8686, 2.3462); Station reaumurSebastopol =
     * new Station("Reaumur — Sebastopol", 1, false, 48.8663, 2.3523); Station
     * artsMetiers = new Station("Arts et Metiers", 1, false, 48.8656, 2.3564);
     * Station temple = new Station("Temple", 1, false, 48.8667, 2.3616); Station
     * republique = new Station("Republique", 1, false, 48.8675, 2.3638); Station
     * parmentier = new Station("Parmentier", 1, false, 48.8657, 2.3746); Station
     * rueStMaur = new Station("Rue Saint-Maur", 1, false, 48.8642, 2.3781); Station
     * gambetta = new Station("Gambetta", 1, false, 48.8649, 2.3981); Station
     * porteDeBagnolet = new Station("Porte de Bagnolet", 1, false, 48.8641,
     * 2.4092); Station gallieni = new Station("Gallieni", 1, false, 48.8648,
     * 2.4168);
     * 
     * // Creation des voies Voie voie48 = new Voie(pontDeLevalloisBecon,
     * anatoleFrance, 5, false); Voie voie49 = new Voie(anatoleFrance, louiseMichel,
     * 5, false); Voie voie50 = new Voie(louiseMichel, porteDeChamperret, 5, false);
     * Voie voie51 = new Voie(porteDeChamperret, pereireMarJ, 5, false); Voie voie52
     * = new Voie(pereireMarJ, wagram, 5, false); Voie voie53 = new Voie(wagram,
     * malesherbes, 5, false); Voie voie54 = new Voie(malesherbes, europe, 5,
     * false); Voie voie55 = new Voie(europe, stLazare, 5, false); Voie voie56 = new
     * Voie(stLazare, havreCaumartin, 5, false); Voie voie57 = new
     * Voie(havreCaumartin, opera, 5, false); Voie voie58 = new Voie(opera,
     * quatreSeptembre, 5, false); Voie voie59 = new Voie(quatreSeptembre, bourse,
     * 5, false); Voie voie60 = new Voie(bourse, sentier, 5, false); Voie voie61 =
     * new Voie(sentier, reaumurSebastopol, 5, false); Voie voie62 = new
     * Voie(reaumurSebastopol, artsMetiers, 5, false); Voie voie63 = new
     * Voie(artsMetiers, temple, 5, false); Voie voie64 = new Voie(temple,
     * republique, 5, false); Voie voie65 = new Voie(republique, parmentier, 5,
     * false); Voie voie66 = new Voie(parmentier, rueStMaur, 5, false); Voie voie67
     * = new Voie(rueStMaur, gambetta, 5, false); Voie voie68 = new Voie(gambetta,
     * porteDeBagnolet, 5, false); Voie voie69 = new Voie(porteDeBagnolet, gallieni,
     * 5, false);
     * 
     * // Ajout des voies aux stations pontDeLevalloisBecon.addVoie(voie48);
     * anatoleFrance.addVoie(voie48); anatoleFrance.addVoie(voie49);
     * louiseMichel.addVoie(voie49); louiseMichel.addVoie(voie50);
     * porteDeChamperret.addVoie(voie50); porteDeChamperret.addVoie(voie51);
     * pereireMarJ.addVoie(voie51); pereireMarJ.addVoie(voie52);
     * wagram.addVoie(voie52); wagram.addVoie(voie53); malesherbes.addVoie(voie53);
     * malesherbes.addVoie(voie54); europe.addVoie(voie54); europe.addVoie(voie55);
     * stLazare.addVoie(voie55); stLazare.addVoie(voie56);
     * havreCaumartin.addVoie(voie56); havreCaumartin.addVoie(voie57);
     * opera.addVoie(voie57); opera.addVoie(voie58);
     * quatreSeptembre.addVoie(voie58); quatreSeptembre.addVoie(voie59);
     * bourse.addVoie(voie59); bourse.addVoie(voie60); sentier.addVoie(voie60);
     * sentier.addVoie(voie61); reaumurSebastopol.addVoie(voie61);
     * reaumurSebastopol.addVoie(voie62); artsMetiers.addVoie(voie62);
     * artsMetiers.addVoie(voie63); temple.addVoie(voie63); temple.addVoie(voie64);
     * republique.addVoie(voie64); republique.addVoie(voie65);
     * parmentier.addVoie(voie65); parmentier.addVoie(voie66);
     * rueStMaur.addVoie(voie66); rueStMaur.addVoie(voie67);
     * gambetta.addVoie(voie67); gambetta.addVoie(voie68);
     * porteDeBagnolet.addVoie(voie68); porteDeBagnolet.addVoie(voie69);
     * gallieni.addVoie(voie69);
     * 
     * // Ajout des stations a la ligne 3 ligne3.addStation(pontDeLevalloisBecon);
     * ligne3.addStation(anatoleFrance); ligne3.addStation(louiseMichel);
     * ligne3.addStation(porteDeChamperret); ligne3.addStation(pereireMarJ);
     * ligne3.addStation(wagram); ligne3.addStation(malesherbes);
     * ligne3.addStation(europe); ligne3.addStation(stLazare);
     * ligne3.addStation(havreCaumartin); ligne3.addStation(opera);
     * ligne3.addStation(quatreSeptembre); ligne3.addStation(bourse);
     * ligne3.addStation(sentier); ligne3.addStation(reaumurSebastopol);
     * ligne3.addStation(artsMetiers); ligne3.addStation(temple);
     * ligne3.addStation(republique); ligne3.addStation(parmentier);
     * ligne3.addStation(rueStMaur); ligne3.addStation(gambetta);
     * ligne3.addStation(porteDeBagnolet); ligne3.addStation(gallieni);
     * 
     * // Creation des stations pour la ligne 4 Station porteDeClignancourt = new
     * Station("Porte de Clignancourt", 4, false, 48.8998, 2.3446); Station simplon
     * = new Station("Simplon", 4, false, 48.8921, 2.3483); Station
     * marcadetPoissonniers = new Station("Marcadet - Poissonniers", 4, false,
     * 48.8902, 2.3495); Station chateauRouge = new Station("Château Rouge", 4,
     * false, 48.8885, 2.3507); Station gareDuNord = new Station("Gare du Nord", 4,
     * false, 48.8805, 2.3553); Station gareDeLEstVerdun = new
     * Station("Gare de l'Est (Verdun)", 4, false, 48.8772, 2.3582); Station
     * chateauDEau = new Station("Château d'Eau", 4, false, 48.8728, 2.3542);
     * Station strasbourgSaintDenis = new Station("Strasbourg - Saint-Denis", 4,
     * false, 48.8696, 2.3543); Station etienneMarcel = new
     * Station("etienne Marcel", 4, false, 48.8638, 2.3485); Station lesHalles = new
     * Station("Les Halles", 4, false, 48.8616, 2.3471); Station cite = new
     * Station("Cite", 4, false, 48.8554, 2.3474); Station saintMichel = new
     * Station("Saint-Michel", 4, false, 48.8534, 2.3444); Station odeon = new
     * Station("Odeon", 4, false, 48.8516, 2.3398); Station saintGermainDesPres =
     * new Station("Saint-Germain-des-Pres", 4, false, 48.8516, 2.3333); Station
     * saintSulpice = new Station("Saint-Sulpice", 4, false, 48.8507, 2.3332);
     * Station saintPlacide = new Station("Saint-Placide", 4, false, 48.8465,
     * 2.3279); Station montparnasseBienvenue = new
     * Station("Montparnasse - Bienvenue", 4, false, 48.8421, 2.3219); Station vavin
     * = new Station("Vavin", 4, false, 48.8405, 2.3329); Station raspail = new
     * Station("Raspail", 4, false, 48.8381, 2.3314); Station denfertRochereau = new
     * Station("Denfert-Rochereau (Colonel Rol-Tanguy)", 4, false, 48.8338, 2.3324);
     * Station moutonDuvernet = new Station("Mouton-Duvernet", 4, false, 48.8317,
     * 2.3306); Station alesia = new Station("Alesia", 4, false, 48.8284, 2.3285);
     * Station porteDOrleansLeclerc = new
     * Station("Porte d'Orleans (General Leclerc)", 4, false, 48.8231, 2.3257);
     * Station mairieDeMontrouge = new Station("Mairie de Montrouge", 4, false,
     * 48.8199, 2.3198);
     * 
     * // Creation des voies pour la ligne 4 Voie voie93 = new
     * Voie(porteDeClignancourt, simplon, 4, false); Voie voie94 = new Voie(simplon,
     * marcadetPoissonniers, 4, false); Voie voie95 = new Voie(marcadetPoissonniers,
     * chateauRouge, 4, false); Voie voie96 = new Voie(chateauRouge, gareDuNord, 4,
     * false); Voie voie97 = new Voie(gareDuNord, gareDeLEstVerdun, 4, false); Voie
     * voie98 = new Voie(gareDeLEstVerdun, chateauDEau, 4, false); Voie voie99 = new
     * Voie(chateauDEau, strasbourgSaintDenis, 4, false); Voie voie100 = new
     * Voie(strasbourgSaintDenis, etienneMarcel, 4, false); Voie voie101 = new
     * Voie(etienneMarcel, lesHalles, 4, false); Voie voie102 = new Voie(lesHalles,
     * cite, 4, false); Voie voie103 = new Voie(cite, saintMichel, 4, false); Voie
     * voie104 = new Voie(saintMichel, odeon, 4, false); Voie voie105 = new
     * Voie(odeon, saintGermainDesPres, 4, false); Voie voie106 = new
     * Voie(saintGermainDesPres, saintSulpice, 4, false); Voie voie107 = new
     * Voie(saintSulpice, saintPlacide, 4, false); Voie voie108 = new
     * Voie(saintPlacide, montparnasseBienvenue, 4, false); Voie voie109 = new
     * Voie(montparnasseBienvenue, vavin, 4, false); Voie voie110 = new Voie(vavin,
     * raspail, 4, false); Voie voie111 = new Voie(raspail, denfertRochereau, 4,
     * false); Voie voie112 = new Voie(denfertRochereau, moutonDuvernet, 4, false);
     * Voie voie113 = new Voie(moutonDuvernet, alesia, 4, false); Voie voie114 = new
     * Voie(alesia, porteDOrleansLeclerc, 4, false); Voie voie115 = new
     * Voie(porteDOrleansLeclerc, mairieDeMontrouge, 4, false);
     * 
     * // Ajout des voies aux stations porteDeClignancourt.addVoie(voie93);
     * simplon.addVoie(voie93); simplon.addVoie(voie94);
     * marcadetPoissonniers.addVoie(voie94); marcadetPoissonniers.addVoie(voie95);
     * chateauRouge.addVoie(voie95); chateauRouge.addVoie(voie96);
     * gareDuNord.addVoie(voie96); gareDuNord.addVoie(voie97);
     * gareDeLEstVerdun.addVoie(voie97); gareDeLEstVerdun.addVoie(voie98);
     * chateauDEau.addVoie(voie98); chateauDEau.addVoie(voie99);
     * strasbourgSaintDenis.addVoie(voie99); strasbourgSaintDenis.addVoie(voie100);
     * etienneMarcel.addVoie(voie100); etienneMarcel.addVoie(voie101);
     * lesHalles.addVoie(voie101); lesHalles.addVoie(voie102);
     * cite.addVoie(voie102); cite.addVoie(voie103); saintMichel.addVoie(voie103);
     * saintMichel.addVoie(voie104); odeon.addVoie(voie104); odeon.addVoie(voie105);
     * saintGermainDesPres.addVoie(voie105); saintGermainDesPres.addVoie(voie106);
     * saintSulpice.addVoie(voie106); saintSulpice.addVoie(voie107);
     * saintPlacide.addVoie(voie107); saintPlacide.addVoie(voie108);
     * montparnasseBienvenue.addVoie(voie108);
     * montparnasseBienvenue.addVoie(voie109); vavin.addVoie(voie109);
     * vavin.addVoie(voie110); raspail.addVoie(voie110); raspail.addVoie(voie111);
     * denfertRochereau.addVoie(voie111); denfertRochereau.addVoie(voie112);
     * moutonDuvernet.addVoie(voie112); moutonDuvernet.addVoie(voie113);
     * alesia.addVoie(voie113); alesia.addVoie(voie114);
     * porteDOrleansLeclerc.addVoie(voie114); porteDOrleansLeclerc.addVoie(voie115);
     * mairieDeMontrouge.addVoie(voie115);
     * 
     * // Ajout des stations a la ligne 4 ligne4.addStation(porteDeClignancourt);
     * ligne4.addStation(simplon); ligne4.addStation(marcadetPoissonniers);
     * ligne4.addStation(chateauRouge); ligne4.addStation(gareDuNord);
     * ligne4.addStation(gareDeLEstVerdun); ligne4.addStation(chateauDEau);
     * ligne4.addStation(strasbourgSaintDenis); ligne4.addStation(etienneMarcel);
     * ligne4.addStation(lesHalles); ligne4.addStation(cite);
     * ligne4.addStation(saintMichel); ligne4.addStation(odeon);
     * ligne4.addStation(saintGermainDesPres); ligne4.addStation(saintSulpice);
     * ligne4.addStation(saintPlacide); ligne4.addStation(montparnasseBienvenue);
     * ligne4.addStation(vavin); ligne4.addStation(raspail);
     * ligne4.addStation(denfertRochereau); ligne4.addStation(moutonDuvernet);
     * ligne4.addStation(alesia); ligne4.addStation(porteDOrleansLeclerc);
     * ligne4.addStation(mairieDeMontrouge);
     * 
     * // Ajout de la ligne au reseau metro this.ajouterLigne(ligne1);
     * this.ajouterLigne(ligne2); this.ajouterLigne(ligne3);
     * this.ajouterLigne(ligne4);
     * 
     * }
     */
}