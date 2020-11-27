/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.Client.gui.model;

import crudmysql.Client.Dao.DaoDepenseClient;
import crudmysql.beans.Depense;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DepenseClientModel extends AbstractTableModel {

    private List<Depense> depenses;

    public DepenseClientModel() {
        depenses = new ArrayList<Depense>();
        try {
            depenses = DaoDepenseClient.getDepenseClientDao().getAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 12;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return depenses.size();
    }

    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return "ID";
        } else if (col == 1) {
            return "Facture";
        } else if (col == 2) {
            return "Alimentation";
        } else if (col == 3) {
            return "Habillement";
        } else if (col == 4) {
            return "Internet";
        } else if (col == 5) {
            return "Loisir";
        } else if (col == 6) {
            return "Impots";
        } else if (col == 7) {
            return "Santé";
        } else if (col == 8) {
            return "Transport";
        } else if (col == 9) {
            return "Services";
        }else if(col==10){
            return "Autres";
        }else{
            return "id_famille";
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        // TODO Auto-generated method stub
        if (col == 0) {
            return depenses.get(row).getId();
        } else if (col == 1) {
            return depenses.get(row).getFacture();
        }else if (col == 2) {
            return depenses.get(row).getAlimentation();
        }  else if (col == 3) {
            return depenses.get(row).getHabillement();
        } else if (col == 4) {
            return depenses.get(row).getInternet();
        } else if (col == 5) {
            return depenses.get(row).getLoisir();
        } else if (col == 6) {
            return depenses.get(row).getImpots();
        } else if (col == 7) {
            return depenses.get(row).getSante();
        } else if (col == 8) {
            return depenses.get(row).getTransport();
        } else if (col == 9) {
            return depenses.get(row).getService();
        } else if (col == 10) {
            return depenses.get(row).getAutre();
        } else if (col == 11) {
            return depenses.get(row).getIdfamille();
        }
        return null;
    }

}
