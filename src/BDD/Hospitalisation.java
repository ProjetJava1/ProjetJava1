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
public class Hospitalisation {
    private int Id_hospitalisation =0;
    private int No_malade = 0;
    private String Code_service = "";
    private int No_chambre = 0;
    private int Lit =0;
    
    public Hospitalisation(int No_malade,String Code_service,int No_chambre,int Lit) {
    this.No_malade = No_malade;
    this.Code_service = Code_service;
    this.No_chambre = No_chambre;
    this.Lit = Lit;    
}
    public Hospitalisation(int Id_hospitalisation, int No_malade,String Code_service,int No_chambre,int Lit) {
    this.Id_hospitalisation=Id_hospitalisation;
    this.No_malade = No_malade;
    this.Code_service = Code_service;
    this.No_chambre = No_chambre;
    this.Lit = Lit;    
}
    
    public Hospitalisation(){};
     
   public int getId_hospitalisation() {
    return Id_hospitalisation;
  }

  public void setId_hospitalisation(int Id_hospitalisation) {
    this.Id_hospitalisation = Id_hospitalisation;
  }
  
  public int getNo_malade() {
    return No_malade;
  }

  public void setNo_malade(int No_malade) {
    this.No_malade = No_malade;
  }

  public String getCode_service() {
    return Code_service;
  }

  public void setCode_service(String Code_service) {
    this.Code_service = Code_service;
  }

  public int getNo_chambre() {
    return No_chambre;
  }

  public void setNo_chambre(int No_chambre) {
    this.No_chambre = No_chambre;
  }   
  
  public int getLit() {
    return Lit;
  }

  public void setLit(int Lit) {
    this.Lit = Lit;
  }   
}
