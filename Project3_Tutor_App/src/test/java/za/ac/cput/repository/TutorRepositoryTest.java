package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TutorRepositoryTest {
    private static TutorRepository repository;

    static {
        try {
            repository = TutorRepository.getRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Tutor tutor = TutorFactory.createTutor("21456789","SnaSilwane", "snawosilulwane@gmail.com", "Snawo", "Silulwane", "214569082","2022-05-20");


    @Test
    void create() throws SQLException {
        Tutor created = repository.create(tutor);
        assertEquals(tutor.getUsername(), created.getUsername());
        assertEquals(tutor.getEmail(),created.getEmail());
    }

    @Test
    void read() throws SQLException {
        repository.create(tutor);
        Tutor gettutor = repository.read(tutor.getId());
        assertEquals(tutor.getUsername(), gettutor.getUsername());
        assertEquals(tutor.getEmail(),gettutor.getEmail());
    }

    @Test
    void update() throws SQLException {
        repository.create(tutor);
        tutor.setUsername("valazom");
        repository.update(tutor);
        Tutor gettutor = repository.read(tutor.getId());
        assertEquals(tutor.getUsername(), gettutor.getUsername());
    }

    @Test
    void delete() throws SQLException {
        repository.create(tutor);
        repository.delete(tutor.getId());
        assertEquals(repository.getAll().isEmpty(),true);
    }

    @Test
    void getAll() throws SQLException {
        repository.create(tutor);
        assertEquals(!repository.getAll().isEmpty(),true);
    }

    @Test
    void getTutor() throws SQLException {
        repository.create(tutor);
        Tutor gettutor = repository.getTutor(tutor.getId());

        assertEquals(tutor.getId(),gettutor.getId());
    }
}