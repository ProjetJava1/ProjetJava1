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
public class InfirmierDAO extends DAO<Infirmier>{
    @Override
    public Infirmier create(Infirmier obj) {
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
                                                    	"INSERT INTO infirmier (numero, code_service, rotation, salaire) VALUES(?, ?, ?, ?)"
                                                    );  
                                prepare.setInt(1, id);
				prepare.setString(2, obj.getCode_service());
				prepare.setString(3, obj.getRotation());
                                prepare.setFloat(4, obj.getSalaire());
                           
                                prepare.executeUpdate();
				obj = this.find(obj.getNumero());	
				
			//}
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}
	
	
	
    @Override
	public Infirmier find(int id) {
		Infirmier inf = new Infirmier();
		try {
            ResultSet result = this .connect
                                    .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM infirmier WHERE numero = " + id
                                             );
            if(result.first())
            		inf = new Infirmier(
                                        result.getString("code_service"),
                                        result.getString("rotation"),
                                        result.getFloat("salaire")                                
                                        );
//            
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		   return inf;

	}
	
	
    @Override
	public Infirmier update(Infirmier obj) {
		try {
			
                this .connect	
                     .createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE infirmier SET code_service = '" + obj.getCode_service() + "',"+
                        " rotation = '" +obj.getRotation() + "',"+
                        " salaire = '" +obj.getSalaire() + "',"+                     
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
			
                this    .connect
                    	.createStatement(
                             ResultSet.TYPE_SCROLL_INSENSITIVE, 
                             ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                             "DELETE FROM infirmier WHERE numero = " + id
                        );
			
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
    
}
