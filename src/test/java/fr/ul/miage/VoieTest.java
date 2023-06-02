package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoieTest {

    // Création de variables pour stocker une instance de Voie et deux instances de Station
    private Voie voie;
    private Station station1;
    private Station station2;

    // Méthode qui s'exécute avant chaque test
    // Elle initialise les instances de Station et Voie qui seront utilisées dans les tests
    @BeforeEach
    public void setUp() {
        station1 = new Station("StationTest1", 5, false, 48.8566, 2.3522);
        station2 = new Station("StationTest2", 7, false, 48.8534, 2.3488);
        voie = new Voie(station1, station2, 10, false);
    }

    // Test du getter de la station de départ
    // On vérifie que la valeur renvoyée est bien celle qui a été définie lors de la création de la Voie
    @Test
    public void testGetStationDepart() {
        assertEquals(station1, voie.getStationDepart());
    }

    // Test du getter de la station d'arrivée
    // On vérifie que la valeur renvoyée est bien celle qui a été définie lors de la création de la Voie
    @Test
    public void testGetStationArrivee() {
        assertEquals(station2, voie.getStationArrivee());
    }

    // Test du getter du temps de parcours
    // On vérifie que la valeur renvoyée est bien celle qui a été définie lors de la création de la Voie
    @Test
    public void testGetTempsParcours() {
        assertEquals(10, voie.gettempsParcours());
    }

    // Test du getter de l'accident
    // On vérifie que la valeur renvoyée est bien celle qui a été définie lors de la création de la Voie
    @Test
    public void testIsAccident() {
        assertFalse(voie.getAccident());
    }

    // Test du setter de l'accident
    // On modifie la valeur de l'accident à l'aide du setter, puis on vérifie que la nouvelle valeur a bien été prise en compte
    @Test
    public void testSetAccident() {
        voie.setAccident(true);
        assertTrue(voie.getAccident());
    }
}
