/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.beans.Depense;
import java.util.ArrayList;

/**
 *
 * @author julie
 */
public interface DepenseDao {
    
        public void addDepenseClient(Depense depense);
        public ArrayList<Depense> getAll();

}
