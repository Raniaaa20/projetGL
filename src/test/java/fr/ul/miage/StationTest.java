package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StationTest {

    private Station station;

    @BeforeEach
    public void setUp() {
        station = new Station("StationTest", 5, false, 48.8566, 2.3522);
    }

    @Test
    public void testGetNom() {
        assertEquals("StationTest", station.getNom());
    }

    @Test
    public void testIsAccident() {
        assertFalse(station.isAccident());
    }

    @Test
    public void testSetAccident() {
        station.setAccident(true);
        assertTrue(station.isAccident());
    }

    @Test
    public void testGetTempsArret() {
        assertEquals(5, station.getTempsArret());
    }

    @Test
    public void testAddVoie() {
        Station station2 = new Station("StationTest2", 7, false, 48.8534, 2.3488);
        Voie voie = new Voie(station, station2, 10, false);
        station.addVoie(voie);
        assertTrue(station.getVoies().contains(voie));
    }
}
