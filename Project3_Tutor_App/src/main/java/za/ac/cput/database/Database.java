package za.ac.cput.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Database.java
 * author Abdul Aleem Chilwan (220108447)
 *
 */
public class Database {
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "";
    
    
    
    public static void main(String[] args) throws SQLException {

     
        // Creating the database
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE DATABASE projectApp";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

        } catch (SQLException e) {
            System.out.println("Database already created.");;
        }

        try {
            // Adding tables to the database (resource table)
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/projectApp";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
            Statement stmt = con.createStatement();
            System.out.println("Connection established......");

            //Query to create a table
            String sqlCreateResource = "CREATE TABLE resources ("
                    + "Item_Name varchar(255) NOT NULL,"
                    + "Description varchar(1000) NOT NULL DEFAULT 'Description about the item.',"
                    + "Owner_Contact varchar(255) NOT NULL,"
                    + "Availability varchar(5) NOT NULL,"
                    + "ImageID varchar(255) NOT NULL,"
                    + "PRIMARY KEY (Item_Name))";
            

            String updateTable = "INSERT INTO resources (Item_Name, Description, Owner_Contact, Availability, ImageID) VALUES" +
                    "('Test Driven Development: By Example', 'This book follows two TDD projects from start to finish, illustrating techniques programmers can use to easily and dramatically increase the quality of their work. The examples are followed by references to the featured TDD patterns and refactorings. With its emphasis on agile methods and fast development strategies, Test-Driven Development is sure to inspire readers to embrace these under-utilized but powerful techniques', '38215@mycput.ac.za', 'true', 'IMG_TDD.png')," +
                    "('Software Engineering 10th Edition', 'Software Engineering introduces readers to the overwhelmingly important subject of software programming and development. In the past few years, computer systems have come to dominate not just our technological growth, but the foundations of our world’s major industries. This text seeks to lay out the fundamental concepts of this huge and continually growing subject area in a clear and comprehensive manner.', '382123@mycput.ac.za', 'true', 'IMG_SOFTENG.png')," +
                    "('Design Patterns: Elements of Reusable Object-Oriented Software', 'The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.', '281980@mycput.ac.za', 'false', 'IMG_DESPATS.png');";
           
            stmt.execute(sqlCreateResource);
            stmt.executeUpdate(updateTable);
            
            //Create a student table for login and register page
            String sqlCreateStudent_credential = "CREATE TABLE Student_credential ("
                    + "Id int(11) NOT NULL AUTO_INCREMENT,"
                    + "First_Name varchar(50) NOT NULL,"
                    + "Surname varchar(50) NOT NULL,"
                    + "Email_Address varchar(50) NOT NULL,"
                    + "Course_Enrolled_In varchar(50) NOT NULL,"
                    + "Password varchar(20) NOT NULL,"
                    + "Re_Typr_Password varchar(20) NOT NULL,"
                    + "PRIMARY KEY (Id))";
            
            
           String updateTable1 = "INSERT INTO student_credential (Id, First_Name, Surname, Email_Address, Course_Enrolled_In, Password, Re_Typr_Password) VALUES" +
                    "(NULL, 'admin', 'admin', 'admin@gmail.com', 'Data checker', 'admin', 'admin')," +
                    "(NULL, 'Tasreeq', 'Adams', '@gmail.com', 'Project3', '12345678', '12345678')," +
                    "(NULL, 'Student', 'Student', 'Student@gmail.com', 'Project 3', 'Student', 'Student');";
            //execution for dtudent credential
            stmt.execute(sqlCreateStudent_credential);
            stmt.executeUpdate(updateTable1);

//Create a tutor table for Tutor page
            String sqlCreateTutor = "CREATE TABLE Tutors ("
                    + "id int(20) NOT NULL AUTO_INCREMENT,"
                    + "username varchar(20) NOT NULL,"
                    + "email varchar(30) NOT NULL,"
                    + "firstName varchar(20) NOT NULL,"
                    + "lastName varchar(20) NOT NULL,"
                    + "studentNumber varchar(20) NOT NULL,"
                    + "dateCreated varchar(50) NOT NULL,"
                    + "PRIMARY KEY (id))";

//Create a tutor table for Booking page
            String sqlCreateBooking = "CREATE TABLE Bookings ("
                    + "id int(20) NOT NULL AUTO_INCREMENT,"
                    + "tutorId varchar(50) NOT NULL,"
                    + "courseId varchar(50) NOT NULL,"
                    + "startDate varchar(20) NOT NULL,"
                    + "endDate varchar(20) NOT NULL,"
                    + "PRIMARY KEY (id))";

            stmt.execute(sqlCreateBooking);


            System.out.println("Table Created......");
        }catch(SQLException e) {
            System.out.println("Table already created.");;
        }






    }

}
