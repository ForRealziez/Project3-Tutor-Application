package za.ac.cput.database;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TutorDatabaseTest {

    @Test
    void getTutor() throws SQLException, ClassNotFoundException {
        TutorDatabase database = new TutorDatabase();

        Tutor result = database.GetTutor("select * from tutors where id = '1'");
        assertEquals("1",result.getId());
    }
    @Test
    void getTutors() throws SQLException, ClassNotFoundException {
        TutorDatabase database = new TutorDatabase();

        Set<Tutor> results = database.GetTutors("select * from tutors");
        assertEquals("1",results.stream().findFirst().get().getId());
    }
    @Test
    void createTutors() throws SQLException, ClassNotFoundException {
        TutorDatabase database = new TutorDatabase();
        Tutor tutor = TutorFactory.createTutor("1", "zmatjie1", "214258041@mycput.ac.za", "Zodwa", "Matjie","214258041","2022-04-04");
        boolean result = database.CreateTutors("insert into tutors values(?,?, ?,?, ?,?, ?)",tutor);
        assertEquals(false,result);
    }
}