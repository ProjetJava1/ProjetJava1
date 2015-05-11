package GUI;

/**
 *
 * @author F
 */
import Connexion.ChartDocteur;
import Connexion.ChartMutuelle;
import Connexion.Charts;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Statistiques extends JFrame implements ActionListener
{
    JButton Stat1;
    JButton Stat2;
    JButton Stat3;
    JButton Retour;

    public Statistiques()
    {
        setTitle("Statistiques");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.Stat1 = new JButton("Nombre d'hospitalisations par service");
        this.Stat2 = new JButton("Nombre de docteurs par spécialisation");
        this.Stat3 = new JButton("Nombre de malades par mutuelle");// Changer le nom
        this.Retour = new JButton("Retour");

        Container panneau=this.getContentPane();
        panneau.setLayout(null);

        Stat1.setBounds(new Rectangle(15,20,250,40));
        Stat1.setText("Nombre d'hospitalisations par service");

        Stat2.setBounds(new Rectangle(15,110,250,40));
        Stat2.setText("Nombre de docteurs par spécialisation");

        Stat3.setBounds(new Rectangle(15,200,250,40));
        Stat3.setText("Nombre de malades par mutuelle");

        Retour.setBounds(new Rectangle(15,290,250,40));
        Retour.setText("Retour");

        this.Stat1.addActionListener(this);
        this.Stat2.addActionListener(this);
        this.Stat3.addActionListener(this);
        this.Retour.addActionListener(this);

        panneau.add(Stat1);
        panneau.add(Stat2);
        panneau.add(Stat3);
        panneau.add(Retour);

        setSize(300,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Nombre d'hospitalisations par service"))
        {
            new Charts();
        }
        else if (e.getActionCommand().equals("Nombre de docteurs par spécialisation"))
        {
            new ChartDocteur();
        }
        else if (e.getActionCommand().equals("Nombre de malades par mutuelle"))
        {
            new ChartMutuelle();
        }
        else if (e.getActionCommand().equals("Retour"))
        {
            this.dispose();
        }
    }
}
