package za.ac.cput.repository;
/* TutorRepository.java
Implementation of TutorRepository
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.database.TutorDatabase;
import za.ac.cput.entity.Tutor;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class TutorRepository implements ITutorRepository {
    private static TutorRepository repository = null;
    private TutorDatabase tutorDB = null;

    private TutorRepository() throws SQLException, ClassNotFoundException {
        tutorDB = new TutorDatabase();
    }

    public static TutorRepository getRepository() throws SQLException, ClassNotFoundException {
        if(repository == null){
            repository = new TutorRepository();
        }
        return repository;
    }

    @Override
    public Tutor create(Tutor tutor) throws SQLException {
        boolean success = tutorDB.CreateTutors("insert into tutors values(?,?, ?,?, ?,?, ?)",tutor);

        return tutor;
    }

    @Override
    public Tutor read(String id) throws SQLException {
        Tutor tutor = tutorDB.GetTutor("select * from tutors where id = '" + id + "'");
        return tutor;
    }

    @Override
    public Tutor update(Tutor tutor) throws SQLException {
        Tutor oldTutor = read(tutor.getId());
        if(oldTutor != null){
            tutorDB.UpdateTutor("update tutors set username = ?, email = ?, firstName = ?, lastName = ?, studentNumber = ? , dateCreated = ? where id = ?",tutor);
            return null;
        }
        return tutor;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Tutor tutorToDelete = read(id);
        if(tutorToDelete == null){
            System.out.println("Nothing to delete: ");
            return false;
        }
        tutorDB.DeleteTutor("delete from tutors where id = ?", id);
        System.out.println("Delete success: ");
        return true;
    }

    @Override
    public Set<Tutor> getAll() throws SQLException {
        return tutorDB.GetTutors("select * from tutors");
    }
    @Override
    public Tutor getTutor(String id) throws SQLException {
        return read(id);
    }
}
