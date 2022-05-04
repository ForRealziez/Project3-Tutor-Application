/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.StudentRegister;
import za.ac.cput.factory.StudentRegisterFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegisterRepositoryTest {
    private static StudentRegisterRepository repository = StudentRegisterRepository.getRepository();

    private static StudentRegister studentRegister = StudentRegisterFactory.createStudentRegister
            ("",
                    "Tasreeq@email.com",
                    "12345678",
                    "12345678",
                    "ADP");



    @Test
    void a_create() {
        StudentRegister created = repository.create(studentRegister);
        assertEquals(studentRegister.getRegisterNumber(), created.getRegisterNumber());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        StudentRegister read = repository.read(studentRegister.getRegisterNumber());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        StudentRegister updated = new StudentRegister.Builder().copy(studentRegister)
                .setEmail("Tashi@email.com")
                .setPassword("123456")
                .setPasswordCon("12345678")
                .setCourse("Application Development")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }


    @Test
    void d_getAll() {
        System.out.println("show all:");
        System.out.println(repository.getAll());
    }
}
