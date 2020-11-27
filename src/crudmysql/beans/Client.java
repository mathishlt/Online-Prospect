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
public class Client {

    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String famille;
    private String pro;
    private int revenu;
    private String idfamille;

    public Client() {
        //créer un constructeur si aucun n'est déclaré
    }


    public Client(int id, String nom, String prenom, int age, String famille, String pro, int revenu, String idfamille) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.famille = famille;
        this.pro = pro;
        this.revenu = revenu;
        this.idfamille = idfamille;
    }

    public Client(String nom, String prenom, int age, String famille, String pro, int revenu, String idfamille) {

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.famille = famille;
        this.pro = pro;
        this.revenu = revenu;
        this.idfamille = idfamille;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public int getRevenu() {
        return revenu;
    }

    public void setRevenu(int revenu) {
        this.revenu = revenu;
    }

    public String getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(String idfamille) {
        this.idfamille = idfamille;
    }


    
    //Affiche les données de la bdd onlinebank
    @Override
    public String toString() {

       return "" + "Nom: " + nom + ",Prénom: " + prenom + ", Age: " + age + ",Situation personnelle: " + famille + ",Situation professionnelle " + pro + ",Revenu Annuel " + revenu + ",idfamille=" + idfamille +'}';
    }

}
