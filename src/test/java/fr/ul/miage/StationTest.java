package fr.ul.miage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class StationTest {

    // Test pour le constructeur et les accesseurs (getters)
    @Test
    public void testConstructorAndGetters() {
        // Création d'une nouvelle instance de la classe Station
        Station station = new Station("Test", 10, false, 48.858093, 2.294694);

        // Test si le nom récupéré correspond au nom donné
        assertEquals("Test", station.getNom());
        // Test si le temps d'arrêt récupéré correspond au temps d'arrêt donné
        assertEquals(10, station.getTempsArret());
        // Test si l'état de l'accident récupéré correspond à l'état de l'accident donné (qui est false)
        assertFalse(station.isAccident());
        // Test si la latitude récupérée correspond à la latitude donnée
        assertEquals(48.858093, station.latitude);
        // Test si la longitude récupérée correspond à la longitude donnée
        assertEquals(2.294694, station.longitude);
        // Test si la liste des voies récupérée est vide (ce qui est attendu pour une nouvelle station)
        assertTrue(station.getVoies().isEmpty());
        // Test si le tableau des lignes récupéré est vide (ce qui est attendu pour une nouvelle station)
        assertTrue(station.getLignes().length == 0);
    }

    // Test pour les mutateurs (setters)
	@Test
	public void testSetters() {
	    Station station = new Station("Test", 10, false, 48.858093, 2.294694);

	    // Modification du nom et vérification si le nouveau nom est correct
	    station.setNom("New Test");
	    assertEquals("New Test", station.getNom());

	    // Modification du temps d'arrêt et vérification si le nouveau temps d'arrêt est correct
	    station.setTempsArret(20);
	    assertEquals(20, station.getTempsArret());

	    // Modification de l'état de l'accident et vérification si le nouvel état de l'accident est correct
	    station.setAccident(true);
	    assertTrue(station.isAccident());

	    // Ajout d'une nouvelle voie et vérification si la voie a été ajoutée correctement
	    Station stationArrivee = new Station("Arrivee", 10, false, 48.858844, 2.294351);
	    Voie voie = new Voie(station, stationArrivee, 5, false);
	    station.addVoie(voie);
	    assertTrue(station.getVoies().contains(voie));

	    // Ajout d'une nouvelle ligne et vérification si la ligne a été ajoutée correctement
	    Ligne ligne = new Ligne(1, "Ligne 1");
	    station.setLigne(ligne);

	    // Vérification si la ligne a été ajoutée correctement
	    boolean ligneFound = false;
	    for (Ligne ligneDansTableau : station.getLignes()) {
	        if (ligneDansTableau == ligne) {
	            ligneFound = true;
	            break;
	        }
	    }
	    assertTrue(ligneFound);
	}

    // Test pour la méthode de calcul de distance
    @Test
    public void testDistanceTo() {
        Station station = new Station("Test", 10, false, 48.858093, 2.294694);

        // Calcul de la distance entre la station et un autre point
        // On vérifie si la distance calculée est correcte (à une petite marge d'erreur près)
        double distance = station.distanceTo(48.858844, 2.294351);
        assertEquals(0.083, distance, 0.01);
    }
}
