package za.ac.cput.factory;

import za.ac.cput.entity.staffRegister;
import za.ac.cput.util.Helper;

public class staffRegisterFactory {
    public static staffRegister createStaffRegister(String registerID, String name, String surname, String gender, String email, String physicalAddress, String course, String password, String confirmPassword) {
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

    public static staffRegister createStaffRegister(String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        return null;
    }
}


