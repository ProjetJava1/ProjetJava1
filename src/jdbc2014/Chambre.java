/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2014;

/**
 *
 * @author Arnaud
 */
public class Chambre {
    
    private String Code_service = "";
    private int No_chambre = 0;
    private int Surveillant = 0;
    private int Nb_lits =0;
    
    public Chambre(String code_service,int no_chambre,int surveillant,int nb_lits) {
    this.Code_service = Code_service;
    this.No_chambre = No_chambre;
    this.Surveillant = Surveillant;
    this.Nb_lits = Nb_lits;    
}
    
    public Chambre(){};
     
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

  public int getSurveillant() {
    return Surveillant;
  }

  public void setSurveillant(int Surveillant) {
    this.Surveillant = Surveillant;
  }   
  
  public int getNb_lits() {
    return Nb_lits;
  }

  public void setNb_lits(int Nb_lits) {
    this.Nb_lits = Nb_lits;
  }   
}