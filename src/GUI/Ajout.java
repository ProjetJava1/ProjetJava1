/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BDD.*;
import Connexion.*;
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
        String[] items = {"Chambre", "Docteur", "Hospitalisation", "Infirmier","Malade","Service","Soigne"};
        comboBox = new JComboBox<String>(items);
        comboBox.addActionListener(this);
        theToolbar.add(comboBox);
        this.getContentPane().add(theToolbar);
        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(comboBox))
        {
            this.dispose();
            switch ((String)comboBox.getSelectedItem())
                    {
                case "Chambre" :
                    AjoutChambre();
                    break;
                case "Docteur" :
                    AjoutDocteur();
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
        }
    }

    public void AjoutChambre() 
    {
        int test=0;
        String Code_Service="";
        String strNumSurv;
        String strNbLits;
        String strNumChambre;
        int NumSurv=0;
        int NbLits=0;
        int NumChambre=0;
        
        JOptionPane jop = new JOptionPane();
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code service de la chambre", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        strNumChambre = jop.showInputDialog(null, "Entrer le numero de la chambre", "Numéro de la chambre", JOptionPane.QUESTION_MESSAGE);

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
        
         //Ajout de la Chambre à la base
           DAO<Chambre> chambreDAO = new ChambreDAO();
           Chambre ch = new Chambre(Code_Service, NumChambre, NumSurv, NbLits);
           chambreDAO.create(ch);

    }
    
    public void AjoutDocteur() 
    {
        int test=0;
        String Specialite=null;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Specialite = jop.showInputDialog(null, "Entrer la spécialité du docteur", "Spécialité", JOptionPane.QUESTION_MESSAGE);
        if ((Specialite!=null) && (!Specialite.isEmpty())) test=1;
        }
        
        DAO<Docteur> docDAO = new DocteurDAO();
        Docteur doc = new Docteur(Specialite);
        docDAO.create(doc);
        this.dispose();
    }
    
    public Employe AjoutEmploye() 
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
        
        DAO<Employe> employeDAO = new EmployeDAO();
        Employe emp = new Employe(NomEmp,PrenomEmp, AdresseEmp, TelephoneEmp );
        employeDAO.create(emp);
        return emp;
    }
        
    public void AjoutHospitalisation() 
    {
        int test=0;
        String Code_Service="";
        String strNumChambre;
        String strNumMalade;
        String strNumLit;
        int NumChambre=0;
        int NumMalade=0;
        int NumLit=0;
        
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
        
        DAO<Hospitalisation> hospitalisationDAO = new HospitalisationDAO();
           Hospitalisation hos = new Hospitalisation(NumMalade, Code_Service, NumChambre, NumLit);
           hospitalisationDAO.create(hos);
    }

    public void AjoutInfirmier() 
    {
        int test=0;
        String Code_Service=null;
        String Rotation=null;
        String strSalaire=null;
        float Salaire=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code de son service", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        Rotation = jop.showInputDialog(null, "Entrer sa rotation (jour ou nuit)", "Rotation", JOptionPane.QUESTION_MESSAGE);
        if ((Rotation!=null) && (!Rotation.isEmpty())) test=2;
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
        DAO<Infirmier> infDAO = new InfirmierDAO();
        Infirmier inf = new Infirmier(Code_Service, Rotation, Salaire);
        infDAO.create(inf);
        this.dispose();
        
    }
        
    public void AjoutMalade() 
    {
        int test=0;
        String Nom=null;
        String Prenom=null;
        String Adresse=null;
        String Telephone=null;
        String Mutuelle=null;

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
        Adresse = jop.showInputDialog(null, "Entrer son adresse", "Adresse", JOptionPane.QUESTION_MESSAGE);
        if ((Adresse!=null) && (!Adresse.isEmpty())) test=4;
        }
                        
        while (test==3) {
        Telephone = jop.showInputDialog(null, "Entrer son numéro de téléphone", "Telephone", JOptionPane.QUESTION_MESSAGE);
        if ((Telephone!=null) && (!Telephone.isEmpty())) test=3;
        }
                                
        while (test==4) {
        Mutuelle = jop.showInputDialog(null, "Entrer le nom de sa mutuelle", "Mutuelle", JOptionPane.QUESTION_MESSAGE);
        if ((Mutuelle!=null) && (!Mutuelle.isEmpty())) test=5;
        }
           DAO<Malade> maladeDAO = new MaladeDAO();
           Malade mal = new Malade(Nom, Prenom, Adresse, Telephone, Mutuelle);
           maladeDAO.create(mal);
    }
    
    public void AjoutService() 
    {
        int test=0;
        String Code=null;
        String Nom=null;
        String strBatiment=null;
        String strNumDirecteur=null;
        int NumDirecteur=0;
        
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

        if ((strBatiment!=null) && (!strBatiment.isEmpty())) {
                test=4;
            }
        
        }// Fin du while
        
        DAO<Service> serviceDAO = new ServiceDAO();
           Service ser = new Service(Code, Nom, strBatiment, NumDirecteur);
           serviceDAO.create(ser);    
    } 
             
    public void AjoutSoigne() 
    {
        int test=0;
        String strNumDocteur;
        String strNumMalade;
        int NumDocteur=0;
        int NumMalade=0;
        
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
             
        
           DAO<Soigne> soigneDAO = new SoigneDAO();
           Soigne soi = new Soigne(NumDocteur, NumMalade);
           soigneDAO.create(soi);
    }
}
