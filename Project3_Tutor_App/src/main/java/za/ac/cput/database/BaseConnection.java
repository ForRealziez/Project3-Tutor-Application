package za.ac.cput.database;

import java.sql.*;

public class BaseConnection {
    private Connection _connection;
    public BaseConnection() throws SQLException, ClassNotFoundException {
        setConnecion();
    }

    protected void setConnecion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sonoo","root","root");
        _connection = connection;
    }

    protected ResultSet Execute(String query) throws SQLException {
        Statement statement = _connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    protected void Close() throws SQLException {
        _connection.close();
    }

}