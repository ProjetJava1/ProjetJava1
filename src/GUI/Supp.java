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
        String[] items = {"Chambre", "Docteur", "Hospitalisation", "Infirmier","Malade","Service","Soigne"};
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
            switch ((String)comboBox.getSelectedItem())
            {
            case "Chambre" :
                SupprChambre();
                break;
            case "Docteur" :
                SupprDocteur();
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
        }
    }

    public void SupprChambre()
    {
        int test=0;
        String strId;
        int Id;

        JOptionPane jop = new JOptionPane();

        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant de la chambre à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while

        // SupprChambreFromBase(Id);
    }

    public void SupprDocteur()
    {
        int test=0;
        String strId;
        int Id;
        int chx=0;
        String Nom;
        String Prenom;


        JOptionPane jop = new JOptionPane();
        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant du docteur à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while
        //SupprDocteurFromBaseId(Id);

    }

    public void SupprHospitalisation()
    {
        int test=0;
        String strId;
        int Id;

        JOptionPane jop = new JOptionPane();

        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant de l'hospitalisation à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while

        // SupprHospitalisationFromBase(Id);
    }

    public void SupprInfirmier()
    {
        int test=0;
        String strId;
        int Id;
        int chx=0;
        String Nom;
        String Prenom;

        JOptionPane jop = new JOptionPane();
        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant de l'infirmier à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while
        //SupprInfirmierFromBaseId(Id);
    }

    public void SupprMalade()
    {
        int test=0;
        String strId;
        int Id;
        int chx;
        String Nom;
        String Prenom;

        JOptionPane jop = new JOptionPane();
        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant du malade à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while
        //SupprMaladeFromBaseId(Id);
    }

    public void SupprService()
    {
        int test=0;
        String strId;
        int Id;

        JOptionPane jop = new JOptionPane();

        while (test==0)
        {
            strId = jop.showInputDialog(null, "Entrer l'identifiant du service à supprimer", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strId!=null) && (!strId.isEmpty()))
            {
                try
                {
                    Id = Integer.parseInt(strId);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while

        // SupprServiceFromBase(Id);
    }

    public void SupprSoigne()
    {
        int test=0;
        String strIdDoc;
        int IdDoc;
        String strIdMal;
        int IdMal;

        JOptionPane jop = new JOptionPane();

        while (test==0)
        {
            strIdDoc = jop.showInputDialog(null, "Entrer l'identifiant du docteur", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strIdDoc!=null) && (!strIdDoc.isEmpty()))
            {
                try
                {
                    IdDoc = Integer.parseInt(strIdDoc);
                    test=1;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while

        while (test==1)
        {
            strIdMal = jop.showInputDialog(null, "Entrer l'identifiant du malade", "Identifiant", JOptionPane.QUESTION_MESSAGE);

            if ((strIdMal!=null) && (!strIdMal.isEmpty()))
            {
                try
                {
                    IdMal = Integer.parseInt(strIdMal);
                    test=2;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Erreur : Veuillez entrer un nombre uniquement");
                }
            }
        } // Fin du while
        // SupprSoigneFromBase(IdDoc,IdMal);
    }


}
