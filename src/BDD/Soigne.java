/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

/**
 *
 * @author Arnaud
 */
public class Soigne {
    private int Id_soigne =0;
    private int No_docteur = 0;
    private int No_malade = 0;
    
    public Soigne( int No_docteur, int No_malade) {
    this.No_docteur = No_docteur;
    this.No_malade = No_malade;
    }
    
    public Soigne(){};
     
    public int getId_soigne() {
    return Id_soigne;
    }
    public void setId_soigne(int Id_soigne) {
    this.Id_soigne = Id_soigne;
    }
    public int getNo_docteur() {
    return No_docteur;
    }
    public void setNo_docteur(int No_docteur) {
    this.No_docteur = No_docteur;
    }
    
    public int getNo_malade() {
    return No_malade;
    }
    public void setNo_malade(int No_malade) {
    this.No_malade = No_malade;
    }

}
