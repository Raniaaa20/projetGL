package metroparisien;

public class Menu {
	
    private static final String MENU_ACCUEIL = "Bonjour, veuillez choisir une option..\n1. Se connecter en tant qu'utilisateur\n2. Se connecter en tant qu'administrateur\n3. Quitter\n";
    private static final String MENU_ADMINISTRATEUR = "1. Ajouter incident dans une station\n2. Ajouter incident sur une voie\n3. Quitter\n";
    private static final String MENU_UTILISATEUR = "1. Choisir station de départ\n2. Choisir station d'arrivée\n3. Quitter\n";
    
    public static String getMenuAccueil() {
        return MENU_ACCUEIL;
    }
    
    public static String getMenuAdministrateur() {
        return MENU_ADMINISTRATEUR;
    }
    
    public static String getMenuUtilisateur() {
        return MENU_UTILISATEUR;
    }
}

