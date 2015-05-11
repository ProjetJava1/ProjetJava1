/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author F
 */
import Connexion.*;
import BDD.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

@SuppressWarnings("serial")
public class Recherche extends JFrame implements ActionListener
{	
        private Connection maconnex; 
        JButton RechDoct;
        JButton RechEmp;
        JButton RechNPS;
        JButton Quitter;
        public Connection connect = Connexion.getInstance();

        public Recherche(Connexion conn)
        {
            maconnex=Connexion.getInstance(); 
            setTitle("Requêtes");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.RechDoct = new JButton("Patients affiliés à un docteur");
            this.RechEmp = new JButton("Afficher tous les employés");
            this.RechNPS = new JButton("Afficher des infos des docteurs");
            this.Quitter = new JButton("Quitter");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            RechDoct.setBounds(new Rectangle(15,20,250,40));
            RechDoct.setText("Patients affiliés à un docteur");

            RechEmp.setBounds(new Rectangle(15,110,250,40));
            RechEmp.setText("Afficher tous les employés");
            
            RechNPS.setBounds(new Rectangle(15,200,250,40));
            RechNPS.setText("Afficher des infos des docteurs");
            
            Quitter.setBounds(new Rectangle(15,290,250,40));
            Quitter.setText("Quitter");
            
            
            this.RechDoct.addActionListener(this);
            this.RechEmp.addActionListener(this);
            this.RechNPS.addActionListener(this);
            this.Quitter.addActionListener(this);

            panneau.add(RechDoct);
            panneau.add(RechEmp);
            panneau.add(RechNPS);
            panneau.add(Quitter);

            setSize(300,400);
            setVisible(true);

        }
        
        
    /*
        public static void main (String argv[])
        {
            new Menu("Page de connexion");
        }
    */

    @Override
    public void actionPerformed(ActionEvent e) {
                    
    if (e.getActionCommand().equals("Patients affiliés à un docteur")) {
            System.out.println("Patients affiliés à un docteur");
            new Requete();
          }
          else if (e.getActionCommand().equals("Afficher tous les employés")) {
            System.out.println("Afficher tous les employés");
            try{
                
                
                            ResultSet resultat=this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT nom, prenom FROM employe ORDER BY nom;"
                                             );
                        if(resultat.first()){   
                            ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                            TablePanel tablePanel = new TablePanel( rtm );

                            JFrame mainFrame = new JFrame( "Affiche table " );
                            mainFrame.add( tablePanel, BorderLayout.CENTER );                          
                            mainFrame.setSize( 640, 480 );
                            mainFrame.setVisible( true );

                        }
                        }catch (SQLException f) {
		            f.printStackTrace();
		    }
            
          }
          else if (e.getActionCommand().equals("Afficher des infos des docteurs")) {
            System.out.println("Afficher des infos des docteurs");
            //REQUETE A FAIRE
          }
          else if (e.getActionCommand().equals("Retour")) {
            System.out.println("Retour");
            this.dispose();          }
    }
}