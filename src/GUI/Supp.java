/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author F
 */
@SuppressWarnings("serial")
public class Supp extends JFrame implements ActionListener
{
    JToolBar theToolbar;
    JComboBox<String> comboBox;
    String Service;
    int Code;
    String strCode;

    public Supp()
    {
        super("Suppression de données");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Ferme la fenêtre quand on appuie sur la croix
        
        theToolbar = new JToolBar("My Toolbar");
        theToolbar.setFloatable(true);
        JLabel theLabel = new JLabel("Choisissez la table où faire la suppression ");
        theToolbar.add(theLabel);
        String[] items = {"Chambre", "Docteur", "Employé", "Hospitalisation", "Infirmier","Malade","Service","Soigne"};
        comboBox = new JComboBox<String>(items);
        comboBox.addActionListener(this);
        theToolbar.add(comboBox);
        this.getContentPane().add(theToolbar);
        this.pack();
        this.setVisible(true);
    }
    
    public void SuppInfo(String Service)
    {
        JOptionPane jop = new JOptionPane();
        JOptionPane jop2 = new JOptionPane();
        strCode = jop.showInputDialog(null, "Entrer le code du service à supprimer", "Code", JOptionPane.QUESTION_MESSAGE);
        
// Si non vide ni "annuler"
        if ((strCode!=null) && (!strCode.isEmpty()))
        {

           // SuppFromBase(Service,Code);
            System.out.println(Service);
        }
            
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(comboBox))
        {
            switch ((String)comboBox.getSelectedItem())
                    {
                case "Chambre" :
                    SupprChambre();
                    break;
                case "Docteur" :
                    SupprDocteur();
                    break;
                case "Employé" :
                    SupprEmploye();
                    break;
                case "Hospitalisation" :
                    SupprHospitalisation();
                    break;
                case "Infirmier" :
                    SupprInfirmier();
                    break;
                case "Malade" :
                    SupprMalade();
                    break;
                case "Service" :
                    SupprService();
                    break;
                case "Soigne" :
                    SupprSoigne();
                    break;
            }
            System.out.println(comboBox.getSelectedItem());
            this.dispose();
            //AjoutInfo((String)comboBox.getSelectedItem());
        }
    }
    

    
    public void SupprChambre() 
    {
        int test=0;
        String strId;
        int Id;
        
        JOptionPane jop = new JOptionPane();

        while (test==0) {
        strId = jop.showInputDialog(null, "Entrer l'identifiant de la chambre à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

        if ((strId!=null) && (!strId.isEmpty())) {
            try {
                Id = Integer.parseInt(strId);
                test=2;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        // SupprChambreFromBase(Id);
    }
    

}
