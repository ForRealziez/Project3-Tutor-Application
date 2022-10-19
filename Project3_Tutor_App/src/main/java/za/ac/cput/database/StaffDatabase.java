package za.ac.cput.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class StaffDatabase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/staffDatabase";
        String uname = "root";
        String password = "Giant123";
        Connection con = DriverManager.getConnection(url, uname, password);
        Statement statement = con.createStatement();

        statement.executeUpdate("CREATE TABLE STAFF");
        statement.close();
        con.close();

        String s = "CREATE TABLE Staff_Register ("
                + "Staff ID` VARCHAR(13) NOT NULL,"
                + "Name` VARCHAR(16) NOT NULL,"
                + "Surname` VARCHAR(255) NOT NULL,"
                + "Gender` VARCHAR(32) NOT NULL,"
                + "Email` VARCHAR(45) NOT NULL,"
                + "Physical address` VARCHAR(45) NOT NULL,"
                + "Course` VARCHAR(45) NOT NULL,"
                + "Password` VARCHAR(45) NOT NULL,"
                + "PRIMARY KEY (`Staff ID`))";
//        String sqlCreateStaffRegister "CREATE TABLE Staff_Register ("
//          + "Staff ID` VARCHAR(13) NOT NULL,"
//          + "Name` VARCHAR(16) NOT NULL,"
//          + "Surname` VARCHAR(255) NOT NULL,"
//          + "Gender` VARCHAR(32) NOT NULL,"
//          + "Email` VARCHAR(45) NOT NULL,"
//          + "Physical address` VARCHAR(45) NOT NULL,"
//          + "Course` VARCHAR(45) NOT NULL,"
//          + "Password` VARCHAR(45) NOT NULL,"
//          + "PRIMARY KEY (`Staff ID`))";

        String updateTable = "INSERT INTO staffRegister (Name, Surname, Gender, Email, Physical_address, Course, Password) VALUES" +
           "('0192038948993','Natasha', 'James', 'Female', 'natasha@james.co.za', '22 lions head road', 'ADT', 'MYDOG!s2cute'),"+
           "('2637719021233','Larry', 'Wise', 'Male', 'larry@wise.co.za', '1 table mountain road', 'ITS', '@Ilovel0v3'),"+
           "('7890111178990','Bloomy', 'Xolo', 'Female', 'bloomy@xolo.ac.za', '22 lions head road', 'ADT', 'lotto!isaddictiv3');";
        ;

    }
}
