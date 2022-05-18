package za.ac.cput.repository;

import za.ac.cput.entity.staffRegister;
import java.util.Set;

public interface IStaffRegisterRepository extends IRepository<staffRegister, String>{
    public Set<staffRegister> getAll();

}