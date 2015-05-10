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
public class chambre {
    
    private String code_service = "";
    private int no_chambre = 0;
    private int surveillant = 0;
    private int nb_lits =0;
    
    public chambre(String code_service,int no_chambre,int surveillant,int nb_lits) {
    this.code_service = code_service;
    this.no_chambre = no_chambre;
    this.surveillant = surveillant;
    this.nb_lits = nb_lits;    
}
    
    public chambre(){};
     
  public String getcode_service() {
    return code_service;
  }

  public void setcode_service(String code_service) {
    this.code_service = code_service;
  }

  public int getno_chambre() {
    return no_chambre;
  }

  public void setno_chambre(int no_chambre) {
    this.no_chambre = no_chambre;
  }

  public int getsurveillant() {
    return surveillant;
  }

  public void setsurveillant(int surveillant) {
    this.surveillant = surveillant;
  }   
  
  public int getnb_lits() {
    return nb_lits;
  }

  public void setnb_lits(int nb_lits) {
    this.nb_lits = nb_lits;
  }   
}
