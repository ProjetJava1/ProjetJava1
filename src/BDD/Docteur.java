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
public class Docteur {
    
    private int Numero = 0;
    private String Spécialité = "";
    
    public Docteur(int Numero, String Spécialité) {
    this.Numero = Numero;
    this.Spécialité = Spécialité;
    }
    
    public Docteur(){};
     
    public int getNumero() {
    return Numero;
    }
    public void setNumero(int Numero) {
    this.Numero = Numero;
    }
    
    public String getSpécialité() {
    return Spécialité;
    }
    public void setSpécialité(String Spécialité) {
    this.Spécialité = Spécialité;
    }


}
