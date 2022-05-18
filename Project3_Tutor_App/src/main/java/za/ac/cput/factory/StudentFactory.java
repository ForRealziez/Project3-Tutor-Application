package za.ac.cput.factory;

import za.ac.cput.entity.Student;
import za.ac.cput.util.Helper;

public class StudentFactory {

    public static Student createStudent(String fullname, String surname,String email,  String password, String course){
        String studentID = za.ac.cput.util.Helper.generateId();

        if(Helper.isEmpty(fullname) || Helper.isEmpty(surname) || Helper.isEmpty(password) || Helper.isEmpty(course))
            return null;

        if(!Helper.isValidEmail(email))
            return null;

        Student student = new Student.StudentBuilder().setStudentID(studentID)
                .setFullname(fullname)
                .setSurname(surname)
                .setEmail(email)
                .setPassword(password)
                .setCourse(course)
                .build();
        return student;

    }
}
