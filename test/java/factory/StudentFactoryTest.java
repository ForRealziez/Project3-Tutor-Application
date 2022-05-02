package factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    public void test() {

        Student student = StudentFactory.createStudent("Chante ALicia", "Lewis","chantel@yahoo.com","12345","ADP01");
        System.out.println(student.toString());
        assertNotNull(student);

    }
}