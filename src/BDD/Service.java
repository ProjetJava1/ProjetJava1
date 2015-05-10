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
public class Service {
    
    private String Code_service = "";
    private String Nom = "";
    private char Batiment = 0;
    private int Directeur =0;
    
    public Service(String Code_service,String Nom,char Batiment,int Directeur) {
    this.Code_service = Code_service;
    this.Nom = Nom;
    this.Batiment = Batiment;
    this.Directeur = Directeur;    
}
    
    public Service(){};
     
    public String getCode_service() {
    return Code_service;
    }

    public void setCode_service(String Code_service) {
    this.Code_service = Code_service;
    }

    public String getNom() {
    return Nom;
    }

  public void setNom(String Nom) {
    this.Nom = Nom;
  }

  public char getBatiment() {
    return Batiment;
  }

  public void setBatiment(char Batiment) {
    this.Batiment = Batiment;
  }   
  
  public int getDirecteur() {
    return Directeur;
  }

  public void setDirecteur(int Directeur) {
    this.Directeur = Directeur;
  }   
    
}
