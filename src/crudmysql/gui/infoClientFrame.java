/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.gui;

import crudmysql.beans.Client;
import crudmysql.beans.Offre;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import crudmysql.dao.impl.OffreDaoJdbc;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Julien
 */
public class infoClientFrame extends JFrame {

    private ArrayList<Client> clients;
    private DefaultListModel model = new DefaultListModel();
    private DefaultListModel model2 = new DefaultListModel();
    private JPanel panel;
    private JButton cardClientBtn;
    private int k = 0;
    private String id_select;
    private OffreDaoJdbc offreDaoJdbc;
    private String souscription;
    private String id;
    private String revenu;
    private String nom;
    private String prenom;
    private String age;
    private Offre offres;
    private String perso;
    private String pro;
    private String idfamille;
    private JTextField nameP;
    private JTextField prenomP;
    private JTextField ageP;
    private JTextField familleP;
    private JTextField proP;
    private JTextField revenuP;


    public infoClientFrame(String id, String nom,String prenom,String age,String perso,String pro,String revenu,String idfamille,Offre offres) {
        super();
        setTitle("Information Client");
        setBounds(100, 100, 200, 400);
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.perso=perso;
        this.pro=pro;
        this.revenu=revenu;
        this.offres=offres;
        this.idfamille=idfamille;

        setMinimumSize(new Dimension(500, 500));
        initComponent();
    }

    private void initComponent() {
        
        JPanel panel = new JPanel(new GridLayout(30, 1));
        JLabel label1 = new JLabel("Nom:");
        panel.add(label1);
        JLabel label1_1 = new JLabel(nom);
        panel.add(label1_1);

        JLabel label2 = new JLabel("Prénom:");
        panel.add(label2);
        JLabel label1_2 = new JLabel(prenom);
        panel.add(label1_2);

        JLabel label3 = new JLabel("Age:");
        panel.add(label3);
        JLabel label1_3 = new JLabel(age);
        panel.add(label1_3);

        JLabel label4 = new JLabel("Situtaion familliale:");
        panel.add(label4);
        JLabel label1_4 = new JLabel(perso);
        panel.add(label1_4);

        JLabel label5 = new JLabel("Situation professionnelle:");
        panel.add(label5);
        JLabel label1_5 = new JLabel(pro);
        panel.add(label1_5);
        
        JLabel label6 = new JLabel("Revenu Annuel:");
        panel.add(label6);
        JLabel label1_6 = new JLabel(revenu);
        panel.add(label1_6);
        
        JLabel label7 = new JLabel("Les offres souscrits:");
        panel.add(label7);
        
        
        
        getContentPane().add(panel);


            }
}
