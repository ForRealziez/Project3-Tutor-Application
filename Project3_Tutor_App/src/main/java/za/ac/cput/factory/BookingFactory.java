package za.ac.cput.factory;
/* BookingFactory.java
Factory for the Booking entity
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.entity.Booking;
import za.ac.cput.util.Helper;

public class BookingFactory {
    public static Booking createBooking(String id, String tutorId, String courseId, String startDate, String endDate)
    {

        if (Helper.isEmpty(id) || Helper.isEmpty(tutorId) || Helper.isEmpty(courseId) || Helper.isEmpty(startDate) || Helper.isEmpty(endDate) ) {
            return null;
        }


        return new Booking
                .Builder()
                .setId(id)
                .setTutorId(tutorId)
                .setCourseId(courseId)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
    }
}
