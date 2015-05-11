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
import Connexion.ChartDocteur;
import Connexion.ChartMutuelle;
import Connexion.Charts;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Statistiques extends JFrame implements ActionListener
{	
        JButton Stat1;
        JButton Stat2;
        JButton Stat3;
        JButton Quitter;

        public Statistiques()
        {
            setTitle("Statistiques");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.Stat1 = new JButton("Nombre d'hospitalisations par service");
            this.Stat2 = new JButton("Nombre de docteurs par spécialisation");
            this.Stat3 = new JButton("Nombre de malades par mutuelle");// Changer le nom
            this.Quitter = new JButton("Quitter");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            Stat1.setBounds(new Rectangle(15,20,250,40));
            Stat1.setText("Nombre d'hospitalisations par service");

            Stat2.setBounds(new Rectangle(15,110,250,40));
            Stat2.setText("Nombre de docteurs par spécialisation");
            
            Stat3.setBounds(new Rectangle(15,200,250,40));
            Stat3.setText("Nombre de malades par mutuelle");
            
            Quitter.setBounds(new Rectangle(15,290,250,40));
            Quitter.setText("Quitter");
            
            
            this.Stat1.addActionListener(this);
            this.Stat2.addActionListener(this);
            this.Stat3.addActionListener(this);
            this.Quitter.addActionListener(this);

            panneau.add(Stat1);
            panneau.add(Stat2);
            panneau.add(Stat3);
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
    if (e.getActionCommand().equals("Nombre d'hospitalisations par service")) {
            System.out.println("Nombre d'hospitalisations par service");
            new Charts();
          }
          else if (e.getActionCommand().equals("Nombre de docteurs par spécialisation")) {
            System.out.println("Nombre de docteurs par spécialisation");
            new ChartDocteur();
          }
          else if (e.getActionCommand().equals("Nombre de malades par mutuelle")) {
            System.out.println("Nombre de malades par mutuelle");
            new ChartMutuelle();
          }
          else if (e.getActionCommand().equals("Quitter")) {
            System.out.println("Quitter");
            this.dispose();
          }
    }
}