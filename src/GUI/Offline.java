package GUI;

/**
 *
 * @author F
 */
import Connexion.Connexion;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Offline extends JFrame implements ActionListener
{
    String Login;
    JPasswordField mdpBase;
    String password2;
    String password1;
    
    public Offline()
    {
        JOptionPane jop = new JOptionPane();

        Login = jop.showInputDialog(null, "Entrer le login de la base", "Login", JOptionPane.QUESTION_MESSAGE);
        // Si non vide ni "annuler"
        if ((Login!=null)&&(!Login.isEmpty()))
        {          
            JPanel panel2 = new JPanel();
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
            panel2.setBorder(new TitledBorder("Entrer votre mot de passe"));
            
            mdpBase = new JPasswordField(20);
            mdpBase.addActionListener(this);

            panel2.add(mdpBase);
            this.getContentPane().add(panel2);

            this.pack();
            this.setVisible(true);
        }
        else System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(mdpBase))
        {
            char[] thePassword2 = mdpBase.getPassword();
            password2 = new String(thePassword2);
            this.dispose();
            
            try
            {
                try
                {
                    // tentative de connexion si les 4 attributs sont remplis
                    new Connexion(Login, password2);
                }
                catch (ClassNotFoundException cnfe)
                {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            }
            catch (SQLException f)
            {
                System.out.println("Connexion echouee : probleme SQL");
                f.printStackTrace();
            }
            
            new Menu();
         }
    }
}
