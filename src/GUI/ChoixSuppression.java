/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


/**
 *
 * @author F
 */
@SuppressWarnings("serial")
public class ChoixSuppression extends JFrame implements ActionListener
{
   
        JButton Iden;
        JButton NP;
        int chx=0;
        
        
        public ChoixSuppression()
        {
        setTitle("Choix du type de suppression");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.Iden = new JButton("Suppression par identifiant");
            this.NP = new JButton("Suppression par nom et prénom");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            Iden.setBounds(new Rectangle(25,30,225,40));
            Iden.setText("Suppression par identifiant");

            NP.setBounds(new Rectangle(25,100,225,40));
            NP.setText("Suppression par nom et prénom");
            
            this.Iden.addActionListener(this);
            this.NP.addActionListener(this);

            panneau.add(Iden);
            panneau.add(NP);

            setSize(300,200);
            setVisible(true);
    }
        
        public int Result()
                {
                    return chx;
                }
        
        @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Suppression par identifiant")) {
            System.out.println("Suppression par identifiant");
            chx=1;           
            this.dispose(); // Ferme la fenêtre

           Result();
          }
          else if (e.getActionCommand().equals("Suppression par nom et prénom")) {
            System.out.println("Suppression par nom et prénom");
            chx=2;
            this.dispose(); // Ferme la fenêtre
            Result();
          }
        
        
}
}