package za.ac.cput.repository;

import za.ac.cput.entity.Booking;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* BookingRepository.java
Implementation of BookingRepository
Author: 214258041_Lelihle Gazi
 */
public class BookingRepository implements IBookingRepository {
        private static BookingRepository repository = null;
        private Set<Booking> bookingDB = null;

        private BookingRepository() {
            bookingDB = new HashSet<>();
        }

        public static BookingRepository getRepository(){
            if(repository == null){
                repository = new BookingRepository();
            }
            return repository;
        }

        @Override
        public Booking create(Booking booking) {
            boolean success = bookingDB.add(booking);
            if(!success){
                return null;
            }
            return booking;
        }

        @Override
        public Booking read(String id) {
            Booking booking = bookingDB.stream().filter(u -> u.getId().equals(id))
                    .findAny().orElse(null);
            return booking;
        }

        @Override
        public Booking update(Booking booking) {
            Booking oldBooking = read(booking.getId());
            if(oldBooking != null){
                bookingDB.remove(oldBooking);
                bookingDB.add(booking);
                return null;
            }
            return booking;
        }

        @Override
        public boolean delete(String id) {
            Booking bookingToDelete = read(id);
            if(bookingToDelete == null){
                return false;
            }
            bookingDB.remove(bookingToDelete);
            return true;
        }

        @Override
        public Set<Booking> getAll() {
            return bookingDB;
        }
        @Override
        public Booking getBooking(String id) {
            return read(id);
        }

    @Override
    public Set<Booking> getCourseBookings(String courseId) {
        Set<Booking> bookings = bookingDB.stream()
                .filter(u -> u.getCourseId().equals(courseId))
                .collect(Collectors.toSet());
        return bookings;
    }

    @Override
    public Set<Booking> getTutorBookings(String tutorId) {
        Set<Booking> bookings = bookingDB.stream()
                .filter(u -> u.getTutorId().equals(tutorId))
                .collect(Collectors.toSet());
        return bookings;
    }
}
