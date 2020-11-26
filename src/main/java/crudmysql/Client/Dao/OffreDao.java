/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.beans.Offre;

/**
 *
 * @author julien
 */
public interface OffreDao {
    
    public void addOffreClient(Offre offre);
    public Offre getSouscription(String idfamille);
    
}
