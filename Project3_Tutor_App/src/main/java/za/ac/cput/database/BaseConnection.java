package za.ac.cput.database;

import java.sql.*;

public class BaseConnection {
    protected Connection _connection;
    public BaseConnection() throws SQLException, ClassNotFoundException {
        setConnecion();
    }

    protected void setConnecion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(
                Database.DB_URL,Database.USER,Database.PASS);
        _connection = connection;
    }
    protected ResultSet Execute(String query) throws SQLException {
        Statement statement = _connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
    protected boolean ExecuteInsert(String query) throws SQLException {
        Statement statement = _connection.createStatement();

        boolean result = statement.execute(query);

        return  result;
    }
    protected void Close() throws SQLException {
        _connection.close();
    }

}