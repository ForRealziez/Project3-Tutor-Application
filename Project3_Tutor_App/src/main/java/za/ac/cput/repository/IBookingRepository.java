package za.ac.cput.repository;
/* IBookingRepository.java
Interface for the BookingRepository
Author: 214258041_Lelihle Gazi
 */

import za.ac.cput.entity.Booking;
import java.util.Set;

public interface IBookingRepository extends IRepository<Booking, String> {
        public Set<Booking> getAll();
        public Booking getBooking(String id);
        public Set<Booking> getCourseBookings(String courseId);
        public Set<Booking> getTutorBookings(String tutorId);
}
