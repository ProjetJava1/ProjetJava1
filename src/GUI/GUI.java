package GUI;

/**
 *
 * @author F
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
    String ServeurECE;
    JPasswordField mdpECE;
    String password1;
    
    public GUI()
    {
        JOptionPane jop = new JOptionPane();

        ServeurECE = jop.showInputDialog(null, "Entrer le nom du serveur", "Serveur", JOptionPane.QUESTION_MESSAGE);
        
        if ((ServeurECE!=null) && (!ServeurECE.isEmpty()))
        {           
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            panel1.setBorder(new TitledBorder("Entrer votre mot de passe ECE"));
            
            mdpECE = new JPasswordField(20);
            mdpECE.addActionListener(this);

            panel1.add(mdpECE);
            this.getContentPane().add(panel1);

            this.pack();
            this.setVisible(true);
        }
        else System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(mdpECE))
        {
            char[] thePassword1 = mdpECE.getPassword();
            String password1 = new String(thePassword1);
            this.dispose();
            new GUI2(ServeurECE,password1);
        }
    }

    public static void main (String argv[])
    {
        new OnOff();
    }

}
