/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.beans.Client;
import java.util.ArrayList;

/**
 *
 * @author julien
 */
public interface ClientDao {
    
    public void addClient(Client client);
    public ArrayList<Client> getAll();
    public Client get(int id);
    
}
