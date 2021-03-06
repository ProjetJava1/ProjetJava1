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
public class ServiceDAO extends DAO<Service>{
    @Override
    public Service create(Service obj) {
		try {
			 
			//la prochaine valeur de la séquence correspondant à l'id de notre table
			/*ResultSet result = this	.connect
                                    .createStatement(
                                    		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                    		"SELECT NEXTVAL('id_service') as id"
                                    );
			if(result.first()){
				int id = result.getInt("id");*/
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO service (code, nom, batiment, directeur ) VALUES(?, ?, ?, ?)"
                                                    );                 
				prepare.setString(1, obj.getCode_service());
				prepare.setString(2, obj.getNom());
                                prepare.setString(3, obj.getBatiment());
                                prepare.setInt(4, obj.getDirecteur());
                                
				
				prepare.executeUpdate();
				obj = this.find(obj.getId_service());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Service find(int id) {
		Service serv = new Service();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM service WHERE id_service = " + id
                                             );
            if(result.first())
            		serv = new Service(
                                        result.getString("code"),
                                        result.getString("nom"),
                                        result.getString("batiment"),
                                        result.getInt("directeur")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return serv;

	}
	
	
    @Override
	public Service update(Service obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE service SET code = '" + obj.getCode_service() + "',"+
                        " nom = '" +obj.getNom() + "',"+
                        " batiment = '" +obj.getBatiment() + "',"+
                        " directeur ='" +obj.getDirecteur() + "'"+
                    	" WHERE id_service = " + obj.getId_service()                   );
			
			obj = this.find(obj.getId_service());
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
                             "DELETE FROM service WHERE id_service = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}

}