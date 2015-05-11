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
public class GUI2 extends JFrame implements ActionListener
{

    String Login;
    JPasswordField mdpBase;
    String password2;
    String ServeurECE;
    String password1;
    
    public GUI2(String Srv, String pwd1)
    {
        ServeurECE=Srv;
        password1=pwd1;
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
            System.out.println("Password Base is " + password2);
            this.dispose();
           
            //new OuvertureBase(ServeurECE,password1, Login,password2);
            
        }
    }


}
