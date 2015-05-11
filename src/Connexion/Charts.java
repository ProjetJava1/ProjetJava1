/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;
import BDD.*;
import java.sql.*;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Arnaud
 */
public class Charts extends JFrame{
    
    public Connection connect = Connexion.getInstance();
    private ResultSetMetaData rset;
    public Charts(){
     
try {
    Class.forName( "com.mysql.jdbc.Driver" );
} catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
}
int a =0;
int b =0;
int c =0;
try{
                            ResultSet resultat1=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT code_service FROM hospitalisation WHERE code_service =  'REA'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat1.last()){
                            a = resultat1.getRow();
                            }
                            System.out.println(a);
                           
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
                            ResultSet resultat2=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT code_service FROM hospitalisation WHERE code_service =  'CHG'"
                                             );                                                                               
                            // on récupère le nombre de lignes de la requête
                            if(resultat2.last()){
                            b = resultat2.getRow();
                            }
                            System.out.println(b);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
    
                            ResultSet resultat3=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT code_service FROM hospitalisation WHERE code_service =  'CAR'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat3.last()){
                            c = resultat3.getRow();
                            }
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
        
DefaultPieDataset union = new DefaultPieDataset();

//remplir l'ensemble

union.setValue("REA",a);
union.setValue("CAR",b);
union.setValue("CHG",c);

JFreeChart repart = 
    ChartFactory.createPieChart3D("Nombre d'hospitalisation par service",
    union, true, true, false);
ChartPanel crepart = new ChartPanel(repart);
this.add(crepart);
this.pack();
this.setVisible(true);
    }

    /*private void add(ChartPanel crepart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}