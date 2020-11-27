/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.dao.impl;

import crudmysql.beans.Depense;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import crudmysql.Client.Dao.DepenseDao;

/**
 *
 * @author julien
 */
public class DepenseDaoJdbc extends JdbcDao implements DepenseDao {

    public DepenseDaoJdbc() throws SQLException {
        super();
    }

    @Override
    public void addDepenseClient(Depense depense) {
        try {
            // préviens de l'injection SQL
            String sqldepense = "INSERT INTO depense_client(id_famille,facture,alimentation,habillement,internet_communication,loisir,impots,sante,transport,services,autre) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sqldepense);
            statement.setString(1, depense.getIdfamille());
            statement.setInt(2, depense.getFacture());
            statement.setInt(3, depense.getAlimentation());
            statement.setInt(4, depense.getHabillement());
            statement.setInt(5, depense.getInternet());
            statement.setInt(6, depense.getLoisir());
            statement.setInt(7, depense.getImpots());
            statement.setInt(8, depense.getSante());
            statement.setInt(9, depense.getTransport());
            statement.setInt(10, depense.getService());
            statement.setInt(11, depense.getAutre());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
