/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.Dao;

import crudmysql.dao.impl.DepenseDaoJdbc;
import java.sql.SQLException;

/**
 *
 * @author julien
 */
public class DaoDepenseClient {
      private static DepenseDao depensedao;

    private DaoDepenseClient(){
        throw new IllegalStateException();
    }
    
    public static DepenseDao getDepenseClientDao() throws SQLException{
        if(depensedao == null){
            depensedao = new DepenseDaoJdbc();
        }
        return depensedao;
    }
}
