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
public class MaladeDAO extends DAO<Malade>{
    @Override
    public Malade create(Malade obj) {
		try {
			 
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO malade (nom, prenom, adresse, tel, mutuelle ) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setString(1, obj.getNom());
				prepare.setString(2, obj.getPrénom());
                                prepare.setString(3, obj.getAdresse());
                                prepare.setString(4, obj.getTel());
                                prepare.setString(5, obj.getMutuelle());
                                
				
				prepare.executeUpdate();
				obj = this.find(obj.getNumero());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Malade find(int id) {
		Malade mal = new Malade();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM employe WHERE numero = " + id
                                             );
            if(result.first())
            		mal = new Malade(
                                        id,
                                        result.getString("nom"),
                                        result.getString("prenom"),
                                        result.getString("adresse"),
                                        result.getString("tel"),
                                        result.getString("mutuelle")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return mal;

	}
	
	
    @Override
	public Malade update(Malade obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE malade SET nom = '" + obj.getNom() + "',"+
                        " prenom = '" +obj.getPrénom() + "',"+
                        " adresse = '" +obj.getAdresse() + "',"+
                        " tel ='" +obj.getTel() + "'"+
                        " mutuelle ='" +obj.getTel() + "'"+
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
                             "DELETE FROM malade WHERE Numero = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
    
    
}
