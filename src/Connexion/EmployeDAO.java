/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import BDD.*;
import java.sql.*;
/**
 *
 * @author Arnaud
 */
public class EmployeDAO extends DAO<Employe>{
    @Override
    public Employe create(Employe obj) {
		try {
			 
			
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO employe ( nom, prenom, adresse, tel ) VALUES( ?, ?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getNom());
				prepare.setString(2, obj.getPrénom());
                                prepare.setString(3, obj.getAdresse());
                                prepare.setString(4, obj.getTel());
                                
				
				prepare.executeUpdate();
				obj = this.find(obj.getNumero());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Employe find(int id) {
		Employe emp = new Employe();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM employe WHERE numero = " + id
                                             );
            if(result.first())
            		emp = new Employe(
                                        id,
                                        result.getString("nom"),
                                        result.getString("prenom"),
                                        result.getString("adresse"),
                                        result.getString("tel")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return emp;

	}
	
	
    @Override
	public Employe update(Employe obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE employe SET nom = '" + obj.getNom() + "',"+
                        " prenom = '" +obj.getPrénom() + "',"+
                        " adresse = '" +obj.getAdresse() + "',"+
                        " tel ='" +obj.getTel() + "'"+
                    	" WHERE Numero = " + obj.getNumero()                   );
			
			obj = this.find(obj.getNumero());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return obj;
	}


    @Override
	public void delete(int id) {
		try {
			
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM employe WHERE Numero = " + id
                             
                        );
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM infirmier WHERE Numero = " + id
                             
                        );
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM docteur WHERE Numero = " + id
                             
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
    
}