package GUI;

/**
 *
 * @author F
 */
import Connexion.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

@SuppressWarnings("serial")
public class Requete extends JFrame
{
    public Connection connect = Connexion.getInstance();
    String NomDoc;

    public Requete()
    {
        JOptionPane jop = new JOptionPane();

        NomDoc = jop.showInputDialog(null, "Entrer le nom du docteur", "Docteur", JOptionPane.QUESTION_MESSAGE);

        try
        {
            ResultSet resultat=this .connect
                               .createStatement(
                                   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE
                               ).executeQuery(
                                   "SELECT m.nom, m.prenom FROM employe e1, docteur d1, malade m, soigne WHERE d1.numero=e1.numero AND d1.numero= no_docteur AND m.numero=no_malade AND e1.nom="+"'"+NomDoc+"'"
                               );
            if(resultat.first())
            {
                ResultSetTableModel rtm = new ResultSetTableModel( resultat );
                TablePanel tablePanel = new TablePanel( rtm );
                JFrame mainFrame = new JFrame( "Affiche les patients du docteur "+NomDoc );
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
