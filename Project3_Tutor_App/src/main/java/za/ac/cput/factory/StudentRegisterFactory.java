/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.factory;

import za.ac.cput.entity.StudentRegister;
import za.ac.cput.util.Helper;

public class StudentRegisterFactory  {
    public static StudentRegister createStudentRegister(String registerNumber, String email, String password, String passwordCon, String course){
        String registerId = Helper.generateSmallerId();
        StudentRegister studentRegister = new StudentRegister.Builder()
                .setRegisterNumber(registerId)
                .setEmail(email)
                .setPassword(password)
                .setPasswordCon(passwordCon)
                .setCourse(course)
                .build();
        return studentRegister;

    }
}