/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public class ErreurSaisie {
    
    public ErreurSaisie(){
    JOptionPane jop2 = new JOptionPane(); 
    jop2.showMessageDialog(null, "Veuillez entrer un nombre", "Erreur", JOptionPane.INFORMATION_MESSAGE);
}
}
