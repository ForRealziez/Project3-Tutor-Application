package za.ac.cput.database;

import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;
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
            tutor = TutorFactory.createTutor(resultSet.getString(0), resultSet.getString(1),
                    resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5),resultSet.getString(6));
        }

        Close();

        return tutor;
    }

    public Set<Tutor> GetTutors(String tutorQuery) throws SQLException {
        ResultSet resultSet = Execute(tutorQuery);

        Set<Tutor> tutors = new HashSet<>();


        while (resultSet.next()){
            Tutor tutor = TutorFactory.createTutor(resultSet.getString(0), resultSet.getString(1),
                    resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5),resultSet.getString(6));
            tutors.add(tutor);
        }

        Close();

        return tutors;
    }

    public boolean CreateTutors(String query) throws SQLException {
        ResultSet resultSet = Execute(query);

        boolean result = resultSet.rowInserted();

        Close();

        return result;
    }
}