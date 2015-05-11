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
public class Modifier extends JFrame implements ActionListener
{
    JToolBar theToolbar;
    JComboBox<String> comboBox;

    
    String NomEmp;
    String PrenomEmp;
    String AdresseEmp;
    String TelephoneEmp;  
        

    public Modifier()
    {
        super("Modification de données");
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
            switch ((String)comboBox.getSelectedItem())
                    {
                case "Chambre" :
                    ModifChambre();
                    break;
                case "Docteur" :
                    ModifDocteur();
                    break;
                case "Hospitalisation" :
                    ModifHospitalisation();
                    break;
                case "Infirmier" :
                    ModifInfirmier();
                    break;
                case "Malade" :
                    ModifMalade();
                    break;
                case "Service" :
                    ModifService();
                    break;
                case "Soigne" :
                    ModifSoigne();
                    break;
            }
            System.out.println(comboBox.getSelectedItem());
            this.dispose();
            //AjoutInfo((String)comboBox.getSelectedItem());
        }
    }

    public void ModifChambre() 
    {
        int test=-1;
        String Code_Service="";
        String strNumSurv;
        String strNbLits;
        String strNumChambre;
        int NumSurv=0;
        int NbLits=0;
        int NumChambre=0;
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();

        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==0) {
        Code_Service = jop.showInputDialog(null, "Entrer le code de la chambre", "Code", JOptionPane.QUESTION_MESSAGE);
        if ((Code_Service!=null) && (!Code_Service.isEmpty())) test=1;
        }
        
        while (test==1) {
        strNumChambre = jop.showInputDialog(null, "Entrer le numero de chambre", "Numero de chambre", JOptionPane.QUESTION_MESSAGE);

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
        
        Chambre ch=new Chambre(NumMod,Code_Service,NumChambre,NumSurv,NbLits);
        DAO<Chambre> chambreDAO = new ChambreDAO();
        chambreDAO.update(ch);
        // ModifChambreToBase(NumMod,Code_Service,NumChambre,NumSurv,NbLits);

    }
    
    public void ModifDocteur() 
    {
        int test=-1;
        String Specialite="";
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
        while (test==0) {
        Specialite = jop.showInputDialog(null, "Entrer la spécialité du docteur", "Spécialité", JOptionPane.QUESTION_MESSAGE);
        if ((Specialite!=null) && (!Specialite.isEmpty())) test=1;
        }
        
        ModifEmploye();

        // ModifDocteurToBase(NumMod,Specialite,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
        Employe emp=new Employe(NumMod,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
        DAO<Employe> employeDAO = new EmployeDAO();
        employeDAO.update(emp);
        Docteur dr=new Docteur(NumMod,Specialite);
        DAO<Docteur> docteurDAO = new DocteurDAO();
        docteurDAO.update(dr);
    }
    
    public void ModifEmploye() 
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

    }
        
    public void ModifHospitalisation() 
    {
        int test=-1;
        String Code_Service="";
        String strNumChambre;
        String strNumMalade;
        String strNumLit;
        int NumChambre=0;
        int NumMalade=0;
        int NumLit=0;
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer le numéro à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
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
        
        // ModifHospitalisationToBase(NumMod,NumMalade,Code_Service,NumChambre,NumLit);
        Hospitalisation hos=new Hospitalisation(NumMod,NumMalade,Code_Service,NumChambre,NumLit);
        DAO<Hospitalisation> hospitalisationDAO = new HospitalisationDAO();
        hospitalisationDAO.update(hos);
    }

    public void ModifInfirmier() 
    {
        int test=-1;
        String Code_Service="";
        String Rotation="";
        String strSalaire;
        float Salaire=0;
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
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
        
        ModifEmploye();
        Employe emp=new Employe(NumMod,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
        DAO<Employe> employeDAO = new EmployeDAO();
        employeDAO.update(emp);
        Infirmier inf=new Infirmier(NumMod,Code_Service,Rotation,Salaire);
        DAO<Infirmier> infirmierDAO = new InfirmierDAO();
        infirmierDAO.update(inf);
        
        // ModifInfirmierToBase(NumMod,Code_Service,Rotation,Salaire,NomEmp,PrenomEmp,AdresseEmp,TelephoneEmp);
    }
        
    public void ModifMalade() 
    {
        int test=-1;
        String Nom=null;
        String Prenom=null;
        String Adresse=null;
        String Telephone=null;
        String Mutuelle=null;
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
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
        // ModMaladeToBase(NumMod,Nom,Prenom,Adresse,Telephone,Mutuelle);
        Malade mal=new Malade(NumMod,Nom,Prenom,Adresse,Telephone,Mutuelle);
        DAO<Malade> maladeDAO = new MaladeDAO();
        maladeDAO.update(mal);
    }
    
    public void ModifService() 
    {
        int test=-1;
        String Code=null;
        String Nom=null;
        String strBatiment=null;
        String strNumDirecteur=null;
        int NumDirecteur=0;
        String strNumMod;
        int NumMod;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
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
                test=4;
            }
        }// Fin du while
        
        // AddServiceToBase(Code,Nom,Batiment,NumDirecteur);
        Service ser=new Service(Code,Nom,strBatiment,NumDirecteur);
        DAO<Service> serviceDAO = new ServiceDAO();
        serviceDAO.update(ser);
    } 
             
    public void ModifSoigne() 
    {
        int test=-1;
        String strNumDocteur;
        String strNumMalade;
        int NumDocteur=0;
        int NumMalade=0;
        String strNumMod;
        int NumMod=0;
        
        JOptionPane jop = new JOptionPane();
        
        while (test==-1) {
        strNumMod = jop.showInputDialog(null, "Entrer l'identifiant à modifier", "Numéro", JOptionPane.QUESTION_MESSAGE);

        if ((strNumMod!=null) && (!strNumMod.isEmpty())) {
            try {
                NumMod = Integer.parseInt(strNumMod);
                test=0;
            }
            catch (NumberFormatException e){ 
                System.out.println("Erreur : Veuillez entrer un nombre uniquement");
            }
        }
        } // Fin du while
        
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
        Soigne soi=new Soigne(NumMod, NumDocteur, NumMalade);
        DAO<Soigne> soigneDAO = new SoigneDAO();
        soigneDAO.update(soi);
    }
}
