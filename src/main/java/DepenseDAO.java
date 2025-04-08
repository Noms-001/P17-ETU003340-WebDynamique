package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Credit;
import models.Depense;

public class DepenseDAO {
    
    public static void save(Depense depense) throws Exception {
        String sql = "INSERT INTO Depense(libelle, credit, montant) VALUES (?, ?, ?)";
        try (Connection connection = UtilsDB.getConnexion();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, depense.getLibelle());
            statement.setInt(2, depense.getCredit());
            statement.setDouble(3, depense.getMontant());

            statement.executeUpdate();
            System.out.println("Insertion réussie");
        } catch (Exception e) {
            System.out.println("Insertion échouée : " + e.getMessage());
            throw e;
        }
    }

    public static ArrayList<Depense> findAll() throws Exception{
        String sql = "SELECT * FROM Depense";
        ArrayList<Depense> credits = new ArrayList<>();
        try (Connection connection = UtilsDB.getConnexion();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultset = statement.executeQuery(sql);) {
                while (resultset.next()) {
                    credits.add(new Depense(resultset.getInt("id"),
                            resultset.getString("libelle"), resultset.getInt("credit"), 
                            resultset.getDouble("montant"))); 
                }
            }
            System.out.println("Récupération réussie");
        } catch ( Exception e) {
            System.out.println("Récupération échouée : " + e.getMessage());
            throw e;
        }
        return credits;
    }
}