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
public class SoigneDAO extends DAO<Soigne>{
    @Override
    public Soigne create(Soigne obj) {
		try {
			 
			
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO soigne ( no_docteur, no_malade) VALUES(?, ?)"
                                                    );
				prepare.setInt(1, obj.getNo_docteur());
				prepare.setInt(2, obj.getNo_malade());                                
				
				prepare.executeUpdate();
				obj = this.find(obj.getId_soigne());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Soigne find(int id) {
		Soigne soi = new Soigne();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM soigne WHERE id_soigne = " + id
                                             );
            if(result.first())
            		soi = new Soigne(
                                        result.getInt("no_docteur"),
                                        result.getInt("no_malade")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return soi;

	}
	
	
    @Override
	public Soigne update(Soigne obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE soigne SET no_docteur = '" + obj.getNo_docteur() + "',"+
                        " no_malade = '" +obj.getNo_malade() + "'"+
                    	" WHERE id_soigne = " + obj.getId_soigne()                   );
			
			obj = this.find(obj.getId_soigne());
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
                             "DELETE FROM soigne WHERE id_soigne = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
    
}