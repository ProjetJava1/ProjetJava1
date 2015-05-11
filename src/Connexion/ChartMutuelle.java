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
public class ChartMutuelle extends JFrame{
    
    public Connection connect = Connexion.getInstance();
    
    public ChartMutuelle(){
     
try {
    Class.forName( "com.mysql.jdbc.Driver" );
} catch ( ClassNotFoundException e ) {
    /* Gérer les éventuelles erreurs ici. */
}
int ag2r =0;
int ccvrp =0;
int cnamts =0;
int lmde =0;
int maaf =0;
int mas = 0;
int mgen =0;
int mgsp =0;
int mma =0;
int mnam =0;
int mnftc =0;
int mnh = 0;
try{
                            ResultSet resultat1=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'AG2R'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat1.last()){
                            ag2r = resultat1.getRow();
                            }
                         System.out.println(ag2r);
                           
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
                            ResultSet resultat2=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'CCVRP'"
                                             );                                                                               
                            // on récupère le nombre de lignes de la requête
                            if(resultat2.last()){
                            ccvrp = resultat2.getRow();
                            }
                            System.out.println(ccvrp);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
    
                            ResultSet resultat3=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'CNAMTS'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat3.last()){
                            cnamts = resultat3.getRow();
                            }
                            System.out.println(cnamts);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat4=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'LMDE'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat4.last()){
                            lmde = resultat4.getRow();
                            }
                            System.out.println(lmde);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat5=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MAAF'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat5.last()){
                            maaf = resultat5.getRow();
                            }
                            System.out.println(maaf);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat6=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MAS'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat6.last()){
                            mas = resultat6.getRow();
                            }
                            System.out.println(mas);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
                            ResultSet resultat7=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MGEN'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat7.last()){
                            mgen = resultat7.getRow();
                            }
                            System.out.println(mgen);
                           
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
                            ResultSet resultat8=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MGSP'"
                                             );                                                                               
                            // on récupère le nombre de lignes de la requête
                            if(resultat8.last()){
                            mgsp = resultat8.getRow();
                            }
                            System.out.println(mgsp);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
try{
    
                            ResultSet resultat9=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MMA'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat9.last()){
                            mma = resultat9.getRow();
                            }
                            System.out.println(mma);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat10=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MNAM'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat10.last()){
                            mnam = resultat10.getRow();
                            }
                            System.out.println(mnam);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat11=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MNFTC'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat11.last()){
                            mnftc = resultat11.getRow();
                            }
                            System.out.println(mnftc);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }

try{
    
                            ResultSet resultat12=this.connect.createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT mutuelle FROM malade WHERE mutuelle =  'MNH'"
                                             );
                            // on récupère le nombre de lignes de la requête
                            if(resultat12.last()){
                            mnh = resultat12.getRow();
                            }
                            System.out.println(mnh);
                            
                        }catch (SQLException e) {
		            e.printStackTrace();
		    }
DefaultPieDataset union = new DefaultPieDataset();

//remplir l'ensemble

union.setValue("AG2R",ag2r);
union.setValue("CCVRP",ccvrp);
union.setValue("CNAMTS",cnamts);
union.setValue("LMDE",lmde);
union.setValue("MAAD",maaf);
union.setValue("MAS",mas);
union.setValue("MGEN",mgen);
union.setValue("MGSP",mgsp);
union.setValue("MMA",mma);
union.setValue("MNAM",mnam);
union.setValue("MNFTC",mnftc);
union.setValue("MNH",mnh);

JFreeChart repart = 
    ChartFactory.createPieChart3D("Nombre de malades par mutuelle",
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