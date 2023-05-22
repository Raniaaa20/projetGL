import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceUtilisateur extends Application {

    // Les mots de passe pour les types d'utilisateurs
    private static final String MDP_ADMIN = "2023";
    private static final String MDP_USER = "2024";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu de connexion");

        GridPane gridPane = new GridPane();
        // Définit l'espacement autour du panneau
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        // Définit l'espacement vertical entre les cellules
        gridPane.setVgap(10);
        // Définit l'espacement horizontal entre les cellules
        gridPane.setHgap(10);

        // Crée et positionne les champs d'utilisateur
        Label userLabel = new Label("Utilisateur");
        GridPane.setConstraints(userLabel, 0, 0);
        TextField userField = new TextField();
        GridPane.setConstraints(userField, 1, 0);

        // Crée et positionne les champs de mot de passe
        Label passwordLabel = new Label("Mot de passe");
        GridPane.setConstraints(passwordLabel, 0, 1);
        final PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        // Crée et positionne les options de type de compte
        Label typeLabel = new Label("Type de compte");
        GridPane.setConstraints(typeLabel, 0, 2);
        final ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Admin", "Utilisateur");
        typeBox.setValue("Utilisateur");
        GridPane.setConstraints(typeBox, 1, 2);

        // Crée le bouton de connexion et défini ce qui se passe lorsqu'il est pressé
        Button loginButton = new Button("Connexion");
        GridPane.setConstraints(loginButton, 1, 3);
        loginButton.setOnAction(e -> {
            String selectedType = typeBox.getValue();
            String enteredPassword = passwordField.getText();
            if ("Admin".equals(selectedType) && MDP_ADMIN.equals(enteredPassword)) {
                // Si l'utilisateur est un admin et que le mot de passe est correct, ouvre la
                // nouvelle fenêtre en tant qu'admin
                openNewWindow("Admin");
            } else if ("Utilisateur".equals(selectedType) && MDP_USER.equals(enteredPassword)) {
                // Si l'utilisateur est un utilisateur normal et que le mot de passe est
                // correct, ouvre la nouvelle fenêtre en tant qu'utilisateur
                openNewWindow("Utilisateur");
            } else {
                // Si le mot de passe est incorrect, affiche un message d'erreur
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur d'authentification");
                alert.setHeaderText(null);
                alert.setContentText("Nom d'utilisateur ou mot de passe incorrect");
                alert.showAndWait();
            }
        });

        // Ajoute tous les éléments au panneau
        gridPane.getChildren().addAll(userLabel, userField, passwordLabel, passwordField, typeLabel, typeBox,
                loginButton);

        // Crée la scène avec le panneau et l'affiche
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Cette méthode est appelée pour ouvrir une nouvelle fenêtre lorsque
    // l'utilisateur se connecte avec succès
    private void openNewWindow(String userType) {
        Stage newStage = new Stage(); // Crée une nouvelle fenêtre
        Label label = new Label("Bienvenue, " + userType); // Crée un message de bienvenue
        Scene newScene = new Scene(label, 200, 100); // Crée une nouvelle scène avec le message de bienvenue
        newStage.setScene(newScene); // Définit la scène pour la nouvelle fenêtre
        newStage.show(); // Affiche la nouvelle fenêtre
    }
}
