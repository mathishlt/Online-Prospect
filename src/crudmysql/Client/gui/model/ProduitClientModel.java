/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.gui.model;

import crudmysql.Client.Dao.DaoOffreClient;
import crudmysql.beans.Offre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProduitClientModel extends AbstractTableModel {

    private List<Offre> offres;

    public ProduitClientModel() {
        offres = new ArrayList<Offre>();
        try {
            offres = DaoOffreClient.getOffreClientDao().getAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 6;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return offres.size();
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "ID";
        } else if (col == 1) {
            return "Offres";
        } else if (col == 2) {
            return "Nom";
        } else if (col == 3) {
            return "Prénom";
        } else if (col == 4) {
            return "Souscription";
        }else {
            return "id_famille";

        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        // TODO Auto-generated method stub
        if (col == 0) {
            return offres.get(row).getId();
        } else if (col == 1) {
            return offres.get(row).getOffre();
        }else if (col == 2) {
            return offres.get(row).getNom();
        }  else if (col == 3) {
            return offres.get(row).getPrenom();
        } else if (col == 4) {
            return offres.get(row).getSouscription();
        } else if (col == 5) {
            return offres.get(row).getIdfamille();
        }
        return null;
    }

}
