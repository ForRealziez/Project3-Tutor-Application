/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.repository;

import za.ac.cput.entity.StudentRegister;

import java.util.HashSet;
import java.util.Set;

public class StudentRegisterRepository implements IStudentRegisterRepository {

    private static StudentRegisterRepository  repository = null;
    private Set<StudentRegister> studentRegisterDB = null;

    //singleton
    private StudentRegisterRepository (){
        studentRegisterDB = new HashSet<StudentRegister>();
    }
    public static StudentRegisterRepository getRepository(){
        if(repository == null){
            repository = new StudentRegisterRepository();
        }
        return repository;
    }



    @Override
    public StudentRegister create(StudentRegister studentRegister) {
        boolean success = studentRegisterDB.add(studentRegister);
        if(!success)
            return null;
        return studentRegister;
    }

    @Override
    public StudentRegister read(String registerNumber) {
        StudentRegister studentRegister = studentRegisterDB.stream()
                .filter(w -> w.getRegisterNumber()
                        .equals(registerNumber))
                .findAny()
                .orElse(null);
        return studentRegister;

    }

    @Override
    public StudentRegister update(StudentRegister studentRegister) {
        StudentRegister oldStudentRegister = read(studentRegister.getRegisterNumber());
        if(oldStudentRegister != null){
            studentRegisterDB.remove(oldStudentRegister);
            studentRegisterDB.add(studentRegister);
            return studentRegister;
        }
        return null;
    }

    @Override
    public boolean delete(String registerNumber) {
        StudentRegister studentRegisterToDelete = read(registerNumber);
        if (studentRegisterToDelete == null)
            return false;
        studentRegisterDB.remove(studentRegisterToDelete);
        return true;
    }

    @Override
    public Set<StudentRegister> getAll() {return studentRegisterDB;}
}
