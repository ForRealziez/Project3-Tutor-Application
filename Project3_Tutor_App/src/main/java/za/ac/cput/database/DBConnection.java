/**
 * @author Moegammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.database;
import java.sql.*;


public class DBConnection {
Connection con = null;

try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Demo","root","");
    } catch (Exception ex) {
        System.out.println("there was a error connecting to db.");
    }
    return con;
    
    protected Connection _connection;
    public BaseConnection() throws SQLException, ClassNotFoundException {
        setConnecion();
    }

}

/**
 *public class DBConnection {
    static final String DB_URL = "jdbc:mysql://localhost/students";
    static final String USER = "root";
    static final String PASS = "root";
    
    public static Connection connectDB(){
    Connection conn = null;
    try{
        //register jdbc driver ,mot required for newer verion of jdk
        Class.forName("com.mysql.jdbc.Driver");
        //open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        return conn;
        
    }catch(Exception ex){
        System.out.println("there was a error connecting to db.");
        return null;
    }
    }    
}
 * @author Tasreeq
 */

