package GUI;

/**
 *
 * @author F
 */
import Connexion.Connexion;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class RechercheAll extends JFrame implements ActionListener
{
    JToolBar theToolbar;
    JComboBox<String> comboBox;
    public Connection connect = Connexion.getInstance();

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
                AfficheChambre();
                break;
            case "Docteur" :
                AfficheDocteur();
                break;
            case "Employé" :
                AfficheEmploye();
                break;
            case "Hospitalisation" :
                AfficheHospitalisation();
                break;
            case "Infirmier" :
                AfficheInfirmier();
                break;
            case "Malade" :
                AfficheMalade();
                break;
            case "Service" :
                AfficheService();
                break;
            case "Soigne" :
                AfficheSoigne();
                break;
            }
        }
    }

    public void AfficheChambre()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM chambre;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Chambre" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheDocteur()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM docteur;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Docteur " );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheEmploye()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM employe;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Employe " );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheHospitalisation()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM hospitalisation;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Hospitalisation" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheInfirmier()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM infirmier;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Infirmier" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheMalade()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM malade;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Malade" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheService()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM service;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Service" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }

    public void AfficheSoigne()
    {

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT * FROM soigne;"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche table Soigne" );
                mainFrame.add( tablePanel, BorderLayout.CENTER );
                mainFrame.setSize( 640, 480 );
                mainFrame.setVisible( true );

            }
        }
        catch (SQLException f)
        {
            f.printStackTrace();
        }
    }
}

