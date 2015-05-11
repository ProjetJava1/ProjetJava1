package GUI;

/**
 *
 * @author F
 */
import Connexion.Connexion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener
{
    private Connexion maconnex;

    JButton Recherche;
    JButton MaJ;
    JButton Stat;
    JButton Quitter;

    public Menu(Connexion conn)
    {
        maconnex = conn;

        setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.Recherche = new JButton("Recherche");
        this.MaJ = new JButton("Mise à jour");
        this.Stat = new JButton("Statistiques");
        this.Quitter = new JButton("Quitter");

        Container panneau=this.getContentPane();
        panneau.setLayout(null);

        Recherche.setBounds(new Rectangle(75,20,150,40));
        Recherche.setText("Recherche");

        MaJ.setBounds(new Rectangle(75,110,150,40));
        MaJ.setText("Mise à jour");

        Stat.setBounds(new Rectangle(75,200,150,40));
        Stat.setText("Statistiques");

        Quitter.setBounds(new Rectangle(75,290,150,40));
        Quitter.setText("Quitter");

        this.Recherche.addActionListener(this);
        this.MaJ.addActionListener(this);
        this.Stat.addActionListener(this);
        this.Quitter.addActionListener(this);

        panneau.add(Recherche);
        panneau.add(MaJ);
        panneau.add(Stat);
        panneau.add(Quitter);

        setSize(300,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Recherche"))
        {
            new Recherche(maconnex);
        }
        else if (e.getActionCommand().equals("Mise à jour"))
        {
            new MaJ("Mise à jour des données");
        }
        else if (e.getActionCommand().equals("Statistiques"))
        {
            new Statistiques();
        }
        else if (e.getActionCommand().equals("Quitter"))
        {
            System.exit(0); // Quitte le programme
        }
    }
}
