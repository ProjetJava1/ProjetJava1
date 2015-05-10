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
public class ChambreDAO extends DAO<Chambre>{
    @Override
    public Chambre create(Chambre obj) {
		try {
			 
			//la prochaine valeur de la séquence correspondant à l'id de notre table
			/*ResultSet result = this	.connect
                                    .createStatement(
                                    		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                    		"SELECT NEXTVAL('id_chambre') as id"
                                    );
			if(result.first()){
				int id = result.getInt("id");*/
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO chambre (code_service, no_chambre, surveillant, nb_lits ) VALUES( ?, ?, ?, ?)"
                                                    );                          
				prepare.setString(2, obj.getCode_service());
				prepare.setInt(3, obj.getNo_chambre());
                                prepare.setInt(4, obj.getSurveillant());
                                prepare.setInt(5, obj.getNb_lits());
                                
				
				prepare.executeUpdate();
				obj = this.find(obj.getId_chambre());	
				
			//}
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
                                                "SELECT * FROM chambre WHERE id_chambre = " + id
                                             );
            if(result.first())
            		ch = new Chambre(
                                        id,
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
                        " no_chambre = '" +obj.getNo_chambre() + "',"+
                        " surveillant = '" +obj.getSurveillant() + "',"+
                        " nb_lits ='" +obj.getNb_lits() + "'"+
                    	" WHERE id_chambre = " + obj.getId_chambre()                   );
			
			obj = this.find(obj.getId_chambre());
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
                             "DELETE FROM chambre WHERE id_chambre = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
}
