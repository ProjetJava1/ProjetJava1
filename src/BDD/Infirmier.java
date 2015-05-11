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
public class Infirmier {
    
    private int Numero = 0;
    private String Code_service = "";
    private String Rotation = "";
    private float Salaire = 0;
    
    public Infirmier(String Code_service,String Rotation,float Salaire) {
    this.Code_service = Code_service;
    this.Rotation = Rotation;
    this.Salaire = Salaire;    
}
    public Infirmier(int Numero, String Code_service,String Rotation,float Salaire) {
    this.Numero=Numero;
    this.Code_service = Code_service;
    this.Rotation = Rotation;
    this.Salaire = Salaire;    
}
    
    public Infirmier(){};
     
  public int getNumero() {
    return Numero;
  }

  public void setNumero(int Numero) {
    this.Numero = Numero;
  }

  public String getCode_service() {
    return Code_service;
  }

  public void setCode_service(String Code_service) {
    this.Code_service = Code_service;
  }

  public String getRotation() {
    return Rotation;
  }

  public void setRotation(String Rotation) {
    this.Rotation = Rotation;
  }   
  
  public float getSalaire() {
    return Salaire;
  }

  public void setSalaire(float Salaire) {
    this.Salaire = Salaire;
  }   
    
}
