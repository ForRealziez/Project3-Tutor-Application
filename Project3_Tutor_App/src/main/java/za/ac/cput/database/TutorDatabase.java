package za.ac.cput.database;

import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TutorDatabase extends BaseConnection
{
    public TutorDatabase() throws SQLException, ClassNotFoundException {
        super();
    }

    public Tutor GetTutor(String tutorQuery) throws SQLException {
        ResultSet resultSet = Execute(tutorQuery);

        Tutor tutor = null;

        while (resultSet.next()){
            tutor = TutorFactory.createTutor(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4), resultSet.getString(5),
                    resultSet.getString(6),resultSet.getString(7));
        }

        Close();

        return tutor;
    }

    public Set<Tutor> GetTutors(String tutorQuery) throws SQLException {
        ResultSet resultSet = Execute(tutorQuery);

        Set<Tutor> tutors = new HashSet<>();


        while (resultSet.next()){
            Tutor tutor = TutorFactory.createTutor(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4), resultSet.getString(5),
                    resultSet.getString(6),resultSet.getString(7));
            tutors.add(tutor);
        }

        Close();

        return tutors;
    }

    public boolean CreateTutors(String query,Tutor tutor) throws SQLException {
        PreparedStatement statement = _connection.prepareStatement(query);

        statement.setString(1,tutor.getId());
        statement.setString(2, tutor.getUsername());
        statement.setString(3, tutor.getEmail());
        statement.setString(4, tutor.getFirstName());
        statement.setString(5, tutor.getLastName());
        statement.setString(6, tutor.getStudentNumber());
        statement.setString(7, tutor.getDateCreated());
        boolean result = statement.execute();

        Close();

        return result;
    }

    public boolean UpdateTutor(String query,Tutor tutor) throws SQLException {
        PreparedStatement statement = _connection.prepareStatement(query);


        statement.setString(1,tutor.getUsername());
        statement.setString(2,tutor.getEmail());
        statement.setString(3,tutor.getFirstName());
        statement.setString(4,tutor.getLastName());
        statement.setString(5,tutor.getStudentNumber());
        statement.setString(6,tutor.getDateCreated());
        statement.setString(7,tutor.getId());

        boolean result = statement.execute();

        Close();

        return result;
    }

    public boolean DeleteTutor(String query, String id) throws SQLException {

        PreparedStatement statement = _connection.prepareStatement(query);

        statement.setString(1,id);

        boolean result = statement.execute();

        Close();

        return result;
    }

}