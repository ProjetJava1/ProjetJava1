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
 * @author user
 */
public class DocteurDAO extends DAO<Chambre>{
    @Override
    public Chambre create(Chambre obj) {
		try {
			 
			//la prochaine valeur de la séquence correspondant à l'id de notre table
			ResultSet result = this	.connect
                                    .createStatement(
                                    		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                    		"SELECT NEXTVAL('id_chambre') as id"
                                    );
			if(result.first()){
				int id = result.getInt("id");
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO chambre (id_chambre, code_service, no_chambre, surveillants, nb_lits ) VALUES(?, ?, ?, ?)"
                                                    );
                                prepare.setInt(1, obj.getNo_chambre());
				prepare.setString(2, obj.getCode_service());
				prepare.setInt(3, obj.getNo_chambre());
                                prepare.setInt(4, obj.getSurveillant());
                                prepare.setInt(5, obj.getNb_lits());
                                
                                
				
				prepare.executeUpdate();
				obj = this.find(id);	
				
			}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Chambre find(int id) {
		Chambre ch = new Chambre();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM chambre WHERE no_chambre = " + id
                                             );
            if(result.first())
            		ch = new Chambre(
                                        result.getString("code_service"),
                                        result.getInt("no_chambre"), 
                                        result.getInt("surveillant"),
                                        result.getInt("nb_lits")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return ch;

	}
	
	
    @Override
	public Chambre update(Chambre obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE chambre SET code_service = '" + obj.getCode_service() + "',"+
                        " surveillant = '" +obj.getSurveillant() + "',"+
                        " nb_lits ='" +obj.getNb_lits() + "'"+
                    	" WHERE lan_id = " + obj.getNo_chambre()
                     );
			
			obj = this.find(obj.getNo_chambre());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return obj;
	}


    @Override
	public void delete(Chambre obj) {
		try {
			
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM langage WHERE lan_id = " + obj.getNo_chambre()
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
}
