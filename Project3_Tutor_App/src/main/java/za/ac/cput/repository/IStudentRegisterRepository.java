/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.repository;

import za.ac.cput.entity.StudentRegister;

import java.util.Set;

public interface IStudentRegisterRepository  extends IRepository<StudentRegister, String>{
    public Set<StudentRegister> getAll();
}