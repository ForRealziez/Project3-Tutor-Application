package za.ac.cput.repository;
/* IBookingRepository.java
Interface for the BookingRepository
Author: 214258041_Lelihle Gazi
 */

import za.ac.cput.entity.Booking;

import java.sql.SQLException;
import java.util.Set;

public interface IBookingRepository extends IRepository<Booking, String> {
        public Set<Booking> getAll() throws SQLException;
        public Booking getBooking(String id) throws SQLException;
        public Set<Booking> getCourseBookings(String courseId) throws SQLException;
        public Set<Booking> getTutorBookings(String tutorId) throws SQLException;
}
