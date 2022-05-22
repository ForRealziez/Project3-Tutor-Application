package za.ac.cput.database;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookingDatabaseTest {

    @Test
    void getBooking() throws SQLException, ClassNotFoundException {
        BookingDatabase database = new BookingDatabase();

        Booking result = database.GetBooking("select * from bookings where id = '1'");
        assertEquals("1",result.getId());
    }

    @Test
    void getBookings() throws SQLException, ClassNotFoundException {
        BookingDatabase database = new BookingDatabase();

        Set<Booking> results = database.GetBookings("select * from bookings");
        assertEquals("1",results.stream().findFirst().get().getId());
    }

    @Test
    void createBooking() throws SQLException, ClassNotFoundException {
        BookingDatabase database = new BookingDatabase();
        Booking booking = BookingFactory.createBooking("1","214567789","ADP","2022-05-21 00:00:00","2022-05-21 00:50:00");
        boolean result = database.CreateBooking("insert into bookings values(?,?, ?,?, ?)",booking);
        assertEquals(true,!result);
    }

    @Test
    void UpdateBooking() throws SQLException, ClassNotFoundException {
        BookingDatabase database = new BookingDatabase();
        Booking resultBooking = database.GetBooking("select * from bookings where id = '1'");
        database = new BookingDatabase();
        resultBooking.setCourseId("ADP");
        boolean result = database.UpdateBooking("update bookings set tutorId = ?, courseId = ?, startDate = ?, endDate = ? where id = ?",resultBooking);
        assertEquals(true,!result);
    }

    @Test
    void DeleteBooking() throws SQLException, ClassNotFoundException {
        BookingDatabase database = new BookingDatabase();
        boolean result = database.DeleteBooking("delete from bookings where id = ?","1");
        assertEquals(true,!result);
    }
}