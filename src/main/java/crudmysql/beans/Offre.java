/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.beans;

/**
 *
 * @author julien
 */
public class Offre {

    private int id;
    private String nom;
    private String prenom;
    private String idfamille;
    private String offre;
    private String souscription;

    public Offre() {
        //créer un constructeur si aucun n'est déclaré
    }


    public Offre(int id, String nom, String prenom, String idfamille,String offre, String souscription) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idfamille = idfamille;
        this.offre = offre;
        this.souscription = souscription;

    }

    public Offre(String nom, String prenom,String idfamille,String offre,String souscription) {

        this.nom = nom;
        this.prenom = prenom;
        this.idfamille = idfamille;
        this.offre = offre;
        this.souscription = souscription;
    }
    
// Getter et Setter des différents champs
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getSouscription() {
        return souscription;
    }

    public String getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(String idfamille) {
        this.idfamille = idfamille;
    }

    public void setSouscription(String souscription) {
        this.souscription = souscription;
    }
    
    //Affiche les données de la bdd onlinebank
    @Override
    public String toString() {
     return "BDDOffre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ",idfamille=" + idfamille + ",offre=" + offre +",souscription="+souscription +'}';
    }

}
