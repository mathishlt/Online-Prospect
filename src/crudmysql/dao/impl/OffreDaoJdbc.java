/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.dao.impl;

import crudmysql.beans.Offre;
import crudmysql.Client.Dao.OffreDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julien
 */
public class OffreDaoJdbc extends JdbcDao implements OffreDao{
    
    public OffreDaoJdbc() throws SQLException{
        super();
    }
    
    @Override
    public void addOffreClient(Offre offre) {
        try{
            // préviens de l'injection SQL
            String sqloffre = "INSERT INTO offres(offre,id_famille,nom,prenom,souscription) VALUES(?,?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sqloffre);
            statement.setString(1, offre.getOffre());
            statement.setString(2, offre.getIdfamille());
            statement.setString(3, offre.getNom());
            statement.setString(4, offre.getPrenom());
            statement.setString(5, offre.getSouscription());
           statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public Offre getSouscription(String idfamille) {
       Offre a = new Offre();

        try{
            String sqlSouscription =("SELECT * FROM offres WHERE id_famille = (?)");
            PreparedStatement ps = getConnection().prepareCall(sqlSouscription);
            ps.setString(1,idfamille);
            ResultSet rs = ps.executeQuery();

            // on va parcourir les lignes de la table "sql' renvoyée
           if(rs.next()){
                // transformer la ligne sql en un object java
                a = transformSqlToSouscriptionClient(rs);
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    private Offre transformSqlToSouscriptionClient(ResultSet rs) throws SQLException{
        Offre offre = new Offre();
        offre.setId(rs.getInt("id"));
        offre.setNom(rs.getString("nom"));
        offre.setPrenom(rs.getString("prenom"));
        offre.setOffre(rs.getString("offre"));
        offre.setSouscription(rs.getString("souscription"));
        offre.setIdfamille(rs.getString("id_famille"));
        return offre;
    }
    
}
