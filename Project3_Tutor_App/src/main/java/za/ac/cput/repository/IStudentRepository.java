package za.ac.cput.repository;

import za.ac.cput.entity.Student;

import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String> {

    // create, read, update, delete
    public Set<Student> getAll();
}