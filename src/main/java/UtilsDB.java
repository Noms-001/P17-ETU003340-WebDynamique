package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilsDB {
    private static final String URL = "jdbc:mysql://localhost:3306/Previsions";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";

    private static Connection connexion = null;

    public static Connection getConnexion() throws Exception {
        if (connexion == null || connexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
                connexion.setAutoCommit(true);
            } catch (Exception e) {
                throw new Exception("Erreur de connexion : " + e.getMessage());
            }
        }
        return connexion;
    }
}