package za.ac.cput.database;

import za.ac.cput.entity.Booking;

import java.sql.*;

public class BookingDatabase
{
    private Connection _connection;
    public BookingDatabase() throws SQLException, ClassNotFoundException {
        setConnecion();
    }

    public void setConnecion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sonoo","root","root");
        _connection = connection;
    }

    public ResultSet Execute(String query) throws SQLException {
       Statement statement = _connection.createStatement();
       ResultSet resultSet = statement.executeQuery(query);
       return resultSet;
    }

    public void Close(){}


}
