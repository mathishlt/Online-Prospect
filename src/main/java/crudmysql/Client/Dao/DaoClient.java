/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.dao.impl.ClientDaoJdbc;
import java.sql.SQLException;

/**
 *
 * @author Julien
 */
public class DaoClient {
    
    private static ClientDao clientdao;

    private DaoClient(){
        throw new IllegalStateException();
    }
    
    public static ClientDao getClientDao() throws SQLException{
        if(clientdao == null){
            clientdao = new ClientDaoJdbc();
        }
        return clientdao;
    }

    
}
