/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julien
 */
public class JdbcDao {
    
    
    private static final String URL="jdbc:mysql://localhost:3306/onlinebank";
    private static final String USER="root";
    private static final String PASSWORD="";
        private Connection connection_bdd;

    
    public JdbcDao() throws SQLException{
        this.connection_bdd=DriverManager.getConnection(URL,USER,PASSWORD);
 
}
    protected Connection getConnection(){
        
        return this.connection_bdd;
    }
}
