/*package fr.ul.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControlleurTest {

    // Ici, nous utilisons l'annotation @Mock pour créer des versions mockées de nos composants JavaFX.
    // Un mock est une version fictive d'un objet que nous pouvons utiliser pour simuler son comportement.
    @Mock
    private TextField adresseD;

    @Mock
    private TextField adresseA;

    @Mock
    private TextField statD;
    
    @Mock
    private TextField statA;

    @Mock
    private Pane paneOptions;

    @Mock
    private CheckBox rapide;

    @Mock
    private CheckBox corresp;

    @Mock
    private CheckBox stop;

    private Controlleur controlleur;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks
        MockitoAnnotations.initMocks(this);

        // Création de l'instance de Controlleur à tester
        controlleur = new Controlleur();

        // Liaison des mocks à l'instance de Controlleur
        controlleur.adresseD = adresseD;
        controlleur.adresseA = adresseA;
        controlleur.statD = statD;
        controlleur.statA = statA;
        controlleur.paneOptions = paneOptions;
        controlleur.rapide = rapide;
        controlleur.corresp = corresp;
        controlleur.stop = stop;
    }

    @Test
    public void testUpdateOptionsVisibility_allFieldsEmpty() {
        // Configuration des mocks pour retourner une chaîne vide lorsqu'on appelle la méthode getText()
        when(adresseD.getText()).thenReturn("");
        when(adresseA.getText()).thenReturn("");
        when(statD.getText()).thenReturn("");
        when(statA.getText()).thenReturn("");

        // Appel de la méthode à tester
        controlleur.updateOptionsVisibility();

        // Vérification que les méthodes attendues ont été appelées sur les mocks
        // Dans ce cas, nous nous attendons à ce que setVisible(false) soit appelé pour paneOptions, rapide, corresp, stop
        verify(paneOptions).setVisible(false);
        verify(rapide).setVisible(false);
        verify(corresp).setVisible(false);
        verify(stop).setVisible(false);
    }

    @Test
    public void testUpdateOptionsVisibility_allFieldsNotEmpty() {
        // Configuration des mocks pour retourner "Test" lorsqu'on appelle la méthode getText()
        when(adresseD.getText()).thenReturn("Test");
        when(adresseA.getText()).thenReturn("Test");
        when(statD.getText()).thenReturn("Test");
        when(statA.getText()).thenReturn("Test");

        // Appel de la méthode à tester
        controlleur.updateOptionsVisibility();

        // Vérification que les méthodes attendues ont été appelées sur les mocks
        // Dans ce cas, nous nous attendons à ce que setVisible(true) soit appelé pour paneOptions, rapide, corresp, stop
        verify(paneOptions).setVisible(true);
        verify(rapide).setVisible(true);
        verify(corresp).setVisible(true);
        verify(stop).setVisible(true);
    }
}*/
