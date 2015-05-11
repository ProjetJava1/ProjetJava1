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
public class OnOff extends JFrame implements ActionListener
{
   
        JButton On;
        JButton Off;
        int on_off=0;
        
        public OnOff()
        {
        setTitle("Connexion");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.On = new JButton("Connexion online");
            this.Off = new JButton("Connexion offline");

            Container panneau=this.getContentPane();
            panneau.setLayout(null);
            
            On.setBounds(new Rectangle(75,30,150,40));
            On.setText("Connexion online");

            Off.setBounds(new Rectangle(75,100,150,40));
            Off.setText("Connexion offline");
            
            this.On.addActionListener(this);
            this.Off.addActionListener(this);

            panneau.add(On);
            panneau.add(Off);

            setSize(300,200);
            setVisible(true);
    }
        
        @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Connexion online")) {
            System.out.println("connexion online");          
            this.dispose(); // Ferme la fenêtre

            new GUI();
          }
          else if (e.getActionCommand().equals("Connexion offline")) {
            System.out.println("connexion offline");
            this.dispose(); // Ferme la fenêtre
            new Offline();
    }
        
        
}
}
    
    



