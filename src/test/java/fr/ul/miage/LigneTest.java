package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LigneTest {

    private Ligne ligne;

    @BeforeEach
    public void setUp() {
        ligne = new Ligne(1, "ligneTest");
    }

    @Test
    public void testGetNumero() {
        assertEquals(1, ligne.getNumero());
    }

    @Test
    public void testGetNom() {
        assertEquals("ligneTest", ligne.getNom());
    }

    @Test
    public void testAddStation() {
        Station station = new Station("StationTest", 5, false, 48.8566, 2.3522); 
        ligne.addStation(station);
        assertTrue(ligne.getStations().contains(station));
    }

    @Test
    public void testAddVoie() {
        Station station1 = new Station("StationTest1", 5, false, 48.8566, 2.3522);
        Station station2 = new Station("StationTest2", 7, false, 48.8534, 2.3488);
        Voie voie = new Voie(station1, station2, 10, false);
        ligne.addVoie(voie);
        assertTrue(ligne.getVoies().contains(voie));
    }
}
