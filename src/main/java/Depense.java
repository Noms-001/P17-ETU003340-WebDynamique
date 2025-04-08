package models;

public class Depense {
    int id;
    String libelle;
    int credit;
    double montant;

    public Depense(String libelle, int credit, double montant) {
        this.libelle = libelle;
        this.credit = credit;
        this.montant = montant;
    }

     public Depense(int id, String libelle, int credit, double montant) {
        this.id = id;
        this.libelle = libelle;
        this.credit = credit;
        this.montant = montant;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant){
        this.montant = montant;
    }
}