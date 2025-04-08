package models;

public class Credit {
    int id;
    String libelle;
    double montant;

    public Credit(String libelle, double montant) throws Exception{
        this.libelle = libelle;
        this.montant = montant;
    }

     public Credit(int id, String libelle, double montant) throws Exception{
        this.id = id;
        this.libelle = libelle;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

}