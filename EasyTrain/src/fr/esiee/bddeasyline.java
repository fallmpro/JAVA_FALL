package fr.esiee;

import java.sql.*;

public class bddeasyline {

        static DatabaseMetaData DatabaseConnection;

        public static void ajouterUtilisateur(String login, String mdp, String nom, String prenom, String dateEmbauche, String role) {
            Connection connection = null;
            try {
                connection = DatabaseConnection.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (connection != null) {
                try {
                    // Prépare la requête d'insertion SQL
                    String insertQuery = "INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role) VALUES (?, ?, ?, ?, ?, ?)";

                    // Crée un PreparedStatement pour exécuter la requête
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                    // Associe les paramètres aux valeurs fournies
                    preparedStatement.setString(1, login);         // Associe le 1er "?" à la valeur "login"
                    preparedStatement.setString(2, mdp);           // Associe le 2e "?" à la valeur "mdp"
                    preparedStatement.setString(3, nom);           // Associe le 3e "?" à la valeur "nom"
                    preparedStatement.setString(4, prenom);        // Associe le 4e "?" à la valeur "prenom"
                    preparedStatement.setDate(5, Date.valueOf(dateEmbauche));  // Associe le 5e "?" à la valeur "dateEmbauche"
                    preparedStatement.setString(6, role);          // Associe le 6e "?" à la valeur "role"

                    // Exécute la requête d'insertion
                    int rowsInserted = preparedStatement.executeUpdate();

                    // Vérifie si l'insertion a réussi
                    if (rowsInserted > 0) {
                        System.out.println("User added successfully");
                    }

                    // Ferme la connexion et le PreparedStatement
                    preparedStatement.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


