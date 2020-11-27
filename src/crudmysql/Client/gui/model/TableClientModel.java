/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.gui.model;

import crudmysql.Client.Dao.DaoClient;
import crudmysql.beans.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableClientModel extends AbstractTableModel {

    private List<Client> clients;

    public TableClientModel() {
        clients = new ArrayList<Client>();
        try {
            clients = DaoClient.getClientDao().getAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 8;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return clients.size();
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "ID";
        } else if (col == 1) {
            return "Nom";
        } else if (col == 2) {
            return "Prénom";
        } else if (col == 3) {
            return "Âge";
        } else if (col == 4) {
            return "Situation profesionnelle";
        } else if (col == 5) {
            return "Situation personnelle";
        } else if (col == 6) {
            return "Revenus annuels";
        } else {
            return "id_famille";

        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        // TODO Auto-generated method stub
        if (col == 0) {
            return clients.get(row).getId();
        } else if (col == 1) {
            return clients.get(row).getNom();
        } else if (col == 2) {
            return clients.get(row).getPrenom();
        } else if (col == 3) {
            return clients.get(row).getAge();
        } else if (col == 4) {
            return clients.get(row).getPro();
        } else if (col == 5) {
            return clients.get(row).getFamille();
        } else if (col == 6) {
            return clients.get(row).getRevenu();
        } else if (col == 7) {
            return clients.get(row).getIdfamille();
        }
        return null;
    }

}
