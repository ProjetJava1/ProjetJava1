/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
/*
 * 
 * Connexion a votre BDD via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat requete
     */
    private static Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    public String login = "root";
    public String password ="";
    /**
     * Constructeur avec 4 paramètres : username et password ECE, login et password de la BDD
     */
    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // Connexion via le tunnel SSH avec le username et le password ECE
        SSHTunnel ssh = new SSHTunnel(usernameECE, passwordECE);

        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            stmt = conn.createStatement();

        }
    }
    public Connexion(String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        if (loginDatabase == login && passwordDatabase == password) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";

            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();

        }
    }
    public static Connection getInstance(){
	return conn;	
}	
}

