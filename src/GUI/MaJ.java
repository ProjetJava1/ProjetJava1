package GUI;

/**
 *
 * @author F
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MaJ extends JFrame implements ActionListener
{
    JButton Ajouter;
    JButton Supprimer;
    JButton Modifier;
    JButton Retour;

    public MaJ(String titre)
    {
        setTitle(titre);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.Ajouter = new JButton("Ajouter");
        this.Supprimer = new JButton("Supprimer");
        this.Modifier = new JButton("Modifier");
        this.Retour = new JButton("Retour");

        Container panneau=this.getContentPane();
        panneau.setLayout(null);

        Ajouter.setBounds(new Rectangle(75,20,150,40));
        Ajouter.setText("Ajouter");

        Supprimer.setBounds(new Rectangle(75,110,150,40));
        Supprimer.setText("Supprimer");

        Modifier.setBounds(new Rectangle(75,200,150,40));
        Modifier.setText("Modifier");

        Retour.setBounds(new Rectangle(75,290,150,40));
        Retour.setText("Retour");

        this.Ajouter.addActionListener(this);
        this.Supprimer.addActionListener(this);
        this.Modifier.addActionListener(this);
        this.Retour.addActionListener(this);

        panneau.add(Ajouter);
        panneau.add(Supprimer);
        panneau.add(Modifier);
        panneau.add(Retour);

        setSize(300,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Ajouter"))
        {
            new Ajout();
        }
        else if (e.getActionCommand().equals("Supprimer"))
        {
            new Supp();
        }
        else if (e.getActionCommand().equals("Modifier"))
        {
            new Modifier();
        }
        else if (e.getActionCommand().equals("Retour"))
        {
            this.dispose(); // Ferme la fenêtre
        }
    }
}
