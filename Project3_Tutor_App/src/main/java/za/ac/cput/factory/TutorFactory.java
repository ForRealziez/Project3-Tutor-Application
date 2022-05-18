package za.ac.cput.factory;
/* TutorFactory.java
Factory for the Tutor entity
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.entity.Tutor;
import za.ac.cput.util.Helper;

public class TutorFactory {
    public static Tutor createTutor(String username, String email, String firstName, String lastName, String studentNumber, String dateCreated)
    {

        if (Helper.isEmpty(username) || Helper.isEmpty(email) || Helper.isEmpty(studentNumber)) {
            return null;
        }


        return new Tutor
                .Builder()
                .setUsername(username)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStudentNumber(studentNumber)
                .setDateCreated(dateCreated)
                .build();
    }
}
