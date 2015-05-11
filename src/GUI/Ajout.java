/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author F
 */

@SuppressWarnings("serial")
public class Ajout extends JFrame implements ActionListener
{
    JToolBar theToolbar;
    JComboBox<String> comboBox;
    String strCode;
    String Nom;
    String Batiment;
    String Directeur;
    
    String NomEmp;
    String PrenomEmp;
    String AdresseEmp;
    String TelephoneEmp;  
    

    public Ajout()
    {
        super("Ajout de données");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Ferme la fenêtre quand on appuie sur la croix
        
        theToolbar = new JToolBar("My Toolbar");
        theToolbar.setFloatable(true);
        JLabel theLabel = new JLabel("Choisissez votre table ");
        theToolbar.add(theLabel);
        String[] items = {"Chambre", "Docteur", "Employé", "Hospitalisation", "Infirmier","Malade","Service","Soigne"};
        comboBox = new JComboBox<String>(items);
        comboBox.addActionListener(this);
        theToolbar.add(comboBox);
        this.getContentPane().add(theToolbar);
        this.pack();
        this.setVisible(true);
    }
    
    public void AjoutInfo(String Service)
    {
        JOptionPane jop = new JOptionPane();
        JOptionPane jop2 = new JOptionPane();
        strCode = jop.showInputDialog(null, "Entrer le code du service", "Code", JOptionPane.QUESTION_MESSAGE);
        Nom = jop.showInputDialog(null, "Entrer le nom du service", "Nom", JOptionPane.QUESTION_MESSAGE);
        Batiment = jop.showInputDialog(null, "Entrer le batiment", "Batiment", JOptionPane.QUESTION_MESSAGE);
        Directeur = jop.showInputDialog(null, "Entrer le directeur du service", "Directeur", JOptionPane.QUESTION_MESSAGE);
        
// Si non vide ni "annuler"
        if (((strCode!=null) && (!strCode.isEmpty())) &&((Nom!=null) && (!Nom.isEmpty())) && ((Batiment!=null)&&(!Batiment.isEmpty())) && ((Directeur!=null)&&(!Directeur.isEmpty())))
        {
            jop2.showMessageDialog(null, "Le code est: " + strCode + "\nLa nom est: " + Nom + "\nLe batiment est: "+Batiment+  "\nLe directeur est: "+ Directeur, "Ajout", JOptionPane.INFORMATION_MESSAGE);
            // AddToBase(Service,Code,Nom,Batiment,Directeur);
            System.out.println(Service);
        }
            
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(comboBox))
        {
            switch ((String)comboBox.getSelectedItem())
                    {
                case "Chambre" :
                    AjoutChambre();
                    break;
                case "Docteur" :
                    AjoutDocteur();
                    break;
                case "Employé" :
                    AjoutEmploye();
                    break;
                case "Hospitalisation" :
                    AjoutHospitalisation();
                    break;
                case "Infirmier" :
                    AjoutInfirmier();
                    break;
                case "Malade" :
                    AjoutMalade();
                    break;
                case "Service" :
                    AjoutService();
                    break;
                case "Soigne" :
                    AjoutSoigne();
                    break;
            }
            System.out.println(comboBox.getSelectedItem());
            this.dispose();
            //AjoutInfo((String)comboBox.getSelectedItem());
        }
    }

    public void AjoutChambre() 
    {
        int test=0;
        String Code_Service;
        String strNumSurv;
        String strNbLits;
        String strNumChambre;
        int NumSurv;
        int NbLits;
        int NumChambre;
        
        JOptionPane jop = new JOptionPane();
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code de la chambre", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        strNumChambre = jop.showInputDialog(null, "Entrer le nombre de lits", "Nombre de lits", JOptionPane.QUESTION_MESSAGE);

        if ((strNumChambre!=null) && (!strNumChambre.isEmpty())) {
            try {
                NumChambre = Integer.parseInt(strNumChambre);
                test=2;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==2) {
        strNumSurv = jop.showInputDialog(null, "Entrer le numéro du surveillant", "Numéro du surveillant", JOptionPane.QUESTION_MESSAGE);

        if ((strNumSurv!=null) && (!strNumSurv.isEmpty())) {
            try {
                NumSurv = Integer.parseInt(strNumSurv);
                test=3;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
                
        while (test==3) {
        strNbLits = jop.showInputDialog(null, "Entrer le nombre de lits", "Nombre de lits", JOptionPane.QUESTION_MESSAGE);

        if ((strNbLits!=null) && (!strNbLits.isEmpty())) {
            try {
                NbLits = Integer.parseInt(strNbLits);
                test=4;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        // AddChambreToBase(Code_Service,NumChambre,NumSurv,NbLits);

    }
    
    public void AjoutDocteur() 
    {
        int test=0;
        String Specialite;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Specialite = jop.showInputDialog(null, "Entrer la spécialité du docteur", "Spécialité", JOptionPane.QUESTION_MESSAGE);
        if ((Specialite!=null) && (!Specialite.isEmpty())) test=1;
        }
        
        AjoutEmploye();

        // AddDocteurToBase(Specialite,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
    }
    
    public void AjoutEmploye() 
    {
        int test=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        NomEmp = jop.showInputDialog(null, "Entrer son nom", "Nom", JOptionPane.QUESTION_MESSAGE);
        if ((NomEmp!=null) && (!NomEmp.isEmpty())) test=1;
        }
        
        while (test==1) {
        PrenomEmp = jop.showInputDialog(null, "Entrer son prénom", "Prénom", JOptionPane.QUESTION_MESSAGE);
        if ((PrenomEmp!=null) && (!PrenomEmp.isEmpty())) test=2;
        }
                
        while (test==2) {
        AdresseEmp = jop.showInputDialog(null, "Entrer son adresse", "Adresse", JOptionPane.QUESTION_MESSAGE);
        if ((AdresseEmp!=null) && (!AdresseEmp.isEmpty())) test=3;
        }
        
        while (test==3) {
        TelephoneEmp = jop.showInputDialog(null, "Entrer son téléphone", "Téléphone", JOptionPane.QUESTION_MESSAGE);
        if ((TelephoneEmp!=null) && (!TelephoneEmp.isEmpty())) test=4;
        }
        

        // AddEmployeToBase(Num,Nom,Prenom,Adresse,Telephone);
    }
        
    public void AjoutHospitalisation() 
    {
        int test=0;
        String Code_Service;
        String strNumChambre;
        String strNumMalade;
        String strNumLit;
        int NumChambre;
        int NumMalade;
        int NumLit;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code du service", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        strNumMalade = jop.showInputDialog(null, "Entrer le numéro du malade", "Numéro du malade", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMalade!=null) && (!strNumMalade.isEmpty())) {
            try {
                NumMalade = Integer.parseInt(strNumMalade);
                test=2;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==2) {
        strNumChambre = jop.showInputDialog(null, "Entrer le numéro de sa chambre", "Numéro de sa chambre", JOptionPane.QUESTION_MESSAGE);

        if ((strNumChambre!=null) && (!strNumChambre.isEmpty())) {
            try {
                NumChambre = Integer.parseInt(strNumChambre);
                test=3;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
                
        while (test==3) {
        strNumLit = jop.showInputDialog(null, "Entrer le numéro de son lit", "Numéro de son lit", JOptionPane.QUESTION_MESSAGE);

        if ((strNumLit!=null) && (!strNumLit.isEmpty())) {
            try {
                NumLit = Integer.parseInt(strNumLit);
                test=4;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        // AddHospitalisationToBase(NumMalade,Code_Service,NumChambre,NumLit);
    }

    public void AjoutInfirmier() 
    {
        int test=0;
        String Code_Service;
        String Rotation;
        String strSalaire;
        float Salaire;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code de son service", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        Rotation = jop.showInputDialog(null, "Entrer sa rotation (jour ou nuit)", "Rotation", JOptionPane.QUESTION_MESSAGE);
        if ((Rotation=="jour") || (Rotation=="nuit")) test=2;
        }
                
        while (test==2) {
        strSalaire = jop.showInputDialog(null, "Entrer son salaire", "Salaire", JOptionPane.QUESTION_MESSAGE);

        if ((strSalaire!=null) && (!strSalaire.isEmpty())) {
            try {
                Salaire = Float.parseFloat(strSalaire);
                test=4;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        AjoutEmploye();
        
        // AddInfirmierToBase(Code_Service,Rotation,Salaire,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
    }
        
    public void AjoutMalade() 
    {
        int test=0;
        String Nom;
        String Prenom;
        String Adresse;
        String Telephone;
        String Mutuelle;

        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Nom = jop.showInputDialog(null, "Entrer son nom", "Nom", JOptionPane.QUESTION_MESSAGE);
        if ((Nom!=null) && (!Nom.isEmpty())) test=1;
        }
        
        while (test==1) {
        Prenom = jop.showInputDialog(null, "Entrer son prénom", "Prenom", JOptionPane.QUESTION_MESSAGE);
        if ((Prenom!=null) && (!Prenom.isEmpty())) test=2;
        }
                
        while (test==2) {
        Adresse = jop.showInputDialog(null, "Entrer le code de la chambre", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Adresse!=null) && (!Adresse.isEmpty())) test=3;
        }
                        
        while (test==3) {
        Telephone = jop.showInputDialog(null, "Entrer son adresse", "Adresse", JOptionPane.QUESTION_MESSAGE);
        if ((Telephone!=null) && (!Telephone.isEmpty())) test=4;
        }
                                
        while (test==4) {
        Mutuelle = jop.showInputDialog(null, "Entrer le nom de sa mutuelle", "Mutuelle", JOptionPane.QUESTION_MESSAGE);
        if ((Mutuelle!=null) && (!Mutuelle.isEmpty())) test=5;
        }
        
        // AddMaladeToBase(Num,Nom,Prenom,Adresse,Telephone,Mutuelle);
    }
    
    public void AjoutService() 
    {
        int test=0;
        String Code;
        String Nom;
        char Batiment;
        String strBatiment;
        String strNumDirecteur;
        int NumDirecteur;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Code = jop.showInputDialog(null, "Entrer le code du service", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code!=null) && (!Code.isEmpty())) test=1;
        }
        
        while (test==1) {
        Nom = jop.showInputDialog(null, "Entrer nom du service", "Nom", JOptionPane.QUESTION_MESSAGE);
        if ((Nom!=null) && (!Nom.isEmpty())) test=2;
        }
                
        while (test==2) {
        strNumDirecteur = jop.showInputDialog(null, "Entrer nom de son directeur", "Directeur", JOptionPane.QUESTION_MESSAGE);

        if ((strNumDirecteur!=null) && (!strNumDirecteur.isEmpty())) {
            try {
                NumDirecteur = Integer.parseInt(strNumDirecteur);
                test=3;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==3) {
        strBatiment = jop.showInputDialog(null, "Entrer nom du batiment", "Batiment", JOptionPane.QUESTION_MESSAGE);

        if ((strBatiment!=null) && (!strBatiment.isEmpty()) && (strBatiment.length()==1)) {

                Batiment = strBatiment.charAt(0);
                test=4;
            }
        }// Fin du while
        
        // AddServiceToBase(Code,Nom,Batiment,NumDirecteur);
    } 
             
    public void AjoutSoigne() 
    {
        int test=0;
        String strNumDocteur;
        String strNumMalade;
        int NumDocteur;
        int NumMalade;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        strNumDocteur = jop.showInputDialog(null, "Entrer le numéro du docteur", "Numéro du docteur", JOptionPane.QUESTION_MESSAGE);

        if ((strNumDocteur!=null) && (!strNumDocteur.isEmpty())) {
            try {
                NumDocteur = Integer.parseInt(strNumDocteur);
                test=1;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==1) {
        strNumMalade = jop.showInputDialog(null, "Entrer le numéro du malade", "Numéro du malade", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMalade!=null) && (!strNumMalade.isEmpty())) {
            try {
                NumMalade = Integer.parseInt(strNumMalade);
                test=2;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
             
        
        //AddSoigneToBase(NumDocteur,NumMalade);
    }
}
