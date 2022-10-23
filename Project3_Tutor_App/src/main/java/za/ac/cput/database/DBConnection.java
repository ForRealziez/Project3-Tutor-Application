/**
 * @author Moegammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.database;
import java.sql.*;


 public class DBConnection {
     public static Connection mycon(){
     Connection con = null;
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         con = DriverManager.getConnection("jdbc:mysql://localhost/projectApp","root", "");
         //Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
     }catch(ClassNotFoundException | SQLException e){
         System.out.println(e);
     }
     
     
     return con;
     }
      
}































/*

 * @author Tasreeq
 * *
 * 
 * public class DBConnection {
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
 */


/*
* static final String DB_URL = "jdbc:mysql:3306//localhost/students";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection connectDB(){
    Connection conn = null;
    try{
        //register jdbc driver ,mot required for newer verion of jdk
        Class.forName("com.mysql.jdbc.Driver");
        //open a connection
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("connected");
        return conn;
        
        
    }catch(Exception ex){
        System.out.println("there was a error connecting to db.");
        return null;
    }
    } 
*
*/

