import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceUtilisateur extends Application {

    private static final String MDP_ADMIN = "2023";
    private static final String MDP_USER = "2024";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu de connexion");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label userLabel = new Label("Utilisateur");
        GridPane.setConstraints(userLabel, 0, 0);
        TextField userField = new TextField();
        GridPane.setConstraints(userField, 1, 0);

        Label passwordLabel = new Label("Mot de passe");
        GridPane.setConstraints(passwordLabel, 0, 1);
        final PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Label typeLabel = new Label("Type de compte");
        GridPane.setConstraints(typeLabel, 0, 2);
        final ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Admin", "Utilisateur");
        typeBox.setValue("Utilisateur");
        GridPane.setConstraints(typeBox, 1, 2);

        Button loginButton = new Button("Connexion");
        GridPane.setConstraints(loginButton, 1, 3);
        loginButton.setOnAction(e -> {
            String selectedType = typeBox.getValue();
            String enteredPassword = passwordField.getText();
            if ("Admin".equals(selectedType) && MDP_ADMIN.equals(enteredPassword)) {
                System.out.println("Connexion en tant qu'admin réussie!");
                // Ouverture de l'interface d'administration
            } else if ("Utilisateur".equals(selectedType) && MDP_USER.equals(enteredPassword)) {
                System.out.println("Connexion en tant qu'utilisateur réussie!");
                // Ouverture de l'interface utilisateur
            } else {
                System.out.println("Authentification échouée.");
                // Affichage du message d'erreur
            }
        });

        gridPane.getChildren().addAll(userLabel, userField, passwordLabel, passwordField, typeLabel, typeBox,
                loginButton);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
