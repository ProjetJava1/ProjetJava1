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
import javax.swing.*;


@SuppressWarnings("serial")
public class Requete extends JFrame
{
    String NomDoc;
    
    public Requete()
    {
        JOptionPane jop = new JOptionPane();
        String requete_test;

        NomDoc = jop.showInputDialog(null, "Entrer le nom du docteur", "Docteur", JOptionPane.QUESTION_MESSAGE);
        requete_test="SELECT m.nom, m.prenom FROM employe e1, docteur d1, malade m, soigne WHERE d1.numero=e1.numero AND d1.numero= no_docteur AND m.numero=no_malade AND e1.nom="+"'"+NomDoc+"'";

    }



}
