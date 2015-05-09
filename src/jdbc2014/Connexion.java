/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2014;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;

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
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<String>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<String>(); // liste des requêtes de MAJ

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

            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();

            // initialisation de la liste des requetes de selection et de MAJ
            remplirRequetes();
            remplirRequetesMaj();
        }
    }

    /**
     * Méthode privée qui ajoute la requete de selection en parametre dans son ArrayList
     */
    private void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode privée qui initialise la liste des requetes de selection
     */
    private void remplirRequetes() {
        ajouterRequete("SELECT nom, prenom FROM employe ORDER BY nom;");
        ajouterRequete("SELECT e1.nom, e1.prenom, d1.specialite FROM employe e1, docteur d1 WHERE d1.numero=e1.numero ORDER BY e1.nom ;");
        ajouterRequete("SELECT m.nom, m.prenom, e1.nom, e1.prenom  FROM employe e1, docteur d1, malade m, soigne WHERE d1.numero=e1.numero AND d1.numero= no_docteur AND m.numero=no_malade ORDER BY m.nom ;");
        /*ajouterRequete("SELECT ename, sal FROM Emp ORDER BY sal;");
        ajouterRequete("SELECT Dept.*, Emp.*, Mission.* FROM Dept, Emp, Mission WHERE Dept.deptno=Emp.deptno AND Emp.empno=Mission.empno;");
        ajouterRequete("SELECT AVG (Emp.sal) FROM Emp, Mission WHERE Emp.empno = Mission.empno;");
        ajouterRequete("SELECT Dept.*, Emp.* FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND comm>0;");
        ajouterRequete("SELECT hiredate, empno, ename FROM Emp WHERE (((hiredate)>='1981-05-01' And (hiredate)<'1981-05-31'))ORDER BY hiredate;");
        ajouterRequete("SELECT ename, job FROM Emp ORDER BY job;");
        ajouterRequete("SELECT DISTINCT dname, job FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND job='Clerk';");
        ajouterRequete("SELECT DISTINCT e1.ename, e1.deptno, e2.ename, e2.deptno FROM Emp e1, Emp e2 WHERE e1.deptno!=e2.deptno AND e1.empno = e2.mgr;");*/
    }

    /**
     * Méthode privée qui ajoute la requete de MAJ en parametre dans son ArrayList
     */
    private void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode privée qui initialise la liste des requetes de MAJ
     */
    private void remplirRequetesMaj() {
        // Requêtes d'insertion
        /*ajouterRequeteMaj("INSERT INTO Dept (deptno,dname,loc) VALUES (50,'ECE','Paris');");

        // Requêtes de modification
        ajouterRequeteMaj("UPDATE Dept SET loc='Eiffel' WHERE loc='Paris';");

        // Requêtes de suppression
        ajouterRequeteMaj("DELETE FROM Dept WHERE loc='Eiffel';");*/

    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            liste.add(rsetMeta.getColumnLabel(i + 1));
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i+1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
}
