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
    Station defense = new Station("La Défense - Grande Arche", 3, false, 48.8924, 2.2356);
    Station esplanadeDeLaDefense = new Station("Esplanade de la Défense", 3, false, 48.8894, 2.2565);
    Station pontDeNeuilly = new Station("Pont de Neuilly", 3, false, 48.8852, 2.2594);
    Station lesSablons = new Station("Les Sablons (Jardin d'Acclimatation)", 3, false, 48.8811, 2.2718);
    Station porteMaillot = new Station("Porte Maillot (Palais des Congrès)", 3, false, 48.8783, 2.2827);
    Station argentine = new Station("Argentine", 3, false, 48.8755, 2.2896);
    Station charlesDeGaulleEtoile = new Station("Charles de Gaulle — Étoile", 3, false, 48.8738, 2.2950);
    Station georgeV = new Station("George V", 3, false, 48.8723, 2.3006);
    Station franklinDRoosevelt = new Station("Franklin D. Roosevelt", 3, false, 48.8686, 2.3076);
    Station champsElyseesClemenceau = new Station("Champs-Élysées — Clemenceau (Grand Palais)", 3, false, 48.8663,
        2.3126);
    Station concorde = new Station("Concorde", 3, false, 48.8651, 2.3214);
    Station tuileries = new Station("Tuileries", 3, false, 48.8636, 2.3323);
    Station palaisRoyalMuseeDuLouvre = new Station("Palais Royal - Musée du Louvre", 3, false, 48.8630, 2.3362);
    Station louvreRivoli = new Station("Louvre — Rivoli", 3, false, 48.8600, 2.3404);
    Station chatelet = new Station("Châtelet", 3, false, 48.8589, 2.3475);
    Station hotelDeVille = new Station("Hôtel de Ville", 3, false, 48.8564, 2.3522);
    Station saintPaul = new Station("Saint-Paul (Le Marais)", 3, false, 48.8555, 2.3605);
    Station bastille = new Station("Bastille", 3, false, 48.8531, 2.3692);
    Station gareDeLyon = new Station("Gare de Lyon", 3, false, 48.8445, 2.3744);
    Station reuillyDiderot = new Station("Reuilly — Diderot", 3, false, 48.8472, 2.3873);
    Station nation = new Station("Nation", 3, false, 48.8486, 2.3961);
    Station porteDeVincennes = new Station("Porte de Vincennes", 3, false, 48.8471, 2.4099);
    Station saintMande = new Station("Saint-Mandé", 3, false, 48.8462, 2.4183);
    Station berault = new Station("Bérault", 3, false, 48.8452, 2.4277);
    Station chateauDeVincennes = new Station("Château de Vincennes", 3, false, 48.8443, 2.4341);

    Voie defense_esplanadeDeLaDefense = new Voie(defense, esplanadeDeLaDefense, 10, false);
    Voie esplanadeDeLaDefense_pontDeNeuilly = new Voie(esplanadeDeLaDefense, pontDeNeuilly, 10, false);
    Voie pontDeNeuilly_lesSablons = new Voie(pontDeNeuilly, lesSablons, 10, false);
    Voie lesSablons_porteMaillot = new Voie(lesSablons, porteMaillot, 10, false);
    Voie porteMaillot_argentine = new Voie(porteMaillot, argentine, 10, false);
    Voie argentine_charlesDeGaulleEtoile = new Voie(argentine, charlesDeGaulleEtoile, 10, false);
    Voie charlesDeGaulleEtoile_georgeV = new Voie(charlesDeGaulleEtoile, georgeV, 10, false);
    Voie georgeV_franklinDRoosevelt = new Voie(georgeV, franklinDRoosevelt, 10, false);
    Voie franklinDRoosevelt_champsElyseesClemenceau = new Voie(franklinDRoosevelt, champsElyseesClemenceau, 10, false);
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
    Station porteDauphine = new Station("Porte Dauphine (Maréchal de Lattre de Tassigny)", 3, false, 48.8713, 2.2746);
    Station victorHugo = new Station("Victor Hugo", 3, false, 48.8693, 2.2828);
    // charlesDeGaulleEtoile
    Station ternes = new Station("Ternes", 3, false, 48.8768, 2.2986);
    Station courcelles = new Station("Courcelles", 3, false, 48.8801, 2.3072);
    Station monceau = new Station("Monceau", 3, false, 48.8833, 2.3084);
    Station villiers = new Station("Villiers", 3, false, 48.8816, 2.3169);
    Station rome = new Station("Rome", 3, false, 48.8828, 2.3236);
    Station placeDeClichy = new Station("Place de Clichy", 3, false, 48.8838, 2.3271);
    Station blanche = new Station("Blanche", 3, false, 48.8827, 2.3338);
    Station pigalle = new Station("Pigalle", 3, false, 48.8825, 2.3375);
    Station anvers = new Station("Anvers (Sacré-Cœur)", 3, false, 48.8826, 2.3443);
    Station barbesRochechouart = new Station("Barbès - Rochechouart", 3, false, 48.8832, 2.3504);
    Station laChapelle = new Station("La Chapelle", 3, false, 48.8845, 2.3590);
    Station stalingrad = new Station("Stalingrad", 3, false, 48.8841, 2.3667);
    Station jaures = new Station("Jaurès", 3, false, 48.8827, 2.3708);
    Station colonelFabien = new Station("Colonel Fabien", 3, false, 48.8782, 2.3708);
    Station belleville = new Station("Belleville", 3, false, 48.8726, 2.3769);
    Station couronnes = new Station("Couronnes", 3, false, 48.8689, 2.3796);
    Station menilmontant = new Station("Ménilmontant", 3, false, 48.8669, 2.3846);
    Station pereLachaise = new Station("Père Lachaise", 3, false, 48.8640, 2.3875);
    Station philippeAuguste = new Station("Philippe Auguste", 3, false, 48.8604, 2.3910);
    Station alexandreDumas = new Station("Alexandre Dumas", 3, false, 48.8576, 2.3951);
    Station avron = new Station("Avron", 3, false, 48.8551, 2.3983);

    // nation

  }

}