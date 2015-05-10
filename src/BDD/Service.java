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
    private int Id_service =0;
    private String Code_service = "";
    private String Nom = "";
    private String Batiment = "";
    private int Directeur =0;
    
    public Service(int Id_service, String Code_service,String Nom,String Batiment,int Directeur) {
    this.Id_service = Id_service;
    this.Code_service = Code_service;
    this.Nom = Nom;
    this.Batiment = Batiment;
    this.Directeur = Directeur;    
}
    
    public Service(){};
     
    public int getId_service() {
    return Id_service;
    }

    public void setId_service(int Id_service) {
    this.Id_service = Id_service;
    }   
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

  public String getBatiment() {
    return Batiment;
  }

  public void setBatiment(String Batiment) {
    this.Batiment = Batiment;
  }   
  
  public int getDirecteur() {
    return Directeur;
  }

  public void setDirecteur(int Directeur) {
    this.Directeur = Directeur;
  }   
    
}
