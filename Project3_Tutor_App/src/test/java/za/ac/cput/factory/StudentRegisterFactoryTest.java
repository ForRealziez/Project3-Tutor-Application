/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.StudentRegister;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegisterFactoryTest {

    @Test
    void createStudentRegister() {
        StudentRegister studentRegister = StudentRegisterFactory.createStudentRegister("","@email.com","12345678","12345678","ADP");
        assertNotNull(studentRegister);
        System.out.println(studentRegister.toString());
    }
}