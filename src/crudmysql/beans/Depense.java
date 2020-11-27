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
public class Depense {

    private int id;
    private String idfamille;
    private int facture;
    private int alimentation;
    private int internet;
    private int habillement;
    private int loisir;
    private int sante;
    private int impots;
    private int transport;
    private int service;
    private int autre;

    public Depense() {
        //créer un constructeur si aucun n'est déclaré
    }

    public Depense(int id, String idfamille, int facture, int alimentation, int internet, int habillement, int loisir, int sante, int impots, int transport, int service, int autre) {

        this.id = id;
        this.idfamille = idfamille;
        this.facture = facture;
        this.alimentation = alimentation;
        this.internet = internet;
        this.habillement = habillement;
        this.loisir = loisir;
        this.sante = sante;
        this.impots = impots;
        this.transport = transport;
        this.service = service;
        this.autre = autre;

    }

    public Depense( String idfamille, int facture, int alimentation, int internet, int habillement, int loisir, int sante, int impots, int transport, int service, int autre) {

        this.idfamille = idfamille;
        this.facture = facture;
        this.alimentation = alimentation;
        this.internet = internet;
        this.habillement = habillement;
        this.loisir = loisir;
        this.sante = sante;
        this.impots = impots;
        this.transport = transport;
        this.service = service;
        this.autre = autre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(String idfamille) {
        this.idfamille = idfamille;
    }

    public int getFacture() {
        return facture;
    }

    public void setFacture(int facture) {
        this.facture = facture;
    }

    public int getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(int alimentation) {
        this.alimentation = alimentation;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getHabillement() {
        return habillement;
    }

    public void setHabillement(int habillement) {
        this.habillement = habillement;
    }

    public int getLoisir() {
        return loisir;
    }

    public void setLoisir(int loisir) {
        this.loisir = loisir;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public int getImpots() {
        return impots;
    }

    public void setImpots(int impots) {
        this.impots = impots;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getAutre() {
        return autre;
    }

    public void setAutre(int autre) {
        this.autre = autre;
    }


    //Affiche les données de la bdd onlinebank
    @Override
    public String toString() {
       return "BDD DEPENSE{" + "id=" + id + ", idfamille=" + idfamille + ", autre=" + autre + ",service=" + service + ",transport=" + transport +",facture="+facture +'}';
    }

}
