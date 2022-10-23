package za.ac.cput.repository;

import za.ac.cput.entity.staffRegister;
import java.util.HashSet;
import java.util.Set;

public class staffRegisterRepository implements IStaffRegisterRepository {

    private static staffRegisterRepository repository = null;
    private Set<staffRegister> staffRegisterDB = null;

    private staffRegisterRepository(){
        staffRegisterDB = new HashSet<staffRegister>();
    }
    public static staffRegisterRepository getRepository(){
        if(repository == null){
            repository = new staffRegisterRepository();
        }
        return repository;
    }

    @Override
    public staffRegister create(staffRegister staffRegister) {
        boolean success = staffRegisterDB.add(staffRegister);
        if (!success)
            return null;
        return staffRegister;
    }

    @Override
    public staffRegister read(String registrationID) {
        staffRegister staffRegister = staffRegisterDB.stream()
                .filter(s -> s.getStaffID()
                        .equals(registrationID))
                .findAny()
                .orElse(null);
        return staffRegister;

    }

    @Override
    public staffRegister update(staffRegister staffRegister) {
        staffRegister oldStaffRegister = read(staffRegister.getStaffID());
        if (oldStaffRegister != null){
            staffRegisterDB.add(staffRegister);
            staffRegisterDB.remove(oldStaffRegister);
            return staffRegister;
        }
        return null;
    }


    @Override
    public boolean delete(String registrationID) {
        staffRegister staffRegisterToDelete = read(registrationID);
        if (staffRegisterToDelete == null)
            return false;
        staffRegisterDB.remove(staffRegisterToDelete);
        return true;
    }


    @Override
    public Set<staffRegister> getAll() {
        return staffRegisterDB;
    }

}


