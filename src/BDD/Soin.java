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
public class Soin {
    
    private int No_docteur = 0;
    private int No_malade = 0;
    
    public Soin(int No_docteur, int No_malade) {
    this.No_docteur = No_docteur;
    this.No_malade = No_malade;
    }
    
    public Soin(){};
     
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
