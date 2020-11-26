/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.launcher;

import crudmysql.beans.Client;
import crudmysql.Client.Dao.DaoClient;
import crudmysql.Client.Dao.DaoOffreClient;
import crudmysql.gui.MainFrame;
import crudmysql.gui.infoClientFrame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien
 */
public class Launcher {
    
    
    public static void main(String... args){
                    
        try {
            ArrayList<Client> clients = DaoClient.getClientDao().getAll();
            String souscription=DaoOffreClient.getOffreClientDao().getSouscription("").toString();
                 
            MainFrame mf = new MainFrame(clients);
            infoClientFrame dcf = new infoClientFrame(mf,clients,souscription);
            
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
