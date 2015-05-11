/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BDD.*;
import Connexion.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public Connection connect = Connexion.getInstance();

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
            this.dispose();
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
        }
    }

    public void SupprChambre()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while

        DAO<Chambre> chambreDAO = new ChambreDAO();
        chambreDAO.delete(Id);
    }

    public void SupprDocteur()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while
        DAO<Docteur> docteurDAO = new DocteurDAO();
        docteurDAO.delete(Id);
    }

    public void SupprHospitalisation()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while

        DAO<Hospitalisation> hospitalisationDAO = new HospitalisationDAO();
        hospitalisationDAO.delete(Id);
    }

    public void SupprInfirmier()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while
        DAO<Infirmier> infirmierDAO = new InfirmierDAO();
        infirmierDAO.delete(Id);
    }

    public void SupprMalade()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while
        DAO<Malade> maladeDAO = new MaladeDAO();
        maladeDAO.delete(Id);
    }

    public void SupprService()
    {
        int test=0;
        String strId;
        int Id=0;

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
                    new ErreurSaisie();
                }
            }
        } // Fin du while

        DAO<Service> serviceDAO = new ServiceDAO();
        serviceDAO.delete(Id);
    }

    public void SupprSoigne()
    {
        int test=0;
        String strIdDoc;
        int IdDoc=0;
        String strIdMal;
        int IdMal=0;
        int IdSoi=0;

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
                    new ErreurSaisie();
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
                    new ErreurSaisie();
                }
            }
        }
        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM soigne WHERE no_docteur = "+IdDoc+" AND no_malade = "+IdMal
                               );
            if(resultat.first())

                IdSoi=resultat.getInt("id_soigne");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // Fin du while
        DAO<Soigne> soigneDAO = new SoigneDAO();
        soigneDAO.delete(IdSoi);
    }

}
