package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LigneTest {

    private Ligne ligne;

    // Initialisation avant chaque test
    @BeforeEach
    public void setUp() {
        ligne = new Ligne(1, "ligneTest");
    }

    // Test pour vérifier le numéro de la ligne
    @Test
    public void testGetNumero() {
        assertEquals(1, ligne.getNumero());
    }

    // Test pour vérifier le nom de la ligne
    @Test
    public void testGetNom() {
        assertEquals("ligneTest", ligne.getNom());
    }
    
 // Test pour la méthode addStation
    @Test
    public void testAddStation() {
        // Création d'une nouvelle instance de la classe Ligne
        Ligne ligne = new Ligne(1, "Ligne 1");

        // Ajout d'une nouvelle station et vérification si la station a été ajoutée correctement
        Station station = new Station("Station Test", 10, false, 48.858093, 2.294694);
        ligne.addStation(station);

        assertTrue(ligne.getStations().contains(station));
    }
    
    // Test pour la méthode addVoie
    @Test
    public void testAddVoie() {
        // Création d'une nouvelle instance de la classe Ligne
        Ligne ligne = new Ligne(1, "Ligne 1");

        // Ajout d'une nouvelle voie et vérification si la voie a été ajoutée correctement
        Station station1 = new Station("Station1 Test", 10, false, 48.858093, 2.294694);
        Station station2 = new Station("Station2 Test", 10, false, 48.858844, 2.294351);
        Voie voie = new Voie(station1, station2, 5, false);
        ligne.addVoie(voie);

        assertTrue(ligne.getVoies().contains(voie));
    }
}
