package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Credit;

public class CreditDAO {
    
    public static void save(Credit credit) throws Exception {
        String sql = "INSERT INTO Credit(libelle, montant) VALUES (?, ?)";
        try (Connection connection = UtilsDB.getConnexion();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, credit.getLibelle());
            statement.setDouble(2, credit.getMontant());

            statement.executeUpdate();
            System.out.println("Insertion réussie");
        } catch (Exception e) {
            System.out.println("Insertion échouée : " + e.getMessage());
            throw e;
        }
    }

    public static ArrayList<Credit> findAll() throws Exception{
        String sql = "SELECT * FROM Credit";
        ArrayList<Credit> credits = new ArrayList<>();
        try (Connection connection = UtilsDB.getConnexion();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultset = statement.executeQuery(sql);) {
                while (resultset.next()) {
                    credits.add(new Credit(resultset.getInt("id"),
                            resultset.getString("libelle"), resultset.getDouble("montant"))); 
                }
            }
            System.out.println("Récupération réussie");
        } catch ( Exception e) {
            System.out.println("Récupération échouée : " + e.getMessage());
            throw e;
        }
        return credits;
    }

    public static double getDepense(int credit) throws Exception {
        String sql = "SELECT SUM(Depense.montant) FROM Credit JOIN Depense ON Credit.id = Depense.credit AND Credit.id = " + credit;
        double depense = 0;
        try (Connection connection = UtilsDB.getConnexion();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultset = statement.executeQuery(sql);) {
                if (resultset.next()) {
                    depense = resultset.getDouble(1); 
                }
            }
            System.out.println("Récupération réussie");
        } catch ( Exception e) {
            System.out.println("Récupération échouée : " + e.getMessage());
            throw e;
        }
        return depense;
    }

    public static double getReste(int credit) throws Exception {
        Credit creditObj = null;
        double reste = 0;
        try {
            creditObj = CreditDAO.getCreditByID(credit);
            reste = creditObj.getMontant() - CreditDAO.getDepense(credit);
        } catch(Exception e) {
            throw e;
        }
        return reste;
    }

    public static Credit getCreditByID(int id) throws Exception {
        String sql = "SELECT * FROM Credit WHERE id = " + id;
        Credit credit = null;
        try (Connection connection = UtilsDB.getConnexion();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultset = statement.executeQuery(sql);) {
                if (resultset.next()) {
                    credit = new Credit(resultset.getInt("id"),
                            resultset.getString("libelle"), resultset.getDouble("montant")); 
                }
            }
            System.out.println("Récupération réussie");
        } catch ( Exception e) {
            System.out.println("Récupération échouée : " + e.getMessage());
            throw e;
        }
        return credit;
    }
}