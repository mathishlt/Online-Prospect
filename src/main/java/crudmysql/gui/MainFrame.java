/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.gui;

import crudmysql.beans.Client;
import crudmysql.beans.Offre;
import crudmysql.beans.Depense;
import crudmysql.Client.Dao.DaoClient;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Julien
 */
public class MainFrame extends JFrame{
    
    private ArrayList<Client> clients;
    private JPanel panel;
    private JButton addClientBtn;
    private JButton infoClientButton;
    private DefaultListModel model = new DefaultListModel();
    private Client newClient;
    private Offre newOffre;
    private Depense newDepense;
    private String souscription;

    public MainFrame(ArrayList<Client> clients ){
        super();
        setVisible(true);
        setTitle("Test BDD");
        setBounds(100, 100, 450, 600);
        setMinimumSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.clients = clients;
        initComponent();
    }
    
    private void initComponent(){
        this.panel = new JPanel(new BorderLayout());
        
        for(Client a : clients){
          model.addElement(a);
       }
        
        
        this.infoClientButton = new JButton("Voir tout les clients");
        panel.add(this.infoClientButton, BorderLayout.NORTH);
        infoClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new infoClientFrame(getThis(),clients,souscription).setVisible(true);
            }
        });
        
        this.addClientBtn = new JButton("Ajouter un client");
        panel.add(this.addClientBtn, BorderLayout.SOUTH);
        addClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addClientFrame(getThis()).setVisible(true);
            }
        });
        
        getContentPane().add(panel);
    }
    
    public void refresh(){
        try {
            clients = DaoClient.getClientDao().getAll();
            model.addElement(clients.get(clients.size()-1));
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MainFrame getThis(){
        return this;
    }

    public Client getNewClient() {
        return newClient;
    }

    public void setNewClient(Client newClient) {
        System.out.println("Client passé en paramètre "+newClient);
        this.newClient = newClient;
    }
        
    public Offre getNewOffreClient() {
        return newOffre;
    }

    public void setNewOffreClient(Offre newOffre) {
        System.out.println("Offre passé en paramètre "+newOffre);
        this.newOffre = newOffre;
    }
    
    public Depense getNewDepenseClient() {
        return newDepense;
    }

    public void setNewDepenseClient(Depense newDepense) {
        System.out.println("Depense passé en paramètre "+newDepense);
        this.newDepense = newDepense;
    }
    
    
}
