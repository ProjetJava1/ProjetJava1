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
   
        JButton On;
        JButton Off;
        int on_off=0;
        
        public ChoixSuppression()
        {
        setTitle("Choix du type de suppression");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.On = new JButton("Suppression par identifiant");
            this.Off = new JButton("Suppression par nom et prénom");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            On.setBounds(new Rectangle(25,30,225,40));
            On.setText("Suppression par identifiant");

            Off.setBounds(new Rectangle(25,100,225,40));
            Off.setText("Suppression par nom et prénom");
            
            this.On.addActionListener(this);
            this.Off.addActionListener(this);

            panneau.add(On);
            panneau.add(Off);

            setSize(300,200);
            setVisible(true);
    }
        
        @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Suppression par identifiant")) {
            System.out.println("Suppression par identifiant");
            on_off=1;           
            this.dispose(); // Ferme la fenêtre

            new GUI(on_off);
          }
          else if (e.getActionCommand().equals("Suppression par nom et prénom")) {
            System.out.println("Suppression par nom et prénom");
            on_off=2;
            this.dispose(); // Ferme la fenêtre
            new GUI(on_off);
    }
        
        
}
}
    
    



