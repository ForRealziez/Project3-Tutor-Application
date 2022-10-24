package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {
    private static BookingRepository repository;

    static {
        try {
            repository = BookingRepository.getRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Booking booking = BookingFactory.createBooking("214567682","LEE","ADP","2022-05-19");


    @Test
    void create() throws SQLException, ClassNotFoundException {
        Booking created = repository.create(booking);
        assertEquals(booking.getTutorId(), created.getTutorId());
        assertEquals(booking.getCourseId(),created.getCourseId());
    }

    @Test
    void read() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        Booking getbooking = repository.read("214567682");
        assertEquals(booking.getTutorId(), getbooking.getTutorId());
        assertEquals(booking.getCourseId(),getbooking.getCourseId());
    }

    @Test
    void update() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        booking.setStartDate("2022-05-22");
        booking.setEndDate("2022-05-23");
        repository.update(booking);
        Booking getbooking = repository.read("214567682");
        assertEquals(booking.getStartDate(), getbooking.getStartDate());
        assertEquals(booking.getEndDate(),getbooking.getEndDate());
    }

    @Test
    void delete() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        repository.delete(booking.getId());
        assertEquals(repository.getAll().isEmpty(),true);
    }

    @Test
    void getAll() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        assertEquals(!repository.getAll().isEmpty(),true);
    }

    @Test
    void getBooking() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        Booking getbooking = repository.getBooking(booking.getId());

        assertEquals(booking.getId(),getbooking.getId());
    }

    @Test
    void getCourseBookings() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        Set<Booking> courseBooking = repository.getCourseBookings(booking.getCourseId());

        assertEquals(courseBooking.stream().count(),1);
    }

    @Test
    void getTutorBookings() throws SQLException, ClassNotFoundException {
        repository.create(booking);
        Set<Booking> tutorBooking = repository.getTutorBookings(booking.getTutorId());

        assertEquals(tutorBooking.stream().count(),1);
    }
}