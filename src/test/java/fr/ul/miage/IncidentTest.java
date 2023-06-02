package fr.ul.miage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidentTest {

	//Ce test vérifie simplement que le constructeur et la méthode getDescription 
	//de la classe Incident fonctionnent correctement.
	
    @Test
    void testDescription() {
        // Arrange
        String expectedDescription = "Test incident";

        // Act
        Incident incident = new Incident(expectedDescription);

        // Assert
        assertEquals(expectedDescription, incident.getDescription());
    }
}
