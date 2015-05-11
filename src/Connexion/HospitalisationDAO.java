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
public class HospitalisationDAO extends DAO<Hospitalisation>{
    @Override
    public Hospitalisation create(Hospitalisation obj) {
                    try{
                            ResultSet resultat=this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM hospitalisation WHERE code_service = '"+obj.getCode_service()+"'AND no_chambre='"+obj.getNo_chambre()+"'AND lit='"+obj.getLit()+"'"
                                             );
                        if(resultat.first()){
                            System.out.println("Ce lit est déjà occupé");
                        }
			 
                        else{
    			PreparedStatement prepare = this	.connect
                                                    .prepareStatement(
                                                    	"INSERT INTO hospitalisation ( no_malade, code_service, no_chambre, lit) VALUES(?, ?, ?, ?)"
                                                    );
				prepare.setInt(1, obj.getNo_malade());
				prepare.setString(2, obj.getCode_service()); 
                                prepare.setInt(3, obj.getNo_chambre());
                                prepare.setInt(4, obj.getLit());
				
				prepare.executeUpdate();
				obj = this.find(obj.getId_hospitalisation());
				
                        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Hospitalisation find(int id) {
		Hospitalisation hos = new Hospitalisation();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM hospitalisation WHERE id_hospitalisation = " + id
                                             );
            if(result.first())
            		hos = new Hospitalisation(
                                        result.getInt("no_malade"),
                                        result.getString("code_service"),
                                        result.getInt("no_chambre"),
                                        result.getInt("lit")
                                    );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return hos;

	}
	
	
    @Override
	public Hospitalisation update(Hospitalisation obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE hospitalisation SET no_malade = '" + obj.getNo_malade() + "',"+
                        " code_service = '" +obj.getCode_service() + "',"+
                        " no_chambre = '" +obj.getNo_chambre() + "',"+
                        " lit = '" +obj.getLit() + "'"+
                    	" WHERE id_hospitalisation = " + obj.getId_hospitalisation()                   );
			
			obj = this.find(obj.getId_hospitalisation());
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
                             "DELETE FROM hospitalisation WHERE id_hospitalisation = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
    
}