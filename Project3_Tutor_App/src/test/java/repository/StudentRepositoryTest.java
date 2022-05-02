package repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentRepositoryTest {
    private static StudentRepository repository = StudentRepository.getRepository();
    private static Student student= StudentFactory.createStudent("San Ann","Vraagom","svraagom@yahoo.com","0000","MTO");

    @Test
    void a_create() {
        Student created = repository.create(student);
        assertEquals(student.getStudentID(), created.getStudentID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Student read = repository.read(student.getStudentID());
        assertNotNull(read);
        System.out.print("Read: " + read);
    }

    @Test
    void c_update() {
        Student updated = new Student.StudentBuilder().copy(student).setStudentID("145145")
                .setFullname("Keegan")
                .setSurname("Karelse")
                .setEmail("keeganv@gmail.com")
                .setPassword("kv12469")
                .setCourse("TOT48")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);

    }

    @Test
    void e_delete() {
        boolean
                success = repository.delete(student.getStudentID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }


}