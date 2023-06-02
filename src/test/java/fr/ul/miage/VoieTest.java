package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoieTest {

    private Voie voie;
    private Station station1;
    private Station station2;

    @BeforeEach
    public void setUp() {
        station1 = new Station("StationTest1", 5, false, 48.8566, 2.3522);
        station2 = new Station("StationTest2", 7, false, 48.8534, 2.3488);
        voie = new Voie(station1, station2, 10, false);
    }

    @Test
    public void testGetStationDepart() {
        assertEquals(station1, voie.getStationDepart());
    }

    @Test
    public void testGetStationArrivee() {
        assertEquals(station2, voie.getStationArrivee());
    }

    @Test
    public void testGetTempsParcours() {
        assertEquals(10, voie.gettempsParcours());
    }

    @Test
    public void testIsAccident() {
        assertFalse(voie.getAccident());
    }

    @Test
    public void testSetAccident() {
        voie.setAccident(true);
        assertTrue(voie.getAccident());
    }
}
