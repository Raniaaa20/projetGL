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

    // Test pour vérifier l'ajout d'une station à la ligne
    @Test
    public void testAddStation() {
        Station station = new Station("StationTest", 5, false, 48.8566, 2.3522); 
        ligne.addStation(station);
        assertTrue(ligne.getStations().contains(station));
    }

    // Test pour vérifier l'ajout d'une voie à la ligne
    @Test
    public void testAddVoie() {
        Station station1 = new Station("StationTest1", 5, false, 48.8566, 2.3522);
        Station station2 = new Station("StationTest2", 7, false, 48.8534, 2.3488);
        Voie voie = new Voie(station1, station2, 10, false);
        ligne.addVoie(voie);
        assertTrue(ligne.getVoies().contains(voie));
    }
}
