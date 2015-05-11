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
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
    String ServeurECE;
    JPasswordField mdpECE;
    String Login;
    JPasswordField mdpBase;

    public GUI(int on_off)
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
        if (e.getSource().equals(mdpECE))
        {
            char[] thePassword1 = mdpECE.getPassword();
            String password1 = new String(thePassword1);
            System.out.println("Password ECE is " + password1);
            this.dispose();
            // TestOpenBaseECE(ServeurECE,password1);
            //new Menu(Serveur,Base,Login);
        }
        else if (e.getSource().equals(mdpBase))
        {
            char[] thePassword2 = mdpBase.getPassword();
            String password2 = new String(thePassword2);
            System.out.println("Password Base is " + password2);
            this.dispose();
            new Menu(ServeurECE,password2, Login);
            // TestOpenBase(ServeurECE,password2);
        }
    }

    public static void main (String argv[])
    {
        //new Menu("a","b","c");
        new ChoixSuppression();
        //new Menu("Menu");
        //new SwingApp("Page de connexion");
    }

}
