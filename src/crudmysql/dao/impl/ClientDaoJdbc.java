/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.dao.impl;

import crudmysql.beans.Client;
import crudmysql.Client.Dao.ClientDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julien
 */
public class ClientDaoJdbc extends JdbcDao implements ClientDao{
    
    public ClientDaoJdbc() throws SQLException{
        super();
    }
    
    @Override
    public void addClient(Client client) {
        try{
            // préviens de l'injection SQL
            String sql = "INSERT INTO client(nom,prenom,age,situation_personnelle,situation_professionnelle,revenu,id_famille) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setInt(3, client.getAge());
            statement.setString(4, client.getFamille());
            statement.setString(5, client.getPro());
            statement.setInt(6, client.getRevenu());
            statement.setString(7, client.getIdfamille());

            /**statement.setDouble(2, alcool.getDegre());
            statement.setDouble(3, alcool.getVolume()); **/
            // ATTENTION PAS SELECT => executeUpdate();
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
  
    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<>();
        try{
            String sql = "SELECT * FROM client";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            while(rs.next()){
                // transformer la ligne sql en un object java
                clients.add(transformSqlToClient(rs));
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client get(int id) {
        Client a = new Client();
        try{
            String sql = "SELECT * FROM client WHERE id = ?";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            if(rs.next()){
                // transformer la ligne sql en un object java
                a = transformSqlToClient(rs);
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    private Client transformSqlToClient(ResultSet rs) throws SQLException{
        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setNom(rs.getString("nom"));
        client.setPrenom(rs.getString("prenom"));
        client.setAge(rs.getInt("age"));
        client.setFamille(rs.getString("situation_personnelle"));
        client.setPro(rs.getString("situation_professionnelle"));
        client.setRevenu(rs.getInt("revenu"));
        client.setIdfamille(rs.getString("id_famille"));
        return client;
    }
    
}
