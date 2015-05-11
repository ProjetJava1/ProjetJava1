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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MaJ extends JFrame implements ActionListener
{	
	JButton Ajouter;
        JButton Supprimer;
        JButton Modifier;
        JButton Retour;

        public MaJ(String titre)
        {
            setTitle(titre);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.Ajouter = new JButton("Ajouter");
            this.Supprimer = new JButton("Supprimer");
            this.Modifier = new JButton("Modifier");
            this.Retour = new JButton("Retour");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            Ajouter.setBounds(new Rectangle(75,20,150,40));
            Ajouter.setText("Ajouter");

            Supprimer.setBounds(new Rectangle(75,110,150,40));
            Supprimer.setText("Supprimer");
            
            Modifier.setBounds(new Rectangle(75,200,150,40));
            Modifier.setText("Modifier");
            
            Retour.setBounds(new Rectangle(75,290,150,40));
            Retour.setText("Retour");
            
            this.Ajouter.addActionListener(this);
            this.Supprimer.addActionListener(this);
            this.Modifier.addActionListener(this);
            this.Retour.addActionListener(this);

            panneau.add(Ajouter);
            panneau.add(Supprimer);
            panneau.add(Modifier);
            panneau.add(Retour);

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
    if (e.getActionCommand().equals("Ajouter")) {
            System.out.println("Ajouter");
            this.dispose();
            new Ajout();
          }
          else if (e.getActionCommand().equals("Supprimer")) {
            System.out.println("Supprimer");
            this.dispose();
            new Supp();
          }
          else if (e.getActionCommand().equals("Modifier")) {
            System.out.println("Modifier");
            this.dispose();
            new Modifier();
          }
          else if (e.getActionCommand().equals("Retour")) {
            System.out.println("Retour");
            this.dispose(); // Ferme la fenêtre
          }
    }
}