/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
/*
 * 
 * Librairies importées
 */
import BDD.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * Affiche dans la fenetre graphique les champs de tables et les requetes de la BDD
 *
 * @author segado
 */
public class Fenetre extends JFrame implements ActionListener, ItemListener {
    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */
    private Connexion maconnexion;
    private Label req, res, champ, desc, maj;
    private JLabel nameECE, passwdECE, loginBDD, passwdBDD;
    private JTextField nameECETexte, loginBDDTexte;
    private JPasswordField passwdECETexte, passwdBDDTexte;
    private JButton connect, bouton1, bouton_Fer, bouton_Afc;
    private java.awt.List listeDeChamps, listeDeRequetes, listeRequetesMaj;
    private JTextArea fenetreRes;
    private JTextField nomTable;
    private JPanel p0, p1, nord, p2, p3;

    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public Fenetre() {

        // creation par heritage de la fenetre
        super("Projet d'utilisation de JDBC dans MySQL");

        // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setVisible(true);

        // creation des boutons
        connect = new JButton("Connexion");
        bouton1 = new JButton("AfficheChamps");
        bouton_Fer = new JButton("AfficheRequetes");
        bouton_Afc = new JButton("Fermer");

        // creation des listes pour les requetes et les champs
        listeDeChamps = new java.awt.List(10, false);
        listeDeRequetes = new java.awt.List(10, false);
        listeRequetesMaj = new java.awt.List(10, false);

        // creation des textes
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);
        nomTable = new JTextField();
        fenetreRes = new JTextArea();

        // creation des labels
        champ = new Label("Champs");
        champ.setAlignment(1);
        req = new Label("Requetes de selection");
        req.setAlignment(1);
        res = new Label("Résultat requete");
        res.setAlignment(1);
        maj = new Label("Requetes de MAJ");
        maj.setAlignment(1);
        nameECE = new JLabel("nom ECE :", JLabel.CENTER);
        passwdECE = new JLabel("mot de passe ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login de la base :", JLabel.CENTER);
        passwdBDD = new JLabel("password de la base :", JLabel.CENTER);

        // creation des panneaux
        p0 = new JPanel();
        p1 = new JPanel();
        nord = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        // mise en page des panneaux
        p0.setLayout(new GridLayout(1, 9));
        p1.setLayout(new GridLayout(1, 4));
        nord.setLayout(new GridLayout(2, 1));
        p2.setLayout(new GridLayout(1, 4));
        p3.setLayout(new GridLayout(1, 4));

        // ajout des objets graphqiues dans les panneaux
        p0.add(nameECE);
        p0.add(nameECETexte);
        p0.add(passwdECE);
        p0.add(passwdECETexte);
        p0.add(loginBDD);
        p0.add(loginBDDTexte);
        p0.add(passwdBDD);
        p0.add(passwdBDDTexte);
        p0.add(connect);
        p1.add(champ);
        p1.add(req);
        p1.add(res);
        p1.add(maj);
        nord.add("North", p0);
        nord.add("North", p1);
        p2.add(listeDeChamps);
        p2.add(listeDeRequetes);
        p2.add(fenetreRes);
        p2.add(listeRequetesMaj);
        p3.add(nomTable);
        p3.add(bouton1);
        p3.add(bouton_Fer);
        p3.add(bouton_Afc);

        // ajout des listeners
        connect.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        bouton1.addActionListener(this);
        bouton_Fer.addActionListener(this);
        bouton_Afc.addActionListener(this);
        listeDeRequetes.addItemListener(this);
        listeRequetesMaj.addItemListener(this);

        // couleurs des objets graphiques
        bouton1.setBackground(Color.green);
        bouton_Fer.setBackground(Color.yellow);
        bouton_Afc.setBackground(Color.red);
        p1.setBackground(Color.blue);
        champ.setBackground(Color.green);
        req.setBackground(Color.yellow);
        res.setBackground(Color.red);
        listeDeRequetes.setBackground(Color.blue);
        listeDeChamps.setBackground(Color.green);
        fenetreRes.setBackground(Color.yellow);
        listeRequetesMaj.setBackground(Color.white);

        // disposition geographique des panneaux
        add("North", nord);
        add("Center", p2);
        add("South", p3);

        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }

    /**
     *
     * Afficher les requetes de selection et de MAJ dans la fenetre
     */
    public void afficherRequetes() {
        // Requetes de selection
        for (int i = 0; i < maconnexion.requetes.size(); i++) {
            listeDeRequetes.add(maconnexion.requetes.get(i));
        }

        // Requetes de MAJ
        for (int i = 0; i < maconnexion.requetesMaj.size(); i++) {
            listeRequetesMaj.add(maconnexion.requetesMaj.get(i));
        }
    }

    /**
     *
     * Pour gerer les actions sur les boutons on utilise la fonction
     * actionPerformed
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        // tester cas de la commande evenementielle
        if (evt.getActionCommand().equals("Fermer")) {

            this.dispose();
            System.exit(0);
        } 
        
        else if (evt.getActionCommand().equals("Connexion")) {
            String passwdECEString = new String(passwdECETexte.getPassword());
            String passwdBDDString = new String(passwdBDDTexte.getPassword());

            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    maconnexion = new Connexion(nameECETexte.getText(), passwdECEString,
                            loginBDDTexte.getText(), passwdBDDString);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
            

        } 
        
        else if (evt.getActionCommand().equals("AfficheChamps")) {
            try {
                ArrayList<String> liste;

                // recuperer la liste des champs de la table
                liste = maconnexion.remplirChampsTable(nomTable.getText());

                // effacer les champs de la fenetre
                listeDeChamps.removeAll();

                // ajouter la liste des champs dans la fenetre
                for (int i = 0; i < liste.size(); i++) {
                    listeDeChamps.add(liste.get(i));
                }

                // se positionner sur le premier champ
                listeDeChamps.select(0);
            } catch (SQLException e) {
                System.out.println("Echec SQL");
                e.printStackTrace();
            }

        } 
        
        else if (evt.getActionCommand().equals("AfficheRequetes")) {
            // effacer la liste des requetes de selection et de MAJ
            listeDeRequetes.removeAll();
            listeRequetesMaj.removeAll();

            // afficher la liste de toutes les requetes
            afficherRequetes();

            // se positionner sur la première requête de selection et de MAJ
            listeDeRequetes.select(0);
            listeRequetesMaj.select(0);
        }
        
           DAO<Soigne> soigneDAO = new SoigneDAO();
           Soigne soi = new Soigne(204,192);
           soigneDAO.create(soi);
    }
        
    
 
    
    /**
    *
    * Pour gerer les actions sur items d'une liste on utilise la methode
    * itemStateChanged
    */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        // clic sur une requete de selection
        if (evt.getSource() == listeDeRequetes) {
            try {
                ArrayList<String> liste;

                // recuperer la liste des lignes de la requete selectionnee
                String requeteSelectionnee = listeDeRequetes.getSelectedItem();
                liste = maconnexion.remplirChampsRequete(requeteSelectionnee);

                // afficher les lignes de la requete selectionnee a partir de la liste
                fenetreRes.setText("");
                for (int i = 0; i < liste.size(); i++) {
                    fenetreRes.append(liste.get(i));
                }
            } catch (SQLException e) {
                System.out.println("Echec SQL");
                e.printStackTrace();
            }
        } // clic sur une requete de MAJ
        else if (evt.getSource() == listeRequetesMaj) {
            try {
                // executer la requete de MAJ selectionnee
                String requeteSelectionnee = listeRequetesMaj.getSelectedItem();
                maconnexion.executeUpdate(requeteSelectionnee);
            } catch (SQLException e) {
                System.out.println("Echec SQL");
                e.printStackTrace();

            }
        }
    }
}

