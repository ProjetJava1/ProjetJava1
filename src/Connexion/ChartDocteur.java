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
public class ChartDocteur extends JFrame{
    
    public Connection connect = Connexion.getInstance();
    
    public ChartDocteur(){
     
try {
    Class.forName( "com.mysql.jdbc.Driver" );
} catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
}
int a =0;
int b =0;
int c =0;
int d =0;
int f =0;
int g = 0;
try{
                            ResultSet resultat1=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT specialite FROM docteur WHERE specialite =  'Cardiologue'"
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
                                                "SELECT specialite FROM docteur WHERE specialite =  'Traumatologue'"
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
                                                "SELECT specialite FROM docteur WHERE specialite =  'Pneumologue'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat3.last()){
                            c = resultat3.getRow();
                            }
                            System.out.println(c);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat4=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT specialite FROM docteur WHERE specialite =  'Orthopediste'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat4.last()){
                            d = resultat4.getRow();
                            }
                            System.out.println(d);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat5=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT specialite FROM docteur WHERE specialite =  'Radiologue'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat5.last()){
                            f = resultat5.getRow();
                            }
                            System.out.println(f);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat6=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT specialite FROM docteur WHERE specialite =  'Anesthesiste'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat6.last()){
                            g = resultat6.getRow();
                            }
                            System.out.println(g);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
DefaultPieDataset union = new DefaultPieDataset();

//remplir l'ensemble

union.setValue("Cardiologue",a);
union.setValue("Traumatologue",b);
union.setValue("Pneumologue",c);
union.setValue("Orthopediste",d);
union.setValue("Radiologue",f);
union.setValue("Anesthesiste",g);

JFreeChart repart = 
    ChartFactory.createPieChart3D("Nombre de médecin par spécialité",
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