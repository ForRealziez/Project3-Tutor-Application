package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;

import static org.junit.jupiter.api.Assertions.*;

class TutorRepositoryTest {
    private static TutorRepository repository = TutorRepository.getRepository();

    private static Tutor tutor = TutorFactory.createTutor("21456789","SnaSilwane", "snawosilulwane@gmail.com", "Snawo", "Silulwane", "214569082","2022-05-20");


    @Test
    void create() {
        Tutor created = repository.create(tutor);
        assertEquals(tutor.getUsername(), created.getUsername());
        assertEquals(tutor.getEmail(),created.getEmail());
    }

    @Test
    void read() {
        repository.create(tutor);
        Tutor gettutor = repository.read(tutor.getId());
        assertEquals(tutor.getUsername(), gettutor.getUsername());
        assertEquals(tutor.getEmail(),gettutor.getEmail());
    }

    @Test
    void update() {
        repository.create(tutor);
        tutor.setUsername("valazom");
        repository.update(tutor);
        Tutor gettutor = repository.read(tutor.getId());
        assertEquals(tutor.getUsername(), gettutor.getUsername());
    }

    @Test
    void delete() {
        repository.create(tutor);
        repository.delete(tutor.getId());
        assertEquals(repository.getAll().isEmpty(),true);
    }

    @Test
    void getAll() {
        repository.create(tutor);
        assertEquals(!repository.getAll().isEmpty(),true);
    }

    @Test
    void getTutor() {
        repository.create(tutor);
        Tutor gettutor = repository.getTutor(tutor.getId());

        assertEquals(tutor.getId(),gettutor.getId());
    }
}