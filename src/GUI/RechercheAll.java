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
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author F
 */

@SuppressWarnings("serial")
public class RechercheAll extends JFrame implements ActionListener
{
    JToolBar theToolbar;
    JComboBox<String> comboBox;

    public RechercheAll()
    {
        super("Recherche d'une classe");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Ferme la fenêtre quand on appuie sur la croix
        
        theToolbar = new JToolBar("My Toolbar");
        theToolbar.setFloatable(true);
        JLabel theLabel = new JLabel("Choisissez votre table ");
        theToolbar.add(theLabel);
        String[] items = {"Chambre", "Docteur","Employé" ,"Hospitalisation", "Infirmier","Malade","Service","Soigne"};
        comboBox = new JComboBox<String>(items);
        comboBox.addActionListener(this);
        theToolbar.add(comboBox);
        this.getContentPane().add(theToolbar);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(comboBox))
        {
            this.dispose();

            switch ((String)comboBox.getSelectedItem())
                    {
                case "Chambre" :
                    //AjoutChambre();
                    break;
                case "Docteur" :
                    //AjoutDocteur();
                    break;
                case "Employé" :
                    //AjoutHospitalisation();
                    break;
                case "Hospitalisation" :
                    //AjoutHospitalisation();
                    break;
                case "Infirmier" :
                    //AjoutInfirmier();
                    break;
                case "Malade" :
                    //AjoutMalade();
                    break;
                case "Service" :
                    //AjoutService();
                    break;
                case "Soigne" :
                    //AjoutSoigne();
                    break;
            }
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
