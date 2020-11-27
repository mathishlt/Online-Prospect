/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.dao.impl.OffreDaoJdbc;
import java.sql.SQLException;

/**
 *
 * @author julie
 */
public class DaoOffreClient {
      private static OffreDao offredao;

    private DaoOffreClient(){
        throw new IllegalStateException();
    }
    
    public static OffreDao getOffreClientDao() throws SQLException{
        if(offredao == null){
            offredao = new OffreDaoJdbc();
        }
        return offredao;
    }
}
