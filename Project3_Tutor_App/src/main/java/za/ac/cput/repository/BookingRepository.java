package za.ac.cput.repository;

import za.ac.cput.database.BookingDatabase;
import za.ac.cput.entity.Booking;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* BookingRepository.java
Implementation of BookingRepository
Author: 214258041_Lelihle Gazi
 */
public class BookingRepository implements IBookingRepository {
        private static BookingRepository repository = null;
        private BookingDatabase bookingDB = null;

        private BookingRepository() throws SQLException, ClassNotFoundException {
            bookingDB = new BookingDatabase();
        }

        public static BookingRepository getRepository() throws SQLException, ClassNotFoundException {
            if(repository == null){
                repository = new BookingRepository();
            }
            return repository;
        }

        @Override
        public Booking create(Booking booking) throws SQLException, ClassNotFoundException {
            boolean success = bookingDB.CreateBooking("insert into bookings values(?,?, ?,?, ?)",booking);
            if(!success){
                return null;
            }
            return booking;
        }

        @Override
        public Booking read(String id) throws SQLException {
            Booking booking = bookingDB.GetBooking("select * from bookings where id = '"+ id +"'");
            return booking;
        }

        @Override
        public Booking update(Booking booking) throws SQLException {
            Booking oldBooking = read(booking.getId());
            if(oldBooking != null){
                bookingDB.UpdateBooking("update bookings set tutorId = ?, courseId = ?, startDate = ?, endDate = ? where id = ?",booking);
                return null;
            }
            return booking;
        }

        @Override
        public boolean delete(String id) throws SQLException {
            Booking bookingToDelete = read(id);
            if(bookingToDelete == null){
                System.out.println("Nothing to delete: ");
                return false;
            }
            bookingDB.DeleteBooking("delete from bookings where id = ?", id);
            System.out.println("Delete success: ");
            return true;
        }

        @Override
        public Set<Booking> getAll() throws SQLException {
            return bookingDB.GetBookings("select * from bookings");
        }
        @Override
        public Booking getBooking(String id) throws SQLException {
            return read(id);
        }

    @Override
    public Set<Booking> getCourseBookings(String courseId) throws SQLException {
        Set<Booking> bookings = bookingDB.GetBookings("select * from bookings where courseId = '" + courseId + "'");
        return bookings;
    }

    @Override
    public Set<Booking> getTutorBookings(String tutorId) throws SQLException {
        Set<Booking> bookings = bookingDB.GetBookings("select * from bookings where tutorId = '" + tutorId + "'");
        return bookings;
    }
}
