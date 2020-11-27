/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.gui;

import crudmysql.beans.Client;
import crudmysql.beans.Offre;
import crudmysql.Client.Dao.DaoClient;
import crudmysql.Client.Dao.DaoDepenseClient;
import crudmysql.Client.Dao.DaoOffreClient;
import crudmysql.beans.Depense;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.UUID;
import javaswingapp.Accueil;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 *
 * @author Julien
 */
public class addClientFrame extends JFrame {

    private Client client;
    private Offre offre;
    private Depense depense;
    private JTextField name;
    private JTextField prenom;
    private JTextField age;
    private JTextField famille;
    private UUID idfamille;
    private JTextField revenu;
    private JButton save;
    private String offre_bank;
    private String[] offre_all = {"Compte courant", "Livret jeune",
        "Livret A",
        "PEL",
        "Assurance Vie",
        "Crédit Conso",
        "Crédit immobilier",
        "Crédit auto",
        "Crédit étudiant",};
    private String[] S_professionnelle = {"Agriculteur exploitant",
        "Salarié de l\'agriculture",
        "Industriel, artisan ou commerçant",
        "Profession libérale",
        "Cadre moyen ou supérieur",
        "Employé",
        "Ouvrier",
        "Personnel de services",
        "Sans activité professionnelle",
        "En recherche d\'emploi",
        "Étudiant",
        "Retraité",
        "Scolarisé",};
    
    private String profession;
    private int alimentation = 0;
    private int facture = 0;
    private int habile = 0;
    private int internet = 0;
    private int transport = 0;
    private int loisir = 0;
    private int impots = 0;
    private int sante = 0;
    private int service = 0;
    private int autre = 0;
    private Accueil ajouter;

    public addClientFrame(Accueil ajouter) {
        super();
        setTitle("Nouveau Client");
        setBounds(100, 100, 200, 400);
        setMinimumSize(new Dimension(1000, 1000));
        this.client = new Client();
        this.offre = new Offre();
        this.depense = new Depense();
        this.ajouter = ajouter;
        initComponent();
    }

    private void initComponent() {
        // lignes puis colonnes
        JPanel panel = new JPanel(new GridLayout(30, 1));
        JLabel label1 = new JLabel("Nom");
        panel.add(label1);
        name = new JTextField();
        panel.add(name);

        JLabel label2 = new JLabel("prenom");
        panel.add(label2);
        prenom = new JTextField();
        panel.add(prenom);

        JLabel label3 = new JLabel("age");
        panel.add(label3);
        age = new JTextField();
        panel.add(age);

        JLabel label4 = new JLabel("situtaion personnelle");
        panel.add(label4);
        famille = new JTextField();
        panel.add(famille);

        JLabel label5 = new JLabel("Situation professionnelle");
        panel.add(label5);
        
        JRadioButton agriculteurButton = new JRadioButton(S_professionnelle[0]);
        agriculteurButton.setMnemonic(KeyEvent.VK_B);
        agriculteurButton.setActionCommand(S_professionnelle[0]);
        agriculteurButton.setSelected(true);

        JRadioButton salarieButton = new JRadioButton(S_professionnelle[1]);
        salarieButton.setMnemonic(KeyEvent.VK_C);
        salarieButton.setActionCommand(S_professionnelle[1]);

        JRadioButton industrielButton = new JRadioButton(S_professionnelle[2]);
        industrielButton.setMnemonic(KeyEvent.VK_D);
        industrielButton.setActionCommand(S_professionnelle[2]);

        JRadioButton liberalButton = new JRadioButton(S_professionnelle[3]);
        liberalButton.setMnemonic(KeyEvent.VK_R);
        liberalButton.setActionCommand(S_professionnelle[3]);

        JRadioButton cadreButton = new JRadioButton(S_professionnelle[4]);
        cadreButton.setMnemonic(KeyEvent.VK_P);
        cadreButton.setActionCommand(S_professionnelle[4]);

        JRadioButton employeButton = new JRadioButton(S_professionnelle[5]);
        employeButton.setMnemonic(KeyEvent.VK_P);
        employeButton.setActionCommand(S_professionnelle[5]);

        JRadioButton ouvrierButton = new JRadioButton(S_professionnelle[6]);
        ouvrierButton.setMnemonic(KeyEvent.VK_P);
        ouvrierButton.setActionCommand(S_professionnelle[6]);

        JRadioButton serviceButton = new JRadioButton(S_professionnelle[7]);
        serviceButton.setMnemonic(KeyEvent.VK_P);
        serviceButton.setActionCommand(S_professionnelle[7]);

        JRadioButton chomageButton = new JRadioButton(S_professionnelle[8]);
        chomageButton.setMnemonic(KeyEvent.VK_P);
        chomageButton.setActionCommand(S_professionnelle[8]);

        JRadioButton rechercheButton = new JRadioButton(S_professionnelle[9]);
        rechercheButton.setMnemonic(KeyEvent.VK_P);
        rechercheButton.setActionCommand(S_professionnelle[9]);

        JRadioButton etudiantButton = new JRadioButton(S_professionnelle[10]);
        etudiantButton.setMnemonic(KeyEvent.VK_P);
        etudiantButton.setActionCommand(S_professionnelle[10]);

        JRadioButton retraiteButton = new JRadioButton(S_professionnelle[11]);
        retraiteButton.setMnemonic(KeyEvent.VK_P);
        retraiteButton.setActionCommand(S_professionnelle[11]);

        JRadioButton scolariseButton = new JRadioButton(S_professionnelle[12]);
        scolariseButton.setMnemonic(KeyEvent.VK_P);
        scolariseButton.setActionCommand(S_professionnelle[12]);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(agriculteurButton);
        group.add(salarieButton);
        group.add(industrielButton);
        group.add(liberalButton);
        group.add(cadreButton);
        group.add(employeButton);
        group.add(ouvrierButton);
        group.add(serviceButton);
        group.add(chomageButton);
        group.add(rechercheButton);
        group.add(etudiantButton);
        group.add(retraiteButton);
        group.add(scolariseButton);

        panel.add(agriculteurButton);
        panel.add(salarieButton);
        panel.add(industrielButton);
        panel.add(liberalButton);
        panel.add(cadreButton);
        panel.add(employeButton);
        panel.add(ouvrierButton);
        panel.add(serviceButton);
        panel.add(chomageButton);
        panel.add(rechercheButton);
        panel.add(etudiantButton);
        panel.add(retraiteButton);
        panel.add(scolariseButton);

        JLabel label6 = new JLabel("revenu");
        panel.add(label6);
        revenu = new JTextField();
        panel.add(revenu);

        /*JLabel label7 = new JLabel("idfamille");
        panel.add(label7);
        idfamille = new JTextField();
        panel.add(idfamille);*/
        save = new JButton("enregistrer");
        panel.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idfamille = UUID.randomUUID();
                client.setNom(name.getText());
                client.setPrenom(prenom.getText());
                client.setAge(Integer.parseInt(age.getText()));
                client.setFamille(famille.getText());
                client.setIdfamille(idfamille.toString());
                client.setRevenu(Integer.parseInt(revenu.getText()));
                offre.setNom(name.getText());
                offre.setPrenom(prenom.getText());
                offre.setIdfamille(idfamille.toString());

                if (salarieButton.isSelected()) {
                    client.setPro("Salarié de l\'agriculture");
                    profession = S_professionnelle[1];
                } else if (agriculteurButton.isSelected()) {
                    client.setPro("Agriculteur exploitant");
                    profession = S_professionnelle[0];
                } else if (industrielButton.isSelected()) {
                    client.setPro("Industriel, artisan ou commerçant");
                    profession = S_professionnelle[2];

                } else if (liberalButton.isSelected()) {
                    client.setPro("Profession libérale");
                    profession = S_professionnelle[3];

                } else if (cadreButton.isSelected()) {
                    client.setPro("Cadre moyen ou supérieur");
                    profession = S_professionnelle[4];

                } else if (employeButton.isSelected()) {
                    client.setPro("Employé");
                    profession = S_professionnelle[5];

                } else if (ouvrierButton.isSelected()) {
                    client.setPro("Ouvrier");
                    profession = S_professionnelle[6];

                } else if (serviceButton.isSelected()) {
                    client.setPro("Personnel de services");
                    profession = S_professionnelle[7];

                } else if (chomageButton.isSelected()) {
                    client.setPro("Sans activité professionnelle");
                    profession = S_professionnelle[8];

                } else if (rechercheButton.isSelected()) {
                    client.setPro("En recherche d\\'emploi");
                    profession = S_professionnelle[9];

                } else if (etudiantButton.isSelected()) {
                    client.setPro("Étudiant");
                    profession = S_professionnelle[10];

                } else if (retraiteButton.isSelected()) {
                    client.setPro("Retraité");
                    profession = S_professionnelle[11];

                } else if (scolariseButton.isSelected()) {
                    client.setPro("Scolarisé");
                    profession = S_professionnelle[12];

                }
                //Ajout depense
                if (profession == S_professionnelle[0] || profession == S_professionnelle[1] || profession == S_professionnelle[2] || profession == S_professionnelle[5]
                        || profession == S_professionnelle[6] || profession == S_professionnelle[7] || profession == S_professionnelle[8]
                        || profession == S_professionnelle[9] || profession == S_professionnelle[10] || profession == S_professionnelle[11]) {

                    alimentation = new Random().nextInt(101) + 350;
                    alimentation = alimentation * 12;
                    facture = new Random().nextInt(450) + 750;
                    facture = facture * 12;
                    habile = new Random().nextInt(1700) + 1500;
                    internet = new Random().nextInt(40) + 30;
                    internet = internet * 12;
                    transport = new Random().nextInt(150) + 50;
                    transport = transport * 12;
                    loisir = new Random().nextInt(200) + 500;
                    impots = new Random().nextInt(1000) + 2000;
                    sante = new Random().nextInt(200) + 100;
                    service = new Random().nextInt(100) + 300;
                    autre = new Random().nextInt(50) + 500;

                } else if (profession == S_professionnelle[3] || profession == S_professionnelle[4]) {
                    
                    alimentation = new Random().nextInt(101) + 350;
                    alimentation = alimentation * 12;
                    facture = new Random().nextInt(1000) + 1000;
                    facture = facture * 12;
                    habile = new Random().nextInt(1500) + 2500;
                    internet = new Random().nextInt(70) + 30;
                    internet = internet * 12;
                    transport = new Random().nextInt(150) + 50;
                    transport = transport * 12;
                    loisir = new Random().nextInt(200) + 500;
                    impots = new Random().nextInt(1000) + 2000;
                    sante = new Random().nextInt(200) + 100;
                    service = new Random().nextInt(100) + 300;
                    autre = new Random().nextInt(50) + 500;

                }

                if (profession == S_professionnelle[10] || profession == S_professionnelle[9] || profession == S_professionnelle[8]) {
                    impots = 0;
                }

                if (Integer.parseInt(age.getText()) <= 16 || profession == S_professionnelle[12]){

                    alimentation = 0;
                    facture = 0;
                    habile = 0;
                    internet = 0;
                    transport = 0;
                    loisir = 0;
                    impots = 0;
                    sante = 0;
                    service = 0;
                    autre = 0;
                }

                    depense.setAlimentation(alimentation);
                    depense.setAutre(autre);
                    depense.setFacture(facture);
                    depense.setHabillement(habile);
                    depense.setIdfamille(idfamille.toString());
                    depense.setImpots(impots);
                    depense.setInternet(internet);
                    depense.setLoisir(loisir);
                    depense.setSante(sante);
                    depense.setService(service);
                    depense.setTransport(transport);
                    ajouter.setNewDepenseClient(depense);
                    
                //ajout offre
                if (Integer.parseInt(age.getText()) >= 18 && Integer.parseInt(age.getText()) <= 25) {

                    for (int v = 0; v <= 8; v++) {
                        int j = (int) (Math.random() * 3);
                        if (j == 0) {
                            offre.setSouscription("signé");
                        } else if (j == 1) {
                            offre.setSouscription("rejeté");

                        } else if (j == 2) {
                            offre.setSouscription("Aucune information");
                        }
                        offre_bank = offre_all[v];
                        offre.setOffre(offre_bank);
                        ajouter.setNewOffreClient(offre);
                        try {
                            DaoOffreClient.getOffreClientDao().addOffreClient(offre);

                        } catch (SQLException ex) {
                            Logger.getLogger(addClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (Integer.parseInt(age.getText()) < 18) {
                    for (int v = 0; v <= 8; v++) {
                        if (v == 2) {
                            offre.setSouscription("signé");
                        } else {
                            offre.setSouscription("Aucune information");
                        }
                        offre_bank = offre_all[v];
                        offre.setOffre(offre_bank);
                        ajouter.setNewOffreClient(offre);
                        try {
                            DaoOffreClient.getOffreClientDao().addOffreClient(offre);

                        } catch (SQLException ex) {
                            Logger.getLogger(addClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                } else if (Integer.parseInt(age.getText()) > 25 && Integer.parseInt(age.getText()) <= 55) {

                    for (int v = 0; v <= 8; v++) {
                        int j = (int) (Math.random() * 3);
                        if (j == 0) {
                            offre.setSouscription("signé");
                        } else if (j == 1) {
                            offre.setSouscription("rejeté");

                        } else if (j == 2) {
                            offre.setSouscription("Aucune information");
                        }
                        offre_bank = offre_all[v];
                        offre.setOffre(offre_bank);
                        ajouter.setNewOffreClient(offre);
                        try {
                            DaoOffreClient.getOffreClientDao().addOffreClient(offre);

                        } catch (SQLException ex) {
                            Logger.getLogger(addClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (Integer.parseInt(age.getText()) >= 55) {

                    for (int v = 0; v <= 8; v++) {
                        int j = (int) (Math.random() * 3);
                        if (j == 0) {
                            offre.setSouscription("signé");
                        } else if (j == 1) {
                            offre.setSouscription("rejeté");

                        } else if (j == 2) {
                            offre.setSouscription("Aucune information");
                        }
                        offre_bank = offre_all[v];
                        offre.setOffre(offre_bank);
                        ajouter.setNewOffreClient(offre);
                        try {
                            DaoOffreClient.getOffreClientDao().addOffreClient(offre);

                        } catch (SQLException ex) {
                            Logger.getLogger(addClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                try {
                    DaoDepenseClient.getDepenseClientDao().addDepenseClient(depense);
                    DaoClient.getClientDao().addClient(client);
                } catch (SQLException ex) {
                    Logger.getLogger(addClientFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ajouter.setNewClient(client);
                setVisible(false);
                ajouter.refresh();
            }
        });

        getContentPane().add(panel);
    }

}
