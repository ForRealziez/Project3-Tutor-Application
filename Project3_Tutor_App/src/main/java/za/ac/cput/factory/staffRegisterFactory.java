package za.ac.cput.factory;

import za.ac.cput.entity.staffRegister;
import za.ac.cput.util.Helper;

public class staffRegisterFactory {
    public static staffRegister createStaffRegister(String registerID, String name, String surname, Boolean gender, String email, String physicalAddress, String course, String password, String confirmPassword){
        String registrationID = Helper.generateSmallerId();
        staffRegister staffRegister = new staffRegister.Builder()
                .setRegistration(registerID)
                .setName(name)
                .setSurname(surname)
                .setGender(gender)
                .setEmail(email)
                .setPhysicalAddress(physicalAddress)
                .setCourse(course)
                .setPassword(password)
                .setConfirmPassword(confirmPassword)
                .build();
        return staffRegister;


    }
}


