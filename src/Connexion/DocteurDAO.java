/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import BDD.*;
import java.sql.*;
import GUI.Ajout;
import javax.swing.JOptionPane;
/**
 *
 * @author Arnaud
 */
public class DocteurDAO extends DAO<Docteur>{
    @Override
    public Docteur create(Docteur obj) {
		try {
                    int id=0;
                        Ajout aj= new Ajout();
                        Employe emp = aj.AjoutEmploye();
                        
                        try{
                            ResultSet resultat=this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM employe WHERE prenom = '"+emp.getPrénom()+"'AND nom='"+emp.getNom()+"'"
                                             );
                        if(resultat.first())
                            
                                        id=resultat.getInt("numero");
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
                        
                        //System.out.println(id);
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO docteur (numero, specialite) VALUES(?,?)"
                                                    );  
                                prepare.setInt(1, id);
				prepare.setString(2, obj.getSpécialité());
                                
				prepare.executeUpdate();
				obj = this.find(obj.getNumero());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Docteur find(int id) {
		Docteur doc = new Docteur();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM docteur WHERE numero = " + id
                                             );
            if(result.first())
            		doc = new Docteur(
                                        result.getString("specialite")                              
                                        );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return doc;

	}
	
	
    @Override
	public Docteur update(Docteur obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE docteur SET specialite = '" + obj.getSpécialité()+ "'"+                   
                    	" WHERE numero = " + obj.getNumero()                   );
			obj = this.find(obj.getNumero());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return obj;
	}


    @Override
	public void delete(int id) {
		try {
                    ResultSet result2 = this .connect
                                .createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_UPDATABLE
                                         ).executeQuery(
                                            "SELECT * FROM soigne WHERE no_docteur = " + id
                                         );
        if(result2.first()){
                //Le message
                System.out.println("Docteur dans soigne");
                JOptionPane jop2 = new JOptionPane(); 
             jop2.showMessageDialog(null, "Suppression impossible: Le docteur soigne un malade", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM docteur WHERE numero = " + id
                        );
        this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM employe WHERE numero = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
}
