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
public class DocteurDAO extends DAO<Docteur>{
    @Override
    public Docteur create(Docteur obj) {
		try {
                        int id=0;
                        String nom="Crapaud";
                        String prenom="Jean-Michel";
                        String adresse="La River";
                        String tel="010";
			DAO<Employe> employeDAO = new EmployeDAO();
                        Employe emp = new Employe(0,nom,prenom,adresse,tel );
                        employeDAO.create(emp);
                        try{
                            ResultSet resultat=this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM employe WHERE prenom = '"+prenom+"'AND nom='"+nom+"'"
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
                    	"UPDATE docteur SET specialite = '" + obj.getSpécialité()+ "',"+                   
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
                                            "SELECT * FROM soigne WHERE no_malade = " + id
                                         );
        if(result2.first()){
                //Le message
                System.out.println("Malade dans soigne");
            
        }
        else this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM docteur WHERE numero = " + id+
                             "DELETE FROM employe WHERE numero = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
}
