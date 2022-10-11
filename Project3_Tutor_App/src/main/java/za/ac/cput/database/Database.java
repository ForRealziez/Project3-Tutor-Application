package za.ac.cput.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws SQLException {

        // Creating the database
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE tutor_application";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            System.out.println("Database already created.");;
        }

        // Adding tables to the database (resource table)
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/du";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
        System.out.println("Connection established......");
        //Creating the Statement
        Statement stmt = con.createStatement();
        //Query to create a table
        String query = "DROP TABLE IF EXISTS resources;";
        String sql = "CREATE TABLE resources ("
                + "Item_Name varchar(255) NOT NULL,"
                + "Description varchar(1000) NOT NULL DEFAULT 'Description about the item.',"
                + "Owner_Contact varchar(255) NOT NULL,"
                + "Availability varchar(5) NOT NULL,"
                + "ImageID varchar(255) NOT NULL,"
                + "PRIMARY KEY (Item_Name))";

        stmt.execute(query);
        stmt.execute(sql);

        System.out.println("Table Created......");



    }

}
