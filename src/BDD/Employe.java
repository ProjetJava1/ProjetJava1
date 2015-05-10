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
public class Employe {
    private int Numero = 0;
    private String Nom = "";
    private String Prénom = "";
    private String Adresse = "";
    private String Tel = "";
    
    
    public Employe (int Numero, String Nom, String Prénom, String Adresse, String Tel) {
    this.Numero = Numero;
    this.Nom = Nom;
    this.Prénom = Prénom;
    this.Tel = Tel;
    this.Tel = Tel;
}
    
    public Employe(){};
     
  public int getNumero() {
    return Numero;
  }

  public void setNumero(int Numero) {
    this.Numero = Numero;
  }

  public String getNom() {
    return Nom;
  }

  public void setNom(String Nom) {
    this.Nom = Nom;
  }

  public String getPrénom() {
    return Prénom;
  }

  public void setPrénom(String Prénom) {
    this.Prénom = Prénom;
  }   
  
  public String getAdresse() {
    return Adresse;
  }

  public void setAdresse(String Adresse) {
    this.Adresse = Adresse;
  }   
    
  public String getTel() {
    return Tel;
  }

  public void setTel(String Tel) {
    this.Tel = Tel;
  }   
}
