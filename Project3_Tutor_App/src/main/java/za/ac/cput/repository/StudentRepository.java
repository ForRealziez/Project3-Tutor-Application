package za.ac.cput.repository;

import za.ac.cput.entity.Student;
import java.util.HashSet;
import java.util.Set;

public class StudentRepository implements IStudentRepository {

    private static StudentRepository repository = null;
    private Set<Student> studentDB = null;

    private StudentRepository() {
        studentDB = new HashSet<Student>();
    }

    public static StudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        boolean success = studentDB.add(student);
        if(!success)
            return null;
        return student;
    }

    @Override
    public Student read(String studentID) {
        Student student = studentDB.stream()
                .filter(s -> s.getStudentID().equals(studentID))
                .findAny()
                .orElse(null);
        return student;
    }

    @Override
    public Student update(Student student) {
        Student oldStudent = read(student.getStudentID());
        if(oldStudent != null){
            studentDB.remove(oldStudent);
            studentDB.add(student);
            return null;
        }
        return student;
    }

    @Override
    public boolean delete(String studentID) {
        Student subjectDelete = read(studentID);
        if(subjectDelete == null)
            return false;
        studentDB.remove(subjectDelete);
        return true;
    }

    @Override
    public Set<Student> getAll() {
        return studentDB;
    }
}