package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReseauMetroTest {
    private ReseauMetro reseauMetro;
    private Station station1, station2;
    private Voie voie;
    private Ligne ligne;

    @BeforeEach
    public void setUp() {
	reseauMetro = new ReseauMetro();
	station1 = new Station("Station 1", 2, false, 1.0, 1.0);
	station2 = new Station("Station 2", 3, false, 2.0, 2.0);
	voie = new Voie(station1, station2, 10,false);
	ligne = new Ligne(1, "Ligne 1");
	ligne.addStation(station1);
	ligne.addStation(station2);
	ligne.addVoie(voie);
    }

    @Test
    public void testAjouterLigne() {
	reseauMetro.ajouterLigne(ligne);
	assertEquals(1, reseauMetro.getLignes().size());
    }

    @Test
    public void testAjouterStation() {
	reseauMetro.ajouterStation("Station 1", station1);
	assertNotNull(reseauMetro.getStation("Station 1"));
    }
    
    

}