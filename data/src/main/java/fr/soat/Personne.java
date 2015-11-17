package fr.soat;

public class Personne {

    String nom;
    String prenom;

    public Personne(String prenom, String nom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        // return "prenom : " + prenom + " - nom : " + nom;
        return nom + " " + prenom;
    }

}
