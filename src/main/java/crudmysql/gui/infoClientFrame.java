/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmysql.gui;

import crudmysql.Client.Dao.DaoOffreClient;
import crudmysql.beans.Client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import crudmysql.dao.impl.OffreDaoJdbc;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien
 */
public class infoClientFrame extends JFrame {

    private MainFrame info;
    private ArrayList<Client> clients;
    private DefaultListModel model = new DefaultListModel();
    private DefaultListModel model2 = new DefaultListModel();
    private JPanel panel;
    private JButton cardClientBtn;
    private int k = 0;
    private String id_select;
    private OffreDaoJdbc offreDaoJdbc;
    private String souscription;

    public infoClientFrame(MainFrame info, ArrayList<Client> clients,String souscription) {
        super();
        setTitle("Information Client");
        setBounds(100, 100, 200, 400);
        setMinimumSize(new Dimension(500, 500));
        this.info = info;
        this.clients = clients;
        this.souscription = souscription;

        initComponent();
    }

    private void initComponent() {

        JPanel panel = new JPanel(new GridLayout(5, 5));

        for (Client a : clients) {
            model.addElement(a);
        }

        JList list = new JList(model);
        JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        list.setValueIsAdjusting(true);
        panel.add(scroll);

        this.cardClientBtn = new JButton("Selectionner ce client");
        panel.add(this.cardClientBtn, BorderLayout.SOUTH);
        cardClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = list.getSelectedIndex();
                Object item = list.getModel().getElementAt(index);
                System.out.println("Value = " + item);
                JLabel text = new JLabel(item.toString());
                setTitle("Carte Client");
                panel.removeAll();
                panel.add(text);

                /*for (Client a : clients) {

                    if (k == index) {
                        id_select = a.getIdfamille();
                        System.out.println("Value = " + id_select);
                       /* try {
                           souscription = DaoOffreClient.getOffreClientDao().getSouscription(id_select).toString();
                            System.out.println("Valghfhgfhgfhfgue = " + souscription);
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {

                    }
                    k++;
                }*/
                
                list.setValueIsAdjusting(true);
                revalidate();
                repaint();

            }
        });

        getContentPane().add(panel);
    }

}
